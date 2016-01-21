package interfacesGraficas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import builders.CreadorPortes;
import builders.PorteGrafico;
import pojo.UsuarioAutenticacion;
import util.UtilVentanas;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;

	public VentanaPrincipal(UsuarioAutenticacion ua) throws SQLException, IOException {
		setTitle("Facturame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton buttonPorte = new JButton("PORTE");
		buttonPorte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Timer timer = new Timer(1000, this);

					clickVentanaPorte(timer);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		buttonPorte.setBounds(120, 49, 179, 25);
		contentPane.add(buttonPorte);

		JButton buttonFactura = new JButton("FACTURA");
		buttonFactura.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					clickVentanaFactura();
				} catch (SQLException sqle) {
					UtilVentanas.Alertas.mostrar(UtilVentanas.Alertas.ERROR_SQL, sqle.toString());
				} catch (IOException ioe) {
					UtilVentanas.Alertas.mostrar(UtilVentanas.Alertas.ERROR_IOE, ioe.toString());
				}
			}
		});
		buttonFactura.setBounds(120, 85, 179, 25);
		contentPane.add(buttonFactura);

		JButton buttonJerarquia = new JButton("JERARQU\u00CDA");
		buttonJerarquia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					clickVentanaJerarquia();
				} catch (SQLException sqle) {
					UtilVentanas.Alertas.mostrar(UtilVentanas.Alertas.ERROR_SQL, sqle.toString());
				} catch (IOException ioe) {
					UtilVentanas.Alertas.mostrar(UtilVentanas.Alertas.ERROR_IOE, ioe.toString());
				}
			}
		});
		buttonJerarquia.setBounds(120, 121, 179, 25);
		contentPane.add(buttonJerarquia);

		JButton buttonGestion = new JButton("GESTI\u00D3N");
		buttonGestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					clickVentanaGestion();
				} catch (SQLException sqle) {
					UtilVentanas.Alertas.mostrar(UtilVentanas.Alertas.ERROR_SQL, sqle.toString());
				} catch (IOException ioe) {
					UtilVentanas.Alertas.mostrar(UtilVentanas.Alertas.ERROR_IOE, ioe.toString());
				}
			}
		});
		buttonGestion.setBounds(120, 157, 179, 25);
		contentPane.add(buttonGestion);

		JButton buttonVerDatos = new JButton("VER DATOS");
		buttonVerDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					clickVentanaConsulta();
				} catch (SQLException sqle) {
					UtilVentanas.Alertas.mostrar(UtilVentanas.Alertas.ERROR_SQL, sqle.toString());
				} catch (IOException ioe) {
					UtilVentanas.Alertas.mostrar(UtilVentanas.Alertas.ERROR_IOE, ioe.toString());
				}
			}
		});
		buttonVerDatos.setBounds(120, 193, 179, 25);
		contentPane.add(buttonVerDatos);

		buttonGestion.setVisible(ua.isAdmin());
		buttonVerDatos.setVisible(ua.isAdmin());
	}

	private void clickVentanaPorte(Timer timer) throws SQLException, IOException, InterruptedException {

		PorteGrafico pg = new PorteGrafico(timer);
		CreadorPortes cp = new CreadorPortes(this);

		cp.setPb(pg);
		cp.hacerPorte();
	}

	private void clickVentanaFactura() throws SQLException, IOException {
		VentanaGenerarFactura ventanaGenerarFactura = new VentanaGenerarFactura(this);
		ventanaGenerarFactura.setVisible(true);
		this.setVisible(false);
	}

	private void clickVentanaJerarquia() throws SQLException, IOException {
		VentanaVisualizacionComposite ventanaVisualizacionComposite = new VentanaVisualizacionComposite(this);
		ventanaVisualizacionComposite.setVisible(true);
		this.setVisible(false);
	}

	private void clickVentanaGestion() throws SQLException, IOException {
		VentanaGestion ventanaGestion = new VentanaGestion(this);
		ventanaGestion.setVisible(true);
		this.setVisible(false);
	}

	private void clickVentanaConsulta() throws SQLException, IOException {
		VentanaConsulta ventanaConsulta = new VentanaConsulta(this);
		ventanaConsulta.setVisible(true);
		this.setVisible(false);
	}
}