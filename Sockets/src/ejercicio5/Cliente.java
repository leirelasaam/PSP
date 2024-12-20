package ejercicio5;

import java.io.IOException;
import java.net.Socket;

public class Cliente {

	private String host;
	private int puerto;

	public Cliente(String host, int puerto) {
		this.host = host;
		this.puerto = puerto;
	}

	public void conectarServidor() {
		Socket socket = null;
		try {
			// Conectar al servidor
			socket = new Socket(host, puerto);
			System.out.println("> Conexión realizada con el servidor.");

			EnviarThread et = new EnviarThread("EnviarCliente", socket);
			RecibirThread rt = new RecibirThread("RecibirCliente", socket);

			et.start();
			rt.start();
			
			// El socket se cierra directamente en los hilos, no hace falta un join

		} catch (IOException e) {
			System.out.println("> Error IO en el cliente: " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		Cliente cliente = new Cliente("localhost", 4321);
		cliente.conectarServidor();
	}
}
