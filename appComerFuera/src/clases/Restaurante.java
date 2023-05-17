package clases;

import java.util.ArrayList;
import java.util.HashMap;

import enumeration.Alergeno;

public class Restaurante extends CosaConNombre {
private String ciudad;
private HashMap<String,Alimento> carta;


public Restaurante(String ciudad, ArrayList<Alimento> alergenoExcluido) {
	super();
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
	
	 
	return x;
}
	
}
//Falta la función

