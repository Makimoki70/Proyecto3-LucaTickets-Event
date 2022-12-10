package com.proyecto.spring.event;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.proyecto.spring.event.model.Event;
import com.proyecto.spring.event.model.Recinto;
import com.proyecto.spring.event.model.Tipo;
import com.proyecto.spring.event.repository.EventRepository;

@SpringBootTest
public class Test05_AltaEvento {

	@Autowired
	EventRepository repository;
	
	@Test
	void contextLoads() {
		Event event = new Event();
		
		LocalDate myDate = LocalDate.parse("01-12-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		
		LocalTime myHora = LocalTime.parse("20:00");
		LocalTime myMinimo = LocalTime.parse("17:00");
		LocalTime myMaximo = LocalTime.parse("22:00");
		
		event.setId(200L);
		event.setNombre("Prueba");
		event.setCorta("PruebaEvento");
		event.setExtendida("PruebaEvento extendido");
		event.setFoto("Patata");
		event.setNormas("Prohibido hacer pruebas en pantalon corto");
		event.setFecha(myDate);
		event.setHora(myHora);
		event.setMinimo(myMinimo);
		event.setMaximo(myMaximo);
		event.setPrecio(200.0);
		
		Recinto sala = new Recinto();
		sala.setNombre("prueba");
		sala.setCiudad("Madrid");
		sala.setDireccion("Calle 123");
		sala.setTipoRecinto(Tipo.terraza);
		sala.setAforo(500);
		
		event.setSala(sala);
		
		Event eventSaved = repository.save(event);
		
		assertThat(eventSaved.getId()).isEqualTo(200L);
		//assertThat(daoUser.findById(userSaved.getId()).get().getNombre()).contains("Prueba");
	}
}
