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
 * <p>Java class for TargetAwareness.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TargetAwareness">
 *   &lt;restriction base="{}cs">
 *     &lt;enumeration value="D"/>
 *     &lt;enumeration value="F"/>
 *     &lt;enumeration value="I"/>
 *     &lt;enumeration value="M"/>
 *     &lt;enumeration value="P"/>
 *     &lt;enumeration value="U"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TargetAwareness")
@XmlEnum
public enum TargetAwareness {

    D,
    F,
    I,
    M,
    P,
    U;

    public String value() {
        return name();
    }

    public static TargetAwareness fromValue(String v) {
        return valueOf(v);
    }

}
