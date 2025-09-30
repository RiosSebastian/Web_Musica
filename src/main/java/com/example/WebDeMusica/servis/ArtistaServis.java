package com.example.WebDeMusica.servis;

import com.example.WebDeMusica.dto.ArtistaDtoRes;
import com.example.WebDeMusica.dto.dtoReq.ArtistaDtoReq;

import java.util.List;

public interface ArtistaServis {


    ArtistaDtoRes createUser(ArtistaDtoReq artistaDtoReq);

    //método para obtener un artista por su nombre
    ArtistaDtoRes getUserByNombre(String nombre);

    // método para actualizar un artista
    ArtistaDtoRes updateUser(Long id, ArtistaDtoReq artistaDtoReq);

    //método para eliminar un artista por su nombre
    void deleteUser(Long id);

    //método para obtener todos los artista
    List<ArtistaDtoRes> getAllUsers();

    ArtistaDtoRes updateProfileImage(Long id, String imageUrl);
}
