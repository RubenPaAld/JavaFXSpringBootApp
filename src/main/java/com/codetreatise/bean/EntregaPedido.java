package com.codetreatise.bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="entrega_pedido")
public class EntregaPedido {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int numero;

    private String nombre;

    public int getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntregaPedido cadena = (EntregaPedido) o;
        return numero == cadena.numero &&
                Objects.equals(nombre, cadena.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, nombre);
    }

    @Override
    public String toString() {
        return "EntregaPedido{" +
                "numero=" + numero +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
