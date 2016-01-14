package interfacesGraficas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VentanaEmpleado extends JFrame {

	private JPanel contentPane;
	private JTextField textDniNif;
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textFechaNacimiento;
	private JTextField textFechaAltaEmpleado;
	private JTextField textSueldo;
	private JTextField textField;

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
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos Personales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 520, 80);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel labelDniNif = new JLabel("DNI/NIF:");
		labelDniNif.setBounds(10, 20, 68, 15);
		panel.add(labelDniNif);
		
		textDniNif = new JTextField();
		textDniNif.setBounds(60, 15, 86, 20);
		panel.add(textDniNif);
		textDniNif.setColumns(10);
		
		JLabel labelNombre = new JLabel("Nombre:");
		labelNombre.setBounds(10, 50, 73, 15);
		panel.add(labelNombre);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(60, 45, 120, 20);
		panel.add(textNombre);
		
		JLabel labelApellidos = new JLabel("Apellidos:");
		labelApellidos.setBounds(190, 50, 120, 15);
		panel.add(labelApellidos);
		
		textApellidos = new JTextField();
		textApellidos.setColumns(10);
		textApellidos.setBounds(248, 45, 262, 20);
		panel.add(textApellidos);
		
		JLabel labelSexo = new JLabel("Sexo:");
		labelSexo.setBounds(155, 20, 56, 15);
		panel.add(labelSexo);
		
		JComboBox comboSexo = new JComboBox();
		comboSexo.setModel(new DefaultComboBoxModel(new String[] {"Femenino", "Masculino"}));
		comboSexo.setBounds(195, 17, 80, 20);
		panel.add(comboSexo);
		
		JLabel labelFechaNacimiento = new JLabel("Fecha de nacimiento:");
		labelFechaNacimiento.setBounds(290, 20, 130, 15);
		panel.add(labelFechaNacimiento);
		
		textFechaNacimiento = new JTextField();
		textFechaNacimiento.setColumns(10);
		textFechaNacimiento.setBounds(420, 15, 90, 20);
		panel.add(textFechaNacimiento);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Datos Empleado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 101, 520, 80);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel labelFechaAltaEmpleado = new JLabel("Fecha de alta:");
		labelFechaAltaEmpleado.setBounds(240, 51, 95, 15);
		panel_1.add(labelFechaAltaEmpleado);
		
		textFechaAltaEmpleado = new JTextField();
		textFechaAltaEmpleado.setColumns(10);
		textFechaAltaEmpleado.setBounds(320, 46, 90, 20);
		panel_1.add(textFechaAltaEmpleado);
		
		JLabel labelSueldo = new JLabel("Sueldo:");
		labelSueldo.setBounds(10, 51, 47, 15);
		panel_1.add(labelSueldo);
		
		textSueldo = new JTextField();
		textSueldo.setColumns(10);
		textSueldo.setBounds(60, 46, 86, 20);
		panel_1.add(textSueldo);
		
		JLabel labelRango = new JLabel("Rango:");
		labelRango.setBounds(10, 20, 47, 15);
		panel_1.add(labelRango);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(60, 15, 450, 20);
		panel_1.add(textField);
		
		JButton buttonAceptar = new JButton("ACEPTAR");
		buttonAceptar.setBounds(10, 195, 120, 25);
		contentPane.add(buttonAceptar);
		
		JButton buttonVerListado = new JButton("VER LISTADO");
		buttonVerListado.setBounds(150, 195, 120, 25);
		contentPane.add(buttonVerListado);
		
		JButton buttonCancelar = new JButton("CANCELAR");
		buttonCancelar.setBounds(290, 195, 120, 25);
		contentPane.add(buttonCancelar);
		
		JButton buttonBorrar = new JButton("");
		buttonBorrar.setBounds(430, 195, 25, 25);
		contentPane.add(buttonBorrar);
	}
	
	private void formWindowClosing(java.awt.event.WindowEvent evt, VentanaPrincipal principal) {
        this.setVisible(false);
        principal.setVisible(true);
    }

}
