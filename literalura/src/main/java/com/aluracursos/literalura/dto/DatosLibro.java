package com.aluracursos.literalura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DatosLibro {

    @JsonAlias("title")
    private String titulo;

    @JsonAlias("download_count")
    private Integer descargas;

    @JsonAlias("languages")
    private List<String> idiomas;

    @JsonAlias("authors")
    private List<DatosAutor> autores;

    public String getTitulo() { return titulo; }

    public Integer getDescargas() { return descargas; }

    public List<String> getIdiomas() { return idiomas; }

    public List<DatosAutor> getAutores() { return autores; }
}