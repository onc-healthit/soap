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
 * <p>Java class for Yokutsan.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Yokutsan">
 *   &lt;restriction base="{}cs">
 *     &lt;enumeration value="x-GSH"/>
 *     &lt;enumeration value="x-ENH"/>
 *     &lt;enumeration value="x-PYL"/>
 *     &lt;enumeration value="x-TKH"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Yokutsan")
@XmlEnum
public enum Yokutsan {

    @XmlEnumValue("x-GSH")
    X_GSH("x-GSH"),
    @XmlEnumValue("x-ENH")
    X_ENH("x-ENH"),
    @XmlEnumValue("x-PYL")
    X_PYL("x-PYL"),
    @XmlEnumValue("x-TKH")
    X_TKH("x-TKH");
    private final String value;

    Yokutsan(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Yokutsan fromValue(String v) {
        for (Yokutsan c: Yokutsan.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
