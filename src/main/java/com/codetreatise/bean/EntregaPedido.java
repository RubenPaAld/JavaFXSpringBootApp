package com.codetreatise.bean;

import javafx.beans.property.*;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="entrega_pedido")
@Access(AccessType.PROPERTY)
public class EntregaPedido {

    private IntegerProperty numero;

    private IntegerProperty metros;

    private ObjectProperty<TipoTransporte> tipoTransporte;

    private ObjectProperty<Destino> destino;

    private ObjectProperty<LocalDate> fechaSalida;

    private ObjectProperty<LocalDate> fechaEstimada;

    private ObjectProperty<LocalDate> fechaLlegada;

    private StringProperty observaciones;

    private ObjectProperty<Pedido> pedido;

    private ObjectProperty<TipoEstadoEntrega> tipoEstadoEntrega;

    public EntregaPedido() {

        this.numero = new SimpleIntegerProperty();
        this.metros = new SimpleIntegerProperty();
        this.tipoTransporte = new SimpleObjectProperty<>();
        this.destino = new SimpleObjectProperty<>();
        this.fechaSalida = new SimpleObjectProperty<>();
        this.fechaEstimada = new SimpleObjectProperty<>();
        this.fechaLlegada = new SimpleObjectProperty<>();
        this.observaciones = new SimpleStringProperty();
        this.pedido = new SimpleObjectProperty<>();
        this.tipoEstadoEntrega = new SimpleObjectProperty<>();
    }

    @Id
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

    public int getMetros() {
        return metros.get();
    }

    public IntegerProperty metrosProperty() {
        return metros;
    }

    public void setMetros(int metros) {
        this.metros.set(metros);
    }

    @ManyToOne()
    @JoinColumn(name = "tipo_transporte")
    public TipoTransporte getTipoTransporte() {
        return tipoTransporte.get();
    }

    public ObjectProperty<TipoTransporte> tipoTransporteProperty() {
        return tipoTransporte;
    }

    public void setTipoTransporte(TipoTransporte tipoTransporte) {
        this.tipoTransporte.set(tipoTransporte);
    }

    @ManyToOne()
    @JoinColumn(name = "destino")
    public Destino getDestino() {
        return destino.get();
    }

    public ObjectProperty<Destino> destinoProperty() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino.set(destino);
    }

    @Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
    public LocalDate getFechaSalida() {
        return fechaSalida.get();
    }

    public ObjectProperty<LocalDate> fechaSalidaProperty() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida.set(fechaSalida);
    }

    @Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
    public LocalDate getFechaEstimada() {
        return fechaEstimada.get();
    }

    public ObjectProperty<LocalDate> fechaEstimadaProperty() {
        return fechaEstimada;
    }

    public void setFechaEstimada(LocalDate fechaEstimada) {
        this.fechaEstimada.set(fechaEstimada);
    }

    @Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
    public LocalDate getFechaLlegada() {
        return fechaLlegada.get();
    }

    public ObjectProperty<LocalDate> fechaLlegadaProperty() {
        return fechaLlegada;
    }

    public void setFechaLlegada(LocalDate fechaLlegada) {
        this.fechaLlegada.set(fechaLlegada);
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

    @ManyToOne()
    @JoinColumn(name = "pedido")
    public Pedido getPedido() {
        return pedido.get();
    }

    public ObjectProperty<Pedido> pedidoProperty() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido.set(pedido);
    }

    @ManyToOne()
    @JoinColumn(name = "tipo_estado_entrega")
    public TipoEstadoEntrega getTipoEstadoEntrega() {
        return tipoEstadoEntrega.get();
    }

    public ObjectProperty<TipoEstadoEntrega> tipoEstadoEntregaProperty() {
        return tipoEstadoEntrega;
    }

    public void setTipoEstadoEntrega(TipoEstadoEntrega tipoEstadoEntrega) {
        this.tipoEstadoEntrega.set(tipoEstadoEntrega);
    }

    @Override
    public String toString() {
        return "EntregaPedido{" +
                "numero=" + numero +
                ", metros=" + metros +
                ", tipoTransporte=" + tipoTransporte +
                ", destino=" + destino +
                ", fechaSalida=" + fechaSalida +
                ", fechaEstimada=" + fechaEstimada +
                ", fechaLlegada=" + fechaLlegada +
                ", observaciones=" + observaciones +
                //", pedido=" + pedido +
                ", tipoEstadoEntrega=" + tipoEstadoEntrega +
                '}';
    }
}
