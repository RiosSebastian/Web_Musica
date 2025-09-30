package com.example.WebDeMusica.servis.servisImpl;

import com.example.WebDeMusica.dto.CancionesDtoRes;
import com.example.WebDeMusica.dto.PleyListDtoRes;
import com.example.WebDeMusica.dto.dtoReq.PleyListDtoReq;
import com.example.WebDeMusica.entity.PleyList;
import com.example.WebDeMusica.repository.PleyListRepository;
import com.example.WebDeMusica.servis.PleyListServis;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PleyListServisImpl implements PleyListServis {

    private final PleyListRepository pleyListRepository;

    public PleyListServisImpl(PleyListRepository pleyListRepository) {
        this.pleyListRepository = pleyListRepository;
    }


    @Override
    public PleyListDtoRes createPletList(PleyListDtoReq pleyListDtoReq) {
        PleyList pleyList = new PleyList();
        pleyList.setNombre(pleyListDtoReq.nombre());
        pleyList.setFechaDeCreacion(pleyListDtoReq.fecha_de_creacion());
        pleyList.setCanciones(pleyListDtoReq.canciones());

        pleyListRepository.save(pleyList);

        return new PleyListDtoRes(
                pleyList.getId(),
                pleyList.getNombre(),
                pleyList.getFechaDeCreacion(),
                pleyList.getCanciones()
        );
    }

    @Override
    public List<CancionesDtoRes> getByNombre(String nombre) {
        PleyList pleyList = (PleyList) pleyListRepository.findByNombre(nombre)
                .orElseThrow(() -> new RuntimeException("Playlist no encontrada"));

        return new PleyListDtoRes(
                pleyList.getId(),
                pleyList.getNombre(),
                pleyList.getFechaDeCreacion(),
                pleyList.getCanciones()
        ).canciones();
    }

    @Override
    public PleyListDtoRes updatePleyList(String nombre, PleyListDtoReq pleyListDtoReq) {
        PleyList pleyList = (PleyList) pleyListRepository.findByNombre(nombre)
                .orElseThrow(() -> new RuntimeException("Playlist no encontrada"));

        pleyList.setNombre(pleyListDtoReq.nombre());
        pleyList.setFechaDeCreacion(pleyListDtoReq.fecha_de_creacion());
        pleyList.setCanciones(pleyListDtoReq.canciones());

        pleyListRepository.save(pleyList);

        return new PleyListDtoRes(
                pleyList.getId(),
                pleyList.getNombre(),
                pleyList.getFechaDeCreacion(),
                pleyList.getCanciones()
        );
    }

    @Override
    public void deletePleyList(String nombre) {
        PleyList pleyList = (PleyList) pleyListRepository.findByNombre(nombre)
                .orElseThrow(() -> new RuntimeException("Playlist no encontrada"));

        pleyListRepository.delete(pleyList);
    }

    @Override
    public List<PleyListDtoRes> getAllPleyList() {
        return pleyListRepository.findAll().stream()
                .map(p -> new PleyListDtoRes(
                        p.getId(),
                        p.getNombre(),
                        p.getFechaDeCreacion(),
                        p.getCanciones()
                ))
                .toList();
    }
}

