package ejercicio3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Recoge el objeto que le manda el servidor, lo modifica y se lo envía al
 * servidor.
 */
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

			// Crear flujo de entrada para recibir datos
			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

			// Recibir el objeto que manda el servidor
			Persona p = (Persona) input.readObject();
			System.out.println("> Persona recibida: " + p.toString());

			// Modificar persona
			p.setNombre("Pepe");
			p.setGenero('M');
			p.setFechaNacimiento(1990, 10, 2);

			// Crear flujo de salida para enviar datos
			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());

			// Mandar el objeto modificado
			output.writeObject(p);
			output.flush();

			// Cerrar las conexiones en orden inverso a la apertura
			input.close();
			output.close();
			socket.close();
		} catch (IOException e) {
			System.out.println("> Error en el cliente: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("> Error en el casteo del objeto Persona: " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		Cliente cliente = new Cliente("localhost", 5300);
		cliente.conectarServidor();
	}
}
