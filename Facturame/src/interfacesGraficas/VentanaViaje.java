package interfacesGraficas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VentanaViaje extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VentanaViaje frame = new VentanaViaje();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaViaje() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				formWindowClosing(e);
			}
		});
		setTitle("Facturame --- Viaje");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 231);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelOrigen = new JLabel("Origen: ");
		labelOrigen.setBounds(10, 10, 120, 20);
		contentPane.add(labelOrigen);
		
		JLabel labelDestino = new JLabel("Destino: ");
		labelDestino.setBounds(10, 40, 120, 20);
		contentPane.add(labelDestino);
		
		JLabel labelHoraSalida = new JLabel("Hora de salida:");
		labelHoraSalida.setBounds(10, 71, 120, 20);
		contentPane.add(labelHoraSalida);
		
		JLabel labelHoraLlegada = new JLabel("Hora de llegada: ");
		labelHoraLlegada.setBounds(200, 70, 120, 20);
		contentPane.add(labelHoraLlegada);
		
		JLabel labelFechaSalida = new JLabel("Fecha de salida:");
		labelFechaSalida.setBounds(10, 100, 120, 20);
		contentPane.add(labelFechaSalida);
		
		JLabel labelFechaLlegada = new JLabel("Fecha de salida:");
		labelFechaLlegada.setBounds(200, 100, 120, 20);
		contentPane.add(labelFechaLlegada);
		
		JLabel labelKmViaje = new JLabel("Km del viaje:");
		labelKmViaje.setBounds(10, 130, 120, 20);
		contentPane.add(labelKmViaje);
		
		textField = new JTextField();
		textField.setBounds(55, 10, 367, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(55, 40, 367, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(95, 70, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(290, 70, 86, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(95, 100, 86, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(290, 100, 86, 20);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setBounds(95, 130, 86, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JButton buttonAceptar = new JButton("ACEPTAR");
		buttonAceptar.setBounds(10, 161, 120, 25);
		contentPane.add(buttonAceptar);
		
		JButton buttonBorrar = new JButton("");
		buttonBorrar.setBounds(140, 161, 25, 25);
		contentPane.add(buttonBorrar);
	}
	
	private void formWindowClosing(java.awt.event.WindowEvent evt) {
        this.setVisible(false);
    }

}
