package interfacesGraficas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VentanaEmpresa extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textNif;
	private JTextField textDireccion;
	private JTextField textTelefono;
	private JTextField textMail;

	public VentanaEmpresa(VentanaPrincipal principal) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				formWindowClosing(e, principal);
			}
		});
		setTitle("Facturame --- Empresa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelNombre = new JLabel("Nombre:");
		labelNombre.setBounds(10, 10, 50, 20);
		contentPane.add(labelNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(110, 5, 120, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel labelNif = new JLabel("NIF:");
		labelNif.setBounds(10, 40, 61, 20);
		contentPane.add(labelNif);
		
		textNif = new JTextField();
		textNif.setColumns(10);
		textNif.setBounds(110, 35, 120, 20);
		contentPane.add(textNif);
		
		JLabel labelDireccion = new JLabel("Direcci\u00F3n:");
		labelDireccion.setBounds(10, 70, 61, 20);
		contentPane.add(labelDireccion);
		
		textDireccion = new JTextField();
		textDireccion.setColumns(10);
		textDireccion.setBounds(110, 65, 120, 20);
		contentPane.add(textDireccion);
		
		JLabel labelTelefono = new JLabel("Tel\u00E9fono:");
		labelTelefono.setBounds(10, 100, 61, 20);
		contentPane.add(labelTelefono);
		
		textTelefono = new JTextField();
		textTelefono.setColumns(10);
		textTelefono.setBounds(110, 95, 120, 20);
		contentPane.add(textTelefono);
		
		JLabel labelMail = new JLabel("Mail:");
		labelMail.setBounds(10, 130, 61, 20);
		contentPane.add(labelMail);
		
		textMail = new JTextField();
		textMail.setColumns(10);
		textMail.setBounds(110, 125, 120, 20);
		contentPane.add(textMail);
	}
	
	private void formWindowClosing(java.awt.event.WindowEvent evt, VentanaPrincipal principal) {
        this.setVisible(false);
        principal.setVisible(true);
    }

}
