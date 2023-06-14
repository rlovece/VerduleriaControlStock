package org.example.Moldes;

import org.example.enums.Categorias;

import java.io.Serializable;
import java.util.Objects;

public class Producto implements Serializable {
    private static final long serialVersionUID = 2222222222222222201L;

    private int id;
    private String descripcion;
    private double precio;
    private int stock;
    private Categorias categoria;

    //region Constructores

    public Producto(int id, String descripcion, double precio, int stock, Categorias categoria) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }

    public Producto (){}

    //endregion

    //region getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

    //endregion

    //region equal y hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return id == producto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    //endregion

    @Override
    public String toString() {
        return "\n\n Producto " + id +
                ", Categoria: " + categoria +
                "\n Descripcion: '" + descripcion + '\'' +
                "\n $" + precio +
                " Stock:  " + stock;
    }
}
