package ejercicio1;

public class Ejercicio1 {

	public static void main(String[] args) {
		ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "notepad");
		
		try {
			// Iniciar el proceso
			pb.start();
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}

	}

}
