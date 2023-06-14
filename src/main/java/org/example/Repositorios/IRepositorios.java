package org.example.Repositorios;

import org.example.Moldes.Cliente;

import java.util.ArrayList;

public interface IRepositorios <T> {

    void cargar();
    void guardar();
    ArrayList<T> listar();
    void agregar(T... nuevoObjeto);
    void eliminar(int id);
    void modificar(int id);

}
