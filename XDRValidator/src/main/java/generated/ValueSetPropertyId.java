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
 * <p>Java class for ValueSetPropertyId.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ValueSetPropertyId">
 *   &lt;restriction base="{}cs">
 *     &lt;enumeration value="appliesTo"/>
 *     &lt;enumeration value="howApplies"/>
 *     &lt;enumeration value="openIssue"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ValueSetPropertyId")
@XmlEnum
public enum ValueSetPropertyId {

    @XmlEnumValue("appliesTo")
    APPLIES_TO("appliesTo"),
    @XmlEnumValue("howApplies")
    HOW_APPLIES("howApplies"),
    @XmlEnumValue("openIssue")
    OPEN_ISSUE("openIssue");
    private final String value;

    ValueSetPropertyId(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ValueSetPropertyId fromValue(String v) {
        for (ValueSetPropertyId c: ValueSetPropertyId.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
