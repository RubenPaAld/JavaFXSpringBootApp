/*
package com.codetreatise.bean;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name="entrega")
public class Entrega {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int numero;

    @ManyToOne()
    @JoinColumn(name="tipo")
    private Tipo tipo;

    @ManyToOne()
    @JoinColumn(name="campana")
    private Campana campana;

    @ManyToOne()
    @JoinColumn(name="destino")
    private Destino destino;

    @ManyToOne()
    @JoinColumn(name="proveedor")
    private Proveedor proveedor;

    @ManyToOne()
    @JoinColumn(name="comprador")
    private Cadena comprador;

    private int calidad;

    private String descripcion;

    private int metrosPedidos;

    private int metrosEntrados;

    private int metrosPendientes;

    //@Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
    private Timestamp fDisponible;

    public int getNumero() {
        return numero;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Campana getCampana() {
        return campana;
    }

    public Destino getDestino() {
        return destino;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public int getCalidad() {
        return calidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getMetrosPedidos() {
        return metrosPedidos;
    }

    public int getMetrosEntrados() {
        return metrosEntrados;
    }

    public int getMetrosPendientes() {
        return metrosPendientes;
    }

    public Timestamp getfDisponible() {
        return fDisponible;
    }

    public Cadena getComprador() {
        return comprador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entrega entrega = (Entrega) o;
        return numero == entrega.numero &&
                calidad == entrega.calidad &&
                metrosPedidos == entrega.metrosPedidos &&
                metrosEntrados == entrega.metrosEntrados &&
                metrosPendientes == entrega.metrosPendientes &&
                Objects.equals(tipo, entrega.tipo) &&
                Objects.equals(campana, entrega.campana) &&
                Objects.equals(destino, entrega.destino) &&
                Objects.equals(proveedor, entrega.proveedor) &&
                Objects.equals(comprador, entrega.comprador) &&
                Objects.equals(descripcion, entrega.descripcion) &&
                Objects.equals(fDisponible, entrega.fDisponible);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, tipo, campana, destino, proveedor, comprador, calidad, descripcion, metrosPedidos, metrosEntrados, metrosPendientes, fDisponible);
    }

    @Override
    public String toString() {
        return "Entrega{" +
                "numero=" + numero +
                ", tipo=" + tipo +
                ", campana=" + campana +
                ", destino=" + destino +
                ", proveedor=" + proveedor +
                ", comprador=" + comprador +
                ", calidad=" + calidad +
                ", descripcion='" + descripcion + '\'' +
                ", metrosPedidos=" + metrosPedidos +
                ", metrosEntrados=" + metrosEntrados +
                ", metrosPendientes=" + metrosPendientes +
                ", fDisponible=" + fDisponible +
                '}';
    }
}
*/
package com.codetreatise.bean;

import javafx.beans.property.*;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name="materia_prima")
@Access(AccessType.PROPERTY)
public class MateriaPrima implements Serializable {

    private IntegerProperty  numero;

    private StringProperty nombre;

    private StringProperty descripcion;

    private ObjectProperty<Calidad> calidad;

    private ObjectProperty<Color> color;

    private ObjectProperty<TipoMateria> tipoMateria;

    public MateriaPrima() {
        this.numero = new SimpleIntegerProperty();
        this.descripcion = new SimpleStringProperty();
        this.nombre = new SimpleStringProperty();
        this.calidad = new SimpleObjectProperty();
        this.color = new SimpleObjectProperty();
        this.tipoMateria = new SimpleObjectProperty();
    }
    @Id
    @Column(name = "numero")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int getNumero() {
        return numero.get();
    }

    public IntegerProperty numeroProperty() {
        return numero;
    }

    @ManyToOne()
    @JoinColumn(name = "calidad")
    public Calidad getCalidad() {
        return calidad.get();
    }

    public ObjectProperty<Calidad> calidadProperty() {
        return calidad;
    }

    @ManyToOne()
    @JoinColumn(name = "color")
    public Color getColor() {
        return color.get();
    }

    public ObjectProperty<Color> colorProperty() {
        return color;
    }

    @Column(name = "descripcion")
    public String getDescripcion() {
        return descripcion.get();
    }

    public StringProperty descripcionProperty() {
        return descripcion;
    }

    @Column(name = "nombre")
    public String getNombre() {
        return nombre.get();
    }

    @ManyToOne()
    @JoinColumn(name = "tipo_materia")
    public TipoMateria getTipoMateria() {
        return tipoMateria.get();
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public void setNumero(int numero) {
        this.numero.set(numero);
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public void setDescripcion(String descripcion) {
        this.descripcion.set(descripcion);
    }

    public void setCalidad(Calidad calidad) {
        this.calidad.set(calidad);
    }

    public void setColor(Color color) {
        this.color.set(color);
    }

    public ObjectProperty<TipoMateria> tipoMateriaProperty() {
        return tipoMateria;
    }

    public void setTipoMateria(TipoMateria tipoMateria) {
        this.tipoMateria.set(tipoMateria);
    }

    @Override
    public String toString() {
        return "MateriaPrima{" +
                "numero=" + numero +
                ", nombre=" + nombre +
                ", descripcion=" + descripcion +
                ", calidad=" + calidad +
                ", color=" + color +
                ", tipoMateria=" + tipoMateria +
                '}';
    }
}
