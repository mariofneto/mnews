package com.example.mnews.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_noticia")
public class Noticia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition="TEXT")
    private String author;
    @Column(columnDefinition="TEXT")
    private String title;
    @Column(columnDefinition="TEXT")
    private String description;
    @Column(columnDefinition="TEXT")
    private String url;
    @Column(columnDefinition="TEXT")
    private String source;
    @Column(columnDefinition="TEXT")
    private String image;
    @Column(columnDefinition="TEXT")
    private String category;
    @Column(columnDefinition="TEXT")
    private String language;
    @Column(columnDefinition="TEXT")
    private String country;
    @Column(columnDefinition="TEXT")
    private String published_at;


    public Noticia() {
    }

    public Noticia(Long id, String author, String title, String description, String url, String source, String image, String category, String language, String country, String published_at) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.source = source;
        this.image = image;
        this.category = category;
        this.language = language;
        this.country = country;
        this.published_at = published_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPublished_at() {
        return published_at;
    }

    public void setPublished_at(String published_at) {
        this.published_at = published_at;
    }
}
