package ventana;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RompecabezasNumerico extends JFrame{
	
	private JButton[] botones = new JButton[16];
	
	
	public RompecabezasNumerico() {
		this.setTitle("Rompecabezas numerico");
		this.setVisible(true);
		this.add(rompecabezas());
		this.pack();
		this.setLocationRelativeTo(null);
		
		this.setMinimumSize(getMinimumSize());
		this.setPreferredSize(getPreferredSize());;
	}

	private JPanel rompecabezas() {
		Font fuente = new Font("Cambria", Font.PLAIN, 24);
		Color colorFondo = new Color(26, 28, 30);
		Color colorBotones = new Color(150, 203, 255);
		
		JPanel panelRompecabezas = new JPanel(new BorderLayout());
		panelRompecabezas.setBackground(colorFondo);
		panelRompecabezas.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
		
		JPanel tablero = new JPanel(new GridLayout(4, 4, 10, 10));
		tablero.setBackground(colorFondo);
		panelRompecabezas.add(tablero, BorderLayout.CENTER);
		
		for(int i = 0; i < 16; i++) {
			JButton boton = new JButton(i==15?" ":String.valueOf(i+1));
			boton.setFont(fuente);
			boton.setBackground(colorBotones);
			boton.setBorder(null);
			boton.setPreferredSize(new Dimension(80, 80));
			tablero.add(boton);
		}
		
		JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelBoton.setBackground(colorFondo);
		panelBoton.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
		panelRompecabezas.add(panelBoton, BorderLayout.SOUTH);
		
		JButton botonReiniciar = new JButton("Reiniciar");
		botonReiniciar.setFont(fuente);
		botonReiniciar.setBackground(colorBotones);
		botonReiniciar.setBorder(null);
		botonReiniciar.setPreferredSize(new Dimension(200, 50));
		panelBoton.add(botonReiniciar);
		
		return panelRompecabezas;
	}
}
