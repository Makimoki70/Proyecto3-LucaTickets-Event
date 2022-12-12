package com.proyecto.spring.event.controller.error;

public class EventNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public EventNotFoundException(){
		super("Error: No existe ese evento");
	}
	public EventNotFoundException(Long id){
		super("Error: No existe el evento "+id);
	}
	public EventNotFoundException(String s){
		super("Error: No existen eventos que contengan: " + s);
	}
}