package interfacesGraficas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import util.UtilVentanas;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class VentanaGestion extends JFrame {

	private JPanel contentPane;

	public VentanaGestion(VentanaPrincipal principal) {
		setTitle("Facturame --- Gesti\u00F3n");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
		        formWindowClosing(principal);
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 445, 136);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton buttonCamion = new JButton("");
		buttonCamion.setIcon(new ImageIcon("images\\camiones_32.png"));
		buttonCamion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					clickVentanaCamion();
				} catch (SQLException sqle) {
					UtilVentanas.Alertas.mostrar(UtilVentanas.Alertas.ERROR_SQL,sqle.toString());
				} catch (IOException ioe) {
					UtilVentanas.Alertas.mostrar(UtilVentanas.Alertas.ERROR_IOE,ioe.toString());
				}
			}
		});
		buttonCamion.setBounds(36, 22, 50, 50);
		contentPane.add(buttonCamion);
		
		JButton buttonEmpleados = new JButton("");
		buttonEmpleados.setIcon(new ImageIcon("images\\empleados_32.png"));
		buttonEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					clickVentanaEmpleado();
				} catch (SQLException sqle) {
					UtilVentanas.Alertas.mostrar(UtilVentanas.Alertas.ERROR_SQL,sqle.toString());
				} catch (IOException ioe) {
					UtilVentanas.Alertas.mostrar(UtilVentanas.Alertas.ERROR_IOE,ioe.toString());
				}
			}
		});
		buttonEmpleados.setBounds(134, 22, 50, 50);
		contentPane.add(buttonEmpleados);
		
		JButton buttonEmpresas = new JButton("");
		buttonEmpresas.setIcon(new ImageIcon("images\\empresas_32.png"));
		buttonEmpresas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					clickVentanaEmpresa();
				} catch (SQLException sqle) {
					UtilVentanas.Alertas.mostrar(UtilVentanas.Alertas.ERROR_SQL,sqle.toString());
				} catch (IOException ioe) {
					UtilVentanas.Alertas.mostrar(UtilVentanas.Alertas.ERROR_IOE,ioe.toString());
				}
			}
		});
		buttonEmpresas.setBounds(234, 22, 50, 50);
		contentPane.add(buttonEmpresas);
		
		JButton buttonUsuarioSistema = new JButton("");
		buttonUsuarioSistema.setIcon(new ImageIcon("images\\usuario_32.png"));
		buttonUsuarioSistema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					clickVentanaUsuarioSistema();
				} catch (SQLException sqle) {
					UtilVentanas.Alertas.mostrar(UtilVentanas.Alertas.ERROR_SQL,sqle.toString());
				} catch (IOException ioe) {
					UtilVentanas.Alertas.mostrar(UtilVentanas.Alertas.ERROR_IOE,ioe.toString());
				}
			}
		});
		buttonUsuarioSistema.setBounds(333, 22, 50, 50);
		contentPane.add(buttonUsuarioSistema);
	}
	
	private void formWindowClosing(VentanaPrincipal principal) {
	    this.setVisible(false);
	    principal.setVisible(true);
	}
	
	private void clickVentanaCamion() throws SQLException, IOException {
		VentanaCamion ventanaCamion = new VentanaCamion(this);
		ventanaCamion.setVisible(true);
        this.setVisible(false);
    }
	
	private void clickVentanaEmpleado() throws SQLException, IOException {
		VentanaEmpleado ventanaEmpleado = new VentanaEmpleado(this);
		ventanaEmpleado.setVisible(true);
	    this.setVisible(false);
	}
	
	private void clickVentanaEmpresa() throws SQLException, IOException {
		VentanaEmpresa ventanaEmpresa = new VentanaEmpresa(this);
		ventanaEmpresa.setVisible(true);
	    this.setVisible(false);
	}
	
	private void clickVentanaUsuarioSistema() throws SQLException, IOException {
		VentanaUsuarioSistema ventanaUsuarioSistema = new VentanaUsuarioSistema(this);
		ventanaUsuarioSistema.setVisible(true);
	    this.setVisible(false);
	}
	
	/*private void clickVentanaSubordinado() throws SQLException, IOException {
		VentanaSubordinado ventanaSubordinado = new VentanaSubordinado(this);
		ventanaSubordinado.setVisible(true);
	    this.setVisible(false);
	}*/
}
