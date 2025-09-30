package com.example.WebDeMusica.servis.servisImpl;

import com.example.WebDeMusica.dto.ArtistaDtoRes;
import com.example.WebDeMusica.dto.dtoReq.ArtistaDtoReq;
import com.example.WebDeMusica.entity.Artista;
import com.example.WebDeMusica.exeption.NotFoundException;
import com.example.WebDeMusica.mapper.ArtistaMapper;
import com.example.WebDeMusica.repository.ArtistaRepository;
import com.example.WebDeMusica.servis.ArtistaServis;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class ArtistaServisImpl implements ArtistaServis {

    @Autowired
    private ArtistaRepository artistaRepository;

    @Autowired
    private ArtistaMapper modelMapper;
    @Override
    public ArtistaDtoRes createUser(ArtistaDtoReq artistaDtoReq) {
        Artista artista =ArtistaMapper.toArtista(artistaDtoReq);

        // if (user.getProfileImage() == null || user.getProfileImage().isEmpty()) {
        //     user.setProfileImage("https://res.cloudinary.com/dmwsuzs94/image/upload/v1728906889/user_n1laeq.jpg");
        // }

        artista = artistaRepository.save(artista);
        return ArtistaMapper.toDto(artista);
    }

    @Override
    public ArtistaDtoRes getUserByNombre(String nombre) {
         Artista artista = (Artista) artistaRepository.findByNombre(nombre)
                .orElseThrow(() -> new NotFoundException("El artista: " + nombre + "no fue encontrado"));
        return ArtistaMapper.toDto(artista);
    }

    @Override
    public ArtistaDtoRes updateUser(Long id, ArtistaDtoReq artistaDtoReq) {
        Artista existingArtista = artistaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("El artista con ID: " + id + "no fue encontrado"));

        existingArtista.setNombre(artistaDtoReq.nombre());
        existingArtista.setBiografia(artistaDtoReq.Biografia());
        existingArtista.setDiscografia(artistaDtoReq.discografi());

        existingArtista = artistaRepository.save(existingArtista);
        return ArtistaMapper.toDto(existingArtista);
    }

    @Override
    public void deleteUser(Long id) {
        Artista artista = artistaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("El artista con ID: " + id + "no fue encontrado"));
        artistaRepository.delete(artista);
    }

    @Override
    public List<ArtistaDtoRes> getAllUsers() {
        List<Artista> artistas = artistaRepository.findAll();
        return artistas.stream()
                .map(ArtistaMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ArtistaDtoRes updateProfileImage(Long id, String imageUrl) {
        Artista artista = artistaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Artista no encontrado"));
        //user.setProfileImage(imageUrl);
        artistaRepository.save(artista);
        return ArtistaMapper.toDto(artista);

    }
}
