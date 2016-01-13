package interfacesGraficas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import factorias.FactoriaEmpresa;
import operacionesCRUD.CRUDempresa;
import pojo.Empresa;

public class VentanaEmpresa extends JFrame {
	
//	public static void main(String[] args) throws SQLException, ParseException {		
//		VentanaPrincipal principal = new VentanaPrincipal();
//		principal.setVisible(false);
//		VentanaEmpresa ventEmpr = new VentanaEmpresa(principal);
//		ventEmpr.setVisible(true);	
//	}

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textNif;
	private JTextField textDireccion;
	private JTextField textTelefono;
	private JTextField textMail;
	private ArrayList<JTextField> textos = new ArrayList<JTextField>();
	private JButton buttonAceptar;
	private JButton buttonVerListado;
	private JButton buttonCancelar;
	private JButton buttonBorrar;
	
	public VentanaEmpresa(VentanaPrincipal principal) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				formWindowClosing(e, principal);
			}
		});
		setTitle("Facturame --- Empresa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 185);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelNombre = new JLabel("Nombre:");
		labelNombre.setBounds(10, 10, 50, 20);
		contentPane.add(labelNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(70, 10, 120, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel labelNif = new JLabel("NIF:");
		labelNif.setBounds(10, 40, 61, 20);
		contentPane.add(labelNif);
		
		textNif = new JTextField();
		textNif.setColumns(10);
		textNif.setBounds(70, 40, 120, 20);
		contentPane.add(textNif);
		
		JLabel labelDireccion = new JLabel("Direcci\u00F3n:");
		labelDireccion.setBounds(210, 10, 61, 20);
		contentPane.add(labelDireccion);
		
		textDireccion = new JTextField();
		textDireccion.setColumns(10);
		textDireccion.setBounds(281, 10, 120, 20);
		contentPane.add(textDireccion);
		
		JLabel labelTelefono = new JLabel("Tel\u00E9fono:");
		labelTelefono.setBounds(210, 40, 61, 20);
		contentPane.add(labelTelefono);
		
		textTelefono = new JTextField();
		textTelefono.setColumns(10);
		textTelefono.setBounds(281, 40, 120, 20);
		contentPane.add(textTelefono);
		
		JLabel labelMail = new JLabel("Mail:");
		labelMail.setBounds(210, 71, 61, 20);
		contentPane.add(labelMail);
		
		textMail = new JTextField();
		textMail.setColumns(10);
		textMail.setBounds(281, 71, 120, 20);
		contentPane.add(textMail);
		
		textos.add(textNombre);
		textos.add(textNif);
		textos.add(textDireccion);
		textos.add(textTelefono);		
		textos.add(textMail);
		
		buttonAceptar = new JButton("ACEPTAR");
		buttonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					crearEmpresa();
				} catch (SQLException sqle) {
					sqle.printStackTrace();
				}
			}
		});
		buttonAceptar.setBounds(10, 108, 120, 25);
		contentPane.add(buttonAceptar);
		
		buttonVerListado = new JButton("VER LISTADO");
		buttonVerListado.setBounds(150, 108, 120, 25);
		contentPane.add(buttonVerListado);
		
		buttonCancelar = new JButton("CANCELAR");
		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonCancelar.setBounds(290, 108, 120, 25);
		contentPane.add(buttonCancelar);
		
		buttonBorrar = new JButton("");
		buttonBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrarCampos();				
			}
		});
		buttonBorrar.setIcon(new ImageIcon("images\\papelera_16.png"));
		buttonBorrar.setBounds(430, 108, 25, 25);
		contentPane.add(buttonBorrar);
		;
	}
	
	private void formWindowClosing(java.awt.event.WindowEvent evt, VentanaPrincipal principal) {
        this.setVisible(false);
        principal.setVisible(true);
    }
	
	public void borrarCampos(){
		for(JTextField texto:textos){
			texto.setText("");
		}
	}
	
	private void crearEmpresa() throws SQLException{
		Boolean camposObligatorios = true;
		for(JTextField texto:textos){
			camposObligatorios = texto.getText().equals("") ? false : camposObligatorios;
		}
		if(camposObligatorios){
			Empresa empresa = FactoriaEmpresa.crearEmpresa();
			empresa.setNif(textNif.getText());
			empresa.setEmpresa(textNombre.getText());
			empresa.setDireccion(textDireccion.getText());
			empresa.setnTelefono(Integer.parseInt(textTelefono.getText()));
			empresa.setEmail(textMail.getText());
			
			CRUDempresa crudEmpresa = new CRUDempresa();
			crudEmpresa.insertarActualizarEmpresa(empresa, true);
		} else {
			JOptionPane.showMessageDialog(null, "Faltan campos por rellenar");
		}		
	}

}
