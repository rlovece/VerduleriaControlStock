package org.example.Gestiones;

import org.example.EntradaDatos;
import org.example.Exceptions.CantProductoExpection;
import org.example.Exceptions.ClienteExistenteException;
import org.example.Moldes.Cliente;
import org.example.Moldes.Producto;
import org.example.Moldes.Venta;
import org.example.Repositorios.RepoClientes;
import org.example.Repositorios.RepoProductos;
import org.example.Repositorios.RepoVentas;

import javax.swing.*;

public class GestionDeVentas {

    static RepoVentas repoVentas = new RepoVentas();
    static RepoClientes repoClientes = new RepoClientes();
    static RepoProductos repoProdutos = new RepoProductos();

    public void menuVentas () {

        String menu = "\n\n Menu Ventas" +
                "\n Elija una opcion" +
                "\n1. Ver Ventas realizadas" +
                "\n2. Vender" +
                "\n0. Volver\n\n";

        int opcion = 0;

        do {
            opcion = EntradaDatos.entradaInt(menu);
            switch (opcion) {
                case 1:
                    JOptionPane.showConfirmDialog(null, repoVentas.listar().toString(), "Las ventas",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 2:
                    try {
                        Venta nueva = nuevaVenta();
                        repoVentas.agregar(nueva);
                    } catch (CantProductoExpection e) {
                        String error = "Supera stock";
                        JOptionPane.showConfirmDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                default:
                    break;
            }
        } while (opcion != 0);
    }

    public Venta nuevaVenta () throws CantProductoExpection {
        Venta nuevaVenta = new Venta();
        nuevaVenta.setId(repoVentas.listar().size()+1);
        int idCliente = EntradaDatos.entradaInt("Ingrese ID cliente");
        nuevaVenta.setCliente(buscarCliente(idCliente));
        int idProducto = EntradaDatos.entradaInt("Ingrese ID Producto");
        Producto productoVendido = buscarProducto(idProducto);
        nuevaVenta.setProducto(productoVendido);
        nuevaVenta.setCant(EntradaDatos.entradaInt("Cantidad?"));
        if (nuevaVenta.getCant()>productoVendido.getStock()){
            throw new CantProductoExpection("Supera stock");
        }
        productoVendido.setStock(productoVendido.getStock()-nuevaVenta.getCant());
        repoProdutos.eliminar(idProducto);
        repoProdutos.agregar(productoVendido);

        return nuevaVenta;
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

    public static Cliente buscarCliente (int id){
        for(Cliente cliente: repoClientes.listar()){
            if(cliente.getId() == id){
                return cliente;
            }
        }
        return null;
    }

    public static Producto buscarProducto (int id){
        for(Producto producto: repoProdutos.listar()){
            if(producto.getId() == id){
                return producto;
            }
        }
        return null;
    }
}
