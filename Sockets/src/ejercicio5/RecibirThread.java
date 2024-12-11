package ejercicio5;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class RecibirThread extends Thread {

	private Socket socket;
	private DataInputStream input = null;

	public RecibirThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			// Crear flujo de entrada para recibir datos
			input = new DataInputStream(socket.getInputStream());
			while (true) {
				// Recibir mensaje
				String mensaje = input.readUTF();

				if (mensaje != null) {
					System.out.println(mensaje);

					if (mensaje.equalsIgnoreCase("salir")) {
						break;
					}
				}
			}
		} catch (IOException e) {
			System.out.println("-> Error en el input stream: ");
			e.printStackTrace();
		} finally {
			try {
				if (input!= null)
					input.close();
			} catch (IOException e) {
				//
			}
		}
	}
}
