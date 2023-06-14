package org.example.Repositorios;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.example.Moldes.Cliente;
import org.example.Moldes.Venta;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RepoVentas implements IRepositorios<Venta>{
    private final File archivo = new File("src\\main\\java\\org\\example\\Archivos\\ventas.json");
    private final ObjectMapper mapper =  new ObjectMapper();

    private ArrayList<Venta> listaVentas;


    @Override
    public void cargar() {
        try {
            CollectionType collectionType =
                    mapper.getTypeFactory().constructCollectionType(ArrayList.class, Venta.class);
            this.listaVentas = mapper.readValue(archivo, collectionType);
        } catch (IOException e){
            String msj = "Error al cargar archivo";
            JOptionPane.showConfirmDialog(null, msj, "Error", JOptionPane.ERROR_MESSAGE);
            this.listaVentas = new ArrayList<Venta>();
        }
    }

    @Override
    public void guardar() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(archivo, this.listaVentas);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList listar() {
        cargar();
        return this.listaVentas;
    }

    @Override
    public void agregar(Venta... nuevoObjeto) {
        cargar();
        this.listaVentas.addAll(List.of(nuevoObjeto));
        guardar();
    }


    @Override
    public void eliminar(int id) {
        cargar();

        for(Venta venta: this.listaVentas){
            if(venta.getId() == id){
                this.listaVentas.remove(venta);
                break;
            }

        }

        guardar();
    }

    @Override
    public void modificar(int id) {}
}
