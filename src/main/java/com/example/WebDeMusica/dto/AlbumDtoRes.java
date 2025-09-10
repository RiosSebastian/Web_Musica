package com.example.WebDeMusica.dto;

import java.util.List;

public record AlbumDtoRes(String titulo,
                          String genero,
                          Integer año,
                          List canciones) {

}
