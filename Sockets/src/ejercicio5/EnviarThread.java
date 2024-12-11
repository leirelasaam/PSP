package ejercicio5;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class EnviarThread extends Thread {

	private Socket socket;
	private DataOutputStream output = null;
	private Scanner sc = null;

	public EnviarThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			// Crear flujo de salida para enviar datos
			output = new DataOutputStream(socket.getOutputStream());
			// Leer de consola
			sc = new Scanner(System.in);
			while (true) {
				// Leer mensaje de consola
				String mensaje = sc.nextLine();

				if (mensaje != null) {
					// Enviar mensaje
					output.writeUTF(mensaje);

					// Salir del bucle
					if (mensaje.equalsIgnoreCase("salir")) {
						break;
					}
				}
			}
		} catch (IOException e) {
			System.out.println("-> Error en el output stream: " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (sc != null)
					sc.close();
				if (output != null)
					output.close();
			} catch (IOException e) {
				//
			}
		}
	}

}
