package gov.onc.xdrtesttool.xml;

import gov.onc.xdrtesttool.exception.XMLParserException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Source;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMXMLBuilderFactory;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.springframework.ws.soap.SoapMessage;

public class XMLParser {
	static public OMElement parseXMLFile(String filename) throws FactoryConfigurationError, XMLParserException {
		File infile = new File(filename);

		XMLStreamReader parser=null;
		try {
			parser = XMLInputFactory.newInstance().createXMLStreamReader(new FileInputStream(infile));
		} catch (XMLStreamException e) {
			throw new XMLParserException("gov.onc.xdrtest.xml: Could not create XMLStreamReader from " + filename, null);
		} catch (FileNotFoundException e) {
			throw new XMLParserException("gov.onc.xdrtest.xml: Could not find input file " + filename, null);
		}

		StAXOMBuilder builder = new StAXOMBuilder(parser);
		OMElement documentElement =  builder.getDocumentElement();	
		if (documentElement == null) throw new XMLParserException("gov.onc.xdrtest.xml: No document element", null);
		return documentElement;
	}

	static public OMElement parseXMLString(String input_string) throws XMLParserException {
		byte[] ba = input_string.getBytes();

		XMLStreamReader parser=null;

		try {
			parser = XMLInputFactory.newInstance().createXMLStreamReader(new ByteArrayInputStream(ba));
		} catch (XMLStreamException e) {
			throw new XMLParserException("gov.onc.xdrtest.xml: Could not create XMLStreamReader from " + "input stream", null);
		}
		StAXOMBuilder builder = new StAXOMBuilder(parser);
		OMElement documentElement =  builder.getDocumentElement();
		return documentElement;
	}

	static public OMElement parseXMLSource(Source source) throws XMLParserException {
		XMLStreamReader parser=null;

		OMElement documentElement = OMXMLBuilderFactory.createOMBuilder(source).getDocumentElement();
		//parser = XMLInputFactory.newInstance().createXMLStreamReader(source);
		//StAXOMBuilder builder = new StAXOMBuilder(parser);
		//OMElement documentElement =  builder.getDocumentElement();
		return documentElement;
	}

	static public OMElement parseXMLSource(InputStream stream) throws XMLParserException {
		XMLStreamReader parser=null;

		OMElement documentElement = OMXMLBuilderFactory.createOMBuilder(stream).getDocumentElement();
		//parser = XMLInputFactory.newInstance().createXMLStreamReader(source);
		//StAXOMBuilder builder = new StAXOMBuilder(parser);
		//OMElement documentElement =  builder.getDocumentElement();
		return documentElement;
	}

	
	static public InputStream getEnvelopeAsInputStream(SoapMessage soapMsg) throws IOException
	{
		OutputStream output = new ByteArrayOutputStream();
		soapMsg.writeTo(output);
		InputStream input = new ByteArrayInputStream(((ByteArrayOutputStream) output).toByteArray());
		return input;
	}
}
