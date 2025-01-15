package com.alumno.server.alumnoServer.dataBase.entity;

import java.util.Objects;

/**
 * DataBase Entity
 */
public class Alumno {

	private int id = 0;
	private String name = null;
	private String surname = null;
	private String pass = null;
	private int edad = 0;

	public Alumno(int id, String name, String surname, String pass, int edad) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.pass = pass;
		this.edad = edad;
	}
	
	public Alumno() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(edad, id, name, pass, surname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return edad == other.edad && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(pass, other.pass) && Objects.equals(surname, other.surname);
	}

	@Override
	public String toString() {
		return "Alumno [id=" + id + ", name=" + name + ", surname=" + surname + ", pass=" + pass + ", edad=" + edad
				+ "]";
	}

}
