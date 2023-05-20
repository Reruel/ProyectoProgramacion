package clases;

import enumeration.Alergeno;

public class Ingrediente extends CosaConNombre {
	private Alergeno alergeno;

	public Ingrediente(String nombre, Alergeno alergeno) {
		super(nombre);
		this.alergeno = alergeno;
	}

	public Alergeno getAlergeno() {
		return alergeno;
	}

	public void setAlergeno(Alergeno alergeno) {
		this.alergeno = alergeno;
	}

}
