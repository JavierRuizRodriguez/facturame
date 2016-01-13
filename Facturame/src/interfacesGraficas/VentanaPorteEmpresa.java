package interfacesGraficas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

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
import factorias.FactoriaCRUD;
import factorias.FactoriaEmpresa;
import operacionesCRUD.CRUDcamiones;
import operacionesCRUD.CRUDempresa;
import pojo.Camion;
import pojo.Empresa;
import pojo.Porte;
import utils.ConversorArrays;

public class VentanaPorteEmpresa extends JFrame {

	private Porte p;
	private FactoriaCRUD fc;
	private PorteGrafico pb;
	private CRUDempresa ce;
	private JPanel contentPane;
	private JTextField textEmpresa;
	private JTextField textNombre;
	private JTextField textTelefono;
	private JTextField textMail;

	public VentanaPorteEmpresa(PorteGrafico pb, Porte p) throws SQLException {
		this.p = p;
		this.pb = pb;
		this.fc = new FactoriaCRUD();
		this.ce = (CRUDempresa) fc.crearCRUD(FactoriaCRUD.TIPO_EMPRESA);
		setTitle("Facturame --- Porte --- Empresa");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 340, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel labelEligeUnaEmpresa = new JLabel("Elige empresa:");
		labelEligeUnaEmpresa.setBounds(10, 10, 110, 20);
		contentPane.add(labelEligeUnaEmpresa);

		textEmpresa = new JTextField();
		textEmpresa.setBounds(120, 10, 140, 20);
		contentPane.add(textEmpresa);
		textEmpresa.setColumns(10);

		JButton buttonBuscar = new JButton("");
		buttonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					buttonBuscarActionPerformed(e);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		buttonBuscar.setIcon(new ImageIcon(
				"D:\\Darako\\Universidad\\Patrones de Dise\u00F1o\\PS_Workspace\\FacturameGIT\\Facturame\\images\\lupa_16.png"));
		buttonBuscar.setSelectedIcon(new ImageIcon(
				"D:\\Darako\\Universidad\\Patrones de Dise\u00F1o\\PS_Workspace\\FacturameGIT\\Facturame\\images\\lupa_24.png"));
		buttonBuscar.setBounds(270, 8, 25, 25);
		contentPane.add(buttonBuscar);

		JComboBox comboBoxEmpresa = new JComboBox();
		comboBoxEmpresa.setBounds(120, 40, 140, 20);
		ArrayList<Object> empresasO = new ArrayList<Object>(ce.buscarTodo());
		ArrayList<Empresa> empresas = ConversorArrays.convertirEmpresas(empresasO);

		for (Empresa e : empresas)
			comboBoxEmpresa.addItem(e.getEmpresa());

		comboBoxEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					comboActionPerformed(e);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		contentPane.add(comboBoxEmpresa);

		JLabel labelNombre = new JLabel("Nombre:");
		labelNombre.setBounds(10, 98, 46, 14);
		contentPane.add(labelNombre);

		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setBounds(86, 95, 209, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);

		JLabel labelTelefono = new JLabel("Tel\u00E9fono:");
		labelTelefono.setBounds(10, 129, 71, 14);
		contentPane.add(labelTelefono);

		textTelefono = new JTextField();
		textTelefono.setEditable(false);
		textTelefono.setBounds(86, 126, 209, 20);
		contentPane.add(textTelefono);
		textTelefono.setColumns(10);

		JLabel labelMail = new JLabel("Mail:");
		labelMail.setBounds(10, 160, 46, 14);
		contentPane.add(labelMail);

		textMail = new JTextField();
		textMail.setEditable(false);
		textMail.setBounds(86, 157, 209, 20);
		contentPane.add(textMail);
		textMail.setColumns(10);

		JButton buttonSiguiente = new JButton("");
		buttonSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonSiguienteActionPerformed(e);
			}
		});
		buttonSiguiente.setIcon(new ImageIcon(
				"D:\\Darako\\Universidad\\Patrones de Dise\u00F1o\\PS_Workspace\\FacturameGIT\\Facturame\\images\\flecha_16.png"));
		buttonSiguiente.setBounds(120, 188, 89, 23);
		contentPane.add(buttonSiguiente);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 71, 304, 14);
		contentPane.add(separator);
	}

	private void formWindowClosing(java.awt.event.WindowEvent evt) {
		this.setVisible(false);
	}

	private void comboActionPerformed(ActionEvent evt) throws SQLException {
		JComboBox comboBox = (JComboBox) evt.getSource();
		Object selected = comboBox.getSelectedItem();
		Empresa empresa = (Empresa) ce.buscarUno(selected);

		textNombre.setText(empresa.getEmpresa());
		textMail.setText(empresa.getEmail());
		textTelefono.setText(String.valueOf(empresa.getnTelefono()));

		p.setNif(empresa.getNif());

	}

	private void buttonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {
		pb.setEspera(false);
		this.setVisible(false);
	}

	public Porte getPorte() {
		return p;
	}

	private void buttonBuscarActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
		Object selected = textEmpresa.getText();
		Empresa empresa = (Empresa) ce.buscarUno(selected);

		if (empresa != null) {
			textNombre.setText((String.valueOf(empresa.getEmpresa())));
			textTelefono.setText((String.valueOf(empresa.getnTelefono())));
			textMail.setText(empresa.getEmail());
			p.setNif(empresa.getNif());
		}
	}
}
