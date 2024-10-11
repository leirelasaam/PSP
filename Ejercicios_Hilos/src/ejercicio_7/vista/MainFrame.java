package ejercicio_7.vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Carrera carrera = null;
	private Trampas trampas = null;

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
		
		carrera = new Carrera();
        trampas = new Trampas(carrera.getCaballos(), this::mostrarPanelCarrera);
        contentPane.add(trampas, BorderLayout.CENTER);
	}
	
    public void mostrarPanelCarrera() {
        cambiarPanel(carrera);
    }
	
	public void cambiarPanel(JPanel nuevoPanel) {
		getContentPane().removeAll();
		getContentPane().add(nuevoPanel, BorderLayout.CENTER);
		revalidate();
		repaint();
	}
}
