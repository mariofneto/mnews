package com.example.mnews.service;

import com.example.mnews.repository.NoticiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class NoticiaService {
    @Autowired
    NoticiaRepository noticiaRepository;

    private final WebClient webClient;

    public NoticiaService(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("http://api.mediastack.com/v1").build();
    }

    public Mono<String> getCincoNoticias(){
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/news")
                        .queryParam("access_key", "4a9f8ca4f605d5db4aebd8cf5eca440b")
                        .queryParam("category", "general")
                        .queryParam("countries", "br")
                        .queryParam("limit", "5")
                        .build())
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<String> getNoticia(){
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/news")
                        .queryParam("access_key", "4a9f8ca4f605d5db4aebd8cf5eca440b")
                        .queryParam("category", "general")
                        .queryParam("countries", "br")
                        .queryParam("limit", "100")
                        .build())
                .retrieve()
                .bodyToMono(String.class);

    }



}
