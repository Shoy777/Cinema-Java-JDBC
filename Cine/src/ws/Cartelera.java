
package ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para cartelera complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="cartelera">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idCartelera" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idLocal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nomCartelera" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cartelera", propOrder = {
    "idCartelera",
    "idLocal",
    "nomCartelera"
})
public class Cartelera {

    protected int idCartelera;
    protected String idLocal;
    protected String nomCartelera;

    /**
     * Obtiene el valor de la propiedad idCartelera.
     * 
     */
    public int getIdCartelera() {
        return idCartelera;
    }

    /**
     * Define el valor de la propiedad idCartelera.
     * 
     */
    public void setIdCartelera(int value) {
        this.idCartelera = value;
    }

    /**
     * Obtiene el valor de la propiedad idLocal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdLocal() {
        return idLocal;
    }

    /**
     * Define el valor de la propiedad idLocal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdLocal(String value) {
        this.idLocal = value;
    }

    /**
     * Obtiene el valor de la propiedad nomCartelera.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomCartelera() {
        return nomCartelera;
    }

    /**
     * Define el valor de la propiedad nomCartelera.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomCartelera(String value) {
        this.nomCartelera = value;
    }

}
