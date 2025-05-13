package com.example.mnews.controller;

import com.example.mnews.model.Noticia;
import com.example.mnews.service.NoticiaService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticiaController {
    @Autowired
    NoticiaService noticiaService;


    @GetMapping("/noticia")
    public Noticia getNoticia() throws MessagingException {
        return noticiaService.getNoticiaAleatoria();
    }
}
