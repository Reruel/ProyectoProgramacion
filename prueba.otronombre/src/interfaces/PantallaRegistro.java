package interfaces;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import clases.Usuario;
import enumeration.Alergeno;
import excepciones.UsuarioYaExisteException;
import utils.DAO;

import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

public class PantallaRegistro extends JPanel{
	private Ventana ventana;
	private JTextField huecoNombre;
	private JTextField huecoContraseña;
	private JRadioButton hombreRadioButton;
    private JRadioButton mujerRadioButton;
    private JRadioButton otroRadioButton;
	
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
		gbc_huecoNombre.gridwidth = 2;
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
		gbc_huecoContraseña.gridwidth = 2;
		gbc_huecoContraseña.gridx = 1;
		gbc_huecoContraseña.gridy = 1;
		add(huecoContraseña, gbc_huecoContraseña);
		huecoContraseña.setColumns(10);
		
		hombreRadioButton = new JRadioButton("Hombre");
		GridBagConstraints gbc_hombreRadioButton = new GridBagConstraints();
		gbc_hombreRadioButton.insets = new Insets(0, 0, 5, 0);
		gbc_hombreRadioButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_hombreRadioButton.gridx = 0;
		gbc_hombreRadioButton.gridy = 2;
		add(hombreRadioButton, gbc_hombreRadioButton);
		
		mujerRadioButton = new JRadioButton("Mujer");
		GridBagConstraints gbc_mujerRadioButton = new GridBagConstraints();
		gbc_mujerRadioButton.insets = new Insets(0, 0, 5, 0);
		gbc_mujerRadioButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_mujerRadioButton.gridx = 1;
		gbc_mujerRadioButton.gridy = 2;
		add(mujerRadioButton, gbc_mujerRadioButton);
		
		otroRadioButton = new JRadioButton("Otro");
		GridBagConstraints gbc_otroRadioButton = new GridBagConstraints();
		gbc_otroRadioButton.insets = new Insets(0, 0, 5, 0);
		gbc_otroRadioButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_otroRadioButton.gridx = 2;
		gbc_otroRadioButton.gridy = 2;
		add(otroRadioButton, gbc_otroRadioButton);
        
		// Agrupar los RadioButtons para que solo se pueda seleccionar uno
        ButtonGroup grupoRadioButtons = new ButtonGroup();
        grupoRadioButtons.add(hombreRadioButton);
        grupoRadioButtons.add(mujerRadioButton);
        grupoRadioButtons.add(otroRadioButton);
		
		JLabel labelAlergenos = new JLabel("Alergenos");
		GridBagConstraints gbc_labelAlergenos = new GridBagConstraints();
		gbc_labelAlergenos.insets = new Insets(0, 0, 5, 5);
		gbc_labelAlergenos.gridx = 0;
		gbc_labelAlergenos.gridy = 3;
		add(labelAlergenos, gbc_labelAlergenos);
		
		JButton botonRegistrar = new JButton("Registrar");
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
					JOptionPane.showMessageDialog(ventana, "Algo malo con SQL ha pasado.", "Buena suerte",
							JOptionPane.ERROR_MESSAGE);
				} catch (UsuarioYaExisteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(ventana, "El usuario " + nombre + " ya existe.", "Registro fallido",
							JOptionPane.ERROR_MESSAGE);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(ventana, "Algo malo ha pasado.", "Buena suerte",
							JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		GridBagConstraints gbc_botonRegistrar = new GridBagConstraints();
		gbc_botonRegistrar.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonRegistrar.gridwidth = 3;
		gbc_botonRegistrar.insets = new Insets(0, 0, 0, 5);
		gbc_botonRegistrar.gridx = 0;
		gbc_botonRegistrar.gridy = 6;
		add(botonRegistrar, gbc_botonRegistrar);
	}
	
}
