package com.example.WebDeMusica.dto;

import lombok.Builder;

@Builder
public record CancionesDtoRes(String titulo,
                              String autor,
                              float duracion,
                              String urlArchivo
) {
}
