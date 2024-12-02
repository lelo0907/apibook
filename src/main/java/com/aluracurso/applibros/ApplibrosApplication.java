package com.aluracurso.applibros;

import com.aluracurso.applibros.modulos.Conviertedatos;
import com.aluracurso.applibros.modulos.Connection;
import com.aluracurso.applibros.modulos.Repository;
import com.aluracurso.applibros.moldes.Datosresults;
import com.aluracurso.applibros.moldes.Moldes;
import com.aluracurso.applibros.principal.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ApplibrosApplication  implements CommandLineRunner {

	@Autowired
	private Repository repository;

	public static void main(String[] args) {
		SpringApplication.run(ApplibrosApplication.class, args);
	}
	@Override
		public void run(String... args) throws Exception {

		Principal principal = new Principal(repository);
		principal.muestraMenu();

		}
}
