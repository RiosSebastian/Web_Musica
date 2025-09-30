package com.example.WebDeMusica.servis;

import com.example.WebDeMusica.dto.CancionesDtoRes;
import com.example.WebDeMusica.dto.dtoReq.CancionesDtoReq;

import java.io.IOException;
import java.util.List;

public interface CancionesServis {

    // Crear una canción (subida de archivo incluida)
    CancionesDtoRes createCancion(CancionesDtoReq cancionDtoReq) throws IOException;

    // Obtener una canción por titulo
    List<CancionesDtoRes> getCancionBytitulo(String titulo);

    //obtener todas las canciones del Autor
    List<CancionesDtoRes> getAllCanciones(String autor);



    // Actualizar canción
    CancionesDtoRes updateCancion(Long id, CancionesDtoReq cancionDtoReq) throws IOException;

    // Eliminar una canción
    void deleteCancion(Long id);

    // Obtener todas las canciones
    List<CancionesDtoRes> getAllCanciones();
}
