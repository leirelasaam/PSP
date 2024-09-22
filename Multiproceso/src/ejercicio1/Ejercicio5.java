package ejercicio1;

import java.io.InputStream;

public class Ejercicio5 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// Comando para buscar el proceso Notepad.exe en el listado de procesos
		ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "tasklist | findstr Notepad.exe");

		try {
			Process p = pb.start();

			// Leer el contenido de la consola
			InputStream is = p.getInputStream();
			String salida = "";
			int c;
			while ((c = is.read()) != -1) {
				System.out.print((char) c);
				salida += (char) c;
			}
			is.close();

			System.out.println();

			if (salida.contains("Notepad.exe")) {
				// Ejecutar el comando kill para matar el proceso
				Runtime.getRuntime().exec("taskkill /F /IM Notepad.exe");
				System.out.println("> El Bloc de Notas se ha cerrado.");
			} else {
				System.out.println("> El Bloc de Notas no está abierto.");
			}

		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

}
