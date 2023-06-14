package org.example.Moldes;

import java.io.Serializable;
import java.util.Objects;

public class Cliente implements Serializable {

    private static final long serialVersionUID = 1111111111111111101L;
    private int id;
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;

    //region Contructores

    public Cliente(int id, String nombre, String apellido, String dni, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
    }

    public Cliente (){}

    //endregion

    //region Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    //endregion

    //region equal y hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return dni == cliente.dni;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }

    //endregion

    @Override
    public String toString() {
        return "\n Cliente " + id +
                "," + nombre + '\'' +
                " " + apellido + '\'' +
                ", DNI" + dni +
                ", tel" + telefono;
    }

}
