package com.krakeDev.TallerExcepciones;

public class ValidarContacto {

    public static void validarTelefono(String telefono) throws IllegalArgumentException {
        if (telefono.length() != 10) {
            throw new IllegalArgumentException("El teléfono debe tener exactamente 10 dígitos. Se recibió: " + telefono);
        }
    }
}