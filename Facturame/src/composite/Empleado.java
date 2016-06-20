package composite;

/**
 * 
 * @author Jorge Gonz�lez Rodr�guez y Javier Ruiz Rodr�guez
 *
 */
public class Empleado extends TrabajadorC {

	public Empleado(String puesto, double salario) {
		super(puesto, salario);
	}

	@Override
	public void anadirSubordinado(TrabajadorC t) {
	}

	@Override
	public void eliminarSubordinado(TrabajadorC t) {
	}

	@Override
	public double getSalarios() {
		return super.getSalario();
	}

	@Override
	public String getDescripcion() {
		return "### " + super.toString();
	}
}
