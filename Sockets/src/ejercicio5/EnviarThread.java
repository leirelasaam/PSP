package ejercicio5;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class EnviarThread extends Thread {

	private Socket socket = null;
	private DataOutputStream output = null;
	private Scanner sc = null;
	private boolean salir = false;

	public EnviarThread(String nombre, Socket socket) {
		super(nombre);
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			// Crear flujo de salida para enviar datos
			output = new DataOutputStream(socket.getOutputStream());
			sc = new Scanner(System.in);
			while (!salir && !socket.isClosed()) {
				// Se va quedar esperando a que haya input, por lo que el hilo no va a morir hasta que se introduzca algo
				String mensaje = sc.nextLine();
				output.writeUTF(mensaje);

				if (mensaje.equalsIgnoreCase("salir")) {
					salir = true;
					System.out.println("> Se envió 'salir'.");
				}
			}

		} catch (IOException e) {
			//
		} finally {
			try {
				if (sc != null)
					sc.close();
				if (output != null)
					output.close();
				if (socket != null) {
					socket.close();
				}
			} catch (IOException e) {

			}
		}
	}

}
