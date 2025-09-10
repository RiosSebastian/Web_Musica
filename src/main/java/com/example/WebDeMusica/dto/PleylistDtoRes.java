package com.example.WebDeMusica.dto;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record PleylistDtoRes(String nombre,
                             LocalDateTime fecha_de_creacion,

                             List canciones) {
}
