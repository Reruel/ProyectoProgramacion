package interfaces;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import clases.Restaurante;
import excepciones.RestauranteNoExisteException;

import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.GrayFilter;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;

public class PantallaLogueado extends JPanel{
	private Ventana ventana;
	public PantallaLogueado(Ventana v) {
		this.ventana=v;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE, 0.0};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Usuario:" + v.usuarioLogado.getNombre());
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		try {
			Restaurante italiano = new Restaurante("Italiano Da Saveria");
			Restaurante miguel = new Restaurante("Restaurante Miguel");
			Restaurante japones = new Restaurante("Japonés Asakusa");
			Restaurante mcDonalds = new Restaurante("McDonalds");
			Restaurante asador = new Restaurante("Asador La Marca");
			
			Object data[][]={ {italiano.getNombre(), italiano.getCiudad(), "Ver Detalles"},    
					{miguel.getNombre(), miguel.getCiudad(), "Ver Detalles"},    
					{japones.getNombre(), japones.getCiudad(), "Ver Detalles"},
					{mcDonalds.getNombre(), mcDonalds.getCiudad(), "Ver Detalles"},
					{asador.getNombre(), asador.getCiudad(), "Ver Detalles"}};
			
			String column[]={"Restaurante", "Ciudad", "Más detalles"};    
			
			DefaultTableModel model = new DefaultTableModel(data, column);
		    final JTable jt = new JTable(model); 
			jt.setRowHeight(50);
			jt.setCellSelectionEnabled(true);  
			ListSelectionModel select= jt.getSelectionModel();  
			select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
			select.addListSelectionListener(new ListSelectionListener() {  
				public void valueChanged(ListSelectionEvent e) {  
					String Data = null;  
					int row = jt.getSelectedRow();  
					int columns = jt.getSelectedColumn();  
					Data = (String) jt.getValueAt(row, columns); 
					if(Data == "Ver Detalles") {
						System.out.println("Seleccion");
						String restaurante = (String) jt.getValueAt(row, 0);
						JFrame f = new JFrame(restaurante);
						
				        JLabel LabelRestaurante = new JLabel(restaurante);
				        LabelRestaurante.setBounds(50,50, 100,30); 
				        f.add(LabelRestaurante);  
		                
				        JLabel LabelCiudad = new JLabel((String) jt.getValueAt(row, 1));
				        LabelCiudad.setBounds(50,100, 100,30); 
				        f.add(LabelCiudad);
				        
				        f.setSize(300,300);    
		                f.setLayout(null);    
		                f.setVisible(true);     
					}  
					System.out.println("Table element selected is: " + Data);
					
			        
				}       
			});  
			JScrollPane sp=new JScrollPane(jt);  
			GridBagConstraints gbc_sp = new GridBagConstraints();
			gbc_sp.gridx = 0;
			gbc_sp.gridy = 1;
			gbc_sp.gridwidth = 3;
			add(sp, gbc_sp);
		}catch(RestauranteNoExisteException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(ventana, "El restaurante no existe.", "Restaurante fallido",
					JOptionPane.ERROR_MESSAGE);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(ventana, "Algo malo ha pasado.", "Buena suerte",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
