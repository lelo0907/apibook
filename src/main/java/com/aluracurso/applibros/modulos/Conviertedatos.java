package com.aluracurso.applibros.modulos;

import com.aluracurso.applibros.moldes.IConvertidor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


    public class Conviertedatos implements IConvertidor {
        private ObjectMapper objectMapper = new ObjectMapper();


        @Override
        public <T> T obtenerDatos(String json, Class<T> clase) {
            try {
                return objectMapper.readValue(json, clase);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }

    }
