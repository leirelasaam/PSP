package ejercicio1.ejercicio7;

/**
 * Imprime el argumento que se le ha pasado.
 */
public class EjemploLectura {

	public static void main(String[] args) {
		if (args.length > 0) {
			String cadena = args[0]; // Recoge la cadena de caracteres
			if (cadena.isEmpty()) {
				System.out.println("No se ha recibido ningun texto.");
			} else {
				System.out.println("Texto recibido: " + cadena); // Muestra la cadena
			}
		} else {
			System.out.println("No se ha recibido ningun texto.");
		}
	}

}
