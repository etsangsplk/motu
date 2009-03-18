//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation,
// vhudson-jaxb-3268
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2007.12.21 at 08:38:29 AM CET
//

package fr.cls.atoll.motu.library.opendap.server;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

/**
 * <p>
 * Java class for AggregationType.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 * 
 * <pre>
 *  &lt;simpleType name=&quot;AggregationType&quot;&gt;
 *    &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}token&quot;&gt;
 *      &lt;enumeration value=&quot;JoinNew&quot;/&gt;
 *      &lt;enumeration value=&quot;Union&quot;/&gt;
 *      &lt;enumeration value=&quot;JoinExisting&quot;/&gt;
 *    &lt;/restriction&gt;
 *  &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlEnum
public enum AggregationType {

    @XmlEnumValue("JoinExisting")
    JOIN_EXISTING("JoinExisting"), @XmlEnumValue("JoinNew")
    JOIN_NEW("JoinNew"), @XmlEnumValue("Union")
    UNION("Union");
    private final String value;

    AggregationType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AggregationType fromValue(String v) {
        for (AggregationType c : AggregationType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v.toString());
    }

}
