package com.example.WebDeMusica.dto.dtoReq;

import lombok.NonNull;

public record UserDtoReq(@NonNull
                        String nombreUsuario,
                         String password,
                         @NonNull
                         String email,
                         String userEnum) {
}
