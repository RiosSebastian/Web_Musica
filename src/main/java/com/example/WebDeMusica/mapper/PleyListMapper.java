package com.example.WebDeMusica.mapper;

import com.example.WebDeMusica.dto.PleyListDtoRes;
import com.example.WebDeMusica.dto.dtoReq.PleyListDtoReq;
import com.example.WebDeMusica.entity.PleyList;

public class PleyListMapper {
    public static PleyListDtoRes toDto(PleyList pleyList){
        return PleyListDtoRes.builder()
                .nombre(pleyList.getNombre())
                .fecha_de_creacion(pleyList.getFechaDeCreacion())
                .canciones(pleyList.getCanciones())
                .build();
    }

    public static PleyList toPleyList(PleyListDtoReq pleyListDtoReq){
        return PleyList.builder()
                .nombre(pleyListDtoReq.nombre())
                .FechaDeCreacion(pleyListDtoReq.fecha_de_creacion())
                .canciones(pleyListDtoReq.canciones())
                .build();
    }
}
