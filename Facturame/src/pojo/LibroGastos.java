package pojo;

import java.sql.Date;

public class LibroGastos {

	private int idEntrada;
	private String concepto;
	private double dinero;
	private Date fechaAsiento;
	private String descripcion;

	public LibroGastos(int idEntrada, String concepto, double dinero, Date fechaAsiento, String descripcion) {

		this.idEntrada = idEntrada;
		this.concepto = concepto;
		this.dinero = dinero;
		this.fechaAsiento = fechaAsiento;
		this.descripcion = descripcion;
	}

	public LibroGastos() {
	}

	public int getIdEntrada() {
		return idEntrada;
	}

	public void setIdEntrada(int idEntrada) {
		this.idEntrada = idEntrada;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public double getDinero() {
		return dinero;
	}

	public void setDinero(double dinero) {
		this.dinero = dinero;
	}

	public Date getFechaAsiento() {
		return fechaAsiento;
	}

	public void setFechaAsiento(Date fechaAsiento) {
		this.fechaAsiento = fechaAsiento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
