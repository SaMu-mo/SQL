package com.krakdev.peliculas.services;

import com.krakdev.peliculas.entidades.Pelicula;
import com.krakdev.peliculas.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioPelicula {

    @Autowired
    private PeliculaRepository peliculaRepository;

    public Pelicula crear(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    public List<Pelicula> listar() {
        return peliculaRepository.findAll();
    }

    public Pelicula buscarPorId(Long id) {
        Optional<Pelicula> resultado = peliculaRepository.findById(id);
        return resultado.orElse(null);
    }

    public Pelicula actualizar(Long id, Pelicula datos) {
        Optional<Pelicula> resultado = peliculaRepository.findById(id);
        if (resultado.isPresent()) {
            Pelicula pelicula = resultado.get();
            pelicula.setNombre(datos.getNombre());
            pelicula.setDirector(datos.getDirector());
            pelicula.setGenero(datos.getGenero());
            pelicula.setDuracion(datos.getDuracion());
            pelicula.setDisponible(datos.isDisponible());
            pelicula.setCalificacion(datos.getCalificacion());
            return peliculaRepository.save(pelicula);
        }
        return null;
    }

    public boolean eliminar(Long id) {
        if (peliculaRepository.existsById(id)) {
            peliculaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Pelicula> buscarPorGenero(String genero) {
        return peliculaRepository.findByGenero(genero);
    }

    public List<Pelicula> buscarPorDisponible(boolean disponible) {
        return peliculaRepository.findByDisponible(disponible);
    }
}