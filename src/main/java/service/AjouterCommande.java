
package service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ajouterCommande complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ajouterCommande">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codeCmd" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="client" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codePdt" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="qteCmd" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="dateCmd" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ajouterCommande", propOrder = {
    "codeCmd",
    "client",
    "codePdt",
    "qteCmd",
    "dateCmd"
})
public class AjouterCommande {

    protected int codeCmd;
    protected String client;
    protected int codePdt;
    protected int qteCmd;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateCmd;

    /**
     * Gets the value of the codeCmd property.
     * 
     */
    public int getCodeCmd() {
        return codeCmd;
    }

    /**
     * Sets the value of the codeCmd property.
     * 
     */
    public void setCodeCmd(int value) {
        this.codeCmd = value;
    }

    /**
     * Gets the value of the client property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClient() {
        return client;
    }

    /**
     * Sets the value of the client property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClient(String value) {
        this.client = value;
    }

    /**
     * Gets the value of the codePdt property.
     * 
     */
    public int getCodePdt() {
        return codePdt;
    }

    /**
     * Sets the value of the codePdt property.
     * 
     */
    public void setCodePdt(int value) {
        this.codePdt = value;
    }

    /**
     * Gets the value of the qteCmd property.
     * 
     */
    public int getQteCmd() {
        return qteCmd;
    }

    /**
     * Sets the value of the qteCmd property.
     * 
     */
    public void setQteCmd(int value) {
        this.qteCmd = value;
    }

    /**
     * Gets the value of the dateCmd property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateCmd() {
        return dateCmd;
    }

    /**
     * Sets the value of the dateCmd property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateCmd(XMLGregorianCalendar value) {
        this.dateCmd = value;
    }

}
