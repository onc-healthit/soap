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
 * <p>Java class for ActTaskRiskAssessmentInstrumentCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActTaskRiskAssessmentInstrumentCode">
 *   &lt;restriction base="{}cs">
 *     &lt;enumeration value="RISKASSESS"/>
 *     &lt;enumeration value="FALLRISK"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActTaskRiskAssessmentInstrumentCode")
@XmlEnum
public enum ActTaskRiskAssessmentInstrumentCode {

    RISKASSESS,
    FALLRISK;

    public String value() {
        return name();
    }

    public static ActTaskRiskAssessmentInstrumentCode fromValue(String v) {
        return valueOf(v);
    }

}
