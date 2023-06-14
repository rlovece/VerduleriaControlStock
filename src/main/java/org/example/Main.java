package org.example;
import org.example.Gestiones.GestionDeClientes;
import org.example.Gestiones.GestionDeProductos;
import org.example.Gestiones.GestionDeVentas;


public class Main {
    public static void main(String[] args) {

        GestionDeClientes gestionDeClientes = new GestionDeClientes();
        GestionDeProductos gestionDeProductos = new GestionDeProductos();
        GestionDeVentas gestionDeVentas = new GestionDeVentas();

        String menu = "\n\n Menu Principal" +
                "\n Elija una opcion" +
                "\n1. Gestion de Clientes" +
                "\n2. Gestion de Productos" +
                "\n3. Ventas\n\n";

        int opcion = 0;
        do {
            opcion = EntradaDatos.entradaInt(menu);
            switch (opcion) {
                case 1:
                    gestionDeClientes.menuGestionCliente();
                    break;
                case 2:
                    gestionDeProductos.menuGestionProductos();
                    break;

                case 3:
                    gestionDeVentas.menuVentas();
                    break;

                default:
                    break;
            }
        } while (opcion != 0);
    }
}

