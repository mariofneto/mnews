package com.example.mnews.controller;

import com.example.mnews.model.Noticia;
import com.example.mnews.service.NoticiaService;
import jakarta.mail.MessagingException;
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
    public Noticia getNoticia() throws MessagingException {
        return noticiaService.getNoticia();
    }
}
