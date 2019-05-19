package com.codetreatise.parameters;

import com.codetreatise.bean.Destino;
import com.codetreatise.bean.TipoEstadoEntrega;
import com.codetreatise.bean.TipoTransporte;

import java.util.List;

public class EntregaParameters {

    private List<Destino> destinos;
    private List<TipoTransporte> tipoTransportes;
    private List<TipoEstadoEntrega> tipoEstadoEntregas;

    private StringComparableParameter metrosEntrega;
    private LocalDateIntervalParameter fechaSalida;
    private LocalDateIntervalParameter fechaEstimada;
    private LocalDateIntervalParameter fechaLlegada;

    public List<Destino> getDestinos() {
        return destinos;
    }

    public void setDestinos(List<Destino> destinos) {
        this.destinos = destinos;
    }

    public List<TipoTransporte> getTipoTransportes() {
        return tipoTransportes;
    }

    public void setTipoTransportes(List<TipoTransporte> tipoTransportes) {
        this.tipoTransportes = tipoTransportes;
    }

    public List<TipoEstadoEntrega> getTipoEstadoEntregas() {
        return tipoEstadoEntregas;
    }

    public void setTipoEstadoEntregas(List<TipoEstadoEntrega> tipoEstadoEntregas) {
        this.tipoEstadoEntregas = tipoEstadoEntregas;
    }

    public StringComparableParameter getMetrosEntrega() {
        return metrosEntrega;
    }

    public void setMetrosEntrega(StringComparableParameter metrosEntrega) {
        this.metrosEntrega = metrosEntrega;
    }

    public LocalDateIntervalParameter getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDateIntervalParameter fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public LocalDateIntervalParameter getFechaEstimada() {
        return fechaEstimada;
    }

    public void setFechaEstimada(LocalDateIntervalParameter fechaEstimada) {
        this.fechaEstimada = fechaEstimada;
    }

    public LocalDateIntervalParameter getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(LocalDateIntervalParameter fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }
}
