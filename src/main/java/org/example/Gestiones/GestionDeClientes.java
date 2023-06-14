package org.example.Gestiones;

import org.example.EntradaDatos;
import org.example.Exceptions.ClienteExistenteException;
import org.example.Moldes.Cliente;
import org.example.Repositorios.RepoClientes;

import javax.swing.*;
import java.util.ArrayList;

public class GestionDeClientes {

    private RepoClientes repoClientes = new RepoClientes();

    public void menuGestionCliente () {

        String menu = "\n\n Menu Gestion Clientes" +
                "\n Elija una opcion" +
                "\n1. Ver Clientes" +
                "\n2. Agregar Cliente" +
                "\n3. Modificar Cliente" +
                "\n0. Volver\n\n";

        int opcion = 0;

        do {
            opcion = EntradaDatos.entradaInt(menu);
            switch (opcion) {
                case 1:
                    JOptionPane.showConfirmDialog(null, repoClientes.listar().toString(), "Los clientes",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 2:
                    try {
                        Cliente nuevo = agregarNuevoCliente();
                        repoClientes.agregar(nuevo);
                    } catch (ClienteExistenteException e) {
                        String error = "Cliente existente";
                        JOptionPane.showConfirmDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case 3:
                    int idModificar = EntradaDatos.entradaInt("Ingrese ID de cliente a Modificar");
                    repoClientes.modificar(idModificar);
                    break;

                default:
                    break;
            }
        } while (opcion != 0);
    }

    public Cliente agregarNuevoCliente () throws ClienteExistenteException {
        Cliente nuevo = new Cliente();
        nuevo.setId(EntradaDatos.entradaInt("Ingrese Id"));
        verificarClienteExistente(nuevo.getId());
        nuevo.setDni(EntradaDatos.entradaString("Ingrese DNI"));
        nuevo.setNombre(EntradaDatos.entradaString("Ingrese Nombre"));
        nuevo.setApellido(EntradaDatos.entradaString("Ingrese Apellido"));
        nuevo.setTelefono(EntradaDatos.entradaString("Ingrese Telefono"));
        return nuevo;
    }

    public void verificarClienteExistente(int id) throws ClienteExistenteException {
        for (Cliente cliente: repoClientes.listar()) {
            if (cliente.getId()==id){
                throw new ClienteExistenteException("Cliente existente");
            }
        }
    }

    public static void modificarCliente (Cliente aModificar){
        aModificar.setDni(EntradaDatos.entradaString("Ingrese DNI"));
        aModificar.setNombre(EntradaDatos.entradaString("Ingrese Nombre"));
        aModificar.setApellido(EntradaDatos.entradaString("Ingrese Apellido"));
        aModificar.setTelefono(EntradaDatos.entradaString("Ingrese Telefono"));
    }
}

