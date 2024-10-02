package ejercicio_4_detonador;

public class Principal {

	public static void main(String[] args) {
		DetonadorConRetardo detonador1 = new DetonadorConRetardo("Detonador 1", 2);
		DetonadorConRetardo detonador2 = new DetonadorConRetardo("Detonador 2", 4);
		DetonadorConRetardo detonador3 = new DetonadorConRetardo("Detonador 3", 6);
		DetonadorConRetardo detonador4 = new DetonadorConRetardo("Detonador 4", 10);
		
		detonador1.start();
		detonador2.start();
		detonador3.start();
		detonador4.start();
		
		try {
			detonador1.join();
			detonador2.join();
			detonador3.join();
			detonador4.join();
		} catch(InterruptedException e) {}
		
		System.out.println("BOOOM");
	}

}
