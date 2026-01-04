package com.example.WebDeMusica.servis;

import com.example.WebDeMusica.dto.AlbumDtoRes;
import com.example.WebDeMusica.dto.UserDtoRes;
import com.example.WebDeMusica.dto.dtoReq.AlbumDtoReq;

import java.util.List;

public interface AlbumServis {

    AlbumDtoRes createAlbum(AlbumDtoReq albumDtoReq);//crear album

    AlbumDtoRes updateAlbum(Long id, AlbumDtoReq albumDTOReq);//actualizar album

    AlbumDtoRes getGenero(String genero);//buscar por genero

    AlbumDtoRes getTitulo(String titulo);//buscar por titulo

    AlbumDtoRes getAnno(Integer año);//buscar por año


    void deleteAlbum(Long id); //para eliminar un album por su ID

    List<AlbumDtoRes> getAllAlbum(); //para obtener todos los album

    UserDtoRes updateTapaDeAlbum(Long id, String imageUrl);


}
