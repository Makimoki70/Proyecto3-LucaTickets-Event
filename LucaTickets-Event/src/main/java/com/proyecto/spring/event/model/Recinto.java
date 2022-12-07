package com.proyecto.spring.event.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Recinto{
	private String nombre, ciudad, direccion;
	private Tipo tipoRecinto;
	private int aforo;
}