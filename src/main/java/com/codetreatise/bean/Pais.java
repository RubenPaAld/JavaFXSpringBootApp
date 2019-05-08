package com.codetreatise.bean;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="pais")
@Access(AccessType.PROPERTY)
public class Pais {

    private IntegerProperty numero;
    private StringProperty nombre;

    public Pais() {
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
    public String toString() {
        return "Pais{" +
                "numero=" + numero +
                ", nombre=" + nombre +
                '}';
    }
}
