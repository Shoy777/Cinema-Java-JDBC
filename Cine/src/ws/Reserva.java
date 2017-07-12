
package ws;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para reserva complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="reserva">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cliente" type="{http://ws/}cliente" minOccurs="0"/>
 *         &lt;element name="detalleCartelera" type="{http://ws/}detalleCartelera" minOccurs="0"/>
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fecReserva" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="idCliente" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idDetalle" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idReserva" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="local" type="{http://ws/}local" minOccurs="0"/>
 *         &lt;element name="pelicula" type="{http://ws/}pelicula" minOccurs="0"/>
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
@XmlType(name = "reserva", propOrder = {
    "cliente",
    "detalleCartelera",
    "estado",
    "fecReserva",
    "idCliente",
    "idDetalle",
    "idReserva",
    "local",
    "pelicula",
    "sala"
})
public class Reserva {

    protected Cliente cliente;
    protected DetalleCartelera detalleCartelera;
    protected String estado;
    @XmlSchemaType(name = "dateTime")
    protected Date fecReserva;
    protected int idCliente;
    protected int idDetalle;
    protected int idReserva;
    protected Local local;
    protected Pelicula pelicula;
    protected Sala sala;

    /**
     * Obtiene el valor de la propiedad cliente.
     * 
     * @return
     *     possible object is
     *     {@link Cliente }
     *     
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Define el valor de la propiedad cliente.
     * 
     * @param value
     *     allowed object is
     *     {@link Cliente }
     *     
     */
    public void setCliente(Cliente value) {
        this.cliente = value;
    }

    /**
     * Obtiene el valor de la propiedad detalleCartelera.
     * 
     * @return
     *     possible object is
     *     {@link DetalleCartelera }
     *     
     */
    public DetalleCartelera getDetalleCartelera() {
        return detalleCartelera;
    }

    /**
     * Define el valor de la propiedad detalleCartelera.
     * 
     * @param value
     *     allowed object is
     *     {@link DetalleCartelera }
     *     
     */
    public void setDetalleCartelera(DetalleCartelera value) {
        this.detalleCartelera = value;
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
     * Obtiene el valor de la propiedad fecReserva.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public Date getFecReserva() {
        return fecReserva;
    }

    /**
     * Define el valor de la propiedad fecReserva.
     * 
     * @param fechaD
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFecReserva(Date fechaD) {
        this.fecReserva = fechaD;
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
     * Obtiene el valor de la propiedad idReserva.
     * 
     */
    public int getIdReserva() {
        return idReserva;
    }

    /**
     * Define el valor de la propiedad idReserva.
     * 
     */
    public void setIdReserva(int value) {
        this.idReserva = value;
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
