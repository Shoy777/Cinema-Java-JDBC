
package ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para cliente complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="cliente">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dni" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idCliente" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nomCompleto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="telFijo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="telMovil" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cliente", propOrder = {
    "dni",
    "email",
    "idCliente",
    "nomCompleto",
    "telFijo",
    "telMovil"
})
public class Cliente {

    protected String dni;
    protected String email;
    protected int idCliente;
    protected String nomCompleto;
    protected String telFijo;
    protected String telMovil;

    /**
     * Obtiene el valor de la propiedad dni.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDni() {
        return dni;
    }

    /**
     * Define el valor de la propiedad dni.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDni(String value) {
        this.dni = value;
    }

    /**
     * Obtiene el valor de la propiedad email.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define el valor de la propiedad email.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Obtiene el valor de la propiedad idCliente.
     * 
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * Define el valor de la propiedad idCliente.
     * 
     */
    public void setIdCliente(int value) {
        this.idCliente = value;
    }

    /**
     * Obtiene el valor de la propiedad nomCompleto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomCompleto() {
        return nomCompleto;
    }

    /**
     * Define el valor de la propiedad nomCompleto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomCompleto(String value) {
        this.nomCompleto = value;
    }

    /**
     * Obtiene el valor de la propiedad telFijo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelFijo() {
        return telFijo;
    }

    /**
     * Define el valor de la propiedad telFijo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelFijo(String value) {
        this.telFijo = value;
    }

    /**
     * Obtiene el valor de la propiedad telMovil.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelMovil() {
        return telMovil;
    }

    /**
     * Define el valor de la propiedad telMovil.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelMovil(String value) {
        this.telMovil = value;
    }

}
