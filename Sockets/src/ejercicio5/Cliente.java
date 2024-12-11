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
			
			EnviarThread et = new EnviarThread(socket);
			RecibirThread rt = new RecibirThread(socket);
			
			et.start();
			rt.start();
			
			et.join();
			rt.join();
		} catch (IOException e) {
			System.out.println("> Error IO en el cliente: " + e.getMessage());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Cliente cliente = new Cliente("localhost", 4321);
		cliente.conectarServidor();
	}
}
