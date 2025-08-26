package com.example.WebDeMusica.dto;

import lombok.Builder;

@Builder
public record  UserDtoRes (Long id,
                           String nombreUsuario,
                           String email,
                           String userEnum){
}
