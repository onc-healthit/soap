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
 * <p>Java class for GreatGrandparent.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="GreatGrandparent">
 *   &lt;restriction base="{}cs">
 *     &lt;enumeration value="GGRPRN"/>
 *     &lt;enumeration value="MGGRFTH"/>
 *     &lt;enumeration value="MGGRMTH"/>
 *     &lt;enumeration value="MGGRPRN"/>
 *     &lt;enumeration value="PGGRFTH"/>
 *     &lt;enumeration value="PGGRMTH"/>
 *     &lt;enumeration value="PGGRPRN"/>
 *     &lt;enumeration value="GGRFTH"/>
 *     &lt;enumeration value="GGRMTH"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "GreatGrandparent")
@XmlEnum
public enum GreatGrandparent {

    GGRPRN,
    MGGRFTH,
    MGGRMTH,
    MGGRPRN,
    PGGRFTH,
    PGGRMTH,
    PGGRPRN,
    GGRFTH,
    GGRMTH;

    public String value() {
        return name();
    }

    public static GreatGrandparent fromValue(String v) {
        return valueOf(v);
    }

}
