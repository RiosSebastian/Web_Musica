package com.example.WebDeMusica.mapper;

import com.example.WebDeMusica.dto.PleylistDtoRes;
import com.example.WebDeMusica.dto.dtoReq.PleyListDtoReq;
import com.example.WebDeMusica.entity.PleyList;

public class PleyListMapper {
    public static PleylistDtoRes toDto(PleyList pleyList){
        return PleylistDtoRes.builder()
                .nombre(pleyList.getNombre())
                .fecha_de_creacion(pleyList.getFecha_de_creacion())
                .canciones(pleyList.getCanciones())
                .build();
    }

    public static PleyList toPleyList(PleyListDtoReq pleyListDtoReq){
        return PleyList.builder()
                .nombre(pleyListDtoReq.nombre())
                .fecha_de_creacion(pleyListDtoReq.fecha_de_creacion())
                .canciones(pleyListDtoReq.canciones())
                .build();
    }
}
