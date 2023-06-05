package clases;

import java.util.HashSet;
import java.util.LinkedHashSet;

import enumeration.Alergeno;
import excepciones.ContraseñaInvalidaException;
import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioYaExisteException;
import utils.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Usuario extends CosaConNombre {
	
	private String contraseña;
	private ArrayList<Alergeno> alergeno;
	
	public Usuario(String nombre) {
		super(nombre);
		contraseña = "";
		alergeno = new ArrayList<Alergeno>();
	}

	public Usuario(String nombre, String contraseña, ArrayList<Alergeno> alergeno) throws SQLException, UsuarioYaExisteException {
		super(nombre);
		HashMap<String,Object> restricciones = new HashMap<String,Object>();
		restricciones.put("nombre",nombre);
		restricciones.put("contraseña", contraseña);
		int res =DAO.insertar("usuario", restricciones);
		if(res==-1) {
			this.setNombre(null);
			throw new UsuarioYaExisteException("El usuario ya existe en la BD");
		}else {
			this.contraseña = contraseña;
			HashMap<String,Object> restricciones2 = new HashMap<String,Object>();
			for(byte i=0; i<alergeno.size();i++) {
				restricciones2.put("nombre",nombre);
				restricciones2.put("alergeno", alergeno.get(i));
				DAO.insertar("usuario_alergenos", restricciones2);
				restricciones2.clear();
			}	
		}
	}
		
	public Usuario(String nombre, String contraseña) throws SQLException, UsuarioNoExisteException, ContraseñaInvalidaException {
		super(nombre);
		HashMap <String, Object> restricciones = new HashMap<String,Object>();
		LinkedHashSet<String> cols = new LinkedHashSet<String>();
	    cols.add("nombre");
	    cols.add("contraseña");
	    restricciones.put("nombre", nombre);
	    ArrayList<Object> resultado = DAO.consultar("usuario_alergenos",cols,restricciones);
	    String contraseniaString = "";
	    if(resultado.isEmpty()) {
	    	this.setNombre(null);
	    	throw new UsuarioNoExisteException("El usuario no existe en la BD.");
	    }else {
	    	if (resultado.get(1).getClass() != contraseña.getClass()) {
                contraseniaString = Integer.toString((int) resultado.get(1));
            } else {
                contraseniaString = resultado.get(1) + "";
            }
            if (!contraseniaString.equals(contraseña)) {
            	this.setNombre(null);
                throw new ContraseñaInvalidaException("La contraseña introducida no coincide");
            } else {
            	LinkedHashSet<String> cols2 = new LinkedHashSet<String>();
            	HashMap<String, Object>restricciones2 = new HashMap<String,Object>();
            	restricciones2.put("nombre",nombre);
            	cols2.add("contraseña");
            	ArrayList<Object>resultado2=DAO.consultar("usuario_alergenos", cols2, restricciones2);
            	ArrayList<Alergeno>alergenoss = new ArrayList<Alergeno>();
            	for(byte i=0;i<resultado2.size();i++) {
            		alergenoss.add((Alergeno) resultado2.get(i));
            	}
            	alergeno = alergenoss;
            }
	    }
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
