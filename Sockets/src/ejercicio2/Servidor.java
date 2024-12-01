package ejercicio2;

import java.io.*;
import java.net.*;

public class Servidor {
	private static final int MAX_CONEXIONES = 3;
	private int puerto;
	
	public Servidor(int puerto) {
		this.puerto = puerto;
	}
	
	private void iniciar() {
		try {
			// Crear un servidor
			ServerSocket serverSocket = new ServerSocket(puerto);
			System.out.println("> Servidor iniciado.");

			int conexiones = 1;
			while (conexiones <= MAX_CONEXIONES) {
				// Aceptar la conexión del cliente
				Socket socket = serverSocket.accept();
				
				// Crear flujo de entrada para recibir datos
				DataInputStream input = new DataInputStream(socket.getInputStream());
				// Crear flujo de salida para enviar datos
				DataOutputStream output = new DataOutputStream(socket.getOutputStream());

				// Leer el mensaje del cliente
				String message = input.readUTF();
				System.out.println("> Recibido: " + message);

				// Enviar una respuesta al cliente
				output.writeUTF("Saludos desde el servidor al Cliente Nº " + conexiones);

				// Cerrar las conexiones
				input.close();
				output.close();
				socket.close();
				
				conexiones++;
			}
			
			System.out.println("> Demasiados clientes por hoy.");
			serverSocket.close();
		} catch (IOException e) {
			System.out.println("> Error en el servidor: " + e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		Servidor servidor = new Servidor(4321);
		servidor.iniciar();
	}
}
