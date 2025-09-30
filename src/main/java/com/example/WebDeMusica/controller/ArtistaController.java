package com.example.WebDeMusica.controller;

import com.example.WebDeMusica.dto.ArtistaDtoRes;
import com.example.WebDeMusica.dto.dtoReq.ArtistaDtoReq;
import com.example.WebDeMusica.servis.ArtistaServis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artistas")
public class ArtistaController {

    private final Logger log = LoggerFactory.getLogger(ArtistaController.class);
    private final ArtistaServis artistaServis;

    @Autowired
    public ArtistaController(ArtistaServis artistaServis) {
        this.artistaServis = artistaServis;
    }

    // Crear artista
    @PostMapping
    public ResponseEntity<ArtistaDtoRes> create(@RequestBody ArtistaDtoReq artistaDtoReq) {
        log.info("Creando nuevo artista: {}", artistaDtoReq.nombre());
        return ResponseEntity.ok(artistaServis.createUser(artistaDtoReq));
    }

    // Obtener artista por nombre
    @GetMapping("/{nombre}")
    public ResponseEntity<ArtistaDtoRes> getByNombre(@PathVariable String nombre) {
        try {
            return ResponseEntity.ok(artistaServis.getUserByNombre(nombre));
        } catch (RuntimeException e) {
            log.warn("Artista no encontrado con nombre: {}", nombre);
            return ResponseEntity.notFound().build();
        }
    }

    // Actualizar artista
    @PutMapping("/{id}")
    public ResponseEntity<ArtistaDtoRes> update(
            @PathVariable Long id,
            @RequestBody ArtistaDtoReq artistaDtoReq) {
        try {
            return ResponseEntity.ok(artistaServis.updateUser(id, artistaDtoReq));
        } catch (RuntimeException e) {
            log.warn("No se pudo actualizar artista con id: {}", id);
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar artista
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            artistaServis.deleteUser(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            log.warn("No se pudo eliminar artista con id: {}", id);
            return ResponseEntity.notFound().build();
        }
    }

    // Listar todos los artistas
    @GetMapping
    public ResponseEntity<List<ArtistaDtoRes>> getAll() {
        return ResponseEntity.ok(artistaServis.getAllUsers());
    }

    // Actualizar foto de perfil del artista
    @PutMapping("/{id}/profile-image")
    public ResponseEntity<ArtistaDtoRes> updateProfileImage(
            @PathVariable Long id,
            @RequestParam String imageUrl) {
        return ResponseEntity.ok(artistaServis.updateProfileImage(id, imageUrl));
    }
}

