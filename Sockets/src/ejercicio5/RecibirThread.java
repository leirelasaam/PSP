package ejercicio5;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class RecibirThread extends Thread {

	private Socket socket;
	private DataInputStream input = null;
	private boolean salir = false;

	public RecibirThread(String nombre, Socket socket) {
		super(nombre);
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			// Crear flujo de entrada para recibir datos
			input = new DataInputStream(socket.getInputStream());
			while (!salir && !socket.isClosed()) {
				String mensaje = input.readUTF();

				if (mensaje.equalsIgnoreCase("salir")) {
                    salir = true;
                    System.out.println("> Se recibió 'salir'.");
                } else {
                    System.out.println("- " + mensaje);
                }
			}
		} catch (IOException e) {
			//
		} finally {
			try {
				if (input!= null)
					input.close();
				if (socket != null) {
	                socket.close();
	            }
			} catch (IOException e) {
				
			}
		}
	}
}
