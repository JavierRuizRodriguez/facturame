package interfacesGraficas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import builders.PorteBuilder;
import builders.PorteGrafico;

public class VentanaPorteCamion extends JFrame {

	private PorteGrafico pb;
	private JPanel contentPane;
	private JTextField textMatricula;
	private JSeparator separator;
	private JButton button;
	private JButton button_1;
	private JLabel label_1;
	private JTextField textField;
	private JLabel label_2;
	private JTextField textField_1;
	private JLabel label_3;
	private JTextField textField_2;
	private JLabel label_4;
	private JTextField textField_3;
	private JLabel lblPesomaxCaja;
	private JTextField textField_4;
	private JLabel label_6;
	private JTextField textField_5;
	private JLabel label_7;
	private JTextField textField_6;
	private JLabel label_8;
	private JTextField textField_7;
	private JLabel label_9;
	private JCheckBox checkBox;

	public VentanaPorteCamion(PorteGrafico pb) {
		this.pb = pb;
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
		button_1.setIcon(new ImageIcon(
				"D:\\Darako\\Universidad\\Patrones de Dise\u00F1o\\PS_Workspace\\FacturameGIT\\Facturame\\images\\lupa_16.png"));
		button_1.setBounds(271, 6, 25, 25);
		contentPane.add(button_1);

		label_1 = new JLabel("Largo: ");
		label_1.setBounds(10, 92, 60, 15);
		contentPane.add(label_1);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(95, 87, 60, 20);
		contentPane.add(textField);

		label_2 = new JLabel("Ancho: ");
		label_2.setBounds(10, 122, 75, 15);
		contentPane.add(label_2);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(95, 117, 60, 20);
		contentPane.add(textField_1);

		label_3 = new JLabel("Largo caja: ");
		label_3.setBounds(165, 91, 68, 15);
		contentPane.add(label_3);

		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(243, 90, 60, 20);
		contentPane.add(textField_2);

		label_4 = new JLabel("Ancho caja: ");
		label_4.setBounds(165, 123, 75, 15);
		contentPane.add(label_4);

		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(243, 120, 60, 20);
		contentPane.add(textField_3);

		lblPesomaxCaja = new JLabel("Peso(max) caja: ");
		lblPesomaxCaja.setBounds(10, 184, 89, 15);
		contentPane.add(lblPesomaxCaja);

		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(95, 179, 60, 20);
		contentPane.add(textField_4);

		label_6 = new JLabel("Volumen caja: ");
		label_6.setBounds(165, 182, 89, 15);
		contentPane.add(label_6);

		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(243, 179, 60, 20);
		contentPane.add(textField_5);

		label_7 = new JLabel("Alto caja: ");
		label_7.setBounds(165, 156, 60, 15);
		contentPane.add(label_7);

		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(243, 153, 60, 20);
		contentPane.add(textField_6);

		label_8 = new JLabel("G\u00E1libo: ");
		label_8.setBounds(10, 155, 60, 15);
		contentPane.add(label_8);

		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(95, 148, 60, 20);
		contentPane.add(textField_7);

		label_9 = new JLabel("Trampilla:");
		label_9.setBounds(10, 210, 68, 15);
		contentPane.add(label_9);

		checkBox = new JCheckBox("");
		checkBox.setSelected(true);
		checkBox.setEnabled(false);
		checkBox.setBounds(95, 206, 21, 23);
		contentPane.add(checkBox);
	}

	private void formWindowClosing(java.awt.event.WindowEvent evt) {
		this.setVisible(false);
	}

	private void buttonActionPerformed(java.awt.event.ActionEvent evt) {
		pb.setEspera(false);
		this.setVisible(false);
	}

}
