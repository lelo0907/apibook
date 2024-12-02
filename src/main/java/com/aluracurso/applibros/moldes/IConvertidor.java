package com.aluracurso.applibros.moldes;

public interface IConvertidor {

    <T> T obtenerDatos(String json, Class<T> clase);
}
