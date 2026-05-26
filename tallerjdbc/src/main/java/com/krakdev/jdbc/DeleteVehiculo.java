package com.krakdev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DeleteVehiculo {

    private static final Logger log = LogManager.getLogger(DeleteVehiculo.class);

    public static void eliminar(String placa) {
        Connection conexion = null;
        PreparedStatement ps = null;
        try {
            conexion = Conexion.obtenerConexion();
            String sql = "DELETE FROM vehiculos WHERE placa = ?";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, placa);
            int filas = ps.executeUpdate();
            log.info("Vehículo eliminado. Filas afectadas: " + filas);
        } catch (SQLException e) {
            log.error("Error al eliminar vehículo: " + e.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
                if (conexion != null) conexion.close();
            } catch (SQLException e) {
                log.error("Error al cerrar conexión: " + e.getMessage());
            }
        }
    }
}