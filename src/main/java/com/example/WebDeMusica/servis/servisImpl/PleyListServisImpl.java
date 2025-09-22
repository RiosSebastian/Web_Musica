package com.example.WebDeMusica.servis.servisImpl;

import com.example.WebDeMusica.dto.CancionesDtoRes;
import com.example.WebDeMusica.dto.PleylistDtoRes;
import com.example.WebDeMusica.dto.dtoReq.PleyListDtoReq;
import com.example.WebDeMusica.entity.PleyList;
import com.example.WebDeMusica.repository.PleyListRepository;
import com.example.WebDeMusica.servis.PleyListServis;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PleyListServisImpl implements PleyListServis {

    private final PleyListRepository pleyListRepository;

    public PleyListServisImpl(PleyListRepository pleyListRepository) {
        this.pleyListRepository = pleyListRepository;
    }

    @Override
    public PleylistDtoRes createPleyList(PleyListDtoReq pleyListDtoReq) {
        PleyList pleyList = new PleyList();
        pleyList.setNombre(pleyListDtoReq.nombre());
        pleyList.setFechaDeCreacion(pleyListDtoReq.fecha_de_creacion());
        pleyList.setCanciones(pleyListDtoReq.canciones());

        pleyListRepository.save(pleyList);

        return new PleylistDtoRes(
                pleyList.getId(),
                pleyList.getNombre(),
                pleyList.getFechaDeCreacion(),
                pleyList.getCanciones()
        );
    }

    @Override
    public PleylistDtoRes getByNombre(String nombre) {
        PleyList pleyList = pleyListRepository.findByNombre(nombre)
                .orElseThrow(() -> new RuntimeException("Playlist no encontrada"));

        return new PleylistDtoRes(
                pleyList.getId(),
                pleyList.getNombre(),
                pleyList.getFechaDeCreacion(),
                pleyList.getCanciones()
        );
    }

    @Override
    public PleylistDtoRes updatePleyList(String nombre, PleyListDtoReq pleyListDtoReq) {
        PleyList pleyList = pleyListRepository.findByNombre(nombre)
                .orElseThrow(() -> new RuntimeException("Playlist no encontrada"));

        pleyList.setNombre(pleyListDtoReq.nombre());
        pleyList.setFechaDeCreacion(pleyListDtoReq.fechaDeCreacion());
        pleyList.setCanciones(pleyListDtoReq.canciones());

        pleyListRepository.save(pleyList);

        return new PleylistDtoRes(
                pleyList.getId(),
                pleyList.getNombre(),
                pleyList.getFechaDeCreacion(),
                pleyList.getCanciones()
        );
    }

    @Override
    public void deletePleyList(String nombre) {
        PleyList pleyList = pleyListRepository.findByNombre(nombre)
                .orElseThrow(() -> new RuntimeException("Playlist no encontrada"));

        pleyListRepository.delete(pleyList);
    }

    @Override
    public List<PleylistDtoRes> getAllPleyList() {
        return pleyListRepository.findAll().stream()
                .map(p -> new PleylistDtoRes(
                        p.getId(),
                        p.getNombre(),
                        p.getFechaDeCreacion(),
                        p.getCanciones()
                ))
                .toList();
    }
}

