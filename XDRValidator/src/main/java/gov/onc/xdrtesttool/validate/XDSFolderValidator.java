package gov.onc.xdrtesttool.validate;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.xml.namespace.QName;

import gov.onc.xdrtesttool.error.MessageRecorder;
import gov.onc.xdrtesttool.error.MessageRecorderItem.MessageType;
import gov.onc.xdrtesttool.exception.XMLParserException;
import gov.onc.xdrtesttool.resource.MetadataType;
import gov.onc.xdrtesttool.xml.XMLParser;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.springframework.ws.soap.SoapMessage;

public class XDSFolderValidator extends XDRValidator{
	MessageRecorder errorRecorder;
	String metadataType = MetadataType.instance.getMetadataType();
	public void validate(SoapMessage soapMsg, MessageRecorder errorRecorder,
			ValidationContext vContext) {
		this.errorRecorder = errorRecorder;
		OMElement element;
		try {
			element = XMLParser.parseXMLSource(soapMsg.getPayloadSource());
			Iterator submitObjectsRequestIter = element
					.getChildrenWithLocalName("SubmitObjectsRequest");
			while (submitObjectsRequestIter.hasNext()) {
				OMElement sorElement = (OMElement) submitObjectsRequestIter
						.next();
				Iterator registryObjectListIter = sorElement
						.getChildrenWithLocalName("RegistryObjectList");
				while (registryObjectListIter.hasNext()) {
					OMElement rolElement = (OMElement) registryObjectListIter
							.next();
					validateRegistryPackage(rolElement);
				}
			}
		} catch (XMLParserException e) {
			errorRecorder.record("XDS_MSG_199", Constants.XDS_Metadata_Checklist,
					"XDSFolder.RegistryPackage", MetadataType.instance.getMessageType(metadataType, "199"));
			e.printStackTrace();
		}
	}

	private void validateRegistryPackage(OMElement registryObjectElement) {
		Iterator registryPackageIter = registryObjectElement
				.getChildrenWithLocalName("RegistryPackage");
		if (!registryPackageIter.hasNext()) {
			errorRecorder.record("XDS_MSG_199", Constants.XDS_Metadata_Checklist,
					"XDSFolder.RegistryPackage", MetadataType.instance.getMessageType(metadataType, "199"));
			return;
		}

		OMElement classificationElement = ValidationUtil
				.findClassificationChildElement(registryObjectElement,
						"urn:uuid:d9d542f3-6cc4-48b6-8870-ea235fbc94c2");
		while (registryPackageIter.hasNext()) {
			OMElement registryPackageElement = (OMElement) registryPackageIter
					.next();
			if (registryPackageIter.hasNext())
				errorRecorder.record("XDS_MSG_199_1", Constants.XDS_Metadata_Checklist,
						"XDSFolder.RegistryPackage", MessageType.Error);

			if (classificationElement == null) {
				classificationElement = ValidationUtil
						.findClassificationChildElement(registryPackageElement,
								"urn:uuid:d9d542f3-6cc4-48b6-8870-ea235fbc94c2");
			}

			OMAttribute idAttr = registryPackageElement.getAttribute(new QName(
					"id"));

			if (classificationElement == null)
				errorRecorder.record("XDS_MSG_199", Constants.XDS_Metadata_Checklist,
						"XDSFolder.RegistryPackage", MetadataType.instance.getMessageType(metadataType, "199"));
			else {
				OMAttribute classAttr = classificationElement
						.getAttribute(new QName("classifiedObject"));
				if (classAttr == null)
					errorRecorder.record("XDS_MSG_199",
							Constants.XDS_Metadata_Checklist,
							"XDSFolder.RegistryPackage", MetadataType.instance.getMessageType(metadataType, "199"));
				else {
					if (!classAttr.getAttributeValue().equals(
							idAttr.getAttributeValue()))
						errorRecorder.record("XDS_MSG_199",
								Constants.XDS_Metadata_Checklist,
								"XDSFolder.RegistryPackage", MetadataType.instance.getMessageType(metadataType, "199"));
				}
			}
			if (idAttr == null)
				errorRecorder.record("XDS_MSG_200", Constants.XDS_Metadata_Checklist,
						"XDSFolder.RegistryPackage.id", MetadataType.instance.getMessageType(metadataType, "200"));

			OMAttribute statusAttr = registryPackageElement
					.getAttribute(new QName("status"));
			if (statusAttr != null)
				errorRecorder.record("XDS_MSG_201", Constants.XDS_Metadata_Checklist,
						"XDSFolder.RegistryPackage.status", MetadataType.instance.getMessageType(metadataType, "201"));

			OMAttribute homeAttr = registryPackageElement
					.getAttribute(new QName("home"));
			if (homeAttr != null)
				errorRecorder.record("XDS_MSG_202", Constants.XDS_Metadata_Checklist,
						"XDSFolder.RegistryPackage.home", MetadataType.instance.getMessageType(metadataType, "202"));

			validateSlot(registryPackageElement);
			ValidationUtil.validateRegistryPackageName(registryPackageElement,
					errorRecorder, "XDS_MSG_204",
					"XDSFolder.RegistryPackage.Name");
			ValidationUtil.validateRegistryPackageDescription(
					registryPackageElement, errorRecorder, "XDS_MSG_205",
					"XDSSubmissionSet.RegistryPackage.Description");
			validateRegistryPackageClassification(registryPackageElement);
		}
	}

	private void validateRegistryPackageClassification(
			OMElement registryPackageElement) {
		OMElement classElement1 = ValidationUtil.findClassificationByScheme(
				registryPackageElement,
				"urn:uuid:1ba97051-7806-41a8-a48b-8fce7af683c5");
		if (classElement1 == null)
			errorRecorder.record("XDR_MSG_206", Constants.XDS_Metadata_Checklist,
					"XDSSubmissionSet.Classification", MetadataType.instance.getMessageType(metadataType, "206"));
		else {
			verifyClassification1(registryPackageElement, classElement1);
		}

		OMElement classElement2 = ValidationUtil.findClassificationByScheme(
				registryPackageElement,
				"urn:uuid:2c144a76-29a9-4b7c-af54-b25409fe7d03");
		if (classElement2 == null)
			errorRecorder.record("XDR_MSG_207", Constants.XDS_Metadata_Checklist,
					"XDSSubmissionSet.Classification", MetadataType.instance.getMessageType(metadataType, "207"));
		else {
			ValidationUtil.validateClassifiedObject(registryPackageElement, classElement2, errorRecorder,
					"XDR_MSG_207", "Classification2");
		}
		ValidateExternalIdentifier1(registryPackageElement);
		ValidateExternalIdentifier2(registryPackageElement);
	}

	private void verifyClassification1(OMElement extrinsicObject,
			OMElement classElement2) {
		// @classifiedObject = the value of rim:ExtrinsicObject/@id
		ValidationUtil.validateClassifiedObject(extrinsicObject, classElement2, errorRecorder,
				"XDR_MSG_206_1", "Classification");

		//There MUST be a Slot element WHERE @name="codingScheme" AND rim:Slot/rim:ValueList/rim:Value is present
		ValidationUtil.validateCodingScheme(classElement2, "XDR_MSG_206_2", "Classification", errorRecorder);

		
		//rim:Name/rim:LocalizedString/@value MUST be present
		ValidationUtil.validateLocalizedString(classElement2, "XDR_MSG_206_3", "Classification", errorRecorder);

		// @nodeRepresentation is present
		OMAttribute attr = classElement2.getAttribute(new QName(
				"nodeRepresentation"));
		if (attr == null)
			errorRecorder.record("XDR_MSG_206_4", Constants.XDS_Metadata_Checklist,
					"XDSSubmissionSet.nodeRepresentation", MessageType.Error);
	}

	private void ValidateExternalIdentifier1(OMElement registryPackageElement)
	{
		OMElement element = ValidationUtil.findExternalIdentifierByScheme(registryPackageElement, "urn:uuid:f64ffdf0-4b97-4e06-b79f-a52b38ec2f8a");
		if(element == null)
			errorRecorder.record("XDR_MSG_208", Constants.XDS_Metadata_Checklist,
					"XDSSubmissionSet.ExternalIdentifier", MetadataType.instance.getMessageType(metadataType, "208"));
		else
		{
			OMAttribute attr = element.getAttribute(new QName("value"));
			if(attr == null)
				errorRecorder.record("XDR_MSG_208", Constants.XDS_Metadata_Checklist,
						"XDSSubmissionSet.ExternalIdentifier", MetadataType.instance.getMessageType(metadataType, "208"));
			else
			{
				String valueStr = attr.getAttributeValue();
				int index1 = valueStr.indexOf("^^^&amp;");
				int index2 = valueStr.indexOf("&amp;ISO");
				if (index1 <= 0 || (index2 <= 0 || index2 <= index1))
					errorRecorder.record("XDR_MSG_208_1",
							Constants.XDS_Metadata_Checklist,
							"XDSSubmissionSet.ExternalIdentifier",
							MessageType.Error);
			}
		}
	}

	private void ValidateExternalIdentifier2(OMElement registryPackageElement)
	{
		OMElement element = ValidationUtil.findExternalIdentifierByScheme(registryPackageElement, "urn:uuid:75df8f67-9973-4fbe-a900-df66cefecc5a");
		if(element == null)
			errorRecorder.record("XDR_MSG_209", Constants.XDS_Metadata_Checklist,
					"XDSDocumentEntry.ExternalIdentifier", MetadataType.instance.getMessageType(metadataType, "209"));
		else
		{
			OMAttribute attr = element.getAttribute(new QName("value"));
			if(attr == null)
				errorRecorder.record("XDR_MSG_209", Constants.XDS_Metadata_Checklist,
						"XDSDocumentEntry.ExternalIdentifier", MetadataType.instance.getMessageType(metadataType, "209"));
			else
			{
				if(attr.getAttributeValue().length() > 64)
					errorRecorder.record("XDR_MSG_209_1",
							Constants.XDS_Metadata_Checklist,
							"XDSDocumentEntry.ExternalIdentifier",
							MessageType.Error);
			}
		}
	}	
	
	private void validateSlot(OMElement registryPackageElement) {
		// Verify: rim:ValueList/rim:Value:
		// - MUST be a single value.
		// - MUST be in DTM format.
		// - MUST be a time in the past.
		if (!ValidationUtil.isSlotUnique(registryPackageElement,
				"lastUpdateTime"))
			errorRecorder.record("XDS_MSG_203_1", Constants.XDS_Metadata_Checklist,
					"XDSFolder.RegistryPackage.Slot.submissionTime",
					MessageType.Error);
		else {
			OMElement submissionSlot = ValidationUtil.findSlot(
					registryPackageElement, "lastUpdateTime");
			if (submissionSlot == null) {
				errorRecorder.record("XDR_MSG_203", Constants.XDS_Metadata_Checklist,
						"XDSFolder.RegistryPackage.Slot.submissionTime",
						MetadataType.instance.getMessageType(metadataType, "203"));
				return;
			}

			List<String> valueList = ValidationUtil
					.getSlotValueList(submissionSlot);
			if (valueList.size() == 0)
				errorRecorder.record("XDR_MSG_203_2", Constants.XDS_Metadata_Checklist,
						"XDSFolder.RegistryPackage.Slot.submissionTime",
						MessageType.Error);

			String attrValue = valueList.get(0);
			Calendar currDtCal = Calendar.getInstance();
			Date currDt = currDtCal.getTime();

			if (!ValidationUtil.validateAndCompareUTCFormat(attrValue, currDt))
				errorRecorder.record("XDR_MSG_203_2", Constants.XDS_Metadata_Checklist,
						"XDSFolder.RegistryPackage.Slot.submissionTime",
						MessageType.Error);

		}

	}

	@Override
	public String getName() {
		return "XDSFolderValidator";
	}
}
