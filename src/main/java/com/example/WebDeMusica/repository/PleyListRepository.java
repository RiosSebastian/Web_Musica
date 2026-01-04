package com.example.WebDeMusica.repository;

import com.example.WebDeMusica.entity.PleyList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PleyListRepository extends JpaRepository<PleyList, Long> {

}
