package interfaces;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.SwingConstants;

import clases.Usuario;
import excepciones.ContraseñaInvalidaException;
import excepciones.UsuarioNoExisteException;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class PantallaLogin extends JPanel {
	private Ventana ventana;
	private JTextField huecoNombre;
	private JTextField huecoContraseña;
	public PantallaLogin(Ventana v) {
		this.ventana=v;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel LabelNombre = new JLabel("Nombre");
		LabelNombre.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_LabelNombre = new GridBagConstraints();
		gbc_LabelNombre.anchor = GridBagConstraints.WEST;
		gbc_LabelNombre.fill = GridBagConstraints.VERTICAL;
		gbc_LabelNombre.insets = new Insets(0, 0, 5, 5);
		gbc_LabelNombre.gridx = 1;
		gbc_LabelNombre.gridy = 1;
		add(LabelNombre, gbc_LabelNombre);
		
		huecoNombre = new JTextField();
		GridBagConstraints gbc_huecoNombre = new GridBagConstraints();
		gbc_huecoNombre.insets = new Insets(0, 0, 5, 5);
		gbc_huecoNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_huecoNombre.gridx = 2;
		gbc_huecoNombre.gridy = 1;
		add(huecoNombre, gbc_huecoNombre);
		huecoNombre.setColumns(10);
		
		JLabel LabelContraseña = new JLabel("Contraseña");
		LabelContraseña.setForeground(new Color(0, 0, 0));
		LabelContraseña.setBackground(new Color(221, 190, 43));
		LabelContraseña.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_LabelContraseña = new GridBagConstraints();
		gbc_LabelContraseña.anchor = GridBagConstraints.WEST;
		gbc_LabelContraseña.fill = GridBagConstraints.VERTICAL;
		gbc_LabelContraseña.insets = new Insets(0, 0, 5, 5);
		gbc_LabelContraseña.gridx = 1;
		gbc_LabelContraseña.gridy = 2;
		add(LabelContraseña, gbc_LabelContraseña);
		
		huecoContraseña = new JTextField();
		GridBagConstraints gbc_huecoContraseña = new GridBagConstraints();
		gbc_huecoContraseña.insets = new Insets(0, 0, 5, 5);
		gbc_huecoContraseña.fill = GridBagConstraints.HORIZONTAL;
		gbc_huecoContraseña.gridx = 2;
		gbc_huecoContraseña.gridy = 2;
		add(huecoContraseña, gbc_huecoContraseña);
		huecoContraseña.setColumns(10);
		
		JButton botonLogin = new JButton("LOGIN");
		botonLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nombre=huecoNombre.getText();
				String contraseña=huecoContraseña.getText();
				JOptionPane.showMessageDialog(ventana, "Tratando de conectar con:\nusuario: " + nombre + "\ncontraseña: " + contraseña);
				try {
					ventana.usuarioLogado=new Usuario(nombre,contraseña);
					ventana.cambiarAPantalla(PantallaLogueado.class);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Login fallido", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (UsuarioNoExisteException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(ventana, "El usuario " + nombre + " no existe", "Login fallido",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (ContraseñaInvalidaException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(ventana, "La contraseña no es correcta", "Login fallido",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
				
			}
		});
		botonLogin.setBackground(new Color(216, 187, 52));
		GridBagConstraints gbc_botonLogin = new GridBagConstraints();
		gbc_botonLogin.insets = new Insets(0, 0, 5, 5);
		gbc_botonLogin.gridx = 1;
		gbc_botonLogin.gridy = 3;
		add(botonLogin, gbc_botonLogin);
		
		JButton botonRegister = new JButton("REGISTER");
		botonRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaRegistro.class);
			}
		});
		botonRegister.setForeground(new Color(0, 0, 0));
		botonRegister.setBackground(new Color(236, 88, 0));
		GridBagConstraints gbc_botonRegister = new GridBagConstraints();
		gbc_botonRegister.insets = new Insets(0, 0, 5, 5);
		gbc_botonRegister.gridx = 2;
		gbc_botonRegister.gridy = 3;
		add(botonRegister, gbc_botonRegister);
	}

}
