package gov.onc.xdrtesttool.xml;

import java.net.InetSocketAddress;
import java.util.UUID;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

import org.apache.log4j.Logger;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.soap.SoapHeaderElement;
import org.springframework.ws.soap.SoapMessage;
import org.springframework.ws.soap.server.SoapEndpointInterceptor;
import org.springframework.ws.transport.context.TransportContext;
import org.springframework.ws.transport.context.TransportContextHolder;
import org.springframework.ws.transport.http.HttpServletConnection;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import java.io.File;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.StringWriter;

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
		try
		{
			UUID idOne = UUID.randomUUID();
			String outputDir = System.getProperty("xdrvalidator.log.dir");
			if(outputDir == null)
				outputDir = System.getProperty("java.io.tmpdir");
	
			WebServiceMessage message = messageContext.getRequest();
			Source source = message.getPayloadSource();
			String xmlFile = xmlToString(source);
			File logDir = new File(outputDir + File.separatorChar + "xdrvalidator" + File.separatorChar + ipAddress);
			if (!logDir.exists()) logDir.mkdirs();
			os = new FileOutputStream(logDir.getAbsolutePath() +File.separatorChar
		            + idOne+".xml");
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