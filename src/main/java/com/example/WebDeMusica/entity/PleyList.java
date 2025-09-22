package com.example.WebDeMusica.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PleyList {

    private long id;
    private String nombre;
    private LocalDateTime FechaDeCreacion;
    private List canciones;
}
