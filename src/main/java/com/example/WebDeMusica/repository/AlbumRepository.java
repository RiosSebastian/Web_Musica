package com.example.WebDeMusica.repository;

import com.example.WebDeMusica.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository  extends JpaRepository<Album, Long> {
}
