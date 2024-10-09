package ejercicio_7.vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ejercicio_5.hilos.HiloContador;
import ejercicio_7.hilos.HiloCaballo;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JProgressBar;
import java.awt.Color;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldCaballo1;
	private JTextField textFieldCaballo2;
	private JTextField textFieldCaballo3;
	private JTextField textFieldCaballo4;

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
		
		JPanel panelCarrera = new JPanel();
		panelCarrera.setBounds(5, 5, 374, 451);
		panelCarrera.setLayout(null);
		contentPane.add(panelCarrera);
		
		JLabel lblGanador = new JLabel("");
		lblGanador.setBounds(84, 24, 177, 14);
		panelCarrera.add(lblGanador);
		
		JLabel lblCaballo1 = new JLabel("Caballo 1:");
		lblCaballo1.setBounds(10, 84, 77, 24);
		panelCarrera.add(lblCaballo1);
		
		JProgressBar progressBar1 = new JProgressBar();
		progressBar1.setStringPainted(true);
		progressBar1.setForeground(Color.WHITE);
		progressBar1.setBackground(Color.PINK);
		progressBar1.setBounds(84, 71, 269, 37);
		panelCarrera.add(progressBar1);
		
		JLabel lblCaballo2 = new JLabel("Caballo 2:");
		lblCaballo2.setBounds(10, 143, 77, 24);
		panelCarrera.add(lblCaballo2);
		
		JProgressBar progressBar2 = new JProgressBar();
		progressBar2.setStringPainted(true);
		progressBar2.setForeground(Color.WHITE);
		progressBar2.setBackground(Color.BLUE);
		progressBar2.setBounds(84, 130, 269, 37);
		panelCarrera.add(progressBar2);
		
		JLabel lblCaballo3 = new JLabel("Caballo 3:");
		lblCaballo3.setBounds(10, 207, 77, 24);
		panelCarrera.add(lblCaballo3);
		
		JProgressBar progressBar3 = new JProgressBar();
		progressBar3.setStringPainted(true);
		progressBar3.setForeground(Color.WHITE);
		progressBar3.setBackground(Color.GREEN);
		progressBar3.setBounds(84, 194, 269, 37);
		panelCarrera.add(progressBar3);
		
		JLabel lblCaballo4 = new JLabel("Caballo 4:");
		lblCaballo4.setBounds(10, 275, 77, 24);
		panelCarrera.add(lblCaballo4);
		
		JProgressBar progressBar4 = new JProgressBar();
		progressBar4.setStringPainted(true);
		progressBar4.setForeground(Color.WHITE);
		progressBar4.setBackground(Color.MAGENTA);
		progressBar4.setBounds(84, 262, 269, 37);
		panelCarrera.add(progressBar4);
		
		JPanel panelPrioridades = new JPanel();
		panelPrioridades.setBounds(5, 5, 374, 451);
		contentPane.add(panelPrioridades);
		panelPrioridades.setLayout(null);
		
		JLabel lblNomCaballo1 = new JLabel("Caballo 1:");
		lblNomCaballo1.setBounds(53, 75, 46, 14);
		panelPrioridades.add(lblNomCaballo1);
		
		textFieldCaballo1 = new JTextField();
		textFieldCaballo1.setBounds(125, 72, 86, 20);
		panelPrioridades.add(textFieldCaballo1);
		textFieldCaballo1.setColumns(10);
		
		JLabel lblNomCaballo2 = new JLabel("Caballo 2:");
		lblNomCaballo2.setBounds(53, 121, 46, 14);
		panelPrioridades.add(lblNomCaballo2);
		
		textFieldCaballo2 = new JTextField();
		textFieldCaballo2.setColumns(10);
		textFieldCaballo2.setBounds(125, 118, 86, 20);
		panelPrioridades.add(textFieldCaballo2);
		
		JLabel lblNomCaballo3 = new JLabel("Caballo 3:");
		lblNomCaballo3.setBounds(53, 168, 46, 14);
		panelPrioridades.add(lblNomCaballo3);
		
		textFieldCaballo3 = new JTextField();
		textFieldCaballo3.setColumns(10);
		textFieldCaballo3.setBounds(125, 165, 86, 20);
		panelPrioridades.add(textFieldCaballo3);
		
		JLabel lblNomCaballo4 = new JLabel("Caballo 4:");
		lblNomCaballo4.setBounds(53, 214, 46, 14);
		panelPrioridades.add(lblNomCaballo4);
		
		textFieldCaballo4 = new JTextField();
		textFieldCaballo4.setColumns(10);
		textFieldCaballo4.setBounds(125, 211, 86, 20);
		panelPrioridades.add(textFieldCaballo4);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPrioridades.setVisible(false);
				panelCarrera.setVisible(true);
			}
		});
		btnGuardar.setBounds(122, 278, 89, 23);
		panelPrioridades.add(btnGuardar);
		
		HiloCaballo caballo1 = new HiloCaballo("Caballo 1", progressBar1, lblGanador);
		HiloCaballo caballo2 = new HiloCaballo("Caballo 2", progressBar2, lblGanador);
		HiloCaballo caballo3 = new HiloCaballo("Caballo 3", progressBar3, lblGanador);
		HiloCaballo caballo4 = new HiloCaballo("Caballo 4", progressBar4, lblGanador);
		
		JButton btnEmpezar = new JButton("Comenzar carrera");
		btnEmpezar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				caballo1.start();
				caballo2.start();
				caballo3.start();
				caballo4.start();
			}
		});
		btnEmpezar.setBounds(84, 332, 269, 23);
		panelCarrera.add(btnEmpezar);
		
		textFieldCaballo1.setText("" + caballo1.getPriority());
		textFieldCaballo2.setText("" + caballo2.getPriority());
		textFieldCaballo3.setText("" + caballo3.getPriority());
		textFieldCaballo4.setText("" + caballo4.getPriority());
        panelCarrera.setVisible(false);
	}
}
