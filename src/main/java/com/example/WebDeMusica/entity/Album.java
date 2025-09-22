package com.example.WebDeMusica.entity;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Album {
    private  Long id;

    private String titulo;

    private String genero;

    private Integer anno;

    private String ImageUrl;

     private List canciones;
}
