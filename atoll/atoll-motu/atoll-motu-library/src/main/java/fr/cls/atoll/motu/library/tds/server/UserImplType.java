//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-3268 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2008.01.16 at 12:27:53 PM CET 
//

package fr.cls.atoll.motu.library.tds.server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import org.w3c.dom.Element;

/**
 * <p>
 * Java class for UserImplType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 *  &lt;complexType name=&quot;UserImplType&quot;&gt;
 *    &lt;complexContent&gt;
 *      &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *        &lt;sequence&gt;
 *          &lt;any/&gt;
 *        &lt;/sequence&gt;
 *        &lt;attribute name=&quot;className&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; /&gt;
 *      &lt;/restriction&gt;
 *    &lt;/complexContent&gt;
 *  &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserImplType", propOrder = { "any" })
public class UserImplType {

    @XmlAnyElement(lax = true)
    protected Object any;
    @XmlAttribute
    protected String className;

    /**
     * Gets the value of the any property.
     * 
     * @return possible object is {@link Object } {@link Element }
     * 
     */
    public Object getAny() {
        return any;
    }

    /**
     * Sets the value of the any property.
     * 
     * @param value allowed object is {@link Object } {@link Element }
     * 
     */
    public void setAny(Object value) {
        this.any = value;
    }

    /**
     * Gets the value of the className property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getClassName() {
        return className;
    }

    /**
     * Sets the value of the className property.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setClassName(String value) {
        this.className = value;
    }

}
