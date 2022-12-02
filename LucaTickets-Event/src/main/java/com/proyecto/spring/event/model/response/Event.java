package com.proyecto.spring.event.model.response;

import java.util.Date;

public class Event{
	private String nombre, corta, extendida, foto, normas;
	private Date fecha;
	private int hora, minimo, maximo;
	private Recinto sala;

	public Event(String nom,String cor,String ext,String fot,String nor,
			Date f,int h,int i,int a,Recinto s){
		nombre=nom;
		corta=cor;
		extendida=ext;
		foto=fot;
		normas=nor;
		fecha=f;
		hora=h;
		minimo=i;
		if(i<a)
			maximo=a;
		else
			maximo=i;
		sala=s;
	}

	public Event(String nom,String cor,String ext,String nor,
			Date f,int h,int i,int a,Recinto s){
		nombre=nom;
		corta=cor;
		extendida=ext;
		foto="";
		normas=nor;
		fecha=f;
		hora=h;
		minimo=i;
		if(i<a)
			maximo=a;
		else
			maximo=i;
		sala=s;
	}

	public String getNombre(){
		return nombre;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public String getCorta(){
		return corta;
	}

	public void setCorta(String corta){
		this.corta = corta;
	}

	public String getExtendida(){
		return extendida;
	}

	public void setExtendida(String extendida){
		this.extendida = extendida;
	}

	public String getFoto(){
		return foto;
	}

	public void setFoto(String foto){
		this.foto = foto;
	}

	public String getNormas(){
		return normas;
	}

	public void setNormas(String normas){
		this.normas = normas;
	}

	public Date getFecha(){
		return fecha;
	}

	public void setFecha(Date fecha){
		this.fecha = fecha;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora){
		this.hora = hora;
	}

	public int getMinimo(){
		return minimo;
	}

	public void setMinimo(int minimo){
		this.minimo = minimo;
	}

	public int getMaximo() {
		return maximo;
	}

	public void setMaximo(int maximo){
		this.maximo = maximo;
	}

	public Recinto getSala(){
		return sala;
	}

	public void setSala(Recinto sala){
		this.sala = sala;
	}

	@Override
	public String toString(){
		String s,j;
		if(foto=="")
			s="";
		else
			s=", foto="+foto;
		if(minimo<maximo)
			j=", minimo=" + minimo + ", maximo=" + maximo;
		else
			j=", precio="+minimo;
		return "Event [nombre=" + nombre + ", corta=" + corta + ", extendida=" + extendida + s
				+ ", normas=" + normas + ", fecha=" + fecha + ", hora=" + hora + j + ", sala=" + sala + "]";
	}
}