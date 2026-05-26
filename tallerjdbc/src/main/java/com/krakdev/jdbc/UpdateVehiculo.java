package com.krakdev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UpdateVehiculo {

    private static final Logger log = LogManager.getLogger(UpdateVehiculo.class);

    public static void actualizar(String placa, double nuevoPrecio, String nuevoColor, int nuevoKilometraje) {
        Connection conexion = null;
        PreparedStatement ps = null;
        try {
            conexion = Conexion.obtenerConexion();
            String sql = "UPDATE vehiculos SET precio = ?, color = ?, kilometraje = ? WHERE placa = ?";
            ps = conexion.prepareStatement(sql);
            ps.setDouble(1, nuevoPrecio);
            ps.setString(2, nuevoColor);
            ps.setInt(3, nuevoKilometraje);
            ps.setString(4, placa);
            int filas = ps.executeUpdate();
            log.info("Vehículo actualizado. Filas afectadas: " + filas);
        } catch (SQLException e) {
            log.error("Error al actualizar vehículo: " + e.getMessage());
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