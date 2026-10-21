package com.example.prestamos.Exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException (String mensaje){
        super(mensaje);
    }
}

