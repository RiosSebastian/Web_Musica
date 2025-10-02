package com.example.WebDeMusica.servis;

import com.example.WebDeMusica.entity.Archivo;
import com.example.WebDeMusica.util.ResposeFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ArchivosServis {

    Archivo store(MultipartFile file) throws IOException;//permite almecenar o cargar archivos a la base de datos

    //permite descargar archivos de uestra base de datos
    Optional<Archivo> getArchivo(UUID id) throws FileNotFoundException;

    //permite consultar la lista de archicos cargados a nuestra base de datos
    List<ResposeFile> getAllfiles();
}

