package com.example.WebDeMusica.servis.servisImpl;

import com.example.WebDeMusica.dto.AlbumDtoRes;
import com.example.WebDeMusica.dto.UserDtoRes;
import com.example.WebDeMusica.dto.dtoReq.AlbumDtoReq;
import com.example.WebDeMusica.entity.Album;
import com.example.WebDeMusica.repository.AlbumRepository;
import com.example.WebDeMusica.servis.AlbumServis;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServisImpl implements AlbumServis {

    private final AlbumRepository albumRepository;

    public AlbumServisImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public AlbumDtoRes createAlbum(AlbumDtoReq albumDtoReq) {
        Album album = new Album();
        album.setTitulo(albumDtoReq.titulo());
        album.setGenero(albumDtoReq.genero());
        album.setAnno(albumDtoReq.anno());
        album.setImageUrl(albumDtoReq.imageUrl());

        albumRepository.save(album);

        return new AlbumDtoRes(
                album.getTitulo(),
                album.getGenero(),
                album.getAnno(),
                album.getImageUrl()
        );
    }

    @Override
    public AlbumDtoRes updateAlbum(Long id, AlbumDtoReq albumDtoReq) {
        Album album = albumRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Álbum no encontrado"));

        album.setTitulo(albumDtoReq.titulo());
        album.setGenero(albumDtoReq.genero());
        album.setAnno(albumDtoReq.anno());
        album.setImageUrl(albumDtoReq.imageUrl());

        albumRepository.save(album);


    }

    @Override
    public AlbumDtoRes getGenero(String genero) {
        Album album = albumRepository.findByGenero(genero)
                .orElseThrow(() -> new RuntimeException("Álbum con género no encontrado"));
        return new AlbumDtoRes(album.getTitulo(), album.getGenero(), album.getAnno(), album.getImageUrl());
    }

    @Override
    public AlbumDtoRes getTitulo(String titulo) {
        Album album = albumRepository.findByTitulo(titulo)
                .orElseThrow(() -> new RuntimeException("Álbum con título no encontrado"));
        return new AlbumDtoRes( album.getTitulo(), album.getGenero(), album.getAnno(), album.getImageUrl());
    }

    @Override
    public AlbumDtoRes getAnno(Integer anno) {
        Album album = albumRepository.findByAnno(anno)
                .orElseThrow(() -> new RuntimeException("Álbum del año " + anno + " no encontrado"));
        return new AlbumDtoRes(album.getId(), album.getTitulo(), album.getGenero(), album.getAnno(), album.getImageUrl());
    }

    @Override
    public void deleteAlbum(Long id) {
        if (!albumRepository.existsById(id)) {
            throw new RuntimeException("Álbum no encontrado");
        }
        albumRepository.deleteById(id);
    }

    @Override
    public List<AlbumDtoRes> getAllAlbum() {
        return albumRepository.findAll().stream()
                .map(album -> new AlbumDtoRes(album.getTitulo(), album.getGenero(), album.getAnno(), album.getImageUrl()))
                .toList();
    }

    @Override
    public AlbumDtoRes updateTapaDeAlbum(Long id, String imageUrl) {
        Album album = albumRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Álbum no encontrado"));

        album.setImageUrl(imageUrl);
        albumRepository.save(album);

        return new AlbumDtoRes(album.getId(), album.getTitulo(), album.getGenero(), album.getAnno(), album.getImageUrl());
    }
}
