//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.06.26 at 08:48:51 AM EDT 
//


package generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActInformationAccess.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActInformationAccess">
 *   &lt;restriction base="{}cs">
 *     &lt;enumeration value="INFA"/>
 *     &lt;enumeration value="INFASO"/>
 *     &lt;enumeration value="INFAO"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActInformationAccess")
@XmlEnum
public enum ActInformationAccess {

    INFA,
    INFASO,
    INFAO;

    public String value() {
        return name();
    }

    public static ActInformationAccess fromValue(String v) {
        return valueOf(v);
    }

}
