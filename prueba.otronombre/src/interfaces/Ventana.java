package interfaces;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
		
		try {
			File musiquita = new File("./Baby-dont-hurt-me-slowed-meme.wav");
			Clip clip = AudioSystem.getClip();
	        AudioInputStream ais = AudioSystem.getAudioInputStream(musiquita);
	        clip.open(ais);
	        clip.loop(Clip.LOOP_CONTINUOUSLY);
		}catch(Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(this, "La música no pudo iniciarse.", "Tristeza musical",
					JOptionPane.ERROR_MESSAGE);
		}
        
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
