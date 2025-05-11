package com.example.mnews.service;

import com.example.mnews.model.Noticia;
import com.example.mnews.model.Pessoa;
import com.example.mnews.repository.NoticiaRepository;
import com.example.mnews.repository.PessoaRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoticiaService {
    @Autowired
    NoticiaRepository noticiaRepository;

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    private JavaMailSender javaMailSender;


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

    public Noticia getNoticia() throws MessagingException {
        Noticia noticia = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/news")
                        .queryParam("access_key", "4a9f8ca4f605d5db4aebd8cf5eca440b")
                        .queryParam("category", "general")
                        .queryParam("countries", "br")
                        .queryParam("limit", "1")
                        .build())
                .retrieve()
                .bodyToMono(Noticia.class).block();

        noticiaRepository.save(noticia);
        envioDeNoticiaPorEmail(noticia);
        return noticia;

    }

    public Mono<String> envioDeNoticiaPorEmail(Noticia noticia) throws MessagingException {
        List<Pessoa> pessoasList = pessoaRepository.findAll();

        for(Pessoa pessoa : pessoasList) {
            String destinatario = pessoa.getEmail();
            String assunto = noticia.getClass().getTitle();
            String mensagem = "Olá " + funcionario.getNome() + ", segue em anexo o seu holerite :)";

            MimeMessage mimeMessage = javaMailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setTo(destinatario);
            helper.setSubject(assunto);
            helper.setText(mensagem);

            javaMailSender.send(mimeMessage);
        }

        }
    }



}
