package com.example.WebDeMusica.mapper;

import com.example.WebDeMusica.dto.ArtistaDtoRes;
import com.example.WebDeMusica.dto.dtoReq.ArtisitaDtoReq;
import com.example.WebDeMusica.entity.Artista;

public class ArtistaMapper {
    public static ArtistaDtoRes toDto(Artista artista){
       return ArtistaDtoRes.builder()
                .nombre(artista.getNombre())
                .Historia(artista.getHistoria())
                .discografia(artista.getDiscografia())
                .build();
    }

    public static Artista toArtista(ArtisitaDtoReq artisitaDtoReq){
        return Artista.builder()
                .nombre(artisitaDtoReq.nombre())
                .Historia(artisitaDtoReq.Historia())
                .discografia(artisitaDtoReq.discografi())
                .build();
    }

}
