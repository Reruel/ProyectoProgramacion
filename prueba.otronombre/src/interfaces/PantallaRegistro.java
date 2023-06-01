package interfaces;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import clases.Usuario;
import enumeration.Alergeno;
import excepciones.UsuarioYaExisteException;
import utils.DAO;

import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

public class PantallaRegistro extends JPanel{
	private Ventana ventana;
	private JTextField huecoNombre;
	private JTextField huecoContraseña;
	public PantallaRegistro(Ventana v) {
		this.ventana=v;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel labelNombre = new JLabel("Nombre");
		GridBagConstraints gbc_labelNombre = new GridBagConstraints();
		gbc_labelNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelNombre.insets = new Insets(0, 0, 5, 5);
		gbc_labelNombre.gridx = 0;
		gbc_labelNombre.gridy = 0;
		add(labelNombre, gbc_labelNombre);
		
		huecoNombre = new JTextField();
		GridBagConstraints gbc_huecoNombre = new GridBagConstraints();
		gbc_huecoNombre.insets = new Insets(0, 0, 5, 0);
		gbc_huecoNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_huecoNombre.gridx = 1;
		gbc_huecoNombre.gridy = 0;
		add(huecoNombre, gbc_huecoNombre);
		huecoNombre.setColumns(10);
		
		JLabel labelContraseña = new JLabel("Contraseña");
		GridBagConstraints gbc_labelContraseña = new GridBagConstraints();
		gbc_labelContraseña.insets = new Insets(0, 0, 5, 5);
		gbc_labelContraseña.gridx = 0;
		gbc_labelContraseña.gridy = 1;
		add(labelContraseña, gbc_labelContraseña);
		
		huecoContraseña = new JTextField();
		GridBagConstraints gbc_huecoContraseña = new GridBagConstraints();
		gbc_huecoContraseña.insets = new Insets(0, 0, 5, 0);
		gbc_huecoContraseña.fill = GridBagConstraints.HORIZONTAL;
		gbc_huecoContraseña.gridx = 1;
		gbc_huecoContraseña.gridy = 1;
		add(huecoContraseña, gbc_huecoContraseña);
		huecoContraseña.setColumns(10);
		
		JLabel labelAlergenos = new JLabel("Alergenos");
		GridBagConstraints gbc_labelAlergenos = new GridBagConstraints();
		gbc_labelAlergenos.insets = new Insets(0, 0, 5, 5);
		gbc_labelAlergenos.gridx = 0;
		gbc_labelAlergenos.gridy = 2;
		add(labelAlergenos, gbc_labelAlergenos);
		
		JButton botonRegistrar = new JButton("Resgistrar");
		botonRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nombre = huecoNombre.getText();
				String contraseña = huecoContraseña.getText();
				ArrayList<Alergeno> alergenos = new ArrayList<Alergeno>();
				//if (glutenCheck.isSelected){alergenos.add(Alergeno.GLUTEN)}
				try {
					new Usuario(nombre,contraseña,alergenos);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UsuarioYaExisteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		GridBagConstraints gbc_botonRegistrar = new GridBagConstraints();
		gbc_botonRegistrar.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonRegistrar.gridwidth = 2;
		gbc_botonRegistrar.insets = new Insets(0, 0, 0, 5);
		gbc_botonRegistrar.gridx = 0;
		gbc_botonRegistrar.gridy = 6;
		add(botonRegistrar, gbc_botonRegistrar);
	}
	
}
