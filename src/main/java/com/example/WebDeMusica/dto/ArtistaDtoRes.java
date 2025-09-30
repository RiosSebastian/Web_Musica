package com.example.WebDeMusica.dto;

import lombok.Builder;

import java.util.List;
@Builder
public record ArtistaDtoRes(String nombre,
                            String Biografia,
                            List discografia) {
}
