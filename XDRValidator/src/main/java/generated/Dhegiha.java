//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.02.18 at 10:59:00 AM EST 
//


package generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Dhegiha.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Dhegiha">
 *   &lt;restriction base="{}cs">
 *     &lt;enumeration value="x-KAA"/>
 *     &lt;enumeration value="x-OMA"/>
 *     &lt;enumeration value="x-OSA"/>
 *     &lt;enumeration value="x-QUA"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Dhegiha")
@XmlEnum
public enum Dhegiha {

    @XmlEnumValue("x-KAA")
    X_KAA("x-KAA"),
    @XmlEnumValue("x-OMA")
    X_OMA("x-OMA"),
    @XmlEnumValue("x-OSA")
    X_OSA("x-OSA"),
    @XmlEnumValue("x-QUA")
    X_QUA("x-QUA");
    private final String value;

    Dhegiha(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Dhegiha fromValue(String v) {
        for (Dhegiha c: Dhegiha.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
