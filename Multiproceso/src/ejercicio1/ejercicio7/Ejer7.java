package ejercicio1.ejercicio7;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Pide un texto que se pasa como argumento a la clase EjemploLectura.
 * El archivo .class se ha compilado con la versión JDK 21.
 */
public class Ejer7 {
	public static void main(String[] args) {
		// Pedir texto al usuario
		System.out.print("Introduce un texto: ");
		Scanner sc = new Scanner(System.in);
		String texto = sc.nextLine(); // Lee la entrada del usuario
		sc.close();

		// Preparar el comando para ejecutar EjemploLectura.class
		ProcessBuilder pb = new ProcessBuilder("java", "-cp", "src", "ejercicio1.ejercicio7.EjemploLectura", texto);
		
		try {
			Process p = pb.start();

			// Capturar la salida
            InputStream is = p.getInputStream();
            int c;
            StringBuilder salida = new StringBuilder();
            while ((c = is.read()) != -1) {
                salida.append((char) c);
            }
            is.close();

            // Esperar a que el proceso termine
            p.waitFor();

            // Imprimir la salida de EjemploLectura
            System.out.println(salida.toString());

		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
}
