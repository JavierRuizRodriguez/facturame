package interfacesGraficas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import builders.PorteGrafico;
import factorias.FactoriaCRUD;
import factorias.FactoriaVehiculo;
import operacionesCRUD.CRUDcamiones;
import pojo.Camion;
import pojo.Porte;
import utils.ConversorArrays;

public class VentanaPorteCamion extends JFrame {

	private Porte p;
	private FactoriaCRUD fc;
	private PorteGrafico pb;
	private CRUDcamiones cc;
	private JPanel contentPane;
	private JTextField textMatricula;
	private JSeparator separator;
	private JButton button;
	private JButton button_1;
	private JLabel label_1;
	private JTextField tLargo;
	private JLabel label_2;
	private JTextField tAncho;
	private JLabel label_3;
	private JTextField tLargoCaja;
	private JLabel label_4;
	private JTextField tAnchoCaja;
	private JLabel lblPesomaxCaja;
	private JTextField tPesoCaja;
	private JLabel label_6;
	private JTextField tVolCaja;
	private JLabel label_7;
	private JTextField tAltoCaja;
	private JLabel label_8;
	private JTextField tGalibo;
	private JLabel label_9;
	private JCheckBox tTrampilla;

	public VentanaPorteCamion(PorteGrafico pb, Porte p) throws SQLException {
		this.p = p;
		this.pb = pb;
		this.fc = new FactoriaCRUD();
		this.cc = (CRUDcamiones) fc.crearCRUD(FactoriaCRUD.TIPO_CAMION);
		setTitle("Facturame --- Porte --- Cami\u00F3n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 340, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("Elige cami\u00F3n:");
		label.setBounds(10, 11, 110, 20);
		contentPane.add(label);

		textMatricula = new JTextField();
		textMatricula.setColumns(10);
		textMatricula.setBounds(120, 11, 140, 20);
		contentPane.add(textMatricula);

		JComboBox comboBoxMatricula = new JComboBox();
		comboBoxMatricula.setBounds(120, 41, 140, 20);
		ArrayList<Object> camionesO = new ArrayList<Object>(cc.buscarTodo());
		ArrayList<Camion> camiones = ConversorArrays.convertirCamiones(camionesO);

		for (Camion c : camiones)
			comboBoxMatricula.addItem(c.getMatricula());

		comboBoxMatricula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					comboActionPerformed(e);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		contentPane.add(comboBoxMatricula);

		separator = new JSeparator();
		separator.setBounds(10, 74, 304, 14);
		contentPane.add(separator);

		button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonActionPerformed(e);
			}
		});

		button.setIcon(new ImageIcon(
				"D:\\Darako\\Universidad\\Patrones de Dise\u00F1o\\PS_Workspace\\FacturameGIT\\Facturame\\images\\flecha_16.png"));
		button.setBounds(119, 238, 89, 23);
		contentPane.add(button);

		button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					button1ActionPerformed(e);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_1.setIcon(new ImageIcon(
				"D:\\Darako\\Universidad\\Patrones de Dise\u00F1o\\PS_Workspace\\FacturameGIT\\Facturame\\images\\lupa_16.png"));
		button_1.setBounds(271, 6, 25, 25);
		contentPane.add(button_1);

		label_1 = new JLabel("Largo: ");
		label_1.setBounds(10, 92, 60, 15);
		contentPane.add(label_1);

		tLargo = new JTextField();
		tLargo.setEditable(false);
		tLargo.setColumns(10);
		tLargo.setBounds(95, 87, 60, 20);
		contentPane.add(tLargo);

		label_2 = new JLabel("Ancho: ");
		label_2.setBounds(10, 122, 75, 15);
		contentPane.add(label_2);

		tAncho = new JTextField();
		tAncho.setEditable(false);
		tAncho.setColumns(10);
		tAncho.setBounds(95, 117, 60, 20);
		contentPane.add(tAncho);

		label_3 = new JLabel("Largo caja: ");
		label_3.setBounds(165, 91, 68, 15);
		contentPane.add(label_3);

		tLargoCaja = new JTextField();
		tLargoCaja.setEditable(false);
		tLargoCaja.setColumns(10);
		tLargoCaja.setBounds(243, 90, 60, 20);
		contentPane.add(tLargoCaja);

		label_4 = new JLabel("Ancho caja: ");
		label_4.setBounds(165, 123, 75, 15);
		contentPane.add(label_4);

		tAnchoCaja = new JTextField();
		tAnchoCaja.setEditable(false);
		tAnchoCaja.setColumns(10);
		tAnchoCaja.setBounds(243, 120, 60, 20);
		contentPane.add(tAnchoCaja);

		lblPesomaxCaja = new JLabel("Peso(max) caja: ");
		lblPesomaxCaja.setBounds(10, 184, 89, 15);
		contentPane.add(lblPesomaxCaja);

		tPesoCaja = new JTextField();
		tPesoCaja.setEditable(false);
		tPesoCaja.setColumns(10);
		tPesoCaja.setBounds(95, 179, 60, 20);
		contentPane.add(tPesoCaja);

		label_6 = new JLabel("Volumen caja: ");
		label_6.setBounds(165, 182, 89, 15);
		contentPane.add(label_6);

		tVolCaja = new JTextField();
		tVolCaja.setEditable(false);
		tVolCaja.setColumns(10);
		tVolCaja.setBounds(243, 179, 60, 20);
		contentPane.add(tVolCaja);

		label_7 = new JLabel("Alto caja: ");
		label_7.setBounds(165, 156, 60, 15);
		contentPane.add(label_7);

		tAltoCaja = new JTextField();
		tAltoCaja.setEditable(false);
		tAltoCaja.setColumns(10);
		tAltoCaja.setBounds(243, 153, 60, 20);
		contentPane.add(tAltoCaja);

		label_8 = new JLabel("G\u00E1libo: ");
		label_8.setBounds(10, 155, 60, 15);
		contentPane.add(label_8);

		tGalibo = new JTextField();
		tGalibo.setEditable(false);
		tGalibo.setColumns(10);
		tGalibo.setBounds(95, 148, 60, 20);
		contentPane.add(tGalibo);

		label_9 = new JLabel("Trampilla:");
		label_9.setBounds(10, 210, 68, 15);
		contentPane.add(label_9);

		tTrampilla = new JCheckBox("");
		tTrampilla.setSelected(true);
		tTrampilla.setEnabled(false);
		tTrampilla.setBounds(95, 206, 21, 23);
		contentPane.add(tTrampilla);
	}

	private void formWindowClosing(java.awt.event.WindowEvent evt) {
		this.setVisible(false);
	}

	private void buttonActionPerformed(java.awt.event.ActionEvent evt) {
		pb.setEspera(false);
		this.setVisible(false);
	}

	public Porte getPorte() {
		return p;
	}

	private void comboActionPerformed(ActionEvent evt) throws SQLException {
		JComboBox comboBox = (JComboBox) evt.getSource();

		Object selected = comboBox.getSelectedItem();
		Camion camion = (Camion) cc.buscarUno(selected);

		tAncho.setText((String.valueOf(camion.getAncho())));
		tAnchoCaja.setText((String.valueOf(camion.getAncho())));
		tAltoCaja.setText((String.valueOf(camion.getAlturaCaja())));
		tGalibo.setText((String.valueOf(camion.getGalibo())));
		tLargo.setText((String.valueOf(camion.getLargo())));
		tLargoCaja.setText((String.valueOf(camion.getLongCaja())));
		tPesoCaja.setText((String.valueOf(camion.getPesoMaxCaja())));
		tVolCaja.setText((String.valueOf(camion.getVolumenCaja())));
		tTrampilla.setSelected((camion.isTrampilla()));
		p.setnBastidor(camion.getnBastidor());

	}

	private void button1ActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
		Object selected = textMatricula.getText();
		Camion camion = (Camion) cc.buscarUno(selected);

		if (camion != null) {
			tAncho.setText((String.valueOf(camion.getAncho())));
			tAnchoCaja.setText((String.valueOf(camion.getAncho())));
			tAltoCaja.setText((String.valueOf(camion.getAlturaCaja())));
			tGalibo.setText((String.valueOf(camion.getGalibo())));
			tLargo.setText((String.valueOf(camion.getLargo())));
			tLargoCaja.setText((String.valueOf(camion.getLongCaja())));
			tPesoCaja.setText((String.valueOf(camion.getPesoMaxCaja())));
			tVolCaja.setText((String.valueOf(camion.getVolumenCaja())));
			tTrampilla.setSelected((camion.isTrampilla()));
			p.setnBastidor(camion.getnBastidor());
		}
	}

}
