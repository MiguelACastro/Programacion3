package ventana;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

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
		Font fuente = new Font("Impact", Font.BOLD, 32);
		Color colorFondo = new Color(26, 28, 30);
		Color colorBotones = new Color(150, 203, 255);
		
		JPanel panelRompecabezas = new JPanel(new BorderLayout());
		panelRompecabezas.setBackground(colorFondo);
		panelRompecabezas.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
		
		JPanel tablero = new JPanel(new GridLayout(4, 4, 10, 10));
		tablero.setBackground(colorFondo);
		panelRompecabezas.add(tablero, BorderLayout.CENTER);
		
		for(int i = 0; i < 16; i++) {
			JButton boton = new JButton();
			boton.setFont(fuente);
			boton.setForeground(Color.DARK_GRAY);
			boton.setBackground(colorBotones);
			boton.setBorder(null);
			boton.setPreferredSize(new Dimension(80, 80));
			botones[i] = boton;
			tablero.add(boton);
			
			int pos = i;
			boton.addActionListener(new ActionListener() {
				
				private int posicion = pos;

				@Override
				public void actionPerformed(ActionEvent e) {
					mover(posicion);
					
				}
			});
		}
		reiniciar();
		
		JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelBoton.setBackground(colorFondo);
		panelBoton.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
		panelRompecabezas.add(panelBoton, BorderLayout.SOUTH);
		
		JButton botonReiniciar = new JButton("Reiniciar");
		botonReiniciar.setForeground(Color.DARK_GRAY);
		botonReiniciar.setBackground(colorBotones);
		botonReiniciar.setFont(fuente.deriveFont(24f).deriveFont(Font.PLAIN));
		botonReiniciar.setBorder(null);
		botonReiniciar.setPreferredSize(new Dimension(200, 50));
		botonReiniciar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				reiniciar();
			}
		});
		panelBoton.add(botonReiniciar);
		
		return panelRompecabezas;
	}

	private void reiniciar() {
		for(int i = 0; i < 16; i++) {
			botones[i].setText(i==15?"":String.valueOf(i+1));
		}
		
		shuffle();
	}
	
	private void shuffle() {
		Random rng = new Random(System.currentTimeMillis());
		for(int i = 15; i > 0; i--) {
			int j = rng.nextInt(15);
			swap(i, j);
		}
	}
	
	private void mover(int posicionActual) {
		int ARRIBA = posicionActual-4;
		int ABAJO = posicionActual+4;
		int DERECHA = posicionActual+1;
		int IZQUIERDA = posicionActual-1;
		
		if(esEspacioVacio(ARRIBA)) {
			swap(posicionActual, ARRIBA);
		}
		else if(esEspacioVacio(DERECHA)) {
			swap(posicionActual, DERECHA);
		}
		else if(esEspacioVacio(IZQUIERDA)) {
			swap(posicionActual, IZQUIERDA);
		}
		else if(esEspacioVacio(ABAJO)) {
			swap(posicionActual, ABAJO);
		}
	}

	private boolean esEspacioVacio(int pos) {
		return pos >= 0 && pos < 16 && botones[pos].getText().equals("");
	}
	

	private void swap(int pos1, int pos2) {
		String temp = botones[pos2].getText();
		botones[pos2].setText(botones[pos1].getText());
		botones[pos1].setText(temp);
	}
}
