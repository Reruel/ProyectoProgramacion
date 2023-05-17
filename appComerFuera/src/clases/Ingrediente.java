package clases;

import enumeration.Alergeno;

public class Ingrediente extends CosaConNombre {
	private Alergeno alergeno;

	public Ingrediente(Alergeno alergeno) {
		super();
		this.alergeno = alergeno;
	}

	public Alergeno getAlergeno() {
		return alergeno;
	}

	public void setAlergeno(Alergeno alergeno) {
		this.alergeno = alergeno;
	}

}
