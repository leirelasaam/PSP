package com.alumno.server.alumnoServer.dataBase.entity;

import java.util.ArrayList;
import java.util.List;

public class DDBBSimulada {

	private static DDBBSimulada instance = null;
	private List<Alumno> alumnos = null;
	
	public static DDBBSimulada getInstance() {
		if (instance == null) {
			instance = new DDBBSimulada();
		}
		
		return instance;
	}
	
	private DDBBSimulada() {
		super();
		
		alumnos = new ArrayList<Alumno>();
		Alumno alumno = new Alumno();
		alumno.setEdad(28);
		alumno.setId(1);
		alumno.setName("Leire");
		alumno.setPass("1234");
		alumno.setSurname("Lasa");
		
		alumnos.add(alumno);
	}
}
