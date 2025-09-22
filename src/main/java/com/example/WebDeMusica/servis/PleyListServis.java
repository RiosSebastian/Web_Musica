package com.example.WebDeMusica.servis;

import com.example.WebDeMusica.dto.CancionesDtoRes;
import com.example.WebDeMusica.dto.PleylistDtoRes;
import com.example.WebDeMusica.dto.dtoReq.PleyListDtoReq;

import java.util.List;

public interface PleyListServis {

    CancionesDtoRes createPletList(PleyListDtoReq pleyListDtoReq);

    //método para obtener una pleyList por su nombre
    List<CancionesDtoRes> getByNombre(String nombre);

    // método para actualizar una pleyList
    PleylistDtoRes updatePleyList(String nombre, PleyListDtoReq pleyListDtoReq);

    //método para eliminar una pleyList por su nombre
    void deletePleyList(String nombre);

    //método para obtener todas las pleyList
    List<PleylistDtoRes> getAllPleyList();
}
