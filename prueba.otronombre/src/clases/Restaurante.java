package clases;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

import enumeration.Alergeno;
import excepciones.RestauranteNoExisteException;
import excepciones.RestauranteYaExisteException;
import utils.DAO;

public class Restaurante extends CosaConNombre {
	private ArrayList<Alimento> alergenoExcluido;
	private String ciudad;
	private HashMap<String, Alimento> carta;
	
	
	
	public Restaurante(String nombre, String ciudad, ArrayList<Alimento> alergenoExcluido) throws SQLException, RestauranteYaExisteException {
		super(nombre);
		HashMap<String,Object> restricciones = new HashMap<String,Object>();
		int num = DAO.insertar("restaurante", restricciones);
		if(num==-1) {
			throw new RestauranteYaExisteException("El restaurante ya existe");
		}else {
			this.ciudad = ciudad;
			this.alergenoExcluido = alergenoExcluido;
		}
		
		//Insertar restaurante en bd
	}
	
	public Restaurante(String nombre) throws RestauranteNoExisteException {
		//PROBLEMA: la variable nombre se inicializa al principio del constructor obligatoriamente
		super(nombre);
		HashMap<String,Object> restricciones = new HashMap<String,Object>();
		LinkedHashSet<String>columnas=new LinkedHashSet<String>();
		restricciones.put("nombre",nombre);
		columnas.add("nombre");
		columnas.add("ciudad");
		try {
			ArrayList<Object> consulta = DAO.consultar("restaurante", columnas, restricciones);
			if(consulta.isEmpty()) {
				throw new RestauranteNoExisteException("El restaurante no existe");
			}else {
				ciudad=(String)consulta.get(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//COnsultar ese restaurante con ese nombre y traerlo de la bd
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
		//Añade las demas columnas de alimento, para traer todos sus datos
		restricciones.put("nombreRestaurante", getNombre());
		//select nombreAlimento from platoRestaurante where nombreRestaurante="Restaurante pepito"
		try {
			ArrayList<Object> consulta = DAO.consultar("platoRestaurante", columnas, restricciones);
			ArrayList<Alimento> alimentos = new ArrayList<Alimento>();
			for(byte i=0;i<consulta.size();i++) {
				/*System.out.println((String)consulta.get(i));
				Alimento al = new Alimento((String)consulta.get(i));
				//Crea constructor vacio que no interaccione con bd, y establece los datos leidos desde bd con los setters
				alimentos.add(al);
				//faltan incluir el resto de valores de las variables internas
				*/
			}
			//Usamos este boolean para salir del doble bucle en caso de eliminar un alimento de la lista
			boolean excluir = false;
			for(byte i=0;i<alimentos.size();i++) {
				//no sé cómo sacar los alergenos del alimento que esta en el array alimentos
				ArrayList<Ingrediente> Ingredientes = alimentos.get(i).getIngredientes();
				//Hacemos un bucle para recorrer los ingredientes de los alimentos del restaurante
				for(byte j=0;i<Ingredientes.size();j++) {
					//y otro para reocrrer los alergenos excluídos
					for(byte k=0;i<alergenoExcluido.size();k++) {
						//Si el alérgeno está en el Alimento, excluímos dicho alimento
						if(Ingredientes.get(j).getAlergeno() == alergenoExcluido.get(k)) {
							alimentos.remove(i);
							i--;
							//cómo excluímos un alimento, salimos del bucle de los alérgenos
							excluir=true;
							break;
						}
					}
					if(excluir) {
						//Si hemos salido del bucle de los alérgenos por haber excluido algún alimento, establecemos de nuevo el boolean y salimos del bucle de los ingredientes del alimento
						excluir = false;
						break;
					}
				}
			}
			
			return alimentos;
		}catch (Exception exception) {
		    exception.printStackTrace();
		}
		return null;
	}
	

}
//Falta la función
