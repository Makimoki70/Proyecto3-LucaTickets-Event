package com.ejemplos.spring.secundario;

public class Recinto{
	private String nombre, ciudad, direccion;
	private Tipo tipoRecinto;
	private int aforo;
	
	public Recinto(String nombre, String ciudad, String direccion, Tipo tipoRecinto, int aforo) {
		super();
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.tipoRecinto = tipoRecinto;
		this.aforo = aforo;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Tipo getTipoRecinto() {
		return tipoRecinto;
	}
	public void setTipoRecinto(Tipo tipoRecinto) {
		this.tipoRecinto = tipoRecinto;
	}
	public int getAforo() {
		return aforo;
	}
	public void setAforo(int aforo) {
		this.aforo = aforo;
	}
}