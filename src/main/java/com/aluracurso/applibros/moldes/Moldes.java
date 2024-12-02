package com.aluracurso.applibros.moldes;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "books")
public class Moldes {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(unique = true)
        @JsonAlias("title")
        private String titulo;

        @JsonAlias("authors")
        @ElementCollection
        @CollectionTable(name = "authors", joinColumns = @JoinColumn(name = "book_id"))
        private List<DatosAutor> autores;

        @JsonAlias("languages")
        @ElementCollection
        @CollectionTable(name = "languages", joinColumns = @JoinColumn(name = "book_id"))
        private List<String> idiomas;

        @JsonAlias("subjects")
        @ElementCollection
        @CollectionTable(name = "subjects", joinColumns = @JoinColumn(name = "book_id"))
        private List<String> genero;

        @JsonAlias("download_count")
        private Long numeroDeDescargas;

        // Constructor por defecto requerido por JPA
        public Moldes() {}

        public Moldes(String titulo, List<DatosAutor> autores, List<String> idiomas, List<String> genero, Long numeroDeDescargas) {
                this.titulo = titulo;
                this.autores = autores;
                this.idiomas = idiomas;
                this.genero = genero;
                this.numeroDeDescargas = numeroDeDescargas;

        }

        // Getters y setters
        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getTitulo() {
                return titulo;
        }

        public void setTitulo(String titulo) {
                this.titulo = titulo;
        }

        public List<DatosAutor> getAutores() {
                return autores;
        }

        public void setAutores(List<DatosAutor> autores) {
                this.autores = autores;
        }

        public List<String> getIdiomas() {
                return idiomas;
        }

        public void setIdiomas(List<String> idiomas) {
                this.idiomas = idiomas;
        }

        public List<String> getGenero() {
                return genero;
        }

        public void setGenero(List<String> genero) {
                this.genero = genero;
        }

        public Long getNumeroDeDescargas() {
                return numeroDeDescargas;
        }

        public void setNumeroDeDescargas(Long numeroDeDescargas) {
                this.numeroDeDescargas = numeroDeDescargas;
        }

        @Override
        public String toString() {
                return "Moldes{" +
                        "id=" + id +
                        ", titulo='" + titulo + '\'' +
                        ", autores=" + autores +
                        ", idiomas=" + idiomas +
                        ", genero=" + genero +
                        ", numeroDeDescargas=" + numeroDeDescargas +
                        '}';
        }
}
