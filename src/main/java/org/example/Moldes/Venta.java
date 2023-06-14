package org.example.Moldes;

import java.io.Serializable;
import java.util.Objects;

public class Venta implements Serializable {
    private static final long serialVersionUID = 3333333333333333301L;

    private int id;
    private Cliente cliente;
    private Producto producto;
    private int cant;

    //region Constructores

    public Venta(int id, Cliente cliente, Producto producto, int cant) {
        this.id = id;
        this.cliente = cliente;
        this.producto = producto;
        this.cant = cant;
    }

    public Venta (){}

    //endregion

    //region Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    //endregion

    //region equal y hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venta venta = (Venta) o;
        return id == venta.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    //endregion


    @Override
    public String toString() {
        return "\n\n Venta " + id +
                "    Cliente=" + cliente.getNombre() +
                " " + cliente.getApellido() +
                "\n " + cant + " " + producto.getDescripcion() +
                "\n $" + (cant*producto.getPrecio());
    }
}
