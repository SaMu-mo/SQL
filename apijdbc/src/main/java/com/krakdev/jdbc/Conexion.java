package com.krakdev.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Conexion {

    private static final Logger log = LoggerFactory.getLogger(Conexion.class);

    private static final String URL      = "jdbc:postgresql://localhost:5432/apijdbc";
    private static final String USUARIO  = "postgres";
    private static final String PASSWORD = "1234";

    public static Connection obtenerConexion() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            log.info("Conexión realizada exitosamente");
        } catch (SQLException e) {
            log.error("Error de conexión: " + e.getMessage());
        }
        return conexion;
    }
}