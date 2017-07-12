
package ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para pelicula complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="pelicula">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fecEstreno" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="idPelicula" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nomPelicula" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pelicula", propOrder = {
    "fecEstreno",
    "idPelicula",
    "nomPelicula",
    "tipo"
})
public class Pelicula {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fecEstreno;
    protected int idPelicula;
    protected String nomPelicula;
    protected String tipo;

    /**
     * Obtiene el valor de la propiedad fecEstreno.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFecEstreno() {
        return fecEstreno;
    }

    /**
     * Define el valor de la propiedad fecEstreno.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFecEstreno(XMLGregorianCalendar value) {
        this.fecEstreno = value;
    }

    /**
     * Obtiene el valor de la propiedad idPelicula.
     * 
     */
    public int getIdPelicula() {
        return idPelicula;
    }

    /**
     * Define el valor de la propiedad idPelicula.
     * 
     */
    public void setIdPelicula(int value) {
        this.idPelicula = value;
    }

    /**
     * Obtiene el valor de la propiedad nomPelicula.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomPelicula() {
        return nomPelicula;
    }

    /**
     * Define el valor de la propiedad nomPelicula.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomPelicula(String value) {
        this.nomPelicula = value;
    }

    /**
     * Obtiene el valor de la propiedad tipo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Define el valor de la propiedad tipo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipo(String value) {
        this.tipo = value;
    }

}
