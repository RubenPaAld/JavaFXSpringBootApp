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
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="entrega")
@Access(AccessType.PROPERTY)
public class Entrega implements Serializable {

    private IntegerProperty  numero;

    private Tipo tipo;

    private Campana campana;

    private Destino destino;

    private Proveedor proveedor;

    private Cadena comprador;

    private int calidad;

    private StringProperty descripcion;

    private IntegerProperty  metrosPedidos;

    private IntegerProperty  metrosEntrados;

    private IntegerProperty metrosPendientes;

    private ObjectProperty<LocalDate> fDisponible;

    public Entrega() {
        numero = new SimpleIntegerProperty();
        this.descripcion = new SimpleStringProperty();
        this.metrosPedidos = new SimpleIntegerProperty();
        this.metrosEntrados = new SimpleIntegerProperty();
        this.metrosPendientes = new SimpleIntegerProperty();
        this.fDisponible = new SimpleObjectProperty();

    }

    public Entrega(int numero, Tipo tipo, Campana campana, Destino destino, Proveedor proveedor, Cadena comprador, int calidad, String descripcion, int metrosPedidos, int metrosEntrados, int metrosPendientes, LocalDate fDisponible) {
        this.numero = new SimpleIntegerProperty(numero);
        this.tipo = tipo;
        this.campana = campana;
        this.destino = destino;
        this.proveedor = proveedor;
        this.comprador = comprador;
        this.calidad = calidad;
        this.descripcion = new SimpleStringProperty(descripcion);
        this.metrosPedidos = new SimpleIntegerProperty(metrosPedidos);
        this.metrosEntrados = new SimpleIntegerProperty(metrosEntrados);
        this.metrosPendientes = new SimpleIntegerProperty(metrosPendientes);
        this.fDisponible = new SimpleObjectProperty(fDisponible);
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
    @JoinColumn(name="tipo")
    public Tipo getTipo() {
        return tipo;
    }

    @ManyToOne()
    @JoinColumn(name="campana")
    public Campana getCampana() {
        return campana;
    }

    @ManyToOne()
    @JoinColumn(name="destino")
    public Destino getDestino() {
        return destino;
    }

    @ManyToOne()
    @JoinColumn(name="proveedor")
    public Proveedor getProveedor() {
        return proveedor;
    }

    @ManyToOne()
    @JoinColumn(name="comprador")
    public Cadena getComprador() {
        return comprador;
    }

    @Column(name = "calidad")
    public int getCalidad() {
        return calidad;
    }

    @Column(name = "descripcion")
    public String getDescripcion() {
        return descripcion.get();
    }

    public StringProperty descripcionProperty() {
        return descripcion;
    }

    @Column(name = "metros_pedidos")
    public int getMetrosPedidos() {
        return metrosPedidos.get();
    }

    public IntegerProperty metrosPedidosProperty() {
        return metrosPedidos;
    }

    @Column(name = "metros_entrados")
    public int getMetrosEntrados() {
        return metrosEntrados.get();
    }

    public IntegerProperty metrosEntradosProperty() {
        return metrosEntrados;
    }

    @Column(name = "metros_pendientes")
    public int getMetrosPendientes() {
        return metrosPendientes.get();
    }

    public IntegerProperty metrosPendientesProperty() {
        return metrosPendientes;
    }

    @Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
    @Column(name = "f_disponible")
    public LocalDate getfDisponible() {
        return fDisponible.get();
    }

    public ObjectProperty<LocalDate> fDisponibleProperty() {
        return fDisponible;
    }

    public void setNumero(int numero) {
        this.numero.set(numero);
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public void setCampana(Campana campana) {
        this.campana = campana;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public void setComprador(Cadena comprador) {
        this.comprador = comprador;
    }

    public void setCalidad(int calidad) {
        this.calidad = calidad;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion.set(descripcion);
    }

    public void setMetrosPedidos(int metrosPedidos) {
        this.metrosPedidos.set(metrosPedidos);
    }

    public void setMetrosEntrados(int metrosEntrados) {
        this.metrosEntrados.set(metrosEntrados);
    }

    public void setMetrosPendientes(int metrosPendientes) {
        this.metrosPendientes.set(metrosPendientes);
    }

    public void setfDisponible(LocalDate fDisponible) {
        this.fDisponible.set(fDisponible);
    }
}
