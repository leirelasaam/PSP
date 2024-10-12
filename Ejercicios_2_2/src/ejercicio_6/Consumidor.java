package ejercicio_6;

public class Consumidor extends Thread {
	private Buffer buffer;
	
	public Consumidor(Buffer buffer) {
		this.buffer = buffer;
	}
	
	public void run() {
		for (int i = 0; i < 10; i++) {
			char c = buffer.recoger();
			if (Character.isLetter(c)) {
				System.out.println("> Caracter recogido: " + c);
			} else {
				System.out.println("> Buffer vacío al recoger");
			}
			
			try {
				sleep(2000);
			} catch (InterruptedException ignore) {}
		}
	}
}
