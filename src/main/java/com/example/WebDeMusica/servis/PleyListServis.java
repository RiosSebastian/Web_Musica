package com.example.WebDeMusica.servis;

import com.example.WebDeMusica.dto.CancionesDtoRes;
import com.example.WebDeMusica.dto.PleyListDtoRes;
import com.example.WebDeMusica.dto.dtoReq.PleyListDtoReq;

import java.util.List;

public interface PleyListServis {

    PleyListDtoRes createPletList(PleyListDtoReq pleyListDtoReq);

    //método para obtener una pleyList por su nombre
    List<CancionesDtoRes> getByNombre(String nombre);

    // método para actualizar una pleyList
    PleyListDtoRes updatePleyList(String nombre, PleyListDtoReq pleyListDtoReq);

    //método para eliminar una pleyList por su nombre
    void deletePleyList(String nombre);

    //método para obtener todas las pleyList
    List<PleyListDtoRes> getAllPleyList();
}
