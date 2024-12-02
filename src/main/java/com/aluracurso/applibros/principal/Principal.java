package com.aluracurso.applibros.principal;

import com.aluracurso.applibros.modulos.Connection;
import com.aluracurso.applibros.modulos.Conviertedatos;
import com.aluracurso.applibros.modulos.Repository;
import com.aluracurso.applibros.moldes.DatosAutor;
import com.aluracurso.applibros.moldes.Datosresults;
import com.aluracurso.applibros.moldes.Moldes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {

    private Connection connect = new Connection();
    private Conviertedatos conv = new Conviertedatos();
    private Scanner teclado = new Scanner(System.in);
    private Repository repositorio;
    private List<Datosresults> datosSeries = new ArrayList<>();

    public Principal(Repository repository) {
        {
            this.repositorio = repository;
        }
    }

    public void muestraMenu() {

        var opcion = -1;
        while (opcion != 0) {
            var menu = """
            Bienvenido a tu bucador de libros, a continuacion algunas opciones:
            
            1 - Buscar por Titulo
            2 - Listar libros registrados
            3 - Listar autores registrados
            4 - listar Autores vivos en un determinado año
            5 - listar libros por idioma
                          
            0 - Salir
            """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion) {
                case 1:
                    buscarTitulo();
                    break;
                case 2:
                    allbooksDatabase();
                break;
                case 3:
                    allauthorsDatabase();
                    break;
                case 4:
                    listarAutoresVivos();
                    break;
                case 5:
                    languaguesBook();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");}

        }}



    ///var json =  connect.buscarLibro("https://gutendex.com/books/");
    ///System.out.println(json);
    ///var datos = conv.obtenerDatos(json, Datosresults.class);
       /// System.out.println(datos);


    private Datosresults getDatosresults(String tituloLibro) {
            var json = connect.buscarLibro("https://gutendex.com/books/" + "?search=" + tituloLibro.replace(" ", "+"));
            Datosresults datosBusqueda = conv.obtenerDatos(json, Datosresults.class);
            return datosBusqueda;
        }

    private void buscarTitulo() {
        System.out.println("Ingrese el nombre del libro que desea buscar");
        var tituloLibro = teclado.nextLine();

        // Obtener los datos de búsqueda desde el API
        Datosresults datosBusqueda = getDatosresults(tituloLibro);

        // Buscar el libro en los resultados obtenidos del API
        Optional<Moldes> libroBuscado = datosBusqueda.resultado().stream()
                .filter(l -> l.getTitulo().toUpperCase().contains(tituloLibro.toUpperCase()))
                .findFirst();

        if (libroBuscado.isPresent()) {
            Moldes libro = libroBuscado.get();

            System.out.println("Libro encontrado: " + libro.getTitulo());

            // Verificar si ya está en la base de datos
            Optional<Moldes> libroEnBaseDeDatos = repositorio.findByTituloIgnoreCase(libro.getTitulo());

            if (libroEnBaseDeDatos.isPresent()) {
                System.out.println("El libro ya está guardado en la base de datos. No se guardará de nuevo.");
            } else {
                repositorio.save(libro);
                System.out.println("Libro guardado exitosamente.");
            }
        } else {
            System.out.println("Libro no encontrado");
        }
    }

    public void allbooksDatabase() {
        List<Moldes> todosLibros = repositorio.librosGuardados();
        System.out.println("*** Libros Registrados ***");
        System.out.printf("%-50s | %10s%n", "Título", "Descargas");
        System.out.println("=".repeat(65)); // Línea separadora
        todosLibros.forEach(s ->
                System.out.printf("%-50s | %10d%n", s.getTitulo(), s.getNumeroDeDescargas()));
    }


    public void allauthorsDatabase() {
        // Recupera todos los libros (que contienen la lista de autores)
        List<Moldes> todosLibros = repositorio.librosGuardados();

        System.out.println("*** Autores Registrados ***");
        System.out.printf("%-50s | %20s%n", "Nombre", "Fecha de nacimiento");
        System.out.println("=".repeat(75)); //


        todosLibros.forEach(libro -> {
            libro.getAutores().forEach(autor -> {
                System.out.printf("%-50s | %20s%n",
                        autor.getNombre(),
                        autor.getFechaDeNacimiento() != null ? autor.getFechaDeNacimiento() : "N/A");
            });
        });
    }

    public void listarAutoresVivos() {

        System.out.println("Ingrese el año de nacimiento del autor");
        var ano = teclado.nextInt();


        List<DatosAutor> autoresVivos = repositorio.findAutoresVivosEnAño(ano);

        System.out.println("Autores vivos en el año " + ano + ":");
        for (DatosAutor autor : autoresVivos) {
            System.out.println(autor.getNombre() + " - Año de nacimiento: " + autor.getFechaDeNacimiento());
        }
    }

    public void languaguesBook() {
        System.out.println("Ingrese el idioma de su preferencia estas son las opciones");
        System.out.println("en o es");
        var idioma = teclado.nextLine();
        List<Moldes> idiomaLibros = repositorio.idiomaLibros(idioma);
        System.out.println("*** Libros Registrados ***");
        System.out.printf("%-50s | %10s%n", "Título", "Idiomas");
        System.out.println("=".repeat(65)); // Línea separadora

        idiomaLibros.forEach(s -> {
            // Imprimir los idiomas como una cadena separada por comas
            String idiomas = String.join(", ", s.getIdiomas());
            System.out.printf("%-50s | %s%n", s.getTitulo(), idiomas);
        });
    }



    ///System.exit(0);
}



