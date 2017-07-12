
package ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para sala complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="sala">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idSala" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numSala" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sala", propOrder = {
    "idSala",
    "numSala"
})
public class Sala {

    protected int idSala;
    protected String numSala;

    /**
     * Obtiene el valor de la propiedad idSala.
     * 
     */
    public int getIdSala() {
        return idSala;
    }

    /**
     * Define el valor de la propiedad idSala.
     * 
     */
    public void setIdSala(int value) {
        this.idSala = value;
    }

    /**
     * Obtiene el valor de la propiedad numSala.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumSala() {
        return numSala;
    }

    /**
     * Define el valor de la propiedad numSala.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumSala(String value) {
        this.numSala = value;
    }

}
