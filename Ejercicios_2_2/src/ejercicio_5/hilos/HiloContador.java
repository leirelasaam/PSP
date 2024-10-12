package ejercicio_5.hilos;

import javax.swing.JLabel;

public class HiloContador extends Thread {
	private JLabel label;
	
	public HiloContador(String nombre, JLabel label) {
		super(nombre);
		this.label = label;
	}

	public void run() {
		for (int i = 0; ; i++) {
			try {
				label.setText(getName() + ": " + i);
				sleep(1000);
			} catch (InterruptedException ignore) {
				break;
			}
		}
	}
}
