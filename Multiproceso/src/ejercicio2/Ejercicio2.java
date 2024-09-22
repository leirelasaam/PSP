package ejercicio2;


import java.awt.EventQueue;

import ejercicio2.vista.MainFrame;
/**
 * Ejecuta la aplicación de gestión de resultados.
 */
public class Ejercicio2 {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
