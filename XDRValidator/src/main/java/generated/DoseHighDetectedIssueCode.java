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
 * <p>Java class for DoseHighDetectedIssueCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DoseHighDetectedIssueCode">
 *   &lt;restriction base="{}cs">
 *     &lt;enumeration value="DOSEH"/>
 *     &lt;enumeration value="DOSEHINDA"/>
 *     &lt;enumeration value="DOSEHINDSA"/>
 *     &lt;enumeration value="DOSEHIND"/>
 *     &lt;enumeration value="DOSEHINDW"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DoseHighDetectedIssueCode")
@XmlEnum
public enum DoseHighDetectedIssueCode {

    DOSEH,
    DOSEHINDA,
    DOSEHINDSA,
    DOSEHIND,
    DOSEHINDW;

    public String value() {
        return name();
    }

    public static DoseHighDetectedIssueCode fromValue(String v) {
        return valueOf(v);
    }

}
