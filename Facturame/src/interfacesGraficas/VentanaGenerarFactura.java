package interfacesGraficas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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

import adaptadorFecha.AdaptadorFechaPostgres;
import adaptadorFecha.Fecha;
import adaptadorFecha.FechaEs;
import factorias.FactoriaCRUD;
import iterador.Agregado;
import iterador.AgregadoConcreto;
import iterador.Iterador;
import operacionesCRUD.CRUDempresa;
import pojo.Empresa;

public class VentanaGenerarFactura extends JFrame {

	private FactoriaCRUD fc;
	private Empresa empresa;
	private CRUDempresa ce;
	private JPanel contentPane;
	private JTextField textEmpresa;
	private JTextField textNombre;
	private JTextField textTelefono;
	private JTextField textMail;
	private JTextField tFechaInicio;
	private JTextField tFechaFinal;

	public VentanaGenerarFactura() throws SQLException, IOException {
		this.fc = new FactoriaCRUD();
		this.ce = (CRUDempresa) fc.crearCRUD(FactoriaCRUD.TIPO_EMPRESA);
		setTitle("Facturame --- Porte --- Empresa");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 340, 310);
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
		Agregado agregado = new AgregadoConcreto(empresasO);
		Iterador iterador = agregado.crearIterador();

		try {
			while (iterador.hayMas()) {
				Empresa empresa = (Empresa) iterador.elementoActual();
				comboBoxEmpresa.addItem(empresa.getEmpresa());
				iterador.siguiente();
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Error: " + e.toString());
		}
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
		labelNombre.setBounds(10, 84, 46, 14);
		contentPane.add(labelNombre);

		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setBounds(86, 81, 209, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);

		JLabel labelTelefono = new JLabel("Tel\u00E9fono:");
		labelTelefono.setBounds(10, 115, 71, 14);
		contentPane.add(labelTelefono);

		textTelefono = new JTextField();
		textTelefono.setEditable(false);
		textTelefono.setBounds(86, 112, 209, 20);
		contentPane.add(textTelefono);
		textTelefono.setColumns(10);

		JLabel labelMail = new JLabel("Mail:");
		labelMail.setBounds(10, 146, 46, 14);
		contentPane.add(labelMail);

		textMail = new JTextField();
		textMail.setEditable(false);
		textMail.setBounds(86, 143, 209, 20);
		contentPane.add(textMail);
		textMail.setColumns(10);

		JButton bGenerarFactura = new JButton("Generar factura");
		bGenerarFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					buttonSiguienteActionPerformed(e);
				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		bGenerarFactura.setBounds(107, 238, 118, 23);
		contentPane.add(bGenerarFactura);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 71, 304, 14);
		contentPane.add(separator);

		JLabel lblFechaInicio = new JLabel("Fecha inicio:");
		lblFechaInicio.setBounds(10, 181, 71, 14);
		contentPane.add(lblFechaInicio);

		JLabel lblNewLabel = new JLabel("Fecha final:");
		lblNewLabel.setBounds(10, 212, 71, 14);
		contentPane.add(lblNewLabel);

		tFechaInicio = new JTextField();
		tFechaInicio.setBounds(86, 178, 209, 20);
		contentPane.add(tFechaInicio);
		tFechaInicio.setColumns(10);

		tFechaFinal = new JTextField();
		tFechaFinal.setBounds(86, 209, 210, 20);
		contentPane.add(tFechaFinal);
		tFechaFinal.setColumns(10);
	}

	private void formWindowClosing(java.awt.event.WindowEvent evt) {
		this.setVisible(false);
	}

	private void comboActionPerformed(ActionEvent evt) throws SQLException {
		JComboBox comboBox = (JComboBox) evt.getSource();
		Object selected = comboBox.getSelectedItem();
		empresa = (Empresa) ce.buscarUno(selected);

		textNombre.setText(empresa.getEmpresa());
		textMail.setText(empresa.getEmail());
		textTelefono.setText(String.valueOf(empresa.getnTelefono()));

	}

	private void buttonSiguienteActionPerformed(java.awt.event.ActionEvent evt) throws SQLException, IOException {
		this.setVisible(false);
		Fecha fechaInicio = new AdaptadorFechaPostgres(new FechaEs(tFechaInicio.getText()));
		Fecha fechaFinal = new AdaptadorFechaPostgres(new FechaEs(tFechaFinal.getText()));
		String fechaIniForm = fechaInicio.toString();
		String fechaFinForm = fechaFinal.toString();
		
		VentanaTabla2PDF ventanaPDF = new VentanaTabla2PDF(fechaIniForm, fechaFinForm, empresa.getNif());
		ventanaPDF.setVisible(true);
	}

	private void buttonBuscarActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
		Object selected = textEmpresa.getText();
		empresa = (Empresa) ce.buscarUno(selected);

		if (empresa != null) {
			textNombre.setText((String.valueOf(empresa.getEmpresa())));
			textTelefono.setText((String.valueOf(empresa.getnTelefono())));
			textMail.setText(empresa.getEmail());
		}
	}
}
