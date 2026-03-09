package com.aluracursos.literalura.principal;

import com.aluracursos.literalura.service.LibroService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Principal implements CommandLineRunner {

    private final LibroService servicio;
    private Scanner teclado = new Scanner(System.in);

    public Principal(LibroService servicio) {
        this.servicio = servicio;
    }

    @Override
    public void run(String... args) {

        int opcion = -1;

        while (opcion != 0) {

            System.out.println("""
            1 - Buscar libro por título
            2 - Listar libros
            3 - Listar autores
            4 - Autores vivos en determinado año
            5 - Libros por idioma
            0 - Salir
            """);

            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {

                case 1 -> {
                    System.out.println("Ingrese el título del libro:");
                    String titulo = teclado.nextLine();
                    servicio.buscarLibro(titulo);
                }

                case 2 -> servicio.listarLibros();

                case 3 -> servicio.listarAutores();

                case 4 -> {
                    System.out.println("Ingrese el año:");
                    int ano = teclado.nextInt();
                    servicio.autoresVivos(ano);
                }

                case 5 -> {
                    System.out.println("Ingrese idioma (en, es, fr, pt):");
                    String idioma = teclado.nextLine();
                    servicio.librosPorIdioma(idioma);
                }

                case 0 -> System.out.println("Cerrando aplicación");

                default -> System.out.println("Opción inválida");
            }
        }
    }
}