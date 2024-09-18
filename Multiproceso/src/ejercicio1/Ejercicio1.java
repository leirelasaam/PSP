package ejercicio1;

public class Ejercicio1 {

	public static void main(String[] args) {
		// No es necesario indicar la ruta entera porque es un proceso del sistema
		String infoProceso = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";
		ProcessBuilder pb = new ProcessBuilder(infoProceso);
		
		try {
			// Iniciar el proceso
			pb.start();
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}

	}

}
