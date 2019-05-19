/*
package com.codetreatise.bean;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name="entregaPedidos")
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
        Entrega entregaPedidos = (Entrega) o;
        return numero == entregaPedidos.numero &&
                calidad == entregaPedidos.calidad &&
                metrosPedidos == entregaPedidos.metrosPedidos &&
                metrosEntrados == entregaPedidos.metrosEntrados &&
                metrosPendientes == entregaPedidos.metrosPendientes &&
                Objects.equals(tipo, entregaPedidos.tipo) &&
                Objects.equals(campana, entregaPedidos.campana) &&
                Objects.equals(destino, entregaPedidos.destino) &&
                Objects.equals(proveedor, entregaPedidos.proveedor) &&
                Objects.equals(comprador, entregaPedidos.comprador) &&
                Objects.equals(descripcion, entregaPedidos.descripcion) &&
                Objects.equals(fDisponible, entregaPedidos.fDisponible);
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.scene.control.CheckBox;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name="pedido")
@Access(AccessType.PROPERTY)
public class Pedido implements Serializable {

    private BooleanProperty selected;

    private IntegerProperty  numero;

    private ObjectProperty<Campana> campana;

    private ObjectProperty<Cadena> cadena;

    private ObjectProperty<Proveedor> proveedor;

    private StringProperty descripcion;

    private ObjectProperty<MateriaPrima> materiaPrima;

    private IntegerProperty metros;

    private ObjectProperty<LocalDate> fechaPedido;

    private StringProperty observaciones;

    private BooleanProperty completado;

    private List<EntregaPedido> entregaPedidos;

    public Pedido() {
        this.selected = new SimpleBooleanProperty(false);
        this.numero = new SimpleIntegerProperty();
        this.campana = new SimpleObjectProperty<>();
        this.cadena = new SimpleObjectProperty<>();
        this.proveedor = new SimpleObjectProperty<>();
        this.descripcion = new SimpleStringProperty();
        this.materiaPrima = new SimpleObjectProperty<>();
        this.metros = new SimpleIntegerProperty();
        this.fechaPedido = new SimpleObjectProperty<>();
        this.observaciones = new SimpleStringProperty();
        this.completado = new SimpleBooleanProperty();
        this.entregaPedidos = new ArrayList<>();
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

    public void setNumero(int numero) {
        this.numero.set(numero);
    }

    @OneToMany(mappedBy = "pedido", fetch = FetchType.EAGER)
    public List<EntregaPedido> getEntregaPedidos() {
        return entregaPedidos;
    }

    public void setEntregaPedidos(List<EntregaPedido> entregaPedidos) {
        this.entregaPedidos = entregaPedidos;
    }

    @ManyToOne()
    @JoinColumn(name = "campana")
    public Campana getCampana() {
        return campana.get();
    }

    public ObjectProperty<Campana> campanaProperty() {
        return campana;
    }

    public void setCampana(Campana campana) {
        this.campana.set(campana);
    }

    @ManyToOne()
    @JoinColumn(name = "cadena")
    public Cadena getCadena() {
        return cadena.get();
    }

    public ObjectProperty<Cadena> cadenaProperty() {
        return cadena;
    }

    public void setCadena(Cadena cadena) {
        this.cadena.set(cadena);
    }

    @ManyToOne()
    @JoinColumn(name = "proveedor")
    public Proveedor getProveedor() {
        return proveedor.get();
    }

    public ObjectProperty<Proveedor> proveedorProperty() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor.set(proveedor);
    }

    public String getDescripcion() {
        return descripcion.get();
    }

    public StringProperty descripcionProperty() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion.set(descripcion);
    }

    @ManyToOne()
    @JoinColumn(name = "materia_prima")
    public MateriaPrima getMateriaPrima() {
        return materiaPrima.get();
    }

    public ObjectProperty<MateriaPrima> materiaPrimaProperty() {
        return materiaPrima;
    }

    public void setMateriaPrima(MateriaPrima materiaPrima) {
        this.materiaPrima.set(materiaPrima);
    }

    public int getMetros() {
        return metros.get();
    }

    public IntegerProperty metrosProperty() {
        return metros;
    }

    public void setMetros(int metros) {
        this.metros.set(metros);
    }

    @Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
    public LocalDate getFechaPedido() {
        return fechaPedido.get();
    }

    public ObjectProperty<LocalDate> fechaPedidoProperty() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido.set(fechaPedido);
    }

    public String getObservaciones() {
        return observaciones.get();
    }

    public StringProperty observacionesProperty() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones.set(observaciones);
    }

    public boolean isCompletado() {
        return completado.get();
    }

    public BooleanProperty completadoProperty() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado.set(completado);
    }

    @Transient
    public boolean isSelected() {
        return selected.get();
    }

    public BooleanProperty selectedProperty() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected.set(selected);
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "seleccionado " + selected +
                "numero=" + numero +
                ", campana=" + campana +
                ", cadena=" + cadena +
                ", proveedor=" + proveedor +
                ", descripcion=" + descripcion +
                ", materiaPrima=" + materiaPrima +
                ", metros=" + metros +
                ", fechaPedido=" + fechaPedido +
                ", observaciones=" + observaciones +
                ", completado=" + completado +
                ", entregas " + entregaPedidos.size() +
                '}';
    }
}
