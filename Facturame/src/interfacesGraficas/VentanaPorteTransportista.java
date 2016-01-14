package interfacesGraficas;

<<<<<<< HEAD
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
=======
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
>>>>>>> feature/continuacionBuilder

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
<<<<<<< HEAD
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPorteTransportista extends JFrame {

=======

import builders.PorteGrafico;
import factorias.FactoriaCRUD;
import operacionesCRUD.CRUDempleados;
import pojo.Camion;
import pojo.Porte;
import pojo.Trabajador;
import utils.ConversorArrays;

public class VentanaPorteTransportista extends JFrame {

	private Porte p;
	private FactoriaCRUD fc;
	private PorteGrafico pb;
	private CRUDempleados ce;
>>>>>>> feature/continuacionBuilder
	private JPanel contentPane;
	private JTextField textDni;
	private JTextField textNombre;

<<<<<<< HEAD
	public VentanaPorteTransportista(VentanaPrincipal principal) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				formWindowClosing(e, principal);
			}
		});
=======
	public VentanaPorteTransportista(PorteGrafico pb) throws SQLException {
		this.p = pb.getPorte();
		this.pb = pb;
		this.fc = new FactoriaCRUD();
		this.ce = (CRUDempleados) fc.crearCRUD(FactoriaCRUD.TIPO_EMPLEADO);
>>>>>>> feature/continuacionBuilder
		setTitle("Facturame --- Porte --- Transportista");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 340, 195);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 324, 222);
		contentPane.add(panel);
		
		JLabel lblEligeUnTransportista = new JLabel("Elige transportista:");
		lblEligeUnTransportista.setBounds(10, 10, 110, 20);
		panel.add(lblEligeUnTransportista);
		
		textDni = new JTextField();
		textDni.setColumns(10);
		textDni.setBounds(120, 10, 140, 20);
		panel.add(textDni);
		
		JButton buttonBuscar = new JButton("");
<<<<<<< HEAD
		buttonBuscar.setIcon(new ImageIcon("D:\\Darako\\Universidad\\Patrones de Dise\u00F1o\\PS_Workspace\\FacturameGIT\\Facturame\\images\\lupa_16.png"));
=======
		buttonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					buttonBuscarActionPerformed(arg0);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		buttonBuscar.setIcon(new ImageIcon(
				"D:\\Darako\\Universidad\\Patrones de Dise\u00F1o\\PS_Workspace\\FacturameGIT\\Facturame\\images\\lupa_16.png"));
>>>>>>> feature/continuacionBuilder
		buttonBuscar.setBounds(270, 8, 25, 25);
		panel.add(buttonBuscar);
		
		JComboBox comboBoxDni = new JComboBox();
		comboBoxDni.setBounds(120, 40, 140, 20);
		
		ArrayList<Object> trabajadoresO = new ArrayList<Object>(ce.buscarTodo());
		ArrayList<Trabajador> trabajadores = ConversorArrays.convertirTrabajadores(trabajadoresO);

		for (Trabajador t : trabajadores)
			comboBoxDni.addItem(t.getDni());

		comboBoxDni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					comboActionPerformed(e);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel.add(comboBoxDni);
		
		JLabel labelNombre = new JLabel("Nombre:");
		labelNombre.setBounds(10, 98, 46, 14);
		panel.add(labelNombre);
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setColumns(10);
		textNombre.setBounds(86, 95, 209, 20);
		panel.add(textNombre);
<<<<<<< HEAD
		
		JLabel labelTelefono = new JLabel("Tel\u00E9fono:");
		labelTelefono.setBounds(10, 129, 71, 14);
		panel.add(labelTelefono);
		
		textTelefono = new JTextField();
		textTelefono.setEditable(false);
		textTelefono.setColumns(10);
		textTelefono.setBounds(86, 126, 209, 20);
		panel.add(textTelefono);
		
=======

>>>>>>> feature/continuacionBuilder
		JButton buttonSiguiente = new JButton("");
		buttonSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonSiguienteActionPerformed(e, principal);
			}
		});
<<<<<<< HEAD
		buttonSiguiente.setIcon(new ImageIcon("D:\\Darako\\Universidad\\Patrones de Dise\u00F1o\\PS_Workspace\\FacturameGIT\\Facturame\\images\\flecha_16.png"));
		buttonSiguiente.setBounds(120, 157, 89, 23);
=======
		buttonSiguiente.setIcon(new ImageIcon(
				"D:\\Darako\\Universidad\\Patrones de Dise\u00F1o\\PS_Workspace\\FacturameGIT\\Facturame\\images\\flecha_16.png"));
		buttonSiguiente.setBounds(120, 126, 89, 23);
>>>>>>> feature/continuacionBuilder
		panel.add(buttonSiguiente);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 71, 304, 14);
		panel.add(separator);
	}
	
	private void formWindowClosing(java.awt.event.WindowEvent evt, VentanaPrincipal principal) {
		this.setVisible(false);
		principal.setVisible(true);
	}

	private void buttonSiguienteActionPerformed(java.awt.event.ActionEvent evt, VentanaPrincipal principal) {
		VentanaPorteCamion formPorteCamion = new VentanaPorteCamion(principal);
		formPorteCamion.setVisible(true);
	    this.setVisible(false);
	}
	
<<<<<<< HEAD
=======
	private void comboActionPerformed(ActionEvent evt) throws SQLException {
		JComboBox comboBox = (JComboBox) evt.getSource();
		Object selected = comboBox.getSelectedItem();
		Trabajador empleado = (Trabajador) ce.buscarUno(selected);

		textNombre.setText((String.valueOf(empleado.getNombre() + " " + empleado.getApellidos())));
		
		p.setDni(empleado.getDni());

	}

	private void buttonBuscarActionPerformed(ActionEvent arg0) throws SQLException {
		Object selected = textDni.getText();
		Trabajador empleado = (Trabajador) ce.buscarUno(selected);

		if (empleado != null) {
			textNombre.setText((String.valueOf(empleado.getNombre() + " " + empleado.getApellidos())));

			p.setDni(empleado.getDni());
		}
	}
>>>>>>> feature/continuacionBuilder
}
