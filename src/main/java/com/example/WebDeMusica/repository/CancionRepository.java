package com.example.WebDeMusica.repository;

import com.example.WebDeMusica.entity.Canciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CancionRepository extends JpaRepository<Canciones, Long> {
    <T> ScopedValue<T> findAll(String titulo);
}
