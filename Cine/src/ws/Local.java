
package ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para local complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="local">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dirLocal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idLocal" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nomLocal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ubiLocal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "local", propOrder = {
    "dirLocal",
    "idLocal",
    "nomLocal",
    "ubiLocal"
})
public class Local {

    protected String dirLocal;
    protected int idLocal;
    protected String nomLocal;
    protected String ubiLocal;

    /**
     * Obtiene el valor de la propiedad dirLocal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDirLocal() {
        return dirLocal;
    }

    /**
     * Define el valor de la propiedad dirLocal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirLocal(String value) {
        this.dirLocal = value;
    }

    /**
     * Obtiene el valor de la propiedad idLocal.
     * 
     */
    public int getIdLocal() {
        return idLocal;
    }

    /**
     * Define el valor de la propiedad idLocal.
     * 
     */
    public void setIdLocal(int value) {
        this.idLocal = value;
    }

    /**
     * Obtiene el valor de la propiedad nomLocal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomLocal() {
        return nomLocal;
    }

    /**
     * Define el valor de la propiedad nomLocal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomLocal(String value) {
        this.nomLocal = value;
    }

    /**
     * Obtiene el valor de la propiedad ubiLocal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUbiLocal() {
        return ubiLocal;
    }

    /**
     * Define el valor de la propiedad ubiLocal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUbiLocal(String value) {
        this.ubiLocal = value;
    }

}
