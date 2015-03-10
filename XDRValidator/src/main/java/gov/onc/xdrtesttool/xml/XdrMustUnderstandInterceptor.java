package gov.onc.xdrtesttool.xml;

import gov.onc.xdrtesttool.error.MessageRecorderItem.MessageType;

import java.net.InetSocketAddress;
import java.util.Iterator;
import java.util.UUID;

import javax.ws.rs.core.UriBuilder;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMNamespace;
import org.apache.log4j.Logger;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.soap.SoapHeader;
import org.springframework.ws.soap.SoapHeaderElement;
import org.springframework.ws.soap.SoapMessage;
import org.springframework.ws.soap.server.SoapEndpointInterceptor;
import org.springframework.ws.transport.context.TransportContext;
import org.springframework.ws.transport.context.TransportContextHolder;
import org.springframework.ws.transport.http.HttpServletConnection;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.UriBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.StringWriter;
import java.util.Date;
import java.text.SimpleDateFormat;

public class XdrMustUnderstandInterceptor implements SoapEndpointInterceptor {
	private final Logger log = Logger.getLogger(this.getClass().toString());

    @Override
    public boolean understands(SoapHeaderElement header) {
        return true;
    }

	@Override
	public boolean handleRequest(MessageContext messageContext, Object endpoint)
			throws Exception {
		// TODO Auto-generated method stub
		TransportContext context = TransportContextHolder.getTransportContext();
		HttpServletConnection connection = (HttpServletConnection )context.getConnection();
		HttpServletRequest request = connection.getHttpServletRequest();
		String ipAddress = request.getRemoteAddr();
		SoapMessage soapMessage = (SoapMessage) messageContext.getRequest();
		OutputStream os = null;
		PrintStream printStream = null;
		String fromAddr = getFromAddress(soapMessage);
		if(fromAddr == null)
			fromAddr = ipAddress;

		try
		{
			UUID idOne = UUID.randomUUID();
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmss.S");
			String formattedDate = sdf.format(date);

			String outputDir = System.getProperty("xdrvalidator.log.dir");
			if(outputDir == null)
				outputDir = System.getProperty("java.io.tmpdir");

			WebServiceMessage message = messageContext.getRequest();
			Source source = message.getPayloadSource();
			String xmlFile = xmlToString(source);
			if(fromAddr.indexOf("@") != -1)
			{

				String userId = fromAddr.substring(0, fromAddr.indexOf("@"));
				String domainName = fromAddr.substring(fromAddr.indexOf("@")+1, fromAddr.length());
				fromAddr = domainName + File.separatorChar + userId;
			}
			else
				fromAddr = ipAddress;
			
			String logFileDir = outputDir + File.separatorChar + "xdrvalidator" + File.separatorChar + fromAddr.toUpperCase();
			String logFileName = "Request_"+formattedDate+".xml";
			messageContext.setProperty("LOG_OUTPUT_DIR", logFileDir);
			messageContext.setProperty("LOG_OUTPUT_NAME", formattedDate);
			File logDir = new File(logFileDir);
			if (!logDir.exists()) logDir.mkdirs();
			os = new FileOutputStream(logDir.getAbsolutePath() +File.separatorChar
		            + logFileName);
			printStream = new PrintStream(os);
		    soapMessage.writeTo(printStream);
		    os.flush();
		}
		catch(java.io.IOException e)
		{
			log.error("Failed to log soap request from  "+ ipAddress +" to the file system");
		}
		finally
		{
			if(printStream != null)
				printStream.close();

			if(os != null)
				os.close();
		}
		return true;
	}

	private String getFromAddress(SoapMessage soapMessage)
	{
		try {
			OMElement element = XMLParser.parseXMLSource(XMLParser
					.getEnvelopeAsInputStream(soapMessage));
			if(element == null)
			{
				log.error("Invalid SOAP Request. Unable to parse.");
				return null;
			}

			OMElement header = null;
			Iterator headerIter = element.getChildrenWithLocalName("Header");
			if (!headerIter.hasNext()) {
				log.error("Header is missing from the request");
				return null;
			} else
				header = (OMElement) headerIter.next();

			if(header == null)
			{
				log.error("Header is missing from the request");
				return null;
			}
			else
			{
				Iterator addressIter = header.getChildrenWithLocalName("addressBlock");
				if(!addressIter.hasNext())
				{
					log.error("Address is missing from the Header");
					return null;
				}
				else
				{
					//S:Envelope/S:Header/direct:AddressBlock - Optional
					OMElement addressElement = (OMElement)addressIter.next();

					Iterator fromIter = addressElement.getChildrenWithLocalName("from");
					if(!fromIter.hasNext())
					{
						log.error("Address from is missing from the Header");
						return null;
					}
					else
					{
						OMElement fromElement = (OMElement) fromIter.next();
						String fromAddr = null;
						try
						{
							UriBuilder.fromUri(fromElement.getText());
							fromAddr = fromElement.getText();
						}
						catch(IllegalArgumentException e)
						{
							log.error("Invalid from Address in the Header");
							return null;
						}
						return fromAddr;
					}

				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.error("Failed to get from address from SOAP Header");
		}
		return null;
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


	@Override
	public boolean handleResponse(MessageContext messageContext, Object endpoint)
			throws Exception {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean handleFault(MessageContext messageContext, Object endpoint)
			throws Exception {
		// TODO Auto-generated method stub
		return true;
	}

}