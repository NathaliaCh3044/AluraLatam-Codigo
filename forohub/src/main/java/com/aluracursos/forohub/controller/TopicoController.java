package com.aluracursos.forohub.controller;

import com.aluracursos.forohub.dto.*;
import com.aluracursos.forohub.model.Topico;
import com.aluracursos.forohub.repository.TopicoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoRepository repository;

    public TopicoController(TopicoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @Transactional
    public DatosRespuestaTopico registrar(@RequestBody @Valid DatosRegistroTopico datos){

        repository.findByTituloAndMensaje(datos.titulo(), datos.mensaje())
                .ifPresent(t -> {
                    throw new RuntimeException("Tópico duplicado");
                });

        Topico topico = new Topico(
                datos.titulo(),
                datos.mensaje(),
                datos.autor(),
                datos.curso()
        );

        repository.save(topico);

        return new DatosRespuestaTopico(topico);
    }

    @GetMapping
    public List<DatosRespuestaTopico> listar(){

        return repository.findAll()
                .stream()
                .map(DatosRespuestaTopico::new)
                .toList();
    }

    @GetMapping("/{id}")
    public DatosRespuestaTopico detalle(@PathVariable Long id){

        Topico topico = repository.findById(id)
                .orElseThrow();

        return new DatosRespuestaTopico(topico);
    }

    @PutMapping("/{id}")
    @Transactional
    public DatosRespuestaTopico actualizar(
            @PathVariable Long id,
            @RequestBody DatosActualizarTopico datos){

        Topico topico = repository.findById(id)
                .orElseThrow();

        topico.actualizar(datos.titulo(), datos.mensaje());

        return new DatosRespuestaTopico(topico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminar(@PathVariable Long id){
        repository.deleteById(id);
    }
}