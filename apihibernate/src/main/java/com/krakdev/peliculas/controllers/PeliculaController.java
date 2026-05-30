package com.krakdev.peliculas.controllers;

import com.krakdev.peliculas.entidades.Pelicula;
import com.krakdev.peliculas.services.ServicioPelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    @Autowired
    private ServicioPelicula servicioPelicula;

    // POST /peliculas
    @PostMapping
    public ResponseEntity<Pelicula> crear(@RequestBody Pelicula pelicula) {
        Pelicula nueva = servicioPelicula.crear(pelicula);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    // GET /peliculas
    @GetMapping
    public ResponseEntity<List<Pelicula>> listar() {
        return ResponseEntity.ok(servicioPelicula.listar());
    }

    // GET /peliculas/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Pelicula> buscarPorId(@PathVariable Long id) {
        Pelicula pelicula = servicioPelicula.buscarPorId(id);
        if (pelicula != null) {
            return ResponseEntity.ok(pelicula);
        }
        return ResponseEntity.notFound().build();
    }

    // PUT /peliculas/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Pelicula> actualizar(@PathVariable Long id, @RequestBody Pelicula pelicula) {
        Pelicula actualizada = servicioPelicula.actualizar(id, pelicula);
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        }
        return ResponseEntity.notFound().build();
    }

    // DELETE /peliculas/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        boolean eliminada = servicioPelicula.eliminar(id);
        if (eliminada) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // GET /peliculas/genero?genero=Accion
    @GetMapping("/genero")
    public ResponseEntity<List<Pelicula>> buscarPorGenero(@RequestParam String genero) {
        return ResponseEntity.ok(servicioPelicula.buscarPorGenero(genero));
    }

    // GET /peliculas/disponible?disponible=true
    @GetMapping("/disponible")
    public ResponseEntity<List<Pelicula>> buscarPorDisponible(@RequestParam boolean disponible) {
        return ResponseEntity.ok(servicioPelicula.buscarPorDisponible(disponible));
    }
}