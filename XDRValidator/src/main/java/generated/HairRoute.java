//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.02.18 at 10:59:00 AM EST 
//


package generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HairRoute.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HairRoute">
 *   &lt;restriction base="{}cs">
 *     &lt;enumeration value="SHAMPOO"/>
 *     &lt;enumeration value="HAIR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HairRoute")
@XmlEnum
public enum HairRoute {

    SHAMPOO,
    HAIR;

    public String value() {
        return name();
    }

    public static HairRoute fromValue(String v) {
        return valueOf(v);
    }

}
