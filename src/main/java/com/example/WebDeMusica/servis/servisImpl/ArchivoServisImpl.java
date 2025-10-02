package com.example.WebDeMusica.servis.servisImpl;

import com.example.WebDeMusica.entity.Archivo;
import com.example.WebDeMusica.repository.ArchivoRepository;
import com.example.WebDeMusica.servis.ArchivosServis;
import com.example.WebDeMusica.util.ResposeFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ArchivoServisImpl implements ArchivosServis {
    @Autowired
    private ArchivoRepository archivoRepository;

    @Override
    public Archivo store(MultipartFile file) throws IOException {
       String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Archivo archivo = Archivo.builder()
                .name(fileName)
                .type(file.getContentType())
                .data(file.getBytes())
                .build();
                return archivoRepository.save(archivo);
    }

    @Override
    public Optional<Archivo> getArchivo(UUID id) throws FileNotFoundException {
         Optional<Archivo> file = archivoRepository.findById(id);
         if (file.isPresent()){
             return file;
         }
         throw  new FileNotFoundException();
    }

    @Override
    public List<ResposeFile> getAllfiles() {
        return null;
    }
}
