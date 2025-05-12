package com.example.mnews.dto;

import com.example.mnews.model.Noticia;

import java.util.List;

public class ApiResponse {
    private List<Noticia> data;

    public List<Noticia> getData() {
        return data;
    }

    public void setData(List<Noticia> data) {
        this.data = data;
    }
}
