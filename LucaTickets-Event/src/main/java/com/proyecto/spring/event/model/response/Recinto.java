package com.proyecto.spring.event.model.response;

import com.proyecto.spring.user.enumerar.Tipo;

public class Recinto{
	private String nombre, ciudad, direccion;
	private Tipo tipoRecinto;
	private int aforo;
	
	public Recinto(String n, String c, String d, Tipo r, int a){
		nombre=n;
		ciudad=c;
		direccion=d;
		tipoRecinto=r;
		aforo=a;
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

	@Override
	public String toString(){
		return "Recinto [nombre=" + nombre + ", ciudad=" + ciudad + ", direccion=" + direccion + ", tipoRecinto="
				+ tipoRecinto + ", aforo=" + aforo + "]";
	}
}