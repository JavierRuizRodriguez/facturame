package interfacesGraficas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JToolBar;

import com.lowagie.text.Document;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import factorias.FactoriaCRUD;
import operacionesCRUD.CRUDportes;
import operacionesCRUD.CRUDviajes;
import pojo.Porte;
import pojo.Viaje;

public class VentanaTabla2PDF extends JFrame {
	private static Color color = Color.CYAN;
	private ArrayList<Object> viajes;
	private JTable table;
	private Document doc;
	private ArrayList<Object> portes;
	private FactoriaCRUD fc;
	private CRUDportes cp;
	private CRUDviajes cv;

	/**
	 * Constructor for PrintJTable.
	 * 
	 * @throws SQLException
	 */
	public VentanaTabla2PDF(String fInicio, String fFinal, String empresa) throws SQLException {
		this.table = new JTable();
		table.setPreferredSize(getPreferredSize());
		this.fc = new FactoriaCRUD();
		this.cp = (CRUDportes) fc.crearCRUD(FactoriaCRUD.TIPO_PORTE);
		this.cv = (CRUDviajes) fc.crearCRUD(FactoriaCRUD.TIPO_VIAJE);
		this.portes = new ArrayList<Object>(cp.buscarPorFechas(fInicio, fFinal, empresa));
		getContentPane().setLayout(new BorderLayout());
		crearBarraHerramientas();
		crearTablaCuerpo();
		crearTablaResumen();

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	private void crearTablaResumen() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Create a table with some dummy data
	 * 
	 * @throws SQLException
	 */
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

		String[] columnNames = { "ID factura", "NIF", "Origen", "Destino", "F. inicio", "Kg carga", "Precio",
				"Grupaje?" };

		table = new JTable(datosO, columnNames);

		// Use a panel to contains the table and add it the frame
		JPanel tPanel = new JPanel(new BorderLayout());
		tPanel.add(table.getTableHeader(), BorderLayout.NORTH);
		tPanel.add(table, BorderLayout.CENTER);

		getContentPane().add(tPanel, BorderLayout.CENTER);
	}

	/**
	 * Toolbar for print and exit
	 */
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
			PdfWriter.getInstance(doc, new FileOutputStream("table.pdf"));
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
			manejarDocumento(1);

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
