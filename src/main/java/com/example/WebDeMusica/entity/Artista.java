package com.example.WebDeMusica.entity;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
public class Artista {

   private Long id;

    private String nombre;

    private String Biografia;

    private List discografia;
}
