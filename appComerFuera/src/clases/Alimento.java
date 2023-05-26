package clases;

import java.util.ArrayList;
import java.util.HashSet;

import enumeration.Alergeno;

public class Alimento extends CosaConNombre {
	private byte precio;
	private HashSet<Ingrediente> Ingredientes;
	
	public Alimento(String nombre) {
		super(nombre);
	}

	public Alimento(String nombre, byte precio, HashSet<Ingrediente> ingredientes) {
		super(nombre);
		this.precio = precio;
		Ingredientes = ingredientes;
	}


	// 1 - Crea una tabla alimentoIngrediente con la pk de alimento y la pk de
	// ingrediente
	// Esta tabla está porque la relacion entre alimento e ingrediente es muchos a
	// muchos (HECHO)
	public static ArrayList<Alimento> getTodos() {
		// Traer usando DAO todos los alimentos de la base de datos y devolverlos en
		// arraylist
	}

	public static ArrayList<Alimento> getTodos(ArrayList<Alergeno> alergernosExcluidos) {
		ArrayList<Alimento> todos = getTodos();
		// Elimina del arraylist los que contengan los alérgenos que te vengan en
		// alergenosIncluidos
	}

	public byte getPrecio() {
		return precio;
	}

	public void setPrecio(byte precio) {
		this.precio = precio;
	}

	public HashSet<Ingrediente> getIngredientes() {
		return Ingredientes;
	}

	public void setIngredientes(HashSet<Ingrediente> ingredientes) {
		Ingredientes = ingredientes;
	}

}
