//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.05.29 at 11:04:02 AM CEST 
//


package fr.cls.atoll.motu.api.message.xml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 					Response on variables vocabulary query of a product.
 * 				
 * 
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}variableVocabulary" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{}codeMsg"/>
 *       &lt;attribute name="vocabulary" type="{}variableNameVocabulary" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "variableVocabulary"
})
@XmlRootElement(name = "variablesVocabulary")
public class VariablesVocabulary {

    protected List<VariableVocabulary> variableVocabulary;
    @XmlAttribute(name = "vocabulary")
    protected VariableNameVocabulary vocabulary;
    @XmlAttribute(name = "msg")
    protected String msg;
    @XmlAttribute(name = "code")
    protected String code;

    /**
     * Gets the value of the variableVocabulary property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the variableVocabulary property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVariableVocabulary().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VariableVocabulary }
     * 
     * 
     */
    public List<VariableVocabulary> getVariableVocabulary() {
        if (variableVocabulary == null) {
            variableVocabulary = new ArrayList<VariableVocabulary>();
        }
        return this.variableVocabulary;
    }

    /**
     * Gets the value of the vocabulary property.
     * 
     * @return
     *     possible object is
     *     {@link VariableNameVocabulary }
     *     
     */
    public VariableNameVocabulary getVocabulary() {
        return vocabulary;
    }

    /**
     * Sets the value of the vocabulary property.
     * 
     * @param value
     *     allowed object is
     *     {@link VariableNameVocabulary }
     *     
     */
    public void setVocabulary(VariableNameVocabulary value) {
        this.vocabulary = value;
    }

    /**
     * Gets the value of the msg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsg() {
        return msg;
    }

    /**
     * Sets the value of the msg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsg(String value) {
        this.msg = value;
    }

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

}
