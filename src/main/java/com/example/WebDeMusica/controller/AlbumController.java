package com.example.WebDeMusica.controller;

import com.example.WebDeMusica.dto.AlbumDtoRes;
import com.example.WebDeMusica.dto.UserDtoRes;
import com.example.WebDeMusica.dto.dtoReq.AlbumDtoReq;
import com.example.WebDeMusica.servis.AlbumServis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/albums")
public class AlbumController {

    private final Logger log = LoggerFactory.getLogger(AlbumController.class);
    private final AlbumServis albumServis;

    @Autowired
    public AlbumController(AlbumServis albumServis) {
        this.albumServis = albumServis;
    }

    // Crear álbum
    @PostMapping
    public ResponseEntity<AlbumDtoRes> create(@RequestBody AlbumDtoReq albumDtoReq) {
        log.info("Creando nuevo álbum: {}", albumDtoReq.titulo());
        return ResponseEntity.ok(albumServis.createAlbum(albumDtoReq));
    }

    // Actualizar álbum por id
    @PutMapping("/{id}")
    public ResponseEntity<AlbumDtoRes> update(
            @PathVariable Long id,
            @RequestBody AlbumDtoReq albumDtoReq) {
        try {
            return ResponseEntity.ok(albumServis.updateAlbum(id, albumDtoReq));
        } catch (RuntimeException e) {
            log.warn("No se pudo actualizar álbum con id: {}", id);
            return ResponseEntity.notFound().build();
        }
    }

    // Buscar álbum por género
    @GetMapping("/genero/{genero}")
    public ResponseEntity<AlbumDtoRes> getByGenero(@PathVariable String genero) {
        try {
            return ResponseEntity.ok(albumServis.getGenero(genero));
        } catch (RuntimeException e) {
            log.warn("Álbum no encontrado con género: {}", genero);
            return ResponseEntity.notFound().build();
        }
    }

    // Buscar álbum por título
    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<AlbumDtoRes> getByTitulo(@PathVariable String titulo) {
        try {
            return ResponseEntity.ok(albumServis.getTitulo(titulo));
        } catch (RuntimeException e) {
            log.warn("Álbum no encontrado con título: {}", titulo);
            return ResponseEntity.notFound().build();
        }
    }

    // Buscar álbum por año
    @GetMapping("/anno/{anno}")
    public ResponseEntity<AlbumDtoRes> getByAnno(@PathVariable Integer anno) {
        try {
            return ResponseEntity.ok(albumServis.getAnno(anno));
        } catch (RuntimeException e) {
            log.warn("Álbum no encontrado del año: {}", anno);
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar álbum por id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            albumServis.deleteAlbum(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            log.warn("No se pudo eliminar álbum con id: {}", id);
            return ResponseEntity.notFound().build();
        }
    }

    // Listar todos los álbumes
    @GetMapping
    public ResponseEntity<List<UserDtoRes>> getAll() {
        return ResponseEntity.ok(albumServis.getAllAlbum());
    }

    // Actualizar tapa del álbum
    @PutMapping("/{id}/tapa")
    public ResponseEntity<UserDtoRes> updateTapa(
            @PathVariable Long id,
            @RequestParam String imageUrl) {
        return ResponseEntity.ok(albumServis.updateTapaDeAlbum(id, imageUrl));
    }
}
