package clases;

import java.util.HashSet;
import enumeration.Alergeno;
import java.util.ArrayList;

public class Usuario extends CosaConNombre {
	private String email;
	private String contraseña;
	private ArrayList<Alergeno> alergeno;

	public Usuario(String email, String nombre, String contraseña, ArrayList<Alergeno> alergeno) {
		super(nombre);
		this.email = email;
		this.contraseña = contraseña;
		this.alergeno = alergeno;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public ArrayList<Alergeno> getAlergeno() {
		return alergeno;
	}

	public void setAlergeno(ArrayList<Alergeno> alergeno) {
		this.alergeno = alergeno;
	}

}
