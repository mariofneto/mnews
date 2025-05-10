package com.example.mnews.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_noticia")
@Data
public class Noticia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String title;
    private String description;
    private String url;
    private String source;
    private String image;
    private String category;
    private String language;
    private String country;
    private String published_at;
}
