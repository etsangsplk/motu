//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.05.29 at 11:04:02 AM CEST 
//


package fr.cls.atoll.motu.api.message.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for variableNameVocabulary.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="variableNameVocabulary">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="CF-1.0"/>
 *     &lt;enumeration value="DIF"/>
 *     &lt;enumeration value="GRIB"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "variableNameVocabulary")
@XmlEnum
public enum VariableNameVocabulary {

    @XmlEnumValue("CF-1.0")
    CF_1_0("CF-1.0"),
    DIF("DIF"),
    GRIB("GRIB");
    private final String value;

    VariableNameVocabulary(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VariableNameVocabulary fromValue(String v) {
        for (VariableNameVocabulary c: VariableNameVocabulary.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
