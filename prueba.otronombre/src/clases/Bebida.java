package clases;

import java.util.ArrayList;

public class Bebida extends Alimento {
	// ¿aquí no debería conectarse el enumeration?
	private byte tamaño;

	public Bebida(String nombre, byte precio, ArrayList<Ingrediente> ingredientes, byte tamaño) {
		super(nombre, precio, ingredientes);
		this.tamaño = tamaño;
	}

	public byte getTamaño() {
		return tamaño;
	}

	public void setTamaño(byte tamaño) {
		this.tamaño = tamaño;
	}

}
