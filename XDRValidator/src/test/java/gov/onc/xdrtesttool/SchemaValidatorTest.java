package gov.onc.xdrtesttool;

import static org.junit.Assert.assertEquals;
import gov.onc.xdrtesttool.error.XDRMessageRecorder;
import gov.onc.xdrtesttool.validate.SchemaValidator;

import java.util.List;

import org.junit.Test;
import org.springframework.ws.soap.SoapMessage;

public class SchemaValidatorTest extends XDRBaseTest {

	@Test
	public void validate() {
		SoapMessage message = getSoapMessage();
		SchemaValidator validator = new SchemaValidator();
		XDRMessageRecorder errorRecorder = new XDRMessageRecorder();
		validator.validate(message, errorRecorder, null);
		List errors = errorRecorder.getMessageErrors();
		assertEquals(0, errors.size());
		List warnings = errorRecorder.getMessageWarnings();
		assertEquals(0, warnings.size());
		//List infos = errorRecorder.getMessageInfos();
		//assertEquals(0, infos.size());
	}
}
