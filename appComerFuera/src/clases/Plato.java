package clases;

public class Plato extends Alimento{

	public Plato() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Plato \n\tCiudad : " + getCiudad() + ", getAlergenoExcluido()=" + getAlergenoExcluido()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	
}
