package interfacesGraficas;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import factorias.FactoriaTrabajador;
import operacionesCRUD.CRUDempleados;
import pojo.Trabajador;

public class VentanaEmpleado extends JFrame {

//	public static void main(String[] args) throws SQLException {		
//		VentanaPrincipal principal = new VentanaPrincipal();
//		principal.setVisible(false);
//		VentanaEmpleado ventEmpl = new VentanaEmpleado(principal);
//		ventEmpl.setVisible(true);	
//	}
	
	private JPanel contentPane;
	private JTextField textDniNif;
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textFechaNacimiento;
	private JTextField textFechaAltaEmpleado;
	private JTextField textSueldo;
	private JTextField textRango;
	private JComboBox comboBoxSexo;
	private ArrayList<JTextField> textos = new ArrayList<JTextField>();
	private HashMap componentes;

	public VentanaEmpleado(VentanaPrincipal principal) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				formWindowClosing(e, principal);
			}
		});
		setTitle("Facturame --- Empleado");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 555, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelPersona = new JPanel();
		panelPersona.setBorder(new TitledBorder(null, "Datos Personales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPersona.setBounds(10, 10, 520, 80);
		contentPane.add(panelPersona);
		panelPersona.setLayout(null);
		
		JLabel labelDniNif = new JLabel("DNI/NIF:");
		labelDniNif.setBounds(10, 20, 68, 15);
		panelPersona.add(labelDniNif);
		
		textDniNif = new JTextField();
		textDniNif.setBounds(60, 15, 86, 20);
		panelPersona.add(textDniNif);
		textDniNif.setColumns(10);
		
		JLabel labelNombre = new JLabel("Nombre:");
		labelNombre.setBounds(10, 50, 73, 15);
		panelPersona.add(labelNombre);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(60, 45, 120, 20);
		panelPersona.add(textNombre);
		
		JLabel labelApellidos = new JLabel("Apellidos:");
		labelApellidos.setBounds(190, 50, 120, 15);
		panelPersona.add(labelApellidos);
		
		textApellidos = new JTextField();
		textApellidos.setColumns(10);
		textApellidos.setBounds(248, 45, 262, 20);
		panelPersona.add(textApellidos);
		
		JLabel labelSexo = new JLabel("Sexo:");
		labelSexo.setBounds(155, 20, 56, 15);
		panelPersona.add(labelSexo);
		
		comboBoxSexo = new JComboBox();
		comboBoxSexo.setModel(new DefaultComboBoxModel(new String[] {"Femenino", "Masculino"}));
		comboBoxSexo.setBounds(195, 17, 80, 20);
		panelPersona.add(comboBoxSexo);
		
		JLabel labelFechaNacimiento = new JLabel("Fecha de nacimiento:");
		labelFechaNacimiento.setBounds(290, 20, 130, 15);
		panelPersona.add(labelFechaNacimiento);
		
		textFechaNacimiento = new JTextField();
		textFechaNacimiento.setColumns(10);
		textFechaNacimiento.setBounds(420, 15, 90, 20);
		panelPersona.add(textFechaNacimiento);
		
		JPanel panelEmpleado = new JPanel();
		panelEmpleado.setBorder(new TitledBorder(null, "Datos Empleado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelEmpleado.setBounds(10, 101, 520, 80);
		contentPane.add(panelEmpleado);
		panelEmpleado.setLayout(null);
		
		JLabel labelFechaAltaEmpleado = new JLabel("Fecha de alta:");
		labelFechaAltaEmpleado.setBounds(240, 51, 95, 15);
		panelEmpleado.add(labelFechaAltaEmpleado);
		
		textFechaAltaEmpleado = new JTextField();
		textFechaAltaEmpleado.setColumns(10);
		textFechaAltaEmpleado.setBounds(320, 46, 90, 20);
		panelEmpleado.add(textFechaAltaEmpleado);
		
		JLabel labelSueldo = new JLabel("Sueldo:");
		labelSueldo.setBounds(10, 51, 47, 15);
		panelEmpleado.add(labelSueldo);
		
		textSueldo = new JTextField();
		textSueldo.setColumns(10);
		textSueldo.setBounds(60, 46, 86, 20);
		panelEmpleado.add(textSueldo);
		
		JLabel labelRango = new JLabel("Rango:");
		labelRango.setBounds(10, 20, 47, 15);
		panelEmpleado.add(labelRango);
		
		textRango = new JTextField();
		textRango.setColumns(10);
		textRango.setBounds(60, 15, 450, 20);
		panelEmpleado.add(textRango);
		
		JButton buttonAceptar = new JButton("ACEPTAR");
		buttonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					crearEmpleado();
				} catch (SQLException sqle) {
					// TODO Auto-generated catch block
					sqle.printStackTrace();
				}
			}
		});
		buttonAceptar.setBounds(10, 195, 120, 25);
		contentPane.add(buttonAceptar);
		
		JButton buttonVerListado = new JButton("VER LISTADO");
		buttonVerListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonVerListado.setBounds(150, 195, 120, 25);
		contentPane.add(buttonVerListado);
		
		JButton buttonCancelar = new JButton("CANCELAR");
		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonCancelar.setBounds(290, 195, 120, 25);
		contentPane.add(buttonCancelar);
		
		JButton buttonBorrar = new JButton("");
		buttonBorrar.setIcon(new ImageIcon("images\\papelera_16.png"));
		buttonBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		buttonBorrar.setBounds(430, 195, 25, 25);
		contentPane.add(buttonBorrar);
		
		textos.add(textDniNif);
		textos.add(textNombre);
		textos.add(textApellidos);
		textos.add(textFechaNacimiento);
		textos.add(textFechaAltaEmpleado);
		textos.add(textSueldo);
		textos.add(textSueldo);
		textos.add(textRango);
	}
	
	private void formWindowClosing(java.awt.event.WindowEvent evt, VentanaPrincipal principal) {
        this.setVisible(false);
        principal.setVisible(true);
    }
	
	private void crearEmpleado() throws SQLException{
		Boolean camposObligatorios = true;
		for(JTextField texto:textos){
			camposObligatorios = texto.getText().equals("") ? false : camposObligatorios;
		}
		if(camposObligatorios){
			Trabajador trabajador = FactoriaTrabajador.crearTrabajador();
			trabajador.setApellidos(textApellidos.getText());
			trabajador.setDni(textDniNif.getText());
			trabajador.setFechaAltaEmpleado(Date.valueOf(textFechaAltaEmpleado.getText()));
			trabajador.setFechaNacimiento(Date.valueOf(textFechaNacimiento.getText()));
			trabajador.setNombre(textNombre.getText());
			trabajador.setRango(textRango.getText());		
			trabajador.setSexo(comboBoxSexo.getSelectedItem().toString());
			trabajador.setSueldo(Integer.parseInt(textSueldo.getText()));
			
			CRUDempleados crudEmpleados = new CRUDempleados();
			crudEmpleados.insertarActualizarEmpleado(trabajador, true);
		} else {
			JOptionPane.showMessageDialog(null, "Faltan campos por rellenar");
		}		
	}

}
