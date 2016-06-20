package interfacesGraficas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import factorias.FactoriaUsuarioActual;
import pojo.UsuarioAutenticacion;
import util.UtilVentanas;

public class VentanaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private static VentanaLogin ventana;
	private JPanel contentPane;
	private JTextField tNombre; 
	private JTextField tPass;
	
	private ArrayList<JTextField> textos = new ArrayList<JTextField>();

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

		tNombre = new JTextField();
		tNombre.setColumns(10);
		tNombre.setBounds(120, 16, 140, 20);
		contentPane.add(tNombre);

		JLabel labelContrasena = new JLabel("Contrase\u00F1a:");
		labelContrasena.setBounds(43, 47, 69, 20);
		contentPane.add(labelContrasena);

		tPass = new JTextField();
		tPass.setColumns(10);
		tPass.setBounds(120, 46, 140, 20);
		contentPane.add(tPass);
		
		textos.add(tNombre);
		textos.add(tPass);

		JButton buttonAceptar = new JButton("ACEPTAR");
		buttonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					bAceptarActionPerformed(evt);
				} catch (NoSuchAlgorithmException nsae){
					UtilVentanas.Alertas.mostrar(UtilVentanas.Alertas.ERROR_NSAE,nsae.toString());
				} catch (SQLException sqle){
					UtilVentanas.Alertas.mostrar(UtilVentanas.Alertas.ERROR_SQL,sqle.toString());
				} catch(IOException ioe) {
					UtilVentanas.Alertas.mostrar(UtilVentanas.Alertas.ERROR_IOE,ioe.toString());
				}
			}
		});
		buttonAceptar.setBounds(43, 78, 182, 25);
		contentPane.add(buttonAceptar);

		JButton buttonBorrar = new JButton("");
		buttonBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bBorrarActionPerformed(e);
			}
		});
		buttonBorrar.setIcon(new ImageIcon("images\\papelera_16.png"));
		buttonBorrar.setBounds(235, 77, 25, 25);
		contentPane.add(buttonBorrar);

		this.setVisible(true);		
	}

	public static VentanaLogin getLogin() {
		if (ventana == null)
			ventana = new VentanaLogin();
		return ventana;
	}

	private void bAceptarActionPerformed(ActionEvent evt) throws NoSuchAlgorithmException, SQLException, IOException {
		FactoriaUsuarioActual fua = new FactoriaUsuarioActual();
		UsuarioAutenticacion ua = fua.crearUserAct(tNombre.getText(), tPass.getText());
		
		if(ua.getNickname() == null)
			mostrarAlerta(tNombre.getText());
		else{
			this.setVisible(false);
			JOptionPane.showMessageDialog(null, "Bienvenido al sistema " + ua.getNickname() +".");
			VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(ua);
			ventanaPrincipal.setVisible(true);
		}
	}
	
	private void bBorrarActionPerformed(ActionEvent evt){
		UtilVentanas.borrarTextos(textos);
	}
	
	private void mostrarAlerta(String user) {
		JOptionPane.showMessageDialog(null, "El usuario o la contrase�a introducido no est� registrado en el sistema.");
		tNombre.setText("");
		tPass.setText("");		
	}
	


}
