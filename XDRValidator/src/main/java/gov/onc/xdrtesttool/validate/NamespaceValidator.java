package gov.onc.xdrtesttool.validate;

import java.io.IOException;
import java.util.Iterator;

import gov.onc.xdrtesttool.error.MessageRecorder;
import gov.onc.xdrtesttool.error.MessageRecorderItem.MessageType;
import gov.onc.xdrtesttool.exception.XMLParserException;
import gov.onc.xdrtesttool.resource.MetadataType;
import gov.onc.xdrtesttool.xml.XMLParser;

import org.apache.axiom.om.OMElement;
import org.springframework.ws.soap.SoapMessage;

public class NamespaceValidator extends XDRValidator{

	@Override
	public void validate(SoapMessage soapMsg, MessageRecorder errorRecorder,
			ValidationContext vContext) {
		OMElement element=null;
		try {
				element = XMLParser.parseXMLSource(XMLParser
						.getEnvelopeAsInputStream(soapMsg));
			setMetadataType(element);
			ValidationUtil.validateNamespaces(element, errorRecorder);
		} catch (IOException e) {
			errorRecorder.record("INVALID_NS", soapMsg.toString(), soapMsg.toString(), MessageType.Error);
			e.printStackTrace();
		} catch (Exception e) {
			errorRecorder.record("INVALID_NS", soapMsg.toString(), soapMsg.toString(), MessageType.Error);
			e.printStackTrace();
		}
		
	}
	
	private void setMetadataType(OMElement envelopElement) {
		Iterator headerIter = envelopElement.getChildrenWithLocalName("Header");
		if (!headerIter.hasNext()) 
			MetadataType.instance.setMetadataType(MetadataType.MINIMAL);
		else {
			OMElement header = (OMElement) headerIter.next();
			Iterator addressIter = header
					.getChildrenWithLocalName("addressBlock");
			if (!addressIter.hasNext())
				MetadataType.instance.setMetadataType(MetadataType.MINIMAL);
			else {
				OMElement addressElement = (OMElement) addressIter.next();
				Iterator iter = addressElement
						.getChildrenWithLocalName("metadata-level");
				if (!iter.hasNext())
					MetadataType.instance.setMetadataType(MetadataType.MINIMAL);
				else {
					OMElement element = (OMElement) iter.next();
					String metaValue = element.getText();
					if (metaValue == null
							|| !(metaValue.equals("minimal") || metaValue
									.equals("XDS"))) 
						MetadataType.instance.setMetadataType(MetadataType.MINIMAL);
					else
					{
						String type = gov.onc.xdrtesttool.resource.ResourceManager.instance.getMetadataType(metaValue);
						if(type == null)
							type = MetadataType.MINIMAL;
						MetadataType.instance.setMetadataType(type);
					}
				}
			}
		}
	}
	
	@Override
	public String getName() {
		return "NamespaceValidator";
	}
}