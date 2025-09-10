package com.example.WebDeMusica.dto.dtoReq;

import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.List;

public record PleyListDtoReq(
        @NonNull
        String nombre,
        @NonNull
        LocalDateTime fecha_de_creacion,
        @NonNull
        List canciones) {
}
