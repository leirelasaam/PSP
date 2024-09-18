package ejercicio1;

import java.io.InputStream;
import java.io.OutputStream;

public class Ejercicio5 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		ProcessBuilder pb = new ProcessBuilder("CMD.exe");

		try {
			Process p = pb.start();

			// Escribir el comando
			OutputStream os = p.getOutputStream();
			/*
			 * Comando para obtener el listado de procesos en ejecución y buscar la palabra
			 * Notepad
			 */
			String comando = "tasklist | findstr Notepad" + System.lineSeparator();

			// Pasar de string a un array de bytes
			byte[] comandoBytes = comando.getBytes();
			os.write(comandoBytes);
			os.flush();
			os.close();

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

			/*
			 * El comando ejecutado buscará Notepad, para que las strings no coincidan,
			 * ahora busco Notepad.exe porque si en el comando anterior busco Notepad.exe,
			 * entonces siempre va a pensar que está abierto porque lee todo lo que hay en
			 * la consola.
			 */
			if (salida.contains("Notepad.exe")) {
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
