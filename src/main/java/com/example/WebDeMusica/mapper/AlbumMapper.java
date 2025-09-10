package com.example.WebDeMusica.mapper;

import com.example.WebDeMusica.dto.AlbumDtoRes;
import com.example.WebDeMusica.dto.dtoReq.AlbumDtoReq;
import com.example.WebDeMusica.entity.Album;
import com.example.WebDeMusica.entity.UserEntity;


public class AlbumMapper {
    public static AlbumDtoRes toDto(Album album){
        return AlbumDtoRes.builder()
                .titulo(album.getTitulo())
                .año(album.getAño())
                .genero(album.getGenero())
                .canciones(album.getCanciones())
                .build();
    }

    public static Album toAlbum(AlbumDtoReq request){
        return Album.builder()
                .titulo(request.titulo())
                .año(request.año())
                .genero(request.genero())
                .canciones(request.canciones())
                .build();
    }
}
