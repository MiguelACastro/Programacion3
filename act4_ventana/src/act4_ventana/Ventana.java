package act4_ventana;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ventana extends JFrame{
	
	public Ventana(String titulo) {
		this.setTitle(titulo);
		this.setSize(500, 500);
		
		this.setResizable(true);
		this.setVisible(true);

		this.setLayout(null);
		this.setLocationRelativeTo(null);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel etiqueta = new JLabel("Bienvenido");
		etiqueta.setBounds(200, 200, 65, 30);
		etiqueta.setOpaque(true);
		etiqueta.setBackground(Color.ORANGE);
		
		this.add(etiqueta);
	}
}
