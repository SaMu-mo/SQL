package com.krakeDev.TallerExcepciones;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test {

    private static final Logger log = LogManager.getLogger(Test.class);

    public static void main(String[] args) {

    	String telefono = "0981234567";

        try {
            ValidarContacto.validarTelefono(telefono);
            log.info("Teléfono válido, guardando contacto...");
            GuardarContacto.guardar();
            LeerContacto.leer();
        } catch (IllegalArgumentException e) {
            log.error("Teléfono inválido: " + e.getMessage());
        }
    }
}