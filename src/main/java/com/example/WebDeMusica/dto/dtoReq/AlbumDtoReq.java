package com.example.WebDeMusica.dto.dtoReq;

import lombok.NonNull;

import java.util.List;

public record AlbumDtoReq(@NonNull
                          String titulo,
                          @NonNull
                          String genero,
                          @NonNull
                          Integer anio,
                          String ImageUrl,
                          @NonNull
                          List canciones) {
}
