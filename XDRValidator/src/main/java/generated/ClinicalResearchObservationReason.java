//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.02.16 at 12:17:07 PM EST 
//


package generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClinicalResearchObservationReason.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ClinicalResearchObservationReason">
 *   &lt;restriction base="{}cs">
 *     &lt;enumeration value="NPT"/>
 *     &lt;enumeration value="UPT"/>
 *     &lt;enumeration value="PPT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ClinicalResearchObservationReason")
@XmlEnum
public enum ClinicalResearchObservationReason {

    NPT,
    UPT,
    PPT;

    public String value() {
        return name();
    }

    public static ClinicalResearchObservationReason fromValue(String v) {
        return valueOf(v);
    }

}
