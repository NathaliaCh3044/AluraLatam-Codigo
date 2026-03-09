package com.aluracursos.literalura.service;

import com.aluracursos.literalura.dto.*;
import com.aluracursos.literalura.model.*;
import com.aluracursos.literalura.repository.*;
import org.springframework.stereotype.Service;

@Service
public class LibroService {

    private final LibroRepository libroRepository;
    private final AutorRepository autorRepository;

    private ConsumoAPI consumo = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();

    public LibroService(LibroRepository libroRepository,
                        AutorRepository autorRepository) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
    }

    public void buscarLibro(String titulo){

        String json = consumo.obtenerDatos(titulo);

        DatosRespuesta datos =
                conversor.obtenerDatos(json, DatosRespuesta.class);

        datos.getResultados()
                .stream()
                .limit(1)
                .forEach(d -> {

                    DatosAutor datosAutor = d.getAutores().get(0);

                    Autor autor = new Autor(
                            datosAutor.getNombre(),
                            datosAutor.getNacimiento(),
                            datosAutor.getMuerte()
                    );

                    autorRepository.save(autor);

                    Libro libro = new Libro(
                            d.getTitulo(),
                            d.getIdiomas().get(0),
                            d.getDescargas(),
                            autor
                    );

                    libroRepository.save(libro);

                    System.out.println("Libro guardado: " + libro.getTitulo());
                });
    }

    public void listarLibros() {

        libroRepository.findAll()
                .stream()
                .map(Libro::getTitulo)
                .forEach(System.out::println);
    }

    public void listarAutores() {

        autorRepository.findAll()
                .stream()
                .map(Autor::getNombre)
                .forEach(System.out::println);
    }

    public void autoresVivos(Integer ano) {

        autorRepository
                .findByNacimientoLessThanEqualAndMuerteGreaterThanEqual(ano,ano)
                .stream()
                .map(Autor::getNombre)
                .forEach(System.out::println);
    }

    public void librosPorIdioma(String idioma) {

        libroRepository.findByIdioma(idioma)
                .stream()
                .map(Libro::getTitulo)
                .forEach(System.out::println);
    }
}