package interfacesGraficas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	
	public VentanaPrincipal() {
		setTitle("Facturame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton buttonRegistrarCamion = new JButton("Registrar CAMI\u00D3N");
		buttonRegistrarCamion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonRegistrarCamionActionPerformed(e);
			}
		});
		buttonRegistrarCamion.setBounds(120, 21, 179, 25);
		contentPane.add(buttonRegistrarCamion);
		
		JButton buttonRegistrarEmpleado = new JButton("Registrar EMPLEADO");
		buttonRegistrarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonRegistrarEmpleadoActionPerformed(e);
			}
		});
		buttonRegistrarEmpleado.setBounds(120, 70, 179, 25);
		contentPane.add(buttonRegistrarEmpleado);
		
		JButton buttonRegistrarPorte = new JButton("Registrar PORTE");
		buttonRegistrarPorte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonRegistrarPorteActionPerformed(e);
			}
		});
		buttonRegistrarPorte.setBounds(120, 121, 179, 25);
		contentPane.add(buttonRegistrarPorte);
		
		JButton btnRegistrarU = new JButton("Registrar USUARIO SISTEMA");
		btnRegistrarU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonRegistrarUsuarioSistemaActionPerformed(e);
			}
		});
		btnRegistrarU.setBounds(120, 175, 179, 25);
		contentPane.add(btnRegistrarU);
	}
	
	private void buttonRegistrarCamionActionPerformed(java.awt.event.ActionEvent evt) {
		VentanaCamion formCamion = new VentanaCamion(this);
		formCamion.setVisible(true);
        this.setVisible(false);
    }
	
	private void buttonRegistrarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {
		VentanaEmpleado formEmpleado = new VentanaEmpleado(this);
		formEmpleado.setVisible(true);
        this.setVisible(false);
    }
	
	private void buttonRegistrarPorteActionPerformed(java.awt.event.ActionEvent evt) {
		VentanaPorteViaje formPorte = new VentanaPorteViaje(this);
		formPorte.setVisible(true);
        this.setVisible(false);
    }
	
	private void buttonRegistrarUsuarioSistemaActionPerformed(java.awt.event.ActionEvent evt) {
		VentanaUsuarioSistema formUsuarioSistema = new VentanaUsuarioSistema(this);
		formUsuarioSistema.setVisible(true);
        this.setVisible(false);
    }
}