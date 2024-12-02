package com.aluracurso.applibros.modulos;

import com.aluracurso.applibros.moldes.DatosAutor;
import com.aluracurso.applibros.moldes.Moldes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface Repository extends JpaRepository<Moldes,Long> {
    @Query("SELECT m FROM Moldes m JOIN FETCH m.autores")
    List<Moldes> librosGuardados();

    @Query("SELECT m FROM Moldes m JOIN FETCH m.idiomas WHERE :idioma MEMBER OF m.idiomas" )
    List<Moldes> idiomaLibros(String idioma);

    @Query("SELECT a FROM Moldes m JOIN m.autores a WHERE CAST(a.fechaDeNacimiento AS integer) BETWEEN :ano AND (:ano + 100)")
    List<DatosAutor> findAutoresVivosEnAño(int ano);


    Optional<Moldes> findByTituloIgnoreCase(String titulo);
}
