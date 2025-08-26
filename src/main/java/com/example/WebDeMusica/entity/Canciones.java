package com.example.WebDeMusica.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Canciones {
    private Long id;
    private String titulo;
    private float duracion;
    private String urlArchivo;

}
