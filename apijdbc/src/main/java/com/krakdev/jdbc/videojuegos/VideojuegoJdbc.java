package com.krakdev.jdbc.videojuegos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.krakdev.jdbc.Conexion;
import com.krakdev.videojuegos.entidades.Videojuego;

public class VideojuegoJdbc {

    private static final Logger log = LoggerFactory.getLogger(VideojuegoJdbc.class);

    public Videojuego insertar(Videojuego v) {
        Connection conexion = null;
        PreparedStatement ps = null;
        try {
            conexion = Conexion.obtenerConexion();
            String sql = "INSERT INTO videojuegos (codigo, nombre, plataforma, precio, disponible, genero) VALUES (?, ?, ?, ?, ?, ?)";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, v.getCodigo());
            ps.setString(2, v.getNombre());
            ps.setString(3, v.getPlataforma());
            ps.setDouble(4, v.getPrecio());
            ps.setBoolean(5, v.isDisponible());
            ps.setString(6, v.getGenero());
            ps.executeUpdate();
            log.info("Videojuego insertado: " + v.getCodigo());
        } catch (SQLException e) {
            log.error("Error al insertar videojuego: " + e.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
                if (conexion != null) conexion.close();
            } catch (SQLException e) {
                log.error("Error al cerrar conexión: " + e.getMessage());
            }
        }
        return v;
    }

    public List<Videojuego> listar() {
        List<Videojuego> lista = new ArrayList<>();
        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conexion = Conexion.obtenerConexion();
            String sql = "SELECT * FROM videojuegos";
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Videojuego v = new Videojuego(
                    rs.getString("codigo"),
                    rs.getString("nombre"),
                    rs.getString("plataforma"),
                    rs.getDouble("precio"),
                    rs.getBoolean("disponible"),
                    rs.getString("genero")
                );
                lista.add(v);
            }
            log.info("Listado de videojuegos realizado exitosamente");
        } catch (SQLException e) {
            log.error("Error al listar videojuegos: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conexion != null) conexion.close();
            } catch (SQLException e) {
                log.error("Error al cerrar conexión: " + e.getMessage());
            }
        }
        return lista;
    }

    public Videojuego buscar(String codigo) {
        Videojuego v = null;
        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conexion = Conexion.obtenerConexion();
            String sql = "SELECT * FROM videojuegos WHERE codigo = ?";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            if (rs.next()) {
                v = new Videojuego(
                    rs.getString("codigo"),
                    rs.getString("nombre"),
                    rs.getString("plataforma"),
                    rs.getDouble("precio"),
                    rs.getBoolean("disponible"),
                    rs.getString("genero")
                );
            }
            log.info("Búsqueda realizada para código: " + codigo);
        } catch (SQLException e) {
            log.error("Error al buscar videojuego: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conexion != null) conexion.close();
            } catch (SQLException e) {
                log.error("Error al cerrar conexión: " + e.getMessage());
            }
        }
        return v;
    }

    public Videojuego actualizar(String codigo, Videojuego v) {
        Connection conexion = null;
        PreparedStatement ps = null;
        try {
            conexion = Conexion.obtenerConexion();
            String sql = "UPDATE videojuegos SET nombre = ?, plataforma = ?, precio = ?, disponible = ?, genero = ? WHERE codigo = ?";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, v.getNombre());
            ps.setString(2, v.getPlataforma());
            ps.setDouble(3, v.getPrecio());
            ps.setBoolean(4, v.isDisponible());
            ps.setString(5, v.getGenero());
            ps.setString(6, codigo);
            ps.executeUpdate();
            log.info("Videojuego actualizado: " + codigo);
        } catch (SQLException e) {
            log.error("Error al actualizar videojuego: " + e.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
                if (conexion != null) conexion.close();
            } catch (SQLException e) {
                log.error("Error al cerrar conexión: " + e.getMessage());
            }
        }
        return v;
    }

    public boolean eliminar(String codigo) {
        Connection conexion = null;
        PreparedStatement ps = null;
        try {
            conexion = Conexion.obtenerConexion();
            String sql = "DELETE FROM videojuegos WHERE codigo = ?";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, codigo);
            int filas = ps.executeUpdate();
            log.info("Videojuego eliminado: " + codigo);
            return filas > 0;
        } catch (SQLException e) {
            log.error("Error al eliminar videojuego: " + e.getMessage());
            return false;
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