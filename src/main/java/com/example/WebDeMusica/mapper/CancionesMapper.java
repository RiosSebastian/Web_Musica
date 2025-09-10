package com.example.WebDeMusica.mapper;

import com.example.WebDeMusica.dto.CancionesDtoRes;
import com.example.WebDeMusica.dto.dtoReq.CancionesDtoReq;
import com.example.WebDeMusica.entity.Canciones;

public class CancionesMapper {

    public static CancionesDtoRes toDto(Canciones canciones){
        return CancionesDtoRes.builder()
                .titulo(canciones.getTitulo())
                .autor(canciones.getAutor())
                .duracion(canciones.getDuracion())
                .urlArchivo(canciones.getUrlArchivo())
                .build();
    }

    public static Canciones toCanciones(CancionesDtoReq cancionesDtoReq){
        return Canciones.builder()
                .titulo(cancionesDtoReq.titulo())
                .autor(cancionesDtoReq.autor())
                .duracion(cancionesDtoReq.duracion())
                .urlArchivo(cancionesDtoReq.urlArchivo())
                .build();
    }
}
