package com.example.WebDeMusica.mapper;

import com.example.WebDeMusica.dto.ArtistaDtoRes;
import com.example.WebDeMusica.dto.dtoReq.ArtistaDtoReq;
import com.example.WebDeMusica.entity.Artista;

public class ArtistaMapper {
    public static ArtistaDtoRes toDto(Artista artista){
       return ArtistaDtoRes.builder()
                .nombre(artista.getNombre())
                .Biografia(artista.getBiografia())
                .discografia(artista.getDiscografia())
                .build();
    }

    public static Artista toArtista(ArtistaDtoReq artistaDtoReq){
        return Artista.builder()
                .nombre(artistaDtoReq.nombre())
                .Biografia(artistaDtoReq.Biografia())
                .discografia(artistaDtoReq.discografi())
                .build();
    }

}
