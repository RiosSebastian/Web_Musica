package com.example.WebDeMusica.dto.dtoReq;

import lombok.NonNull;

import java.util.List;

public record ArtisitaDtoReq( @NonNull
                             String nombre,
                             @NonNull
                             String Historia,
                             @NonNull
                             List discografi) {
}
