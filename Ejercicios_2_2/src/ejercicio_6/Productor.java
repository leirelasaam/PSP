package ejercicio_6;

import java.util.Random;

public class Productor extends Thread {
	private Buffer buffer;

	public Productor(Buffer buffer) {
		this.buffer = buffer;
	}

	public void run() {
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
	        char c = (char) ('A' + random.nextInt(26));
			System.out.println("> Caracter añadido: " + c);
			buffer.poner(c);
			
			try {
				sleep(1000);
			} catch (InterruptedException ignore) {
			}
		}
	}
}
