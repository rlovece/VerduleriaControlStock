package org.example.Gestiones;

import org.example.EntradaDatos;
import org.example.Exceptions.ClienteExistenteException;
import org.example.Exceptions.ProductoExitenteException;
import org.example.Moldes.Cliente;
import org.example.Moldes.Producto;
import org.example.Repositorios.RepoClientes;
import org.example.Repositorios.RepoProductos;

import javax.swing.*;

public class GestionDeProductos {

    private RepoProductos repoProductos = new RepoProductos();

    public void menuGestionProductos () {

        String menu = "\n\n Menu Gestion Productos" +
                "\n Elija una opcion" +
                "\n1. Ver Productos" +
                "\n2. Agregar Producto" +
                "\n3. Modificar Producto" +
                "\n0. Volver\n\n";

        int opcion = 0;

        do {
            opcion = EntradaDatos.entradaInt(menu);
            switch (opcion) {
                case 1:
                    JOptionPane.showConfirmDialog(null, repoProductos.listar().toString(), "Los Productos",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 2:
                    try {
                        Producto nuevo = agregarNuevoProducto();
                        repoProductos.agregar(nuevo);
                    } catch (ProductoExitenteException e) {
                        String error = "Producto existente";
                        JOptionPane.showConfirmDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case 3:
                    int idModificar = EntradaDatos.entradaInt("Ingrese ID de Producto a Modificar");
                    repoProductos.modificar(idModificar);
                    break;

                default:
                    break;
            }
        } while (opcion != 0);
    }

    public Producto agregarNuevoProducto () throws ProductoExitenteException {
        Producto nuevo = new Producto();
        nuevo.setId(EntradaDatos.entradaInt("Ingrese Id"));
        verificarProductoExistente(nuevo.getId());
        nuevo.setCategoria(EntradaDatos.entradaCategoria("Ingrese Categoria"));
        nuevo.setDescripcion(EntradaDatos.entradaString("Ingrese Descripcion"));
        nuevo.setPrecio(EntradaDatos.entradaInt("Ingrese precio entero"));
        nuevo.setStock(EntradaDatos.entradaInt("Ingrese cant Stock"));
        return nuevo;
    }

    public void verificarProductoExistente (int id) throws ProductoExitenteException {
        for (Producto producto: repoProductos.listar()) {
            if (producto.getId()==id){
                throw new ProductoExitenteException("Producto existente");
            }
        }
    }

    public static void modificarProducto (Producto aModificar){
        aModificar.setDescripcion(EntradaDatos.entradaString("Ingrese Descripcion"));
        aModificar.setPrecio(EntradaDatos.entradaInt("Ingrese precio entero"));
    }
}
