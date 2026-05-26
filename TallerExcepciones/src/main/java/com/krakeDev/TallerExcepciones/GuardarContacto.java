package com.krakeDev.TallerExcepciones;

import java.io.FileWriter;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GuardarContacto {

    private static final Logger log = LogManager.getLogger(GuardarContacto.class);

    public static void guardar() {
        FileWriter escritor = null;
        try {
            escritor = new FileWriter("contactos.txt", true);
            escritor.write("Nombre: Maria\n");
            escritor.write("Apellido: Gomez\n");
            escritor.write("Telefono: 0981234567\n");
            escritor.write("---\n");
            log.info("Contacto guardado exitosamente");
        } catch (IOException e) {
            log.error("Error al guardar el contacto: " + e.getMessage());
        } finally {
            try {
                if (escritor != null) {
                    escritor.close();
                }
            } catch (IOException e) {
                log.error("Error al cerrar el archivo: " + e.getMessage());
            }
        }
    }
}