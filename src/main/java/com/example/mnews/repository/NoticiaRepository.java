package com.example.mnews.repository;

import com.example.mnews.model.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NoticiaRepository extends JpaRepository<Noticia, Long> {
    Optional<Noticia> findById(Long id);
}
