package clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

import enumeration.Alergeno;
import utils.DAO;

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
		//(HECHO)
		
		// Recorre el arraylist, sacando del mismo a los alimentos que tengan un
		// alergeno que este en alergenoExcluido
		// devuelve el arraylist
		LinkedHashSet<String> columnas = new LinkedHashSet<String>();
		HashMap<String, Object> restricciones = new HashMap<String, Object>();
		columnas.add("nombreAlimento");
		restricciones.put("nombreRestaurante", getNombre());
		//select nombreAlimento from platoRestaurante where nombreRestaurante="Restaurante pepito"
		ArrayList<Object> consulta = DAO.consultar("platoRestaurante", columnas, restricciones);
		ArrayList<Alimento> alimentos = new ArrayList<Alimento>();
		for(byte i=0;i<consulta.size();i++) {
			Alimento al = new Alimento((String)consulta.get(i));
			alimentos.add(al);
			//faltan incluir el resto de valores de las variables internas
		}
		
		for(byte i=0;i<alimentos.size();i++) {
			//no sé cómo sacar los alergenos del alimento que esta en el array alimentos
			if(alimentos.get(i)) {
				alimentos.remove(i);
				i--;
			}
		}
		
		return alimentos;
	}

}
//Falta la función
