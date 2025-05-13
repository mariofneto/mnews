package com.example.mnews.service;

import com.example.mnews.dto.ApiResponse;
import com.example.mnews.model.Noticia;
import com.example.mnews.model.Pessoa;
import com.example.mnews.repository.NoticiaRepository;
import com.example.mnews.repository.PessoaRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Random;

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
        this.webClient = builder
                .baseUrl("http://api.mediastack.com/v1")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
    }

    public Noticia getNoticiaAleatoria() throws MessagingException {
        ApiResponse resposta = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/news")
                        .queryParam("access_key", "4a9f8ca4f605d5db4aebd8cf5eca440b")
                        .queryParam("category", "general")
                        .queryParam("countries", "br")
                        .queryParam("limit", "100")
                        .build())
                .retrieve()
                .bodyToMono(ApiResponse.class)
                .block();

        Random random = new Random();

        Noticia noticia = resposta.getData().get(random.nextInt(0, 100));
        noticiaRepository.save(noticia);
        envioDeNoticiaPorEmail(noticia);
        return noticia;

    }

    private String envioDeNoticiaPorEmail(Noticia noticia) throws MessagingException {
        List<Pessoa> pessoasList = pessoaRepository.findAll();

        for(Pessoa pessoa : pessoasList) {
            String destinatario = pessoa.getEmail();
            String assunto = noticia.getTitle();
            String mensagem =
                    "Notícia do dia: \n" +noticia.getDescription() + " acesse o link para ver a notícia completa: " + noticia.getUrl();

            MimeMessage mimeMessage = javaMailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setTo(destinatario);
            helper.setSubject(assunto);
            helper.setText(mensagem);

            javaMailSender.send(mimeMessage);
        }

        return "Todos os emails enviados!";

        }
    }
