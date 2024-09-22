package ejercicio1;

import java.io.InputStream;

public class Ejercicio3 {

	public static void main(String[] args) {
		// Comando para obtener la dirección MAC
		ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c" ,"getmac");

		try {
			Process p = pb.start();

			// Leer el contenido de la consola
			InputStream is = p.getInputStream();
			int c;
			while ((c = is.read()) != -1) {
				System.out.print((char) c);
			}
			is.close();

		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

}
