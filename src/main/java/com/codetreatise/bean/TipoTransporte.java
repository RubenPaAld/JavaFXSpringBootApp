package com.codetreatise.bean;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="tipo_transporte")
@Access(AccessType.PROPERTY)
public class TipoTransporte {

    private IntegerProperty numero;
    private StringProperty nombre;

    public TipoTransporte() {
        numero = new SimpleIntegerProperty();
        nombre = new SimpleStringProperty();
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

    public String getNombre() {
        return nombre.get();
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoTransporte calidad = (TipoTransporte) o;
        return Objects.equals(numero, calidad.numero) &&
                Objects.equals(nombre, calidad.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, nombre);
    }

    @Override
    public String toString() {
        return "TipoTransporte{" +
                "numero=" + numero +
                ", nombre=" + nombre +
                '}';
    }
}
