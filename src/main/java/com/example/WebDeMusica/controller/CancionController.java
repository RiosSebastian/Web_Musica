package com.example.WebDeMusica.controller;

import com.example.WebDeMusica.dto.CancionesDtoRes;
import com.example.WebDeMusica.dto.dtoReq.CancionesDtoReq;
import com.example.WebDeMusica.servis.CancionesServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/canciones")
public class CancionController {

    private final CancionesServis cancionService;

    @Autowired
    public CancionController(CancionesServis cancionService) {
        this.cancionService = cancionService;
    }

    @PostMapping
    public ResponseEntity<CancionesDtoRes> subirCancion(@ModelAttribute CancionesDtoReq cancionDtoReq) throws IOException {
        return ResponseEntity.ok(cancionService.createCancion(cancionDtoReq));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CancionesDtoRes> getCancion(@PathVariable Long id) {
        return ResponseEntity.ok(cancionService.getCancionById(id));
    }

    @GetMapping
    public ResponseEntity<List<CancionesDtoRes>> getAll() {
        return ResponseEntity.ok(cancionService.getAllCanciones());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CancionesDtoRes> updateCancion(
            @PathVariable Long id,
            @ModelAttribute CancionesDtoReq cancionDtoReq) throws IOException {
        return ResponseEntity.ok(cancionService.updateCancion(id, cancionDtoReq));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cancionService.deleteCancion(id);
        return ResponseEntity.noContent().build();
    }
}

