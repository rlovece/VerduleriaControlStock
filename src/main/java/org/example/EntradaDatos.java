package org.example;

import org.example.enums.Categorias;

import javax.swing.*;

import static javax.swing.JOptionPane.showInputDialog;

public class EntradaDatos {
    public static int entradaInt(String msj) {

        boolean ingresoOK= false;
        int nro = 0;

        while (!ingresoOK) {
            try {
                String entrada = showInputDialog(msj);
                nro = Integer.parseInt(entrada);
                ingresoOK = true;
            } catch (NumberFormatException e) {
                String error = "Debe introducir un nro entero";
                JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        return nro;
    }

    public static String entradaString (String msj) {
        return showInputDialog(msj);
    }

    public static Categorias entradaCategoria (String msj) {

        boolean ingresoOK= false;
        int nro = 0;

        while (!ingresoOK) {
            String entrada = showInputDialog(msj);
            if (entrada.equals(Categorias.VERDURAS.toString())){
                return Categorias.VERDURAS;
            } else if (entrada.equals(Categorias.PANADERÍA.toString())){
                return Categorias.PANADERÍA;
            } else if (entrada.equals(Categorias.FRUTAS.toString())){
                return Categorias.FRUTAS;
            } else if (entrada.equals(Categorias.CONGELADOS.toString())){
                return Categorias.CONGELADOS;
            } else {
                JOptionPane.showConfirmDialog(null, "Categoria incorrecta", "error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        return null;
    }
}
