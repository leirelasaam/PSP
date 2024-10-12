package ejercicio_5.vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import ejercicio_5.hilos.HiloContador;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ArrayList<HiloContador> hilos;
	private ArrayList<JLabel> lblContadores;
	private ArrayList<JLabel> lblPrioridades;

	public MainFrame() {
		setBounds(100, 100, 400, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		hilos = new ArrayList<>();
		lblContadores = new ArrayList<>();
		lblPrioridades = new ArrayList<>();

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Crear los hilos, etiquetas y botones para cada hilo
		for (int i = 0; i < 3; i++) {
			crearHilo(i);
		}

		iniciarTodosHilos();

		JButton btnFinTodos = new JButton("Finalizar todos");
		btnFinTodos.setBounds(125, 182, 124, 23);
		btnFinTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finalizarTodosHilos();
			}
		});
		contentPane.add(btnFinTodos);
	}

	/**
	 * Crea tanto el hilo como los elementos para el mismo, es decir, tanto los
	 * botones como los labels.
	 * 
	 * @param index Número entero que sirve como índice a la hora de iterar.
	 */
	private void crearHilo(int index) {
		JLabel lblContador = new JLabel("Hilo " + (index + 1) + ": 0", SwingConstants.CENTER);
		lblContador.setBounds(44, 277 + 34 * index, 89, 23);
		contentPane.add(lblContador);
		lblContadores.add(lblContador);

		JLabel lblPrioridad = new JLabel("Pri: 5", SwingConstants.CENTER);
		lblPrioridad.setBounds(242, 277 + 34 * index, 89, 23);
		contentPane.add(lblPrioridad);
		lblPrioridades.add(lblPrioridad);

		HiloContador hilo = new HiloContador("Hilo " + (index + 1), lblContador);
		hilos.add(hilo);

		agregarBotonCambiarPrioridad("--", index, false, 44, 59 + 34 * index);
		agregarBotonFinHilo("Fin hilo " + (index + 1), index, 143, 59 + 34 * index);
		agregarBotonCambiarPrioridad("++", index, true, 242, 59 + 34 * index);
	}

	/**
	 * Crea un botón para aumentar o disminuir la prioridad.
	 * 
	 * @param texto    String a mostrar en el botón.
	 * @param index    Índice
	 * @param aumentar Booleano que indica si se debe aumentar (true) o disminuir
	 *                 (false) la prioridad.
	 * @param x        Posición x
	 * @param y        Posición y
	 */
	private void agregarBotonCambiarPrioridad(String texto, int index, boolean aumentar, int x, int y) {
		JButton btn = new JButton(texto);
		btn.setBounds(x, y, 89, 23);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarPrioridad(aumentar, hilos.get(index), lblPrioridades.get(index));
			}
		});
		contentPane.add(btn);
	}

	/**
	 * Crea un botón para finalizar el hilo, haciendo uso de interrupt().
	 * 
	 * @param texto String que contiene el texto a mostrar en el botón.
	 * @param index Índice
	 * @param x     Posición x
	 * @param y     Posición y
	 */
	private void agregarBotonFinHilo(String texto, int index, int x, int y) {
		JButton btnFinHilo = new JButton(texto);
		btnFinHilo.setBounds(x, y, 89, 23);
		btnFinHilo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hilos.get(index).interrupt();
			}
		});
		contentPane.add(btnFinHilo);
	}

	/**
	 * Cambia la prioridad del hilo, teniendo en cuenta el valor mínimo y máximo
	 * posible de la prioridad.
	 * 
	 * @param esAumentar Booleano que indica si se debe aumentar o disminuir la
	 *                   prioridad.
	 * @param hilo       HiloContador al cual se le asigna la nueva prioridad.
	 * @param label      Label que contiene el texto de la prioridad y debe
	 *                   actualizarse.
	 */
	private void cambiarPrioridad(boolean esAumentar, HiloContador hilo, JLabel label) {
		int nuevaPrioridad = hilo.getPriority();
		if (esAumentar && nuevaPrioridad < Thread.MAX_PRIORITY) {
			nuevaPrioridad++;
		} else if (!esAumentar && nuevaPrioridad > Thread.MIN_PRIORITY) {
			nuevaPrioridad--;
		}
		hilo.setPriority(nuevaPrioridad);
		label.setText("Pri: " + nuevaPrioridad);
	}

	/**
	 * Inicia todos los hilos, usando start().
	 */
	private void iniciarTodosHilos() {
		for (HiloContador hilo : hilos) {
			if (hilo != null) {
				hilo.start();
			}
		}
	}

	/**
	 * Finaliza todos los hilos, usando interrupt().
	 */
	private void finalizarTodosHilos() {
		for (HiloContador hilo : hilos) {
			if (hilo != null) {
				hilo.interrupt();
			}
		}
	}
}
