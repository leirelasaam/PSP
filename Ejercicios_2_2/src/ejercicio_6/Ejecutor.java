package ejercicio_6;

public class Ejecutor {

	public static void main(String[] args) {
		Buffer buffer = new Buffer();
		Productor productor = new Productor(buffer);
		Consumidor consumidor = new Consumidor(buffer);
		
		productor.start();
		consumidor.start();
	}

}
