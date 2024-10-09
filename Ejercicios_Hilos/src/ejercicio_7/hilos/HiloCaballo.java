package ejercicio_7.hilos;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class HiloCaballo extends Thread {
	private JLabel label;
	private JProgressBar barra;

	public HiloCaballo(String nombre, JProgressBar barra, JLabel label) {
		super(nombre);
		this.label = label;
		this.barra = barra;
	}

	public void run() {
		while(barra.getValue() <= 100) {
			int random = (int)(Math.random() * 21); // 0 a 20
			try {
				barra.setValue(barra.getValue() + random);
				if (barra.getValue() >= 100) {
					if (label.getText().isEmpty())
						label.setText("Ganador: " + getName());
				}
				
				sleep(1000);
			} catch (InterruptedException ignore) {
				break;
			}
		}
	}

}
