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
 * <p>Java class for PrimaryDentition.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PrimaryDentition">
 *   &lt;restriction base="{}cs">
 *     &lt;enumeration value="TIDA"/>
 *     &lt;enumeration value="TIDB"/>
 *     &lt;enumeration value="TIDC"/>
 *     &lt;enumeration value="TIDD"/>
 *     &lt;enumeration value="TIDE"/>
 *     &lt;enumeration value="TIDF"/>
 *     &lt;enumeration value="TIDG"/>
 *     &lt;enumeration value="TIDH"/>
 *     &lt;enumeration value="TIDI"/>
 *     &lt;enumeration value="TIDJ"/>
 *     &lt;enumeration value="TIDK"/>
 *     &lt;enumeration value="TIDL"/>
 *     &lt;enumeration value="TIDM"/>
 *     &lt;enumeration value="TIDN"/>
 *     &lt;enumeration value="TIDO"/>
 *     &lt;enumeration value="TIDP"/>
 *     &lt;enumeration value="TIDQ"/>
 *     &lt;enumeration value="TIDR"/>
 *     &lt;enumeration value="TIDS"/>
 *     &lt;enumeration value="TIDT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PrimaryDentition")
@XmlEnum
public enum PrimaryDentition {

    TIDA,
    TIDB,
    TIDC,
    TIDD,
    TIDE,
    TIDF,
    TIDG,
    TIDH,
    TIDI,
    TIDJ,
    TIDK,
    TIDL,
    TIDM,
    TIDN,
    TIDO,
    TIDP,
    TIDQ,
    TIDR,
    TIDS,
    TIDT;

    public String value() {
        return name();
    }

    public static PrimaryDentition fromValue(String v) {
        return valueOf(v);
    }

}
