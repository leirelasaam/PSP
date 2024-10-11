package ejercicio_7.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ejercicio_7.hilos.HiloCaballo;

public class Trampas extends JPanel {
	
	private static final long serialVersionUID = -4522680272092728744L;
	
	private ArrayList<HiloCaballo> caballos;
	private ArrayList<JTextField> textFields = null;
	private Runnable cambiarPanelCallback;
	
	public Trampas(ArrayList<HiloCaballo> caballos, Runnable cambiarPanelCallback) {
		this.caballos = caballos;
		this.cambiarPanelCallback = cambiarPanelCallback;
        this.textFields = new ArrayList<>();
        
		initialize();
	}
	
	private void initialize() {
		setBounds(5, 5, 374, 451);
		setLayout(null);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarPrioridades();
			}
		});
		btnGuardar.setBounds(122, 278, 89, 23);
		add(btnGuardar);
		
		crearComponentes();
	}
	
	private void crearComponentes() {
		for (int i = 1; i < 5; i++) {
			JLabel lblNomCaballo = new JLabel("Caballo " + i + ":");
			lblNomCaballo.setBounds(53, 50 * i, 80, 24);
			add(lblNomCaballo);
			
			JTextField textFieldCaballo = new JTextField();
			textFieldCaballo.setBounds(150, 50 * i, 86, 20);
			add(textFieldCaballo);
			textFieldCaballo.setColumns(10);
			
			textFields.add(textFieldCaballo);
			
			textFieldCaballo.setText("" + caballos.get(i-1).getPriority());
		}
	}
	
    private void actualizarPrioridades() {
        for (int i = 0; i < caballos.size(); i++) {
            try {
                int prioridad = Integer.parseInt(textFields.get(i).getText());
                caballos.get(i).setPriority(prioridad);
            } catch (Exception e) {
            	JOptionPane.showMessageDialog(null, "Error al asignar prioridades.", "Error", JOptionPane.ERROR_MESSAGE);
            	return;
            }
        }
        
        cambiarPanel();
    }
	
    private void cambiarPanel() {
        if (cambiarPanelCallback != null) {
            cambiarPanelCallback.run();
        }
    }
	
}
