package interfacesGraficas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import operacionesCRUD.CRUDcamiones;
import operacionesCRUD.CRUDempleados;
import operacionesCRUD.CRUDempresa;
import pojo.Camion;
import pojo.Empresa;

public class VentanaConsulta extends JFrame {

	private JPanel contentPane;
	private JPanel panelCamion;
	private JPanel panelEmpleado;
	private JPanel panelEmpresa;
	private JTextField textNombreEmpresa;
	private JTextField textNifEmpresa;
	private JTextField textTelefonoEmpresa;
	private JTextField textMatriculaCamion;
	private JTextField textNumeroBastidorCamion;
	private JTextField textVolumenCajaCamion;
	private String tipo;
	private JComboBox comboBoxTipo;
	private Empresa[] empresas = new Empresa[10];
	private Camion[] camiones = new Camion[10];
	private int iEmpresa = 0;
	private int iCamion = 0;

	public static void main(String[] args) throws SQLException {		
		VentanaPrincipal principal = new VentanaPrincipal();
		principal.setVisible(false);
		VentanaConsulta ventCons = new VentanaConsulta(principal);
		ventCons.setVisible(true);	
	}
	
	public VentanaConsulta(VentanaPrincipal principal) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				formWindowClosing(e, principal);
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBoxTipo = new JComboBox();
		comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] {"Empresa", "Cami\u00F3n", "Empleado"}));
		comboBoxTipo.setBounds(10, 11, 120, 20);
		contentPane.add(comboBoxTipo);
		
		panelCamion = new JPanel();
		panelCamion.setBorder(new TitledBorder(null, "Cami\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCamion.setBounds(10, 42, 414, 120);
		contentPane.add(panelCamion);
		panelCamion.setLayout(null);
		
		panelEmpleado = new JPanel();
		panelEmpleado.setBorder(new TitledBorder(null, "Empleado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelEmpleado.setBounds(10, 42, 414, 120);
		contentPane.add(panelEmpleado);
		panelEmpleado.setLayout(null);
		
		panelEmpresa = new JPanel();
		panelEmpresa.setBorder(new TitledBorder(null, "Empresa", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelEmpresa.setBounds(10, 42, 414, 120);
		contentPane.add(panelEmpresa);
		panelEmpresa.setLayout(null);
		
		JLabel labelNombreEmpresa = new JLabel("Nombre:");
		labelNombreEmpresa.setBounds(10, 30, 120, 20);
		panelEmpresa.add(labelNombreEmpresa);
		
		JLabel labelNif = new JLabel("NIF:");
		labelNif.setBounds(10, 55, 120, 20);
		panelEmpresa.add(labelNif);
		
		JLabel labelTelefono = new JLabel("Telefono: ");
		labelTelefono.setBounds(10, 80, 120, 20);
		panelEmpresa.add(labelTelefono);
		panelCamion.setLayout(null);
		
		JLabel labelMatricula = new JLabel("Matricula:");
		labelMatricula.setBounds(10, 30, 120, 20);
		panelCamion.add(labelMatricula);

		JLabel labelNumeroBastidor = new JLabel("Número bastidor:");
		labelNumeroBastidor.setBounds(10, 55, 120, 20);
		panelCamion.add(labelNumeroBastidor);

		JLabel labelVolumenCaja = new JLabel("Volumen caja: ");
		labelVolumenCaja.setBounds(10, 80, 120, 20);
		panelCamion.add(labelVolumenCaja);
		
		textNombreEmpresa = new JTextField();
		textNombreEmpresa.setEditable(false);
		textNombreEmpresa.setBounds(140, 30, 264, 20);
		panelEmpresa.add(textNombreEmpresa);
		textNombreEmpresa.setColumns(10);
		
		textNifEmpresa = new JTextField();
		textNifEmpresa.setEditable(false);
		textNifEmpresa.setColumns(10);
		textNifEmpresa.setBounds(140, 55, 264, 20);
		panelEmpresa.add(textNifEmpresa);
		
		textTelefonoEmpresa = new JTextField();
		textTelefonoEmpresa.setEditable(false);
		textTelefonoEmpresa.setColumns(10);
		textTelefonoEmpresa.setBounds(140, 80, 264, 20);
		panelEmpresa.add(textTelefonoEmpresa);
		
		textMatriculaCamion = new JTextField();
		textMatriculaCamion.setEditable(false);
		textMatriculaCamion.setBounds(140, 30, 264, 20);
		panelCamion.add(textMatriculaCamion);
		textMatriculaCamion.setColumns(10);

		textNumeroBastidorCamion = new JTextField();
		textNumeroBastidorCamion.setEditable(false);
		textNumeroBastidorCamion.setColumns(10);
		textNumeroBastidorCamion.setBounds(140, 55, 264, 20);
		panelCamion.add(textNumeroBastidorCamion);

		textVolumenCajaCamion = new JTextField();
		textVolumenCajaCamion.setEditable(false);
		textVolumenCajaCamion.setColumns(10);
		textVolumenCajaCamion.setBounds(140, 80, 264, 20);
		panelCamion.add(textVolumenCajaCamion);
		
		JButton buttonSiguiente = new JButton("");
		buttonSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipo = comboBoxTipo.getSelectedItem().toString();
				try {
					buttonSiguienteActionPerformed(e, tipo);
				} catch (SQLException sqle) {
					sqle.printStackTrace();
				}
			}
		});
		buttonSiguiente.setIcon(new ImageIcon("images\\flecha_16.png"));
		buttonSiguiente.setBounds(159, 190, 25, 25);
		contentPane.add(buttonSiguiente);
		
		JButton buttonCambiarBusqueda = new JButton("");
		buttonCambiarBusqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipo = comboBoxTipo.getSelectedItem().toString();
				try {
					buttonCambiarBusquedaActionPerformed(e, tipo);
				} catch (SQLException sqle) {
					sqle.printStackTrace();
				}
			}
		});
		buttonCambiarBusqueda.setIcon(new ImageIcon("images\\lupa.png"));
		buttonCambiarBusqueda.setBounds(145, 8, 25, 25);
		contentPane.add(buttonCambiarBusqueda);
		
		JButton buttonBorrar = new JButton("");
		buttonBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipo = comboBoxTipo.getSelectedItem().toString();
				try {
					buttonBorrarActionPerformed(e, tipo);
				} catch (SQLException sqle) {
					sqle.printStackTrace();
				}
			}
		});
		buttonBorrar.setIcon(new ImageIcon("images\\papelera_16.png"));
		buttonBorrar.setBounds(229, 190, 25, 25);
		contentPane.add(buttonBorrar);
		
		JButton buttonModificar = new JButton("");
		buttonModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonModificar.setIcon(new ImageIcon("images\\modificar_16.png"));
		buttonModificar.setBounds(194, 190, 25, 25);
		contentPane.add(buttonModificar);
		
		panelCamion.setVisible(false); panelEmpleado.setVisible(false); panelEmpresa.setVisible(true);
	}
	
	private void formWindowClosing(java.awt.event.WindowEvent evt, VentanaPrincipal principal) {
		this.setVisible(false);
		principal.setVisible(true);
	}
	
	private void buttonSiguienteActionPerformed(java.awt.event.ActionEvent evt, String tipo) throws SQLException {
		switch(tipo){
			case "Empresa": {
				int j = iEmpresa;
				for(j = iEmpresa; j<empresas.length;j++){
					if(iEmpresa == empresas.length -1){
						mostrarEmpresa(iEmpresa);
						iEmpresa = 0;
						break;
					}
					if(empresas[j] != null){
						iEmpresa = j; 
						mostrarEmpresa(iEmpresa); 
						break;
					}					
				}
				break;
			}
			case "Camión": {
				CRUDcamiones crudCamiones = new CRUDcamiones(); 
				ArrayList<Camion> todosCamiones = crudCamiones.buscarTodosCamiones();
				int i = 0;
				for(Camion camion:todosCamiones){
					camiones[i] = camion;
					i++;
				}
				textMatriculaCamion.setText(camiones[0].getMatricula());
				textNumeroBastidorCamion.setText(camiones[0].getnBastidor());
				textVolumenCajaCamion.setText(String.valueOf(camiones[0].getVolumenCaja()));
			}
		}
	}
	
	public void mostrarEmpresa(int i){
		textNifEmpresa.setText(empresas[i].getNif());
		textNombreEmpresa.setText(empresas[i].getEmpresa());
		textTelefonoEmpresa.setText(String.valueOf(empresas[i].getnTelefono()));
	}
	
	public void mostrarCamion(int i){
		
	}
	
	private void buttonCambiarBusquedaActionPerformed(java.awt.event.ActionEvent evt, String tipo) throws SQLException {
			
			switch(tipo){
				case "Empresa": {
					CRUDempresa crudEmpresa = new CRUDempresa(); 
					ArrayList<Empresa> todasEmpresas = crudEmpresa.buscarTodasEmpresas();
					int i = 0;
					for(Empresa empresa:todasEmpresas){
						empresas[i] = empresa;
						i++;
					}
					mostrarEmpresa(0);
					panelCamion.setVisible(false); panelEmpleado.setVisible(false); panelEmpresa.setVisible(true); break;
				}
				case "Camión": {
					panelEmpleado.setVisible(false); panelEmpresa.setVisible(false); panelCamion.setVisible(true); break;
				}
				case "Empleado": {
					panelCamion.setVisible(false); panelEmpresa.setVisible(false); panelEmpleado.setVisible(true); break;
				}
			}
		}
	
	private void buttonBorrarActionPerformed(java.awt.event.ActionEvent evt, String tipo) throws SQLException {
		
		switch(tipo){
			case "Empresa": {
				CRUDempresa crudEmpresa = new CRUDempresa(); 
				crudEmpresa.borrarEmpresa(empresas[0].getNif());
				JOptionPane.showMessageDialog(null, "Empresa con Nif "+empresas[0].getNif()+" ha sido borrada.");
			}
			case "Camión": {
				CRUDcamiones crudCamiones = new CRUDcamiones(); 
				crudCamiones.borrarCamion(camiones[0].getnBastidor());
				JOptionPane.showMessageDialog(null, "Camión con número de bastidor "+camiones[0].getnBastidor()+" ha sido borrado.");
			}
			case "Empleado": {
//				CRUDempleados crudEmpleados = new CRUDempleados(); 
//				crudEmpleados.borrarEmpleado(empleados[0].get);
//				JOptionPane.showMessageDialog(null, "Empresa con Nif "+empresas[0].getNif()+" ha sido borrada.");
			}
		}
	}
	
	
	
}
