package interfacesGraficas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import builders.PorteGrafico;
import pojo.Porte;

public class VentanaPorteTransportista extends JFrame {

	private Porte p;
	private PorteGrafico pb;
	private JPanel contentPane;
	private JTextField textDni;
	private JTextField textNombre;
	private JTextField textTelefono;

	public VentanaPorteTransportista(PorteGrafico pb, Porte p) {
		this.p = p;
		this.pb = pb;
		setTitle("Facturame --- Porte --- Transportista");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 340, 230);
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
		buttonBuscar.setIcon(new ImageIcon(
				"D:\\Darako\\Universidad\\Patrones de Dise\u00F1o\\PS_Workspace\\FacturameGIT\\Facturame\\images\\lupa_16.png"));
		buttonBuscar.setBounds(270, 8, 25, 25);
		panel.add(buttonBuscar);

		JComboBox comboBoxDni = new JComboBox();
		comboBoxDni.setBounds(120, 40, 140, 20);
		panel.add(comboBoxDni);

		JLabel labelNombre = new JLabel("Nombre:");
		labelNombre.setBounds(10, 98, 46, 14);
		panel.add(labelNombre);

		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setColumns(10);
		textNombre.setBounds(86, 95, 209, 20);
		panel.add(textNombre);

		JLabel labelTelefono = new JLabel("Tel\u00E9fono:");
		labelTelefono.setBounds(10, 129, 71, 14);
		panel.add(labelTelefono);

		textTelefono = new JTextField();
		textTelefono.setEditable(false);
		textTelefono.setColumns(10);
		textTelefono.setBounds(86, 126, 209, 20);
		panel.add(textTelefono);

		JButton buttonSiguiente = new JButton("");
		buttonSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonSiguienteActionPerformed(e);
			}
		});
		buttonSiguiente.setIcon(new ImageIcon(
				"D:\\Darako\\Universidad\\Patrones de Dise\u00F1o\\PS_Workspace\\FacturameGIT\\Facturame\\images\\flecha_16.png"));
		buttonSiguiente.setBounds(120, 157, 89, 23);
		panel.add(buttonSiguiente);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 71, 304, 14);
		panel.add(separator);
	}

	private void formWindowClosing(java.awt.event.WindowEvent evt) {
		this.setVisible(false);
	}

	private void buttonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {
		pb.setEspera(false);
		this.setVisible(false);
	}

	public Porte getPorte() {
		return p;
	}
}
