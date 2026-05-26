package com.krakdev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SelectVehiculo {

    private static final Logger log = LogManager.getLogger(SelectVehiculo.class);

    public static void listar() {
        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conexion = Conexion.obtenerConexion();
            String sql = "SELECT * FROM vehiculos";
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(
                    "Placa: "         + rs.getString("placa") +
                    " | Marca: "      + rs.getString("marca") +
                    " | Modelo: "     + rs.getString("modelo") +
                    " | Año: "        + rs.getInt("anio") +
                    " | Precio: "     + rs.getDouble("precio") +
                    " | Color: "      + rs.getString("color") +
                    " | Disponible: " + rs.getBoolean("disponible") +
                    " | Kilometraje: " + rs.getInt("kilometraje")
                );
            }
            log.info("Listado de vehículos realizado exitosamente");
        } catch (SQLException e) {
            log.error("Error al listar vehículos: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conexion != null) conexion.close();
            } catch (SQLException e) {
                log.error("Error al cerrar conexión: " + e.getMessage());
            }
        }
    }
}