package ejercicio3;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Persona implements Serializable {
	
	private static final long serialVersionUID = 4852081154722451695L;
	private String nif;
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private char genero;
	
	public Persona() {
		// Constructor vacío
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	@SuppressWarnings("deprecation")
	public void setFechaNacimiento(int a, int m, int d) {
		Date fecha = new Date(a - 1900, m - 1, d);
		this.fechaNacimiento = fecha;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido, fechaNacimiento, genero, nif, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(fechaNacimiento, other.fechaNacimiento)
				&& genero == other.genero && Objects.equals(nif, other.nif) && Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Persona [nif=" + nif + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento="
				+ fechaNacimiento + ", genero=" + genero + "]";
	}

}
