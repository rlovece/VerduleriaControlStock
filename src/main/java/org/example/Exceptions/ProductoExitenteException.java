package org.example.Exceptions;

public class ProductoExitenteException extends Exception{
    public ProductoExitenteException (String mensaje) {
        super(mensaje);
    }
}
