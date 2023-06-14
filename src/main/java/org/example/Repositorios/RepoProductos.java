package org.example.Repositorios;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import jdk.jshell.SourceCodeAnalysis;
import org.example.Gestiones.GestionDeProductos;
import org.example.Moldes.Cliente;
import org.example.Moldes.Producto;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RepoProductos implements IRepositorios<Producto> {

    private final File archivo = new File("src\\main\\java\\org\\example\\Archivos\\productos.json");
    private final ObjectMapper mapper =  new ObjectMapper();

    private ArrayList<Producto> listaProductos;


    @Override
    public void cargar() {
        try {
            CollectionType collectionType =
                    mapper.getTypeFactory().constructCollectionType(ArrayList.class, Producto.class);
            this.listaProductos = mapper.readValue(archivo, collectionType);
        } catch (IOException e){
            String msj = "Error al cargar archivo";
            JOptionPane.showConfirmDialog(null, msj, "Error", JOptionPane.ERROR_MESSAGE);
            this.listaProductos = new ArrayList<Producto>();
        }
    }

    @Override
    public void guardar() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(archivo, this.listaProductos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Producto> listar() {
        cargar();
        return this.listaProductos;
    }

    @Override
    public void agregar(Producto... nuevoObjeto) {
        cargar();
        this.listaProductos.addAll(List.of(nuevoObjeto));
        guardar();
    }

    @Override
    public void eliminar(int id) {
        cargar();

        for(Producto producto: this.listaProductos){
            if(producto.getId() == id){
                this.listaProductos.remove(producto);
                break;
            }
        }

        guardar();
    }

    @Override
    public void modificar(int id) {
        cargar();

        for(Producto producto: this.listaProductos){
            if(producto.getId() == id ){
                GestionDeProductos.modificarProducto(producto);
                break;
            }
        }

        guardar();
    }
}
