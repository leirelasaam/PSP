package ejercicio_7.vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;

import ejercicio_7.hilos.HiloCaballo;

public class Carrera extends JPanel {

	private static final long serialVersionUID = -6315731833918124933L;
	private ArrayList<HiloCaballo> caballos = null;
	private ArrayList<JProgressBar> progressBars = null;
	private JLabel lblGanador;

	public Carrera() {
		this.caballos = new ArrayList<>();
        this.progressBars = new ArrayList<>();
		initialize();
	}
	
	private void initialize() {
		setBounds(5, 5, 374, 451);
		setLayout(null);
		
		lblGanador = new JLabel("");
		lblGanador.setBounds(84, 24, 177, 14);
		add(lblGanador);
		
		crearProgressBars();
		crearCaballos();
		
		JButton btnEmpezar = new JButton("Comenzar carrera");
		btnEmpezar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iniciarCarrera();
			}
		});
		btnEmpezar.setBounds(84, 332, 269, 23);
		add(btnEmpezar);
	}
	
    public void iniciarCarrera() {
        for (HiloCaballo caballo : caballos) {
            caballo.start();
        }
    }
	
	private void crearProgressBars() {
		Random random = new Random();
		UIManager.put("ProgressBar.selectionForeground", Color.BLACK);
	    UIManager.put("ProgressBar.selectionBackground", Color.BLACK);
		
		for (int i = 1; i < 5; i++) {
			JLabel lblCaballo = new JLabel("Caballo " + i + ":");
			lblCaballo.setBounds(10, 70 * i, 77, 24);
			add(lblCaballo);
			
			JProgressBar progressBar = new JProgressBar();
			progressBar.setStringPainted(true);
			progressBar.setBounds(84, 70 * i, 269, 37);
			Color randomColor = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
	        progressBar.setBackground(randomColor);
			add(progressBar);
			
			progressBars.add(progressBar);
		}
		
	}
	
	private void crearCaballos() {
		for (int i = 1; i < 5; i++) {
			HiloCaballo caballo = new HiloCaballo("Caballo " + i, progressBars.get(i-1), lblGanador);
			caballos.add(caballo);
		}
	}
	
	public ArrayList<HiloCaballo> getCaballos(){
		return caballos;
	}
	
}
