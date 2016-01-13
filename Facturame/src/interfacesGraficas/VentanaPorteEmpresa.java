package interfacesGraficas;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPorteEmpresa extends JFrame {

	private JPanel contentPane;
	private JTextField textNif;
	private JTextField textNombre;
	private JTextField textTelefono;
	private JTextField textMail;
	
	public VentanaPorteEmpresa(VentanaPrincipal principal) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				formWindowClosing(e, principal);
			}
		});
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
		
		textNif = new JTextField();
		textNif.setBounds(120, 10, 140, 20);
		contentPane.add(textNif);
		textNif.setColumns(10);
		
		JButton buttonBuscar = new JButton("");
		buttonBuscar.setIcon(new ImageIcon("D:\\Darako\\Universidad\\Patrones de Dise\u00F1o\\PS_Workspace\\FacturameGIT\\Facturame\\images\\lupa_16.png"));
		buttonBuscar.setSelectedIcon(new ImageIcon("D:\\Darako\\Universidad\\Patrones de Dise\u00F1o\\PS_Workspace\\FacturameGIT\\Facturame\\images\\lupa_24.png"));
		buttonBuscar.setBounds(270, 8, 25, 25);
		contentPane.add(buttonBuscar);
		
		JComboBox comboBoxNif = new JComboBox();
		comboBoxNif.setBounds(120, 40, 140, 20);
		contentPane.add(comboBoxNif);
		
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
				buttonSiguienteActionPerformed(e, principal);
			}
		});
		buttonSiguiente.setIcon(new ImageIcon("D:\\Darako\\Universidad\\Patrones de Dise\u00F1o\\PS_Workspace\\FacturameGIT\\Facturame\\images\\flecha_16.png"));
		buttonSiguiente.setBounds(120, 188, 89, 23);
		contentPane.add(buttonSiguiente);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 71, 304, 14);
		contentPane.add(separator);
	}
	
	private void formWindowClosing(java.awt.event.WindowEvent evt, VentanaPrincipal principal) {
		this.setVisible(false);
		principal.setVisible(true);
	}
	
	private void buttonSiguienteActionPerformed(java.awt.event.ActionEvent evt, VentanaPrincipal principal) {
		VentanaPorteTransportista formPorteTransportista = new VentanaPorteTransportista(principal);
		formPorteTransportista.setVisible(true);
	    this.setVisible(false);
	}
}
