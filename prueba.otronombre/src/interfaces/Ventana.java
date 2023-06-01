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
}
