package com.example.WebDeMusica.servis.servisImpl;

import com.example.WebDeMusica.dto.AlbumDtoRes;
import com.example.WebDeMusica.dto.UserDtoRes;
import com.example.WebDeMusica.dto.dtoReq.AlbumDtoReq;
import com.example.WebDeMusica.repository.AlbumRepository;
import com.example.WebDeMusica.servis.AlbumServis;

import java.util.List;

public class AlbumServisImpl implements AlbumServis {

    private final AlbumRepository albumRepository;

    public AlbumServisImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public AlbumDtoRes createAlbum(AlbumDtoReq albumDtoReq) {
        return null;
    }

    @Override
    public AlbumDtoRes updateAlbum(Long id, AlbumDtoReq albumDTOReq) {
        return null;
    }

    @Override
    public AlbumDtoRes getGenero(String genero) {
        return null;
    }

    @Override
    public AlbumDtoRes getTitulo(String titulo) {
        return null;
    }

    @Override
    public AlbumDtoRes getAnno(Integer año) {
        return null;
    }

    @Override
    public void deleteAlbum(Long id) {

    }

    @Override
    public List<UserDtoRes> getAllAlbum() {
        return null;
    }

    @Override
    public UserDtoRes updateTapaDeAlbum(Long id, String imageUrl) {
        return null;
    }
}
