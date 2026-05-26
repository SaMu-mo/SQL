package com.krakeDev.TallerExcepciones;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LeerContacto {

    private static final Logger log = LogManager.getLogger(LeerContacto.class);

    public static void leer() {
        BufferedReader lector = null;
        try {
            lector = new BufferedReader(new FileReader("contactos.txt"));
            String linea;
            for (linea = lector.readLine(); linea != null; linea = lector.readLine()) {
                log.info("Línea leída: " + linea);
            }
        } catch (FileNotFoundException e) {
            log.error("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            log.error("Error al leer el archivo: " + e.getMessage());
        } finally {
            try {
                if (lector != null) {
                    lector.close();
                }
            } catch (IOException e) {
                log.error("Error al cerrar el lector: " + e.getMessage());
            }
        }
    }
}