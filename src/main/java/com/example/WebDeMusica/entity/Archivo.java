package com.example.WebDeMusica.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@Table (name = "archivo")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Archivo {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String type;
    @Lob
    private  byte[] data;
}
