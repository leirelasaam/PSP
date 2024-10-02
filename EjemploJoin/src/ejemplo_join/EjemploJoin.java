package ejemplo_join;

public class EjemploJoin {

	public static void main(String[] args) {
		HiloJoin h1 = new HiloJoin("Hilo1", 2);
		HiloJoin h2 = new HiloJoin("Hilo2", 5);
		HiloJoin h3 = new HiloJoin("Hilo3", 70);
		
		// Si le asignamos una prioridad más alta, se ejecutará siempre antes el hilo 3
		h3.setPriority(10);
		
		h1.start();
		h2.start();
		h3.start();
		
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {}
		
		// Forzamos la interrupción del hilo 3 tras 7 segundos. Por lo que no llegará a imprimir 70 números, sino que 7.
		h3.interrupt();
		
		try {
			h1.join();
			h2.join();
			h3.join();
		} catch(InterruptedException e) {}
		
		System.out.println("FINAL DEL PROGRAMA");
	}

}
