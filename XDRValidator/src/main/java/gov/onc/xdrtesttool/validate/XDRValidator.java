package gov.onc.xdrtesttool.validate;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMNamespace;
import org.springframework.ws.soap.SoapMessage;
import org.w3c.dom.Document;
import org.w3c.dom.traversal.NodeFilter;
import org.xml.sax.SAXException;

import gov.onc.xdrtesttool.error.MessageRecorder;
import gov.onc.xdrtesttool.error.MessageRecorderItem;
import gov.onc.xdrtesttool.exception.XSDParserException;
import gov.onc.xdrtesttool.xml.NamespaceManager;

public abstract class XDRValidator {
	public abstract void validate(SoapMessage soapMsg, MessageRecorder errorRecorder, ValidationContext vContext);
	public abstract String getName();
}
