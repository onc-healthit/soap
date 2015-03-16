
package gov.onc.xdrtesttool.xdrservice.client;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.Result;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.WebServiceTemplate;

public class XDRServiceClient {
	

	
	private static WebServiceTemplate wsTemplate = null;
	private static InputStream is;
	
	public static void  main(String[] args) throws Exception {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
		wsTemplate = (WebServiceTemplate) appContext.getBean("webServiceTemplate");
		is = new XDRServiceClient().getClass().getResourceAsStream("ProvideAndRegisterDocumentSet-bRequest3.xml");		 
		 
		testXDRServiceRequest();
	}

	
	private static final void testXDRServiceRequest() {
			 invokeWS3();
	}
	
	private static Result invokeWS1() {
        StreamSource source = new StreamSource(is);
        StreamResult result = new StreamResult(System.out);
        wsTemplate.sendSourceAndReceiveToResult(source, new WebServiceMessageCallback(){
        	    /* (non-Javadoc)
        	     * @see org.springframework.ws.client.core.WebServiceMessageCallback#doWithMessage(org.springframework.ws.WebServiceMessage)
        	     */
        	    public void doWithMessage(WebServiceMessage message) throws IOException, TransformerException{
					try {
        	    	SOAPMessage soapMessage = ((org.springframework.ws.soap.saaj.SaajSoapMessage)message).getSaajMessage();
        	    	soapMessage.setProperty(SOAPMessage.WRITE_XML_DECLARATION, "true");
        	    	soapMessage.setProperty(SOAPMessage.CHARACTER_SET_ENCODING, "utf-8");
        	    	SOAPEnvelope envelope = soapMessage.getSOAPPart().getEnvelope();
        	    	SOAPHeader header = soapMessage.getSOAPHeader();
        	    	//<a:Action s:mustUnderstand=\"1\">urn:ihe:iti:2007:ProvideAndRegisterDocumentSet-b</a:Action>
        	        QName actionQ = new QName("http://www.w3.org/2005/08/addressing", "Action", "a");
        	        SOAPHeaderElement actionElement = header.addHeaderElement(actionQ);
        	        //QName mustUnderstand = new QName("http://www.w3.org/2003/05/soap-envelope", "mustUnderstand", "s");
        	        QName mustUnderstand = new QName("http://schemas.xmlsoap.org/soap/envelope", "mustUnderstand", "s");
        	        actionElement.addAttribute(mustUnderstand, "true");
        	        actionElement.setValue("urn:ihe:iti:2007:ProvideAndRegisterDocumentSet-b");
        	        
        	        //"<a:MessageID>urn:uuid:6d296e90-e5dc-43d0-b455-7c1f3eb35d83</a:MessageID>"
        	        QName messageQ = new QName("http://www.w3.org/2005/08/addressing", "MessageID", "a");
        	        SOAPHeaderElement messageElement = header.addHeaderElement(messageQ);
        	        messageElement.setValue("urn:uuid:6d296e90-e5dc-43d0-b455-7c1f3eb35d83");
        	        
        	        //"<a:ReplyTo>"
        	        QName replyQ = new QName("http://www.w3.org/2005/08/addressing", "ReplyTo", "a");
        	        SOAPHeaderElement replyElement = header.addHeaderElement(replyQ);
        	        
        	        //"<a:Address>http://www.w3.org/2005/08/addressing/anonymous</a:Address>"+
        	        QName addressQ = new QName("http://www.w3.org/2005/08/addressing", "Address", "a");
        	        SOAPElement addressElement = replyElement.addChildElement(addressQ);
        	        addressElement.setValue("http://www.w3.org/2005/08/addressing/anonymous");
        	        
        	        //"<a:To s:mustUnderstand=\"1\">http://localhost:2647/XdsService/IHEXDSRepository.svc</a:To>";
        	        QName toQ = new QName("http://www.w3.org/2005/08/addressing", "Address", "a");
        	        SOAPElement toElement;
						toElement = header.addHeaderElement(toQ);
        	        toElement.addAttribute(mustUnderstand, "true");
        	        addressElement.setValue("http://localhost:2647/XdsService/IHEXDSRepository.svc");

        	        QName directAddr = new QName("urn:direct:addressing", "addressBlock", "direct");
        	        SOAPHeaderElement directAddrElement = header.addHeaderElement(directAddr);
        	        QName roleAttr = new QName("urn:direct:addressing", "role", "direct");
        	        directAddrElement.addAttribute(roleAttr, "urn:direct:addressing:destination");
        	        QName relayAttr = new QName("urn:direct:addressing", "relay", "direct");
        	        directAddrElement.addAttribute(relayAttr, "true");
        	        QName metaLevelQ = new QName("urn:direct:addressing", "metadata-level", "direct");
        	        SOAPElement metaElement = directAddrElement.addChildElement(metaLevelQ);
					metaElement.setValue("minimal");

        	        QName fromQ = new QName("urn:direct:addressing", "from", "direct");
        	        SOAPElement fromElement = directAddrElement.addChildElement(fromQ);
        	        fromElement.setValue("mailto:jane@mroroionline.mrohisp.com");

        	        QName toDirQ = new QName("urn:direct:addressing", "to", "direct");
        	        SOAPElement toDirElement = directAddrElement.addChildElement(toDirQ);
        	        toDirElement.setValue("mailto:edwards@avianhospitals.hispmail.net");
					
					} catch (SOAPException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					}
        	    }
        	}, result);

        return result;
	}
	
	private static Result invokeWS2() {
        StreamSource source = new StreamSource(is);
        StreamResult result = new StreamResult(System.out);
        wsTemplate.sendSourceAndReceiveToResult(source, new WebServiceMessageCallback(){
        	    /* (non-Javadoc)
        	     * @see org.springframework.ws.client.core.WebServiceMessageCallback#doWithMessage(org.springframework.ws.WebServiceMessage)
        	     */
        	    public void doWithMessage(WebServiceMessage message) throws IOException, TransformerException{
					try {
        	    	SOAPMessage soapMessage = ((org.springframework.ws.soap.saaj.SaajSoapMessage)message).getSaajMessage();
        	    	soapMessage.setProperty(SOAPMessage.WRITE_XML_DECLARATION, "true");
        	    	soapMessage.setProperty(SOAPMessage.CHARACTER_SET_ENCODING, "utf-8");

        	    	SOAPEnvelope envelope = soapMessage.getSOAPPart().getEnvelope();
        	    	SOAPHeader header = soapMessage.getSOAPHeader();

        	        //<direct:metadata-level xmlns:direct="urn:direct:addressing">XDS</direct:metadata-level>
        	        QName metadataQ = new QName("urn:direct:addressing", "metadata-level", "direct");
        	        SOAPHeaderElement metadataElement = header.addHeaderElement(metadataQ);
        	        metadataElement.setValue("XDS");
        	    	
        	        //<direct:addressBlock xmlns:direct="urn:direct:addressing"
        	        //        soapenv:role="urn:direct:addressing:destination" soapenv:relay="true">
        	        //        <direct:from>from@direct.com</direct:from>
        	        //        <direct:to>to@direct.com</direct:to>
        	        //    </direct:addressBlock>
        	        QName soapEnvRoleQ = new QName("http://www.w3.org/2003/05/soap-envelope", "role", "soapenv");
        	        QName soapEnvRelayQ = new QName("http://www.w3.org/2003/05/soap-envelope", "relay", "soapenv");
        	        QName addressQ = new QName("urn:direct:addressing", "addressBlock", "direct");
        	        SOAPHeaderElement addressElement = header.addHeaderElement(addressQ);
        	        addressElement.addAttribute(soapEnvRoleQ, "urn:direct:addressing:destination");
        	        addressElement.addAttribute(soapEnvRelayQ, "true");
        	        QName fromQ = new QName("urn:direct:addressing", "from", "direct");
        	        SOAPElement fromElement = addressElement.addChildElement(fromQ);
        	        fromElement.setValue("from@direct.com");

        	        QName toDirQ = new QName("urn:direct:addressing", "to", "direct");
        	        SOAPElement toDirElement = addressElement.addChildElement(toDirQ);
        	        toDirElement.setValue("to@direct.com");

        	        //<wsa:To soapenv:mustUnderstand="true"
        	        //        xmlns:soapenv="http://www.w3.org/2003/05/soap-envelope"
        	        //        xmlns:wsa="http://www.w3.org/2005/08/addressing">http://transport-testing.nist.gov:12080/ttt/sim/9fdc17ba-0191-4d0c-be2a-c4ea5294b861/rec/xdrpr</wsa:To>
        	        QName soapEnvMustQ = new QName("http://www.w3.org/2003/05/soap-envelope", "mustUnderstand", "soapenv");
        	        QName toQ = new QName("http://www.w3.org/2005/08/addressing", "To", "wsa");
        	        SOAPHeaderElement toElement = header.addHeaderElement(toQ);
        	        toElement.setValue("http://transport-testing.nist.gov:12080/ttt/sim/9fdc17ba-0191-4d0c-be2a-c4ea5294b861/rec/xdrpr");
        	        toElement.addAttribute(soapEnvMustQ, "true");

        	        //<wsa:MessageID soapenv:mustUnderstand="true"
        	        //        xmlns:soapenv="http://www.w3.org/2003/05/soap-envelope"
        	        //        xmlns:wsa="http://www.w3.org/2005/08/addressing">149211c9-9143-4714-924d-a2018743b00f</wsa:MessageID>
        	        QName messageIDQ = new QName("http://www.w3.org/2005/08/addressing", "MessageID", "wsa");
        	        SOAPHeaderElement messageIDElement = header.addHeaderElement(messageIDQ);
        	        messageIDElement.setValue("149211c9-9143-4714-924d-a2018743b00f");
        	        messageIDElement.addAttribute(new QName("soapenv", "mustUnderstand"), "true");
        	        messageIDElement.addAttribute(new QName("xmlns", "soapenv"), "http://www.w3.org/2003/05/soap-envelope");

        	        //<wsa:Action soapenv:mustUnderstand="true"
        	        //        xmlns:soapenv="http://www.w3.org/2003/05/soap-envelope"
        	        //        xmlns:wsa="http://www.w3.org/2005/08/addressing"
        	        //        >urn:ihe:iti:2007:ProvideAndRegisterDocumentSet-b</wsa:Action>
        	        QName actionQ = new QName("http://www.w3.org/2005/08/addressing", "Action", "wsa");
        	        SOAPHeaderElement actionElement = header.addHeaderElement(actionQ);
        	        actionElement.setValue("urn:ihe:iti:2007:ProvideAndRegisterDocumentSet-b");
        	        actionElement.addAttribute(new QName("soapenv", "mustUnderstand"), "true");
        	        actionElement.addAttribute(new QName("xmlns", "soapenv"), "http://www.w3.org/2003/05/soap-envelope");
					
					} catch (SOAPException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					}
        	    }
        	}, result);

        return result;
	}
	

	private static Result invokeWS3() {
        StreamSource source = new StreamSource(is);
        StreamResult result = new StreamResult(System.out);
        wsTemplate.sendSourceAndReceiveToResult(source, new WebServiceMessageCallback(){
        	    /* (non-Javadoc)
        	     * @see org.springframework.ws.client.core.WebServiceMessageCallback#doWithMessage(org.springframework.ws.WebServiceMessage)
        	     */
        	    public void doWithMessage(WebServiceMessage message) throws IOException, TransformerException{
					try {
        	    	SOAPMessage soapMessage = ((org.springframework.ws.soap.saaj.SaajSoapMessage)message).getSaajMessage();
        	    	soapMessage.setProperty(SOAPMessage.WRITE_XML_DECLARATION, "true");
        	    	soapMessage.setProperty(SOAPMessage.CHARACTER_SET_ENCODING, "utf-8");

        	    	SOAPEnvelope envelope = soapMessage.getSOAPPart().getEnvelope();
        	    	SOAPHeader header = soapMessage.getSOAPHeader();

        	    	//<direct:metadata-level xmlns:direct="urn:direct:addressing">minimal</direct:metadata-level>
        	        QName metadataQ = new QName("urn:direct:addressing", "metadata-level", "direct");
        	        SOAPHeaderElement metadataElement = header.addHeaderElement(metadataQ);
        	        metadataElement.setValue("minimal");
        	    	
        	        //<direct:addressBlock xmlns:direct="urn:direct:addressing" soapenv:relay="true" soapenv:role="urn:direct:addressing:destination">
                    //<direct:from>testcase3@nist.gov</direct:from>
                    //<direct:to>testcase3@nist.gov</direct:to>
                    //</direct:addressBlock>

        	        QName soapEnvRoleQ = new QName("http://www.w3.org/2003/05/soap-envelope", "role", "soapenv");
        	        QName soapEnvRelayQ = new QName("http://www.w3.org/2003/05/soap-envelope", "relay", "soapenv");
        	        QName addressQ = new QName("urn:direct:addressing", "addressBlock", "direct");
        	        SOAPHeaderElement addressElement = header.addHeaderElement(addressQ);
        	        addressElement.addAttribute(soapEnvRoleQ, "urn:direct:addressing:destination");
        	        addressElement.addAttribute(soapEnvRelayQ, "true");
        	        QName fromQ = new QName("urn:direct:addressing", "from", "direct");
        	        SOAPElement fromElement = addressElement.addChildElement(fromQ);
        	        fromElement.setValue("testcase3@nist.gov");

        	        QName toDirQ = new QName("urn:direct:addressing", "to", "direct");
        	        SOAPElement toDirElement = addressElement.addChildElement(toDirQ);
        	        toDirElement.setValue("to@direct.com");

        	        //<wsa:To xmlns:wsa="http://www.w3.org/2005/08/addressing" 
        	        //		soapenv:mustUnderstand="true">http://devsoap.sitenv.org/xdrvalidator/Dispatcher/XDRService.wsdl</wsa:To>
        	        QName soapEnvMustQ = new QName("http://www.w3.org/2003/05/soap-envelope", "mustUnderstand", "soapenv");
        	        QName toQ = new QName("http://www.w3.org/2005/08/addressing", "To", "wsa");
        	        SOAPHeaderElement toElement = header.addHeaderElement(toQ);
        	        toElement.setValue("http://devsoap.sitenv.org/xdrvalidator/Dispatcher/XDRService.wsdl");
        	        toElement.addAttribute(soapEnvMustQ, "true");

        	        //<wsa:MessageID xmlns:wsa="http://www.w3.org/2005/08/addressing" soapenv:mustUnderstand="true">40e26365-6d28-4b8f-82d0-73bc6b9b71eb</wsa:MessageID>
        	        QName messageIDQ = new QName("http://www.w3.org/2005/08/addressing", "MessageID", "wsa");
        	        SOAPHeaderElement messageIDElement = header.addHeaderElement(messageIDQ);
        	        messageIDElement.setValue("40e26365-6d28-4b8f-82d0-73bc6b9b71eb");
        	        messageIDElement.addAttribute(soapEnvMustQ, "true");
        	        messageIDElement.addAttribute(new QName("xmlns", "soapenv"), "http://www.w3.org/2003/05/soap-envelope");

        	        //<wsa:Action xmlns:wsa="http://www.w3.org/2005/08/addressing" soapenv:mustUnderstand="true">urn:ihe:iti:2007:ProvideAndRegisterDocumentSet-b</wsa:Action>
        	        QName actionQ = new QName("http://www.w3.org/2005/08/addressing", "Action", "wsa");
        	        SOAPHeaderElement actionElement = header.addHeaderElement(actionQ);
        	        actionElement.setValue("urn:ihe:iti:2007:ProvideAndRegisterDocumentSet-b");
        	        actionElement.addAttribute(soapEnvMustQ, "true");
        	        actionElement.addAttribute(new QName("xmlns", "soapenv"), "http://www.w3.org/2003/05/soap-envelope");
					
					} catch (SOAPException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					}
        	    }
        	}, result);

        return result;
	}
	
	
	
}
