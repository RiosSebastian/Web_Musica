package com.example.WebDeMusica.repository;

import com.example.WebDeMusica.entity.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {
}
