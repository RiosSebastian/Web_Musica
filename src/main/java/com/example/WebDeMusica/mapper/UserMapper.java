package com.example.WebDeMusica.mapper;

import com.example.WebDeMusica.dto.UserDtoRes;
import com.example.WebDeMusica.dto.dtoReq.UserDtoReq;
import com.example.WebDeMusica.entity.UserEntity;
import com.example.WebDeMusica.entity.UserEnum;

public class UserMapper {
    public static UserDtoRes toDTO(UserEntity userEntity) {
        return UserDtoRes.builder()
                .id(userEntity.getId())
                .nombreUsuario(userEntity.getNombreUsuario())
                .email(userEntity.getEmail())
                .userEnum(userEntity.getUserEnum().toString())
                // .profileImage(userEntity.getProfileImage())
                .build();
    }

    public static UserEntity toUserEntity(UserDtoReq request) {
        UserEnum userEnum = UserEnum.valueOf(request.userEnum());
        return UserEntity.builder()
                .nombreUsuario(request.nombreUsuario())
                .email(request.email())
                .password(request.password())
                .userEnum(userEnum)
                .build();
    }
}
