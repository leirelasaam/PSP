package ejercicio1;

import java.io.File;

public class Ejercicio6 {

	public static void main(String[] args) {

		// Carpeta que contiene todos los archivos
		String carpeta = "src\\ejercicio1\\archivos\\";
		
		// Rutas de los archivos
		String bat = carpeta + "ej6.bat";
		String output = carpeta + "output_ej6.txt";
		String error = carpeta + "error_ej6.txt";

		try {
			ProcessBuilder pb = new ProcessBuilder(bat);
			
			// Redireccionar la salida del proceso
			pb.redirectOutput(new File(output));
			pb.redirectError(new File(error));
			
			pb.start();
		} catch (Exception e) {
			System.out.println("Error" + e);
		}

	}

}
