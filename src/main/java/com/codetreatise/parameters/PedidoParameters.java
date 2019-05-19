package com.codetreatise.parameters;

import com.codetreatise.bean.Cadena;
import com.codetreatise.bean.Campana;
import com.codetreatise.bean.MateriaPrima;
import com.codetreatise.bean.Proveedor;

import java.util.List;

public class PedidoParameters {

    private List<Campana> campanas;
    private List<Cadena> cadenas;
    private List<Proveedor> proveedores;
    private List<MateriaPrima> materiasPrimas;
    private LocalDateIntervalParameter fechaPedido;
    private StringComparableParameter metrosPedido;
    private Boolean completado;

    public List<Campana> getCampanas() {
        return campanas;
    }

    public void setCampanas(List<Campana> campanas) {
        this.campanas = campanas;
    }

    public List<Cadena> getCadenas() {
        return cadenas;
    }

    public void setCadenas(List<Cadena> cadenas) {
        this.cadenas = cadenas;
    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

    public List<MateriaPrima> getMateriasPrimas() {
        return materiasPrimas;
    }

    public void setMateriasPrimas(List<MateriaPrima> materiasPrimas) {
        this.materiasPrimas = materiasPrimas;
    }

    public LocalDateIntervalParameter getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDateIntervalParameter fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Boolean getCompletado() {
        return completado;
    }

    public void setCompletado(Boolean completado) {
        this.completado = completado;
    }

    public StringComparableParameter getMetrosPedido() {
        return metrosPedido;
    }

    public void setMetrosPedido(StringComparableParameter metrosPedido) {
        this.metrosPedido = metrosPedido;
    }
}