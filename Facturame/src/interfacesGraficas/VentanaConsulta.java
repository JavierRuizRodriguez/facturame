package interfacesGraficas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
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

import factorias.FactoriaCRUD;
import iterador.Agregado;
import iterador.AgregadoConcreto;
import iterador.Iterador;
import operacionesCRUD.CRUDcamiones;
import operacionesCRUD.CRUDempleados;
import operacionesCRUD.CRUDempresa;
import pojo.Camion;
import pojo.Empresa;
import pojo.Trabajador;
import util.UtilVentanas;

public class VentanaConsulta extends JFrame {

	private JPanel contentPane;
	private JPanel panelCamion;
	private JPanel panelEmpleado;
	private JPanel panelEmpresa;
	private JLabel labelClave;
	private JTextField textNombreEmpresa;
	private JTextField textNifEmpresa;
	private JTextField textTelefonoEmpresa;
	private JTextField textMatriculaCamion;
	private JTextField textNumeroBastidorCamion;
	private JTextField textVolumenCajaCamion;
	private JTextField textDniNifEmpleado;
	private JTextField textNombreEmpleado;
	private JTextField textSueldoEmpleado;
	private JComboBox comboBoxTipo;
	private ArrayList<JTextField> textos = new ArrayList<JTextField>();
	private ArrayList<JTextField> textosCamiones = new ArrayList<JTextField>();
	private ArrayList<JTextField> textosEmpresas = new ArrayList<JTextField>();
	private ArrayList<JTextField> textosEmpleados = new ArrayList<JTextField>();
	private String tipo;
	private FactoriaCRUD fc;
	private CRUDcamiones cc;
	private CRUDempresa ce;
	private CRUDempleados ct;
	private ArrayList<Object> camiones;
	private ArrayList<Object> empleados;
	private ArrayList<Object> empresas;
	private Agregado agregado;
	private Iterador iterador;
	private JTextField textClave;

//	public static void main(String[] args) throws SQLException, IOException {
//		VentanaPrincipal principal = new VentanaPrincipal();
//		principal.setVisible(false);
//		VentanaConsulta ventCons = new VentanaConsulta(principal);
//		ventCons.setVisible(true);
//	}

	public VentanaConsulta(VentanaPrincipal principal) throws SQLException, IOException {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				formWindowClosing(e, principal);
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		comboBoxTipo = new JComboBox();
		comboBoxTipo.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	tipo = comboBoxTipo.getSelectedItem().toString();
					try {
						comboBoxTipoCambiarSeleccion(e, comboBoxTipo.getSelectedItem().toString());
					} catch (SQLException sqle) {
						UtilVentanas.Alertas.mostrar(UtilVentanas.Alertas.ERROR_SQL,sqle.toString());
					}
		    }
		});
		comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] { "Empresa", "Cami\u00F3n", "Empleado" }));
		comboBoxTipo.setBounds(10, 11, 120, 20);
		contentPane.add(comboBoxTipo);

		panelCamion = new JPanel();
		panelCamion
				.setBorder(new TitledBorder(null, "Cami\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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

		JLabel labelDniNif = new JLabel("DNI:");
		labelDniNif.setBounds(10, 30, 120, 20);
		panelEmpleado.add(labelDniNif);

		JLabel labelNombre = new JLabel("Nombre:");
		labelNombre.setBounds(10, 55, 120, 20);
		panelEmpleado.add(labelNombre);

		JLabel labelSueldo = new JLabel("Sueldo: ");
		labelSueldo.setBounds(10, 80, 120, 20);
		panelEmpleado.add(labelSueldo);

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

		textDniNifEmpleado = new JTextField();
		textDniNifEmpleado.setEditable(false);
		textDniNifEmpleado.setBounds(140, 30, 264, 20);
		panelEmpleado.add(textDniNifEmpleado);
		textDniNifEmpleado.setColumns(10);

		textNombreEmpleado = new JTextField();
		textNombreEmpleado.setEditable(false);
		textNombreEmpleado.setColumns(10);
		textNombreEmpleado.setBounds(140, 55, 264, 20);
		panelEmpleado.add(textNombreEmpleado);

		textSueldoEmpleado = new JTextField();
		textSueldoEmpleado.setEditable(false);
		textSueldoEmpleado.setColumns(10);
		textSueldoEmpleado.setBounds(140, 80, 264, 20);
		panelEmpleado.add(textSueldoEmpleado);

		JButton buttonSiguiente = new JButton("");
		buttonSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				try {
					buttonSiguienteActionPerformed(e, tipo);
				} catch (SQLException sqle) {
					UtilVentanas.Alertas.mostrar(UtilVentanas.Alertas.ERROR_SQL,sqle.toString());
				}
			}
		});
		buttonSiguiente.setIcon(new ImageIcon("images\\flecha_16.png"));
		buttonSiguiente.setBounds(159, 190, 25, 25);
		contentPane.add(buttonSiguiente);

		JButton buttonCambiarBusqueda = new JButton("");
		buttonCambiarBusqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					buttonBuscarPorCampoActionPerformed(e, tipo, textClave.getText());
				} catch (SQLException sqle) {
					UtilVentanas.Alertas.mostrar(UtilVentanas.Alertas.ERROR_SQL,sqle.toString());
				} catch (IOException ioe) {
					UtilVentanas.Alertas.mostrar(UtilVentanas.Alertas.ERROR_IOE,ioe.toString());
				} catch (NoSuchAlgorithmException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		buttonCambiarBusqueda.setIcon(new ImageIcon("images\\lupa_16.png"));
		buttonCambiarBusqueda.setBounds(394, 8, 25, 25);
		contentPane.add(buttonCambiarBusqueda);

		JButton buttonBorrar = new JButton("");
		buttonBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					buttonBorrarActionPerformed(e, tipo);
				} catch (IndexOutOfBoundsException iobe){
					UtilVentanas.Alertas.mostrar(UtilVentanas.Alertas.ERROR_IOB,iobe.toString());
				} catch (SQLException sqle){
					UtilVentanas.Alertas.mostrar(UtilVentanas.Alertas.ERROR_SQL,sqle.toString());
				} catch (IOException ioe){
					UtilVentanas.Alertas.mostrar(UtilVentanas.Alertas.ERROR_IOE,ioe.toString());
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

		panelCamion.setVisible(false);
		panelEmpleado.setVisible(false);
		panelEmpresa.setVisible(true);
		textosEmpresas.add(textNombreEmpresa);
		textosEmpresas.add(textNifEmpresa);
		textosEmpresas.add(textTelefonoEmpresa);
		textosCamiones.add(textMatriculaCamion);
		textosCamiones.add(textNumeroBastidorCamion);
		textosCamiones.add(textVolumenCajaCamion);
		textosEmpleados.add(textDniNifEmpleado);
		textosEmpleados.add(textNombreEmpleado);
		textosEmpleados.add(textSueldoEmpleado);
		
		labelClave = new JLabel("Nif:");
		labelClave.setBounds(140, 14, 74, 14);
		contentPane.add(labelClave);
		
		textClave = new JTextField();
		textClave.setBounds(229, 11, 155, 20);
		contentPane.add(textClave);
		textClave.setColumns(10);
		this.fc = new FactoriaCRUD();
		this.ce = (CRUDempresa) fc.crearCRUD(FactoriaCRUD.TIPO_EMPRESA);
		this.cc = (CRUDcamiones) fc.crearCRUD(FactoriaCRUD.TIPO_CAMION);
		this.ct = (CRUDempleados) fc.crearCRUD(FactoriaCRUD.TIPO_EMPLEADO);
		comboBoxTipo.setSelectedIndex(0);
	}

	private void formWindowClosing(java.awt.event.WindowEvent evt, VentanaPrincipal principal) {
		this.setVisible(false);
		principal.setVisible(true);
	}

	private void buttonBuscarPorCampoActionPerformed(java.awt.event.ActionEvent evt, String tipo, String clave) throws SQLException, IOException, NoSuchAlgorithmException{
		switch (tipo) {
			case "Empresa": {
				Empresa empresaAux = (Empresa) fc.crearCRUD(FactoriaCRUD.TIPO_EMPRESA).buscarUno(clave);
				textNifEmpresa.setText(empresaAux.getNif());
				textNombreEmpresa.setText(empresaAux.getEmpresa());
				textTelefonoEmpresa.setText(String.valueOf(empresaAux.getnTelefono()));
				break;
			}
			case "Camión": {
				Camion camionAux = (Camion) fc.crearCRUD(FactoriaCRUD.TIPO_CAMION).buscarUno(clave);
				textMatriculaCamion.setText(camionAux.getMatricula());
				textNumeroBastidorCamion.setText(camionAux.getnBastidor());
				textVolumenCajaCamion.setText(String.valueOf(camionAux.getVolumenCaja()));
				break;
			}
			case "Empleado": {
				Trabajador empleadoAux = (Trabajador) fc.crearCRUD(FactoriaCRUD.TIPO_EMPLEADO).buscarUno(clave);
				textDniNifEmpleado.setText(empleadoAux.getDni());
				textNombreEmpleado.setText(empleadoAux.getNombre()+" "+empleadoAux.getApellidos());
				textSueldoEmpleado.setText(String.valueOf(empleadoAux.getSueldo()));
				break;
			}
		}
	}
	
	private void buttonSiguienteActionPerformed(java.awt.event.ActionEvent evt, String tipo) throws SQLException {
		switch (tipo) {
			case "Empresa": {
				if(!empresas.isEmpty()){
					try {
						if(iterador.primero().equals(iterador.elementoActual())){
							iterador.siguiente();
						}
						if (iterador.hayMas()) {
							textNifEmpresa.setText(((Empresa) iterador.elementoActual()).getNif());
							textNombreEmpresa.setText(((Empresa) iterador.elementoActual()).getEmpresa());
							textTelefonoEmpresa.setText(String.valueOf(((Empresa) iterador.elementoActual()).getnTelefono()));
							iterador.siguiente();
						}
					} catch (IndexOutOfBoundsException iobe) {
						UtilVentanas.Alertas.mostrar(UtilVentanas.Alertas.ERROR_IOB,iobe.toString());
					}
				}
				break;
			}
			case "Camión": {
				if(!camiones.isEmpty()){
					try {
						if (iterador.hayMas()) {
							textMatriculaCamion.setText(((Camion) iterador.elementoActual()).getMatricula());
							textNumeroBastidorCamion.setText(((Camion) iterador.elementoActual()).getnBastidor());
							textVolumenCajaCamion.setText(String.valueOf(((Camion) iterador.elementoActual()).getVolumenCaja()));
							iterador.siguiente();
						} 
					} catch (IndexOutOfBoundsException iobe) {
						UtilVentanas.Alertas.mostrar(UtilVentanas.Alertas.ERROR_IOB,iobe.toString());
					}
				}
				break;
			}
			case "Empleado": {
				if(!empleados.isEmpty()){
					try {						
						if (iterador.hayMas()) {
							if(iterador.primero().equals(iterador.elementoActual())){
								iterador.siguiente();
							}
							textDniNifEmpleado.setText(((Trabajador) iterador.elementoActual()).getDni());
							textNombreEmpleado.setText(((Trabajador) iterador.elementoActual()).getNombre()+" "+((Trabajador) iterador.elementoActual()).getApellidos());
							textSueldoEmpleado.setText(String.valueOf(((Trabajador) iterador.elementoActual()).getSueldo()));
							iterador.siguiente();
						}
					} catch (IndexOutOfBoundsException iobe) {
						UtilVentanas.Alertas.mostrar(UtilVentanas.Alertas.ERROR_IOB,iobe.toString());
					}
				}
				break;
			}
		}
	}

	private void comboBoxTipoCambiarSeleccion(java.awt.event.ActionEvent evt, String tipo) throws SQLException {

		switch (tipo) {
		case "Empresa": {
			labelClave.setText("Nif:");
			empresas = new ArrayList<Object>(ce.buscarTodo());
			if (empresas.isEmpty()) {
				UtilVentanas.borrarTextos(textos);				
			} else {
				agregado = new AgregadoConcreto(empresas);
				iterador = agregado.crearIterador();
				textNifEmpresa.setText(((Empresa) iterador.elementoActual()).getNif());
				textNombreEmpresa.setText(((Empresa) iterador.elementoActual()).getEmpresa());
				textTelefonoEmpresa.setText(String.valueOf(((Empresa) iterador.elementoActual()).getnTelefono()));
			}
			panelCamion.setVisible(false); panelEmpleado.setVisible(false);	panelEmpresa.setVisible(true); break;
		}
		case "Camión": {
			labelClave.setText("Nº Bastidor:");
			camiones = new ArrayList<Object>(cc.buscarTodo());
			if (camiones.isEmpty()) {
				UtilVentanas.borrarTextos(textos);
			} else {
				agregado = new AgregadoConcreto(camiones);
				iterador = agregado.crearIterador();
				textMatriculaCamion.setText(((Camion) iterador.elementoActual()).getMatricula());
				textNumeroBastidorCamion.setText(((Camion) iterador.elementoActual()).getnBastidor());
				textVolumenCajaCamion.setText(String.valueOf(((Camion) iterador.elementoActual()).getVolumenCaja()));
			}
			panelEmpleado.setVisible(false); panelEmpresa.setVisible(false); panelCamion.setVisible(true); break;
		}
		case "Empleado": {
			labelClave.setText("DNI:");
			empleados = new ArrayList<Object>(ct.buscarTodo());
			if (empleados.isEmpty()) {
				UtilVentanas.borrarTextos(textos);
			} else {
				agregado = new AgregadoConcreto(empleados);
				iterador = agregado.crearIterador();
				textDniNifEmpleado.setText(((Trabajador) iterador.elementoActual()).getDni());
				textNombreEmpleado.setText(((Trabajador) iterador.elementoActual()).getNombre() + " "
						+ ((Trabajador) iterador.elementoActual()).getApellidos());
				textSueldoEmpleado.setText(String.valueOf(((Trabajador) iterador.elementoActual()).getSueldo()));
			}
			panelCamion.setVisible(false); panelEmpresa.setVisible(false);	panelEmpleado.setVisible(true);	break;
		}
		}
	}

	private void buttonBorrarActionPerformed(java.awt.event.ActionEvent evt, String tipo)
			throws SQLException, IndexOutOfBoundsException, IOException {

		switch (tipo) {
		case "Empresa": {
			if (UtilVentanas.textosIncompletos(textosEmpresas)) {
				fc.crearCRUD(FactoriaCRUD.TIPO_EMPRESA).borrar(((Empresa) iterador.elementoActual()).getNif());
				JOptionPane.showMessageDialog(null, "Empresa con Nif " + ((Empresa) iterador.elementoActual()).getNif() + " ha sido borrada.");
			} else {
				JOptionPane.showMessageDialog(null, "No hay elementos para borrar");
			}
			break;
		}
		case "Camión": {
			if (UtilVentanas.textosIncompletos(textosCamiones)) {
				fc.crearCRUD(FactoriaCRUD.TIPO_CAMION).borrar(((Camion) iterador.elementoActual()).getnBastidor());
				JOptionPane.showMessageDialog(null, "Camión con número de bastidor "+ ((Camion) iterador.elementoActual()).getnBastidor() + " ha sido borrada.");
			} else {
				JOptionPane.showMessageDialog(null, "No hay elementos para borrar");
			}
			break;
		}
		case "Empleado": {
			if (UtilVentanas.textosIncompletos(textosEmpleados)) {
				fc.crearCRUD(FactoriaCRUD.TIPO_EMPLEADO).borrar(((Trabajador) iterador.elementoActual()).getDni());
				JOptionPane.showMessageDialog(null,
						"Empleado con Dni " + ((Trabajador) iterador.elementoActual()).getDni() +" ha sido borrada.");
			} else {
				JOptionPane.showMessageDialog(null, "No hay elementos para borrar");
			}
			break;
		}
		}
	}
}
