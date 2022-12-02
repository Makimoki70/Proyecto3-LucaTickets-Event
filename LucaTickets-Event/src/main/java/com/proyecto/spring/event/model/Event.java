package com.proyecto.spring.event.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Data
public class Event{
	@Id
	public Long id;
	
	
	private String nombre, corta, extendida, foto, normas;
	private Date fecha;
	private int hora, minimo, maximo;
	private Recinto sala;
}