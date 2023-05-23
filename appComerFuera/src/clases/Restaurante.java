package clases;

import java.util.ArrayList;
import java.util.HashMap;

import enumeration.Alergeno;

public class Restaurante extends CosaConNombre {
	private ArrayList<Alimento> alergenoExcluido;
	private String ciudad;
	private HashMap<String, Alimento> carta;
	
	public Restaurante(String nombre, String ciudad, ArrayList<Alimento> alergenoExcluido) {
		super(nombre);
		this.ciudad = ciudad;
		this.alergenoExcluido = alergenoExcluido;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public ArrayList<Alimento> getAlergenoExcluido() {
		return alergenoExcluido;
	}

	public void setAlergenoExcluido(ArrayList<Alimento> alergenoExcluido) {
		this.alergenoExcluido = alergenoExcluido;
	}

//Recorrer lista de alimentos (en la bd) y descartar si contiene alergenos (alergeno excluido), para que salgan
	public ArrayList<Alimento> getAlimentos(ArrayList<Alergeno> alergenoExcluido) {
		// Tienes que tener tabla intermedia platoRestaurante con la pk de ambos
		// Usa DAO para traerte todos los nombres de plato de este restaurante
		// Usa el constructor de Alimento que recibe solo el nombre del alimento (pk)
		// para meter en un arraylist
		// todos esos alimentos
		// Recorre el arraylist, sacando del mismo a los alimentos que tengan un
		// alergeno que este en alergenoExcluido
		// devuelve el arraylist

		return x;
	}

}
//Falta la función
