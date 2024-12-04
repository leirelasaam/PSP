package ejercicio3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Crea un objeto, se lo manda al cliente, recoge el objeto modificado y lo
 * muestra.
 */
public class Servidor {
	private int puerto;

	public Servidor(int puerto) {
		this.puerto = puerto;
	}

	private void iniciar() {
		try {
			// Crear un servidor
			ServerSocket serverSocket = new ServerSocket(puerto);
			System.out.println("> Servidor iniciado.");

			// Aceptar la conexión del cliente
			Socket socket = serverSocket.accept();

			// Crear flujo de salida para enviar datos
			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());

			// Crear una persona
			Persona p = new Persona();
			p.setNif("16099121H");
			p.setNombre("Leire");
			p.setApellido("Lasa");
			p.setFechaNacimiento(1996, 2, 9);
			p.setGenero('F');

			System.out.println("> Persona enviada al cliente: " + p.toString());

			// Mandar el objeto creado al cliente
			output.writeObject(p);
			output.flush();

			// Crear flujo de entrada para recibir datos
			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

			// Recoger el objeto modificado
			Persona modP = (Persona) input.readObject();
			System.out.println("> Persona modificada por el cliente: " + modP.toString());

			// Cerrar las conexiones
			output.close();
			input.close();
			socket.close();
			serverSocket.close();
		} catch (IOException e) {
			System.out.println("> Error en el servidor: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("> Error en el casteo del objeto Persona: " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		Servidor servidor = new Servidor(5300);
		servidor.iniciar();
	}
}
