package interfacesGraficas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

import com.lowagie.text.Document;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import factorias.FactoriaCRUD;
import operacionesCRUD.CRUDempresa;
import operacionesCRUD.CRUDportes;
import operacionesCRUD.CRUDviajes;
import pojo.Empresa;
import pojo.Porte;
import pojo.Viaje;

public class VentanaTabla2PDF extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Color color = Color.CYAN;
	private ArrayList<Object> viajes;
	private JTable table;
	private JTable table1;

	private JPanel contentPane;
	private Document doc;
	private ArrayList<Object> portes;
	private FactoriaCRUD fc;
	private CRUDportes cp;
	private CRUDviajes cv;
	private Empresa empresa;
	private CRUDempresa ce;

	public VentanaTabla2PDF(String fInicio, String fFinal, String empresa, VentanaPrincipal principal) throws SQLException, IOException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
		        formWindowClosing(principal);
			}
		});
		this.table = new JTable();
		this.table1 = new JTable();
		this.table.setPreferredSize(getPreferredSize());
		this.fc = new FactoriaCRUD();
		this.ce = (CRUDempresa) fc.crearCRUD(FactoriaCRUD.TIPO_EMPRESA);
		this.empresa = (Empresa) ce.buscarUno(empresa);
		this.cp = (CRUDportes) fc.crearCRUD(FactoriaCRUD.TIPO_PORTE);
		this.cv = (CRUDviajes) fc.crearCRUD(FactoriaCRUD.TIPO_VIAJE);
		this.portes = new ArrayList<Object>(cp.buscarPorFechas(fInicio, fFinal, empresa));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		crearBarraHerramientas();
		crearTablaCuerpo();
		crearTablaResumen();

	}

	private void formWindowClosing(VentanaPrincipal principal) {
	    this.setVisible(false);
	    principal.setVisible(true);
	}
	
	private void crearTablaResumen() {
		double sumatorio = 0;
		for (Object o : portes) {
			Porte p = (Porte) o;
			sumatorio = +p.getPrecio();
		}

		String[] columnNames = { "Nombre empresa", "NIF", "Teléfono", "Precio" };
		Object[][] datos = { { empresa.getEmpresa(), empresa.getNif(), empresa.getnTelefono(),
				String.valueOf(sumatorio).concat(" €") } };
		table = new JTable(datos, columnNames);

	}

	private void crearTablaCuerpo() throws SQLException {
		ArrayList<ArrayList<Object>> datos = new ArrayList<ArrayList<Object>>();

		for (Object o : portes) {
			Porte p = (Porte) o;
			viajes = new ArrayList<Object>(cv.buscarPorPorte(p.getIdPorte()));
			for (Object v : viajes) {
				ArrayList<Object> lista = new ArrayList<Object>();
				lista.add(p.getIdPorte());
				lista.add(p.getNif());
				lista.add(((Viaje) v).getLugarInicio());
				lista.add(((Viaje) v).getLugarDestino());
				lista.add(((Viaje) v).getFechaInicio());
				lista.add(p.getKgCarga());
				lista.add(p.getPrecio());
				lista.add(p.isEsGrupaje());
				datos.add(lista);
			}
		}

		Object[][] datosO = new Object[datos.size()][8];

		int contador = 0;
		for (ArrayList<Object> l : datos) {
			System.out.println(contador);
			datosO[contador][0] = l.get(0);
			datosO[contador][1] = l.get(1);
			datosO[contador][2] = l.get(2);
			datosO[contador][3] = l.get(3);
			datosO[contador][4] = l.get(4);
			datosO[contador][5] = l.get(5);
			datosO[contador][6] = l.get(6);
			datosO[contador][7] = l.get(7);
			contador++;
		}

		String[] columnNames = { "ID porte", "NIF", "Origen", "Destino", "F. inicio", "Kg carga", "Precio",
				"Grupaje?" };

		table = new JTable(datosO, columnNames);

		JPanel tPanel = new JPanel(new BorderLayout());
		tPanel.add(table.getTableHeader(), BorderLayout.NORTH);
		tPanel.add(table, BorderLayout.CENTER);

		getContentPane().add(tPanel, BorderLayout.CENTER);
	}

	private void crearBarraHerramientas() {
		JToolBar tb = new JToolBar();

		JButton printBtn = new JButton("Imprimir");
		printBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imprimir();
			}
		});

		tb.add(printBtn);

		getContentPane().add(tb, BorderLayout.NORTH);
	}

	private void imprimir() {
		try {
			doc = new Document();
			PdfWriter.getInstance(doc, new FileOutputStream("documentacion\\table.pdf"));
			PdfPTable pdfTable = new PdfPTable(table.getColumnCount());
			manejarDocumento(0);

			for (int i = 0; i < table.getColumnCount(); i++) {
				PdfPCell celda = new PdfPCell(new Phrase(table.getColumnName(i)));
				celda.setBackgroundColor(VentanaTabla2PDF.color);
				pdfTable.addCell(celda);
			}

			for (int fil = 0; fil < table.getRowCount(); fil++) {
				for (int col = 0; col < table.getColumnCount(); col++) {
					pdfTable.addCell(table.getModel().getValueAt(fil, col).toString());
				}
			}
			doc.add(pdfTable);

//			PdfPTable pdfTable1 = new PdfPTable(table1.getColumnCount());
//			manejarDocumento(0);
//
//			for (int i = 0; i < table.getColumnCount(); i++) {
//				PdfPCell celda = new PdfPCell(new Phrase(table.getColumnName(i)));
//				celda.setBackgroundColor(VentanaTabla2PDF.color);
//				pdfTable1.addCell(celda);
//			}
//
//			for (int fil = 0; fil < table.getRowCount(); fil++) {
//				for (int col = 0; col < table.getColumnCount(); col++) {
//					pdfTable1.addCell(table.getModel().getValueAt(fil, col).toString());
//				}
//			}
//			pdfTable1.setTotalWidth(doc.right(doc.rightMargin()) - doc.left(doc.leftMargin()));

			manejarDocumento(1);
			System.out.println("Impreso");

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

	}

	private void manejarDocumento(int i) {
		if (i == 0)
			doc.open();
		else if (i == 1)
			doc.close();

	}
}
