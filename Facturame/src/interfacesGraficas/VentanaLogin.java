package interfacesGraficas;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VentanaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private static VentanaLogin ventana;
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textDni;
	
	private VentanaLogin() {
		setTitle("Facturame --- Login");		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 152);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelUsuario = new JLabel("Usuario:");
		labelUsuario.setBounds(61, 16, 69, 20);
		contentPane.add(labelUsuario);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(120, 16, 140, 20);
		contentPane.add(textNombre);
		
		JLabel labelContrasena = new JLabel("Contrase\u00F1a:");
		labelContrasena.setBounds(43, 47, 69, 20);
		contentPane.add(labelContrasena);
		
		textDni = new JTextField();
		textDni.setColumns(10);
		textDni.setBounds(120, 46, 140, 20);
		contentPane.add(textDni);
		
		JButton buttonAceptar = new JButton("ACEPTAR");
		buttonAceptar.setBounds(43, 78, 182, 25);
		contentPane.add(buttonAceptar);
		
		JButton buttonBorrar = new JButton("");
		buttonBorrar.setIcon(new ImageIcon("D:\\Darako\\Universidad\\Patrones de Dise\u00F1o\\PS_Workspace\\FacturameGIT\\Facturame\\images\\papelera_16.png"));
		buttonBorrar.setBounds(235, 77, 25, 25);
		contentPane.add(buttonBorrar);
	}	
	
	public static VentanaLogin getLogin(){
		if(ventana == null)
			ventana = new VentanaLogin();
		return ventana;
	}

}
