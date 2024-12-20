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
			System.out.println("> Cliente conectado.");

			EnviarThread et = new EnviarThread("EnviarServidor", socket);
			RecibirThread rt = new RecibirThread("RecibirServidor", socket);
			
			et.start();
			rt.start();
			
			// Como el server socket se cierra en esta clase, esperar para que no se cierre al instante
			et.join();
			rt.join();
			
		} catch (IOException e) {
			System.out.println("> Error IO en el servidor: " + e.getMessage());
		} catch (InterruptedException e) {
			System.out.println("> Error de interrupción en el servidor: " + e.getMessage());
		} finally {
			try {
				if (serverSocket!= null)
					serverSocket.close();
			} catch (IOException e) {
				
			}
		}
	}

	public static void main(String[] args) {
		Servidor servidor = new Servidor(4321);
		servidor.iniciar();
	}
}
