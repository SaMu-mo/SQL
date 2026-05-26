package com.krakdev.apijdbc;

import java.util.List;
import org.springframework.stereotype.Service;
import com.krakdev.jdbc.videojuegos.VideojuegoJdbc;
import com.krakdev.videojuegos.entidades.Videojuego;

@Service
public class ServicioVideojuegoJdbc {

    private VideojuegoJdbc videojuegoJdbc = new VideojuegoJdbc();

    public Videojuego crear(Videojuego v) {
        return videojuegoJdbc.insertar(v);
    }

    public List<Videojuego> listar() {
        return videojuegoJdbc.listar();
    }

    public Videojuego buscarPorCodigo(String codigo) {
        return videojuegoJdbc.buscar(codigo);
    }

    public Videojuego actualizar(String codigo, Videojuego v) {
        return videojuegoJdbc.actualizar(codigo, v);
    }

    public boolean eliminar(String codigo) {
        return videojuegoJdbc.eliminar(codigo);
    }
}