package ejercicio1.ejercicio7;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Pide un texto que se pasa como argumento a la clase EjemploLectura.
 */
public class Ejer7 {
	public static void main(String[] args) {
		// Pedir texto al usuario
		System.out.print("Introduce un texto: ");
		Scanner sc = new Scanner(System.in);
		String texto = sc.nextLine(); // Lee la entrada del usuario
		sc.close();

		// Preparar el comando para ejecutar EjemploLectura
		ProcessBuilder pb = new ProcessBuilder("java", "ejercicio1.ejercicio7.EjemploLectura", texto);
		
		try {
			Process p = pb.start();

			// Capturar la salida
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