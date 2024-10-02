package ejercicio_4_detonador;

public class DetonadorConRetardo extends Thread {
	private int contador;
	
	public DetonadorConRetardo(String nombre, int contador) {
		super(nombre);
		this.contador = contador;
	}
	
	public void run() {
		for (int i = contador; i > 0; i--) {
			System.out.println(getName() + ": " + i);
			try {
				sleep(1000);
			} catch (InterruptedException ignore) {}
		}
		System.out.println("Fin de " + getName());
	}
}
