package com.krakdev.apijdbc;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.krakdev.videojuegos.entidades.Videojuego;

@RestController
@RequestMapping("/jdbc/videojuegos")
public class VideojuegoJdbcController {

    @Autowired
    private ServicioVideojuegoJdbc servicio;

    @PostMapping
    public Videojuego crear(@RequestBody Videojuego v) {
        return servicio.crear(v);
    }

    @GetMapping
    public List<Videojuego> listar() {
        return servicio.listar();
    }

    @GetMapping("/{codigo}")
    public Videojuego buscar(@PathVariable String codigo) {
        return servicio.buscarPorCodigo(codigo);
    }

    @PutMapping("/{codigo}")
    public Videojuego actualizar(@PathVariable String codigo, @RequestBody Videojuego v) {
        return servicio.actualizar(codigo, v);
    }

    @DeleteMapping("/{codigo}")
    public boolean eliminar(@PathVariable String codigo) {
        return servicio.eliminar(codigo);
    }
}