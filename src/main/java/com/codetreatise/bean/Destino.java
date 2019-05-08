package com.codetreatise.bean;

import javafx.beans.property.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="Destino")
public class Destino {

    private IntegerProperty numero;
    private StringProperty nombre;
    private ObjectProperty<Cadena> cadena;

    public Destino() {
        numero = new SimpleIntegerProperty();
        nombre = new SimpleStringProperty();
        cadena = new SimpleObjectProperty();
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

    @Override
    public String toString() {
        return "Destino{" +
                "numero=" + numero +
                ", nombre=" + nombre +
                ", cadena=" + cadena +
                '}';
    }
}
