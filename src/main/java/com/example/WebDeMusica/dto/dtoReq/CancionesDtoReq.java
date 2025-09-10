package com.example.WebDeMusica.dto.dtoReq;

import lombok.NonNull;

public record CancionesDtoReq(@NonNull
                              String titulo,
                              @NonNull
                              String autor,
                              @NonNull
                              float duracion,
                              @NonNull
                              String urlArchivo) {
}
