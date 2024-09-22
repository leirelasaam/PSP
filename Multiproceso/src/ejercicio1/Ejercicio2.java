package ejercicio1;

import java.io.InputStream;

public class Ejercicio2 {

	public static void main(String[] args) {
		// Ejecuta en el CMD el comando dir para listar directorios y ficheros
		ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "dir");
		
		try {
			Process p = pb.start();
			
			// Leer el contenido de la consola
			InputStream is = p.getInputStream();
			int c;
			while((c = is.read()) != -1) {
				System.out.print((char) c);
			}
			is.close();
			
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

}
