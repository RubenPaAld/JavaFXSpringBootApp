package com.codetreatise.bean;

import javafx.beans.property.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="proveedor")
@Access(AccessType.PROPERTY)
public class Proveedor {

    private IntegerProperty numero;
    private StringProperty nombre;
    private ObjectProperty<Pais> pais;

    public Proveedor() {
        numero = new SimpleIntegerProperty();
        nombre = new SimpleStringProperty();
        pais = new SimpleObjectProperty<>();
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

    @ManyToOne()
    @JoinColumn(name = "pais")
    public Pais getPais() {
        return pais.get();
    }

    public ObjectProperty<Pais> paisProperty() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais.set(pais);
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "numero=" + numero +
                ", nombre=" + nombre +
                ", pais=" + pais +
                '}';
    }
}
