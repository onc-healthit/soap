//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.02.16 at 12:17:07 PM EST 
//


package generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HL7ITSVersionCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HL7ITSVersionCode">
 *   &lt;restriction base="{}cs">
 *     &lt;enumeration value="XMLV1PR1"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HL7ITSVersionCode")
@XmlEnum
public enum HL7ITSVersionCode {

    @XmlEnumValue("XMLV1PR1")
    XMLV_1_PR_1("XMLV1PR1");
    private final String value;

    HL7ITSVersionCode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HL7ITSVersionCode fromValue(String v) {
        for (HL7ITSVersionCode c: HL7ITSVersionCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
