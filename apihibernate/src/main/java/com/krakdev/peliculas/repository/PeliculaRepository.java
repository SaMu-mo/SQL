package com.krakdev.peliculas.repository;

import com.krakdev.peliculas.entidades.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {

    List<Pelicula> findByGenero(String genero);

    List<Pelicula> findByDisponible(boolean disponible);
}