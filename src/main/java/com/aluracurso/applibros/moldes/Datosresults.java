package com.aluracurso.applibros.moldes;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public record Datosresults(

        @JsonAlias("results") List<Moldes> resultado) {
}
