package com.example.WebDeMusica.dto;

import lombok.Builder;

import java.util.List;
@Builder
public record AlbumDtoRes(String titulo,
                          String genero,
                          Integer anio,
                          String ImageUrl,
                          List canciones) {

}
