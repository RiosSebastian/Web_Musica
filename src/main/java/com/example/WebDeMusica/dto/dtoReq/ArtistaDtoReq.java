package com.example.WebDeMusica.dto.dtoReq;

import lombok.NonNull;

import java.util.List;

public record ArtistaDtoReq(@NonNull
                             String nombre,
                            @NonNull
                             String Biografia,
                            @NonNull
                             List discografi) {
}
