package org.example.Repositorios;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.example.Gestiones.GestionDeClientes;
import org.example.Moldes.Cliente;

import javax.swing.*;

public class RepoClientes implements IRepositorios<Cliente>{

    private final File archivo = new File("src\\main\\java\\org\\example\\Archivos\\clientes.json");
    private final ObjectMapper mapper =  new ObjectMapper();

    private ArrayList<Cliente> listaClientes;

    @Override
    public void cargar() {
        try {
            CollectionType collectionType =
                    mapper.getTypeFactory().constructCollectionType(ArrayList.class, Cliente.class);
            this.listaClientes = mapper.readValue(archivo, collectionType);
        } catch (IOException e){
            String msj = "Error al cargar archivo";
            JOptionPane.showConfirmDialog(null, msj, "Error", JOptionPane.ERROR_MESSAGE);
            this.listaClientes = new ArrayList<Cliente>();
        }
    }

    @Override
    public void guardar() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(archivo, this.listaClientes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Cliente> listar() {
        cargar();
        return this.listaClientes;
    }

    @Override
    public void agregar(Cliente... nuevoObjeto) {
        cargar();
        this.listaClientes.addAll(List.of(nuevoObjeto));
        guardar();
    }

    @Override
    public void eliminar(int id) {
        cargar();

        for(Cliente cliente: this.listaClientes){
            if(cliente.getId() == id){
                this.listaClientes.remove(cliente);
                break;
            }

        }

        guardar();
    }

    @Override
    public void modificar(int id) {
        cargar();

        for(Cliente cliente: this.listaClientes){
            if(cliente.getId() == id){
                GestionDeClientes.modificarCliente(cliente);
                break;
            }
        }

        guardar();
    }
}
