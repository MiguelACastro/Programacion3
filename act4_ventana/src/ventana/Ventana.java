package ventana;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ventana extends JFrame{
	
	private Font fuenteEtiqueta = new Font("Cambria", Font.PLAIN, 28);
	
	public Ventana(String titulo) {
		this.setTitle(titulo);
		this.setSize(500, 500);
		
		this.setResizable(true);
		this.setVisible(true);

		this.setLayout(null);
		this.setLocationRelativeTo(null);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setMinimumSize(new Dimension(400, 400));
		this.setMaximumSize(new Dimension(600, 600));
		
		this.add(login());
		this.repaint();
	}
	
	public JPanel login() {
		JPanel panelLogin = new JPanel();
		
		panelLogin.setLayout(null);
		panelLogin.setSize(500, 500);
		panelLogin.setBackground(Color.RED);
		
		JLabel etiqueta = new JLabel("Bienvenido");
		
		etiqueta.setFont(fuenteEtiqueta);
		etiqueta.setBounds(172, 20, 140, 30);
		etiqueta.setOpaque(true);
		etiqueta.setBackground(Color.ORANGE);		
		etiqueta.setHorizontalAlignment(JLabel.CENTER);
		
		panelLogin.add(etiqueta);
		
		panelLogin.revalidate();
		return panelLogin;			
	}
}
