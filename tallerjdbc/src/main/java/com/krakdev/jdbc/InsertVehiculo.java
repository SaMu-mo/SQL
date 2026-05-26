package com.krakdev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.krakdev.entidades.Vehiculo;

public class InsertVehiculo {

    private static final Logger log = LogManager.getLogger(InsertVehiculo.class);

    public static void insertar(Vehiculo v) {
        Connection conexion = null;
        PreparedStatement ps = null;
        try {
            conexion = Conexion.obtenerConexion();
            String sql = "INSERT INTO vehiculos (placa, marca, modelo, anio, precio, color, disponible, kilometraje) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, v.getPlaca());
            ps.setString(2, v.getMarca());
            ps.setString(3, v.getModelo());
            ps.setInt(4, v.getAnio());
            ps.setDouble(5, v.getPrecio());
            ps.setString(6, v.getColor());
            ps.setBoolean(7, v.isDisponible());
            ps.setInt(8, v.getKilometraje());
            ps.executeUpdate();
            log.info("Vehículo insertado: " + v.getPlaca());
        } catch (SQLException e) {
            log.error("Error al insertar vehículo: " + e.getMessage());
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