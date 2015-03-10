package gov.onc.xdrtesttool.xdrservice.endpoint;

import gov.onc.xdrtesttool.error.MessageReader;
import gov.onc.xdrtesttool.error.MessageRecorderItem;
import gov.onc.xdrtesttool.error.XDRMessageRecorder;
import gov.onc.xdrtesttool.error.MessageRecorderItem.MessageType;
import gov.onc.xdrtesttool.resource.MetadataType;
import gov.onc.xdrtesttool.resource.ResourceManager;
import gov.onc.xdrtesttool.validate.ValidationUtil;
import gov.onc.xdrtesttool.validate.XDRValidator;
import gov.onc.xdrtesttool.xml.XMLParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.axiom.om.OMElement;
import org.apache.log4j.Logger;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.soap.SoapBody;
import org.springframework.ws.soap.SoapHeader;
import org.springframework.ws.soap.SoapHeaderElement;
import org.springframework.ws.soap.SoapMessage;
import org.springframework.ws.transport.WebServiceMessageReceiver;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.springframework.xml.transform.StringSource;

import javax.xml.ws.soap.Addressing;
import javax.xml.ws.soap.SOAPBinding;

@Endpoint(value = SOAPBinding.SOAP12HTTP_BINDING)
@Addressing(enabled=true, required=true)
public class XDRSeviceMessageReceiverEndpoint {
	private final Logger log = Logger.getLogger(this.getClass().toString());
	private static final String NAMESPACE_RIM_URI = "urn:ihe:iti:xds-b:2007";

	public List<XDRValidator> validators = new ArrayList<XDRValidator>();

	private Source response; 
	public XDRSeviceMessageReceiverEndpoint() {
	}

	public List<XDRValidator> getValidators() {
		return validators;
	}

	public void setValidators(List<XDRValidator> validators) {
		this.validators = validators;
	}

	public @ResponsePayload
	Source handleProvideAndRegisterDocumentSetRequest(
			@RequestPayload Source source, MessageContext messageContext)
			throws Exception {

		String xmlFile = xmlToString(source);

		log.info("Request message content = "+
		xmlFile);

		SoapMessage soapMessage = (SoapMessage) messageContext.getRequest();

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		InputSource is = new InputSource(new StringReader(xmlFile));
		Document doc = builder.parse(is);
		NodeList nodeList = doc.getElementsByTagName("rim:Slot");

		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);

			if (node.hasAttributes()) {
				Attr attr = (Attr) node.getAttributes().getNamedItem("name");
				if (attr != null) {
					String attribute = attr.getValue();
					log.info("attribute: " + attribute);
					if (attribute != null
							&& attribute.equalsIgnoreCase("sourcePatientId")) {
						String value = node.getTextContent().trim();
						log.info("value: " + value);
					}

				}
			}
		}
		XDRMessageRecorder errorRecorder = new XDRMessageRecorder();
		//ValidationUtil.validateSchema(soapMessage, errorRecorder);

		if (validators != null && validators.size() > 0) {
			for (XDRValidator validator : validators) {
				log.info("Name: " + validator.getName());
				validator.validate(soapMessage, errorRecorder, null);
			}
		}
		MessageReader reader = new MessageReader(errorRecorder);
		StringSource responseSource = reader.buildResponse();
		log.info("Response message content = " + responseSource.toString());
		response = responseSource;
		writeResponseToLog(messageContext, responseSource);
		return responseSource;

	}

	private void writeResponseToLog(MessageContext messageContext, StringSource responseSource)
	{
		OutputStream os = null;
		PrintStream printStream = null;
		try {
			String logOutputDir = (String)messageContext.getProperty("LOG_OUTPUT_DIR");
			String outputId = (String)messageContext.getProperty("LOG_OUTPUT_NAME");
			String  logFileName = "Response_"+ outputId + ".xml";
			File logDir = new File(logOutputDir);
			if (!logDir.exists()) logDir.mkdirs();
				os = new FileOutputStream(logDir.getAbsolutePath() +File.separatorChar
				        + logFileName);
			printStream = new PrintStream(os);
			printStream.print(responseSource);
		    os.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(os != null)
			{
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(printStream != null)
				printStream.close();
		}

	}
	
	public Source getResponse()
	{
		return response;
	}
	

	private String xmlToString(Source source) {
		try {
			StringWriter stringWriter = new StringWriter();
			Result result = new StreamResult(stringWriter);
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer();
			transformer.transform(source, result);
			return stringWriter.getBuffer().toString();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		return null;
	}

}
