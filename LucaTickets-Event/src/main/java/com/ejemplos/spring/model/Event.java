package com.ejemplos.spring.model;

import java.time.LocalDate;

import com.ejemplos.spring.secundario.Recinto;

public class Event {
	public Long id;
	private String nombre, corta, extendida, foto, normas;
	private LocalDate fecha;
	private int hora, minimo;
	private int maximo;
	private Recinto sala;
	
	public Event(Long id, String nombre, String corta, String extendida, String foto, String normas, LocalDate fecha,
			int hora, int minimo, int maximo, Recinto sala) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.corta = corta;
		this.extendida = extendida;
		this.foto = foto;
		this.normas = normas;
		this.fecha = fecha;
		this.hora = hora;
		this.minimo = minimo;
		this.maximo = maximo;
		this.sala = sala;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorta() {
		return corta;
	}
	public void setCorta(String corta) {
		this.corta = corta;
	}
	public String getExtendida() {
		return extendida;
	}
	public void setExtendida(String extendida) {
		this.extendida = extendida;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getNormas() {
		return normas;
	}
	public void setNormas(String normas) {
		this.normas = normas;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public int getHora() {
		return hora;
	}
	public void setHora(int hora) {
		this.hora = hora;
	}
	public int getMinimo() {
		return minimo;
	}
	public void setMinimo(int minimo) {
		this.minimo = minimo;
	}
	public int getMaximo() {
		return maximo;
	}
	public void setMaximo(int maximo) {
		this.maximo = maximo;
	}
	public Recinto getSala() {
		return sala;
	}
	public void setSala(Recinto sala) {
		this.sala = sala;
	}
}