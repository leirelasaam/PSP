package ejercicio1;

import java.io.InputStream;
import java.io.OutputStream;

public class Ejercicio4 {

	public static void main(String[] args) {
		ProcessBuilder pb = new ProcessBuilder("CMD.exe");

		try {
			Process p = pb.start();

			// Escribir el comando
			OutputStream os = p.getOutputStream();
			// Comando para obtener el listado de procesos en ejecución
			String dato = "tasklist" + System.lineSeparator();

			// Pasar de string a un array de bytes
			byte[] datoBytes = dato.getBytes();
			os.write(datoBytes);
			os.flush();
			os.close();

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

