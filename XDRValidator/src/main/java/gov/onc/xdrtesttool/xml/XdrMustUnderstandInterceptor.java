package gov.onc.xdrtesttool.xml;

import org.springframework.ws.context.MessageContext;
import org.springframework.ws.soap.SoapHeaderElement;
import org.springframework.ws.soap.server.SoapEndpointInterceptor;

public class XdrMustUnderstandInterceptor implements SoapEndpointInterceptor {
    private final String SAMPLE_NS = "http://www.consol.com/soap-mustunderstand";
 
    @Override
    public boolean understands(SoapHeaderElement header) {
        return true;
    }

	@Override
	public boolean handleRequest(MessageContext messageContext, Object endpoint)
			throws Exception {
		// TODO Auto-generated method stub
		return true;
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