package ejercicio_5.vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ejercicio_5.hilos.HiloContador;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setBounds(100, 100, 400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblContadorH1 = new JLabel("Hilo 1: 0");
		lblContadorH1.setHorizontalAlignment(SwingConstants.CENTER);
		lblContadorH1.setBounds(44, 277, 89, 23);
		contentPane.add(lblContadorH1);
		
		JLabel lblContadorH2 = new JLabel("Hilo 2: 0");
		lblContadorH2.setHorizontalAlignment(SwingConstants.CENTER);
		lblContadorH2.setBounds(44, 311, 89, 23);
		contentPane.add(lblContadorH2);
		
		JLabel lblContadorH3 = new JLabel("Hilo 3: 0");
		lblContadorH3.setHorizontalAlignment(SwingConstants.CENTER);
		lblContadorH3.setBounds(44, 345, 89, 23);
		contentPane.add(lblContadorH3);
		
		HiloContador hilo1 = new HiloContador("Hilo 1", lblContadorH1);
		hilo1.start();
		
		HiloContador hilo2 = new HiloContador("Hilo 2", lblContadorH2);
		hilo2.start();
		
		HiloContador hilo3 = new HiloContador("Hilo 3", lblContadorH3);
		hilo3.start();
		
		JLabel lblPriH1 = new JLabel("Pri: " + hilo1.getPriority());
		lblPriH1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPriH1.setBounds(242, 277, 89, 23);
		contentPane.add(lblPriH1);
		
		JLabel lblPriH2 = new JLabel("Pri: " + hilo2.getPriority());
		lblPriH2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPriH2.setBounds(242, 311, 89, 23);
		contentPane.add(lblPriH2);
		
		JLabel lblPriH3 = new JLabel("Pri: " + hilo3.getPriority());
		lblPriH3.setHorizontalAlignment(SwingConstants.CENTER);
		lblPriH3.setBounds(242, 345, 89, 23);
		contentPane.add(lblPriH3);
		
		JButton btnMinusH1 = new JButton("--");
		btnMinusH1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarPrioridad(false, hilo1, lblPriH1);
			}
		});
		btnMinusH1.setBounds(44, 59, 89, 23);
		contentPane.add(btnMinusH1);
		
		JButton btnFinH1 = new JButton("Fin hilo 1");
		btnFinH1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hilo1.interrupt();
			}
		});
		btnFinH1.setBounds(143, 59, 89, 23);
		contentPane.add(btnFinH1);
		
		JButton btnPlusH1 = new JButton("++");
		btnPlusH1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarPrioridad(true, hilo1, lblPriH1);
			}
		});
		btnPlusH1.setBounds(242, 59, 89, 23);
		contentPane.add(btnPlusH1);
		
		JButton btnMinusH2 = new JButton("--");
		btnMinusH2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarPrioridad(false, hilo2, lblPriH2);
			}
		});
		btnMinusH2.setBounds(44, 93, 89, 23);
		contentPane.add(btnMinusH2);
		
		JButton btnFinH2 = new JButton("Fin hilo 2");
		btnFinH2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hilo2.interrupt();
			}
		});
		btnFinH2.setBounds(143, 93, 89, 23);
		contentPane.add(btnFinH2);
		
		JButton btnPlusH2 = new JButton("++");
		btnPlusH2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarPrioridad(true, hilo2, lblPriH2);
			}
		});
		btnPlusH2.setBounds(242, 93, 89, 23);
		contentPane.add(btnPlusH2);
		
		JButton btnMinusH3 = new JButton("--");
		btnMinusH3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarPrioridad(false, hilo3, lblPriH3);
			}
		});
		btnMinusH3.setBounds(44, 127, 89, 23);
		contentPane.add(btnMinusH3);
		
		JButton btnFinH3 = new JButton("Fin hilo 3");
		btnFinH3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hilo3.interrupt();
			}
		});
		btnFinH3.setBounds(143, 127, 89, 23);
		contentPane.add(btnFinH3);
		
		JButton btnPlusH3 = new JButton("++");
		btnPlusH3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarPrioridad(true, hilo3, lblPriH3);
			}
		});
		btnPlusH3.setBounds(242, 127, 89, 23);
		contentPane.add(btnPlusH3);
		
		JButton btnFinTodos = new JButton("Finalizar todos");
		btnFinTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hilo1.interrupt();
				hilo2.interrupt();
				hilo3.interrupt();
			}
		});
		btnFinTodos.setBounds(125, 182, 124, 23);
		contentPane.add(btnFinTodos);
	}
	
	private void cambiarPrioridad(boolean esAumentar, HiloContador hilo, JLabel label) {
		int dif = 0;
		if (esAumentar) {
			if (hilo.getPriority() < 10)
				dif = 1;
		} else {
			if (hilo.getPriority() > 1)
				dif = -1;
		}
		
		hilo.setPriority(hilo.getPriority() + dif);
		label.setText("Pri: " + hilo.getPriority());
	}
}
