package com.example.WebDeMusica.servis.servisImpl;

import com.example.WebDeMusica.dto.CancionesDtoRes;
import com.example.WebDeMusica.dto.dtoReq.CancionesDtoReq;
import com.example.WebDeMusica.entity.Canciones;
import com.example.WebDeMusica.repository.CancionRepository;
import com.example.WebDeMusica.servis.CancionesServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Service
public class CancionServiceImpl implements CancionesServis {

    private final CancionRepository cancionRepository;

    @Autowired
    public CancionServiceImpl(CancionRepository cancionRepository) {
        this.cancionRepository = cancionRepository;
    }

    @Override
    public CancionesDtoRes createCancion(CancionesDtoReq cancionDtoReq) throws IOException {
        String carpeta = "uploads/";
        File destino = new File(carpeta + cancionDtoReq.archivo().getOriginalFilename());

        cancionDtoReq.archivo().transferTo(destino);

        Canciones cancion = new Canciones();
        cancion.setTitulo(cancionDtoReq.titulo());
        cancion.setDuracion(cancionDtoReq.duracion());
        cancion.setUrlArchivo(destino.getPath());

        cancionRepository.save(cancion);

        return new CancionesDtoRes(
                cancion.getTitulo()
        );
    }



    @Override
    public List<CancionesDtoRes> getAllCanciones(String autor) {
        return null;
    }

    @Override
    public List<CancionesDtoRes> getCancionBytitulo(String titulo) {
        Canciones cancion = (Canciones) cancionRepository.findAll(titulo)
                .orElseThrow(() -> new RuntimeException("Canción no encontrada"));
        return Collections.singletonList(new CancionesDtoRes(cancion.getTitulo()));
    }

    @Override
    public CancionesDtoRes updateCancion(Long id, CancionesDtoReq cancionDtoReq) throws IOException {
        Canciones cancion = cancionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Canción no encontrada"));

        cancion.setTitulo(cancionDtoReq.titulo());
        cancion.setDuracion(cancionDtoReq.duracion());

        if (cancionDtoReq.archivo() != null && !cancionDtoReq.archivo().isEmpty()) {
            String carpeta = "uploads/";
            File destino = new File(carpeta + cancionDtoReq.archivo().getOriginalFilename());
            cancionDtoReq.archivo().transferTo(destino);
            cancion.setUrlArchivo(destino.getPath());
        }

        cancionRepository.save(cancion);

        return new CancionesDtoRes( cancion.getTitulo());
    }

    @Override
    public void deleteCancion(Long id) {
        cancionRepository.deleteById(id);
    }

    @Override
    public List<CancionesDtoRes> getAllCanciones() {
        return cancionRepository.findAll().stream()
                .map(c -> new CancionesDtoRes( c.getTitulo()))
                .toList();
    }
}

