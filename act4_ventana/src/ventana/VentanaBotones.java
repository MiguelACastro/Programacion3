package ventana;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaBotones extends JFrame{
	
	public VentanaBotones() {
		this.setSize(600, 600);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.add(botones());
	}

	private JPanel botones() {
		JPanel panelBotones = new JPanel();
		panelBotones.setBounds(0, 0, 600, 600);
		panelBotones.setBackground(Color.GREEN);
		
		JButton botonGenerador = new JButton("CLICK ME!");
		botonGenerador.setBounds(100, 400, 400, 100);
		JFrame frame = this;
		botonGenerador.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Random rng = new Random(System.currentTimeMillis());
				
				JButton nuevoBoton = new JButton("click me");
				nuevoBoton.setLocation(rng.nextInt(600), rng.nextInt(600));
				nuevoBoton.setSize(rng.nextInt(50, 100), rng.nextInt(50, 100));
				nuevoBoton.setBackground(new Color(rng.nextInt(256), rng.nextInt(256), rng.nextInt(256)));
				
				panelBotones.add(nuevoBoton);
				
				frame.repaint();
			}
		});
		panelBotones.add(botonGenerador);
		
		return panelBotones ;
	}
	
	
}
