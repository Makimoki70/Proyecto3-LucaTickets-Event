package com.proyecto.spring.event.model;


import java.time.LocalDate;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Event{
	@Id
	public Long id;
	
	private String nombre, corta, extendida, foto, normas;
	private LocalDate fecha;
	private LocalDate hora, minimo, maximo;
	private Double precio;
	private Recinto sala;
}