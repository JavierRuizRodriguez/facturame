package interfacesGraficas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VentanaUsuarioSistema extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textoDni;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VentanaUsuarioSistema frame = new VentanaUsuarioSistema();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaUsuarioSistema(VentanaPrincipal principal) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				formWindowClosing(e, principal);
			}
		});
		setTitle("Facturame --- Usuario de Sistema");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 320, 180);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelNombre = new JLabel("Nombre:");
		labelNombre.setBounds(50, 9, 69, 20);
		contentPane.add(labelNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(129, 4, 120, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel labelDni = new JLabel("DNI:");
		labelDni.setBounds(50, 39, 69, 20);
		contentPane.add(labelDni);
		
		textoDni = new JTextField();
		textoDni.setColumns(10);
		textoDni.setBounds(129, 34, 120, 20);
		contentPane.add(textoDni);
		
		JLabel labelAdministrador = new JLabel("Administrador:");
		labelAdministrador.setBounds(50, 69, 82, 20);
		contentPane.add(labelAdministrador);
		
		JCheckBox checkBoxAdministrador = new JCheckBox("");
		checkBoxAdministrador.setBounds(129, 64, 25, 25);
		contentPane.add(checkBoxAdministrador);
		
		JButton buttonAceptar = new JButton("ACEPTAR");
		buttonAceptar.setBounds(10, 100, 120, 25);
		contentPane.add(buttonAceptar);
		
		JButton buttonVerListado = new JButton("VER LISTADO");
		buttonVerListado.setBounds(140, 100, 120, 25);
		contentPane.add(buttonVerListado);
		
		JButton buttonBorrar = new JButton("");
		buttonBorrar.setBounds(270, 100, 25, 25);
		contentPane.add(buttonBorrar);
	}
	
	private void formWindowClosing(java.awt.event.WindowEvent evt, VentanaPrincipal principal) {
        this.setVisible(false);
        principal.setVisible(true);
    }
	
}
