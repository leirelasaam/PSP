package ejercicio5;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	private int puerto;

	public Servidor(int puerto) {
		this.puerto = puerto;
	}

	private void iniciar() {
		// Crear un servidor
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(puerto);
			System.out.println("> Servidor iniciado.");

			// Aceptar la conexión del cliente
			socket = serverSocket.accept();

			EnviarThread et = new EnviarThread(socket);
			RecibirThread rt = new RecibirThread(socket);
			
			et.start();
			rt.start();
			
			et.join();
			rt.join();
		} catch (IOException e) {
			System.out.println("> Error IO en el servidor: " + e.getMessage());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (serverSocket != null)
					serverSocket.close();
				System.out.println("> Servidor cerrado.");
			} catch (IOException e) {
				//
			}
		}
	}

	public static void main(String[] args) {
		Servidor servidor = new Servidor(4321);
		servidor.iniciar();
	}
}
