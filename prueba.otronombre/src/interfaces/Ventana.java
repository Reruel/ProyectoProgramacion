package interfaces;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import clases.Usuario;

public class Ventana extends JFrame{

	protected Usuario usuarioLogado;
	
	public Ventana() {
		this.setSize(600, 500);
		this.setTitle("AllerGEEK");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(new PantallaLogin(this));
		this.setIconImage(new ImageIcon("./cubiertos.png").getImage());
		this.setVisible(true);
	}
	public void cambiarAPantalla(Class<?> clase) {
		this.getContentPane().setVisible(false);
		if (clase.equals(PantallaLogin.class)) {
			this.setContentPane(new PantallaLogin(this));
		} 
		if(clase.equals(PantallaRegistro.class)) {
			this.setContentPane(new PantallaRegistro(this));
		}
		if(clase.equals(PantallaLogueado.class)) {
			this.setContentPane(new PantallaLogueado(this));
		}
		
		this.getContentPane().setVisible(true);
	}
}
