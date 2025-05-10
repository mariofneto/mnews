package com.example.mnews.controller;

import com.example.mnews.service.NoticiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class NoticiaController {
    @Autowired
    NoticiaService noticiaService;

    @GetMapping("/noticias")
    public Mono<ResponseEntity<String>> getNoticias(){
            return noticiaService
                    .getCincoNoticias()
                    .map(ResponseEntity::ok)
                    .defaultIfEmpty(ResponseEntity.noContent().build());
    }

    @GetMapping("/noticia")
    public Mono<ResponseEntity<String>> getNoticia(){
        return noticiaService
                .getNoticia()
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.noContent().build());
    }
}
