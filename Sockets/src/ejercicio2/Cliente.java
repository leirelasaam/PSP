package ejercicio2;

import java.io.*;
import java.net.*;

public class Cliente {
	private String host;
	private int puerto;

	public Cliente(String host, int puerto) {
		this.host = host;
		this.puerto = puerto;
	}

	public void conectarServidor() {
		try {
			// Conectar al servidor
			Socket socket = new Socket(host, puerto);
			System.out.println("> Conexión realizada con el servidor.");

			// Crear flujo de salida para enviar datos
			DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
			// Crear flujo de entrada para recibir datos
			DataInputStream entrada = new DataInputStream(socket.getInputStream());

			// Enviar un mensaje al servidor
			salida.writeUTF("Hola servidor, soy un cliente.");

			// Leer la respuesta del servidor
			String serverResponse = entrada.readUTF();
			System.out.println("> Respuesta del servidor: " + serverResponse);

			// Cerrar las conexiones en orden inverso a la apertura
			entrada.close();
			salida.close();
			socket.close();
		} catch (IOException e) {
			System.out.println("> Error en el cliente: " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		Cliente cliente = new Cliente("localhost", 4321);
		cliente.conectarServidor();
	}
}
