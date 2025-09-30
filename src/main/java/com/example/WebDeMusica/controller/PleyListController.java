package com.example.WebDeMusica.controller;


import com.example.WebDeMusica.dto.CancionesDtoRes;
import com.example.WebDeMusica.dto.PleyListDtoRes;
import com.example.WebDeMusica.dto.dtoReq.PleyListDtoReq;
import com.example.WebDeMusica.servis.PleyListServis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pleylist")
public class PleyListController {

    private final Logger log = LoggerFactory.getLogger(PleyListController.class);
    private final PleyListServis pleyListServis;

    @Autowired
    public PleyListController(PleyListServis pleyListServis) {
        this.pleyListServis = pleyListServis;
    }

    // Crear nueva playlist
    @PostMapping
    public ResponseEntity<PleyListDtoRes> create(@RequestBody PleyListDtoReq pleyListDtoReq) {
        log.info("Creando nueva playlist: {}", pleyListDtoReq.nombre());
        return ResponseEntity.ok(pleyListServis.createPletList(pleyListDtoReq));
    }

    // Obtener playlist por nombre
    @GetMapping("/{nombre}")
    public ResponseEntity<List<CancionesDtoRes>> findOneByName(@PathVariable String nombre) {
        try {
            return ResponseEntity.ok(pleyListServis.getByNombre(nombre));
        } catch (RuntimeException e) {
            log.warn("Playlist no encontrada con nombre: {}", nombre);
            return ResponseEntity.notFound().build();
        }
    }

    // Actualizar playlist
    @PutMapping("/{nombre}")
    public ResponseEntity<PleyListDtoRes> update(
            @PathVariable String nombre,
            @RequestBody PleyListDtoReq pleyListDtoReq) {
        try {
            return ResponseEntity.ok(pleyListServis.updatePleyList(nombre, pleyListDtoReq));
        } catch (RuntimeException e) {
            log.warn("No se pudo actualizar playlist con nombre: {}", nombre);
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar playlist
    @DeleteMapping("/{nombre}")
    public ResponseEntity<Void> delete(@PathVariable String nombre) {
        try {
            pleyListServis.deletePleyList(nombre);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            log.warn("No se pudo eliminar playlist con nombre: {}", nombre);
            return ResponseEntity.notFound().build();
        }
    }

    // Listar todas las playlists
    @GetMapping
    public ResponseEntity<List<PleyListDtoRes>> getAll() {
        return ResponseEntity.ok(pleyListServis.getAllPleyList());
    }
}


