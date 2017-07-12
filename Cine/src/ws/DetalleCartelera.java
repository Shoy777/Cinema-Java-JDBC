
package ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para detalleCartelera complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="detalleCartelera">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cartelera" type="{http://ws/}cartelera" minOccurs="0"/>
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fecFin" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fecInicio" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="horaFin" type="{http://ws/}time" minOccurs="0"/>
 *         &lt;element name="horaInicio" type="{http://ws/}time" minOccurs="0"/>
 *         &lt;element name="idCartelera" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idDetalle" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idPelicula" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idSala" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="local" type="{http://ws/}local" minOccurs="0"/>
 *         &lt;element name="pelicula" type="{http://ws/}pelicula" minOccurs="0"/>
 *         &lt;element name="precio" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="sala" type="{http://ws/}sala" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "detalleCartelera", propOrder = {
    "cartelera",
    "estado",
    "fecFin",
    "fecInicio",
    "horaFin",
    "horaInicio",
    "idCartelera",
    "idDetalle",
    "idPelicula",
    "idSala",
    "local",
    "pelicula",
    "precio",
    "sala"
})
public class DetalleCartelera {

    protected Cartelera cartelera;
    protected String estado;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fecFin;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fecInicio;
    protected Time horaFin;
    protected Time horaInicio;
    protected int idCartelera;
    protected int idDetalle;
    protected int idPelicula;
    protected int idSala;
    protected Local local;
    protected Pelicula pelicula;
    protected double precio;
    protected Sala sala;

    /**
     * Obtiene el valor de la propiedad cartelera.
     * 
     * @return
     *     possible object is
     *     {@link Cartelera }
     *     
     */
    public Cartelera getCartelera() {
        return cartelera;
    }

    /**
     * Define el valor de la propiedad cartelera.
     * 
     * @param value
     *     allowed object is
     *     {@link Cartelera }
     *     
     */
    public void setCartelera(Cartelera value) {
        this.cartelera = value;
    }

    /**
     * Obtiene el valor de la propiedad estado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Define el valor de la propiedad estado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstado(String value) {
        this.estado = value;
    }

    /**
     * Obtiene el valor de la propiedad fecFin.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFecFin() {
        return fecFin;
    }

    /**
     * Define el valor de la propiedad fecFin.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFecFin(XMLGregorianCalendar value) {
        this.fecFin = value;
    }

    /**
     * Obtiene el valor de la propiedad fecInicio.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFecInicio() {
        return fecInicio;
    }

    /**
     * Define el valor de la propiedad fecInicio.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFecInicio(XMLGregorianCalendar value) {
        this.fecInicio = value;
    }

    /**
     * Obtiene el valor de la propiedad horaFin.
     * 
     * @return
     *     possible object is
     *     {@link Time }
     *     
     */
    public Time getHoraFin() {
        return horaFin;
    }

    /**
     * Define el valor de la propiedad horaFin.
     * 
     * @param value
     *     allowed object is
     *     {@link Time }
     *     
     */
    public void setHoraFin(Time value) {
        this.horaFin = value;
    }

    /**
     * Obtiene el valor de la propiedad horaInicio.
     * 
     * @return
     *     possible object is
     *     {@link Time }
     *     
     */
    public Time getHoraInicio() {
        return horaInicio;
    }

    /**
     * Define el valor de la propiedad horaInicio.
     * 
     * @param value
     *     allowed object is
     *     {@link Time }
     *     
     */
    public void setHoraInicio(Time value) {
        this.horaInicio = value;
    }

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
     * Obtiene el valor de la propiedad idDetalle.
     * 
     */
    public int getIdDetalle() {
        return idDetalle;
    }

    /**
     * Define el valor de la propiedad idDetalle.
     * 
     */
    public void setIdDetalle(int value) {
        this.idDetalle = value;
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
     * Obtiene el valor de la propiedad local.
     * 
     * @return
     *     possible object is
     *     {@link Local }
     *     
     */
    public Local getLocal() {
        return local;
    }

    /**
     * Define el valor de la propiedad local.
     * 
     * @param value
     *     allowed object is
     *     {@link Local }
     *     
     */
    public void setLocal(Local value) {
        this.local = value;
    }

    /**
     * Obtiene el valor de la propiedad pelicula.
     * 
     * @return
     *     possible object is
     *     {@link Pelicula }
     *     
     */
    public Pelicula getPelicula() {
        return pelicula;
    }

    /**
     * Define el valor de la propiedad pelicula.
     * 
     * @param value
     *     allowed object is
     *     {@link Pelicula }
     *     
     */
    public void setPelicula(Pelicula value) {
        this.pelicula = value;
    }

    /**
     * Obtiene el valor de la propiedad precio.
     * 
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Define el valor de la propiedad precio.
     * 
     */
    public void setPrecio(double value) {
        this.precio = value;
    }

    /**
     * Obtiene el valor de la propiedad sala.
     * 
     * @return
     *     possible object is
     *     {@link Sala }
     *     
     */
    public Sala getSala() {
        return sala;
    }

    /**
     * Define el valor de la propiedad sala.
     * 
     * @param value
     *     allowed object is
     *     {@link Sala }
     *     
     */
    public void setSala(Sala value) {
        this.sala = value;
    }

}
