package interfacesGraficas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import factorias.FactoriaUsuarioSistema;
import operacionesCRUD.CRUDempleados;
import operacionesCRUD.CRUDusuariosSistema;
import pojo.UsuarioSistema;

public class VentanaUsuarioSistema extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textDni;
	private ArrayList<JTextField> textos = new ArrayList<JTextField>();
	private JCheckBox checkBoxAdministrador;

	public static void main(String[] args) throws SQLException, ParseException {		
		VentanaPrincipal principal = new VentanaPrincipal();
		principal.setVisible(false);
		VentanaUsuarioSistema ventUserSistema = new VentanaUsuarioSistema(principal);
		ventUserSistema.setVisible(true);	
	}
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
		
		textDni = new JTextField();
		textDni.setColumns(10);
		textDni.setBounds(129, 34, 120, 20);
		contentPane.add(textDni);
		
		JLabel labelAdministrador = new JLabel("Administrador:");
		labelAdministrador.setBounds(50, 69, 82, 20);
		contentPane.add(labelAdministrador);
		
		checkBoxAdministrador = new JCheckBox("");
		checkBoxAdministrador.setBounds(129, 64, 25, 25);
		contentPane.add(checkBoxAdministrador);
		
		JButton buttonAceptar = new JButton("ACEPTAR");
		buttonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					crearUsuarioSistema();
				} catch (SQLException sqle) {
					// TODO Auto-generated catch block
					sqle.printStackTrace();
				}
			}
		});
		buttonAceptar.setBounds(10, 100, 120, 25);
		contentPane.add(buttonAceptar);
		
		JButton buttonVerListado = new JButton("VER LISTADO");
		buttonVerListado.setBounds(140, 100, 120, 25);
		contentPane.add(buttonVerListado);
		
		JButton buttonBorrar = new JButton("");
		buttonBorrar.setBounds(270, 100, 25, 25);
		contentPane.add(buttonBorrar);
		
		textos.add(textNombre);
		textos.add(textDni);
	}
	
	private void formWindowClosing(java.awt.event.WindowEvent evt, VentanaPrincipal principal) {
        this.setVisible(false);
        principal.setVisible(true);
    }
	
	private void crearUsuarioSistema() throws SQLException{
		Boolean camposObligatorios = true;
		for(JTextField texto:textos){
			camposObligatorios = texto.getText().equals("") ? false : camposObligatorios;
		}
		if(camposObligatorios){			
			Calendar calendario = Calendar.getInstance();
			java.util.Date fechaAltaAux = calendario.getTime();
			Date fechaAlta = new Date(fechaAltaAux.getTime());
			UsuarioSistema usuarioSistema = FactoriaUsuarioSistema.crearUsuarioSistema(checkBoxAdministrador.isSelected());
			usuarioSistema.setDni(textDni.getText());
			usuarioSistema.setFechaAltaUsuario(fechaAlta);
			usuarioSistema.setNickname(textNombre.getText());
			usuarioSistema.setAdmin(checkBoxAdministrador.isSelected());
			usuarioSistema.setHashContraseña("hash");
			
			CRUDusuariosSistema crudUsuariosSistema = new CRUDusuariosSistema();
			crudUsuariosSistema.insertarActualizaUsuarioSistema(usuarioSistema, true);
		} else {
			JOptionPane.showMessageDialog(null, "Faltan campos por rellenar");
		}		
	}
	
}
