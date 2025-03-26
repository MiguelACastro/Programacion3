package ventana;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class RompecabezasNumerico extends JFrame{
	
	private JButton[] botones = new JButton[16];
	private Timer cronometro;
	private int hora = 0, minutos = 0, segundos = 0;
		
	public RompecabezasNumerico() {
		this.setTitle("Rompecabezas numerico");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
					verificarGanador();
				}
			});
		}
		
		
		JPanel panelCronometro = new JPanel();
		panelCronometro.setBackground(colorFondo);
		panelCronometro.setLayout(new BoxLayout(panelCronometro, BoxLayout.Y_AXIS));
		panelCronometro.setBorder(BorderFactory.createEmptyBorder(60, 30, 60, 30));
		panelRompecabezas.add(panelCronometro, BorderLayout.EAST);
		
		JLabel etiquetaTiempo = new JLabel("00:00:00");
		etiquetaTiempo.setPreferredSize(new Dimension(200, 50));
		etiquetaTiempo.setFont(fuente);
		etiquetaTiempo.setForeground(Color.WHITE);
		etiquetaTiempo.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelCronometro.add(etiquetaTiempo);
		cronometro = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				segundos++;
				if(segundos > 59) {
					segundos = 0;
					minutos++;
				}
				if(minutos > 59) {
					minutos = 0;
					hora++;
				}
				String tiempo = String.format("%02d:%02d:%02d", hora, minutos, segundos);
				etiquetaTiempo.setText(tiempo);
			}
		});
		panelCronometro.add(Box.createVerticalStrut(20));
		
		JButton botonPausa = new JButton("Pausar");
		botonPausa.setFont(fuente.deriveFont(26f));
		botonPausa.setForeground(Color.DARK_GRAY);
		botonPausa.setBackground(colorBotones);
		botonPausa.setAlignmentX(Component.CENTER_ALIGNMENT);
		botonPausa.addActionListener(new ActionListener() {
			private boolean pausado = false;
			@Override
			public void actionPerformed(ActionEvent e) {
				if(pausado) {
					cronometro.start();
					pausado = false;
					botonPausa.setText("Pausar");
				}
				else if(!pausado) {
					cronometro.stop();
					pausado = true;
					botonPausa.setText("Reanudar");
				}
			}
		});
		panelCronometro.add(botonPausa);
		panelCronometro.add(Box.createVerticalStrut(20));
		
		JButton botonReiniciar = new JButton("Reiniciar");
		botonReiniciar.setForeground(Color.DARK_GRAY);
		botonReiniciar.setBackground(colorBotones);
		botonReiniciar.setFont(fuente.deriveFont(26f));
		botonReiniciar.setAlignmentX(Component.CENTER_ALIGNMENT);
		botonReiniciar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				reiniciar();
			}
		});
		panelCronometro.add(botonReiniciar);
		
		reiniciar();
		return panelRompecabezas;
	}

	private void reiniciar() {
		hora = 0;
		segundos = 0;
		minutos = 0;
		for(int i = 0; i < 16; i++) {
			botones[i].setText(i==15?"":String.valueOf(i+1));
		}
		
		do {			
			shuffle();
		}while(!tieneSolucion());
		
		cronometro.restart();
	}
	
	private void shuffle() {
		Random rng = new Random(System.currentTimeMillis());
		for(int i = 15; i > 0; i--) {
			int j = rng.nextInt(i+1);
			swap(i, j);
		}
	
		System.out.println();
	}
	
	private boolean tieneSolucion() {
		int[] numeros = new int[16];
		
		//Empezando a contar desde 1 desde la ultima fila
		int filaEspacioVacio = 0;
		for(int i = 0; i < 16; i++) {
			if(botones[i].getText().equals("")) {
				numeros[i] = 0;
				filaEspacioVacio = 4 - i/4;
			} else {
				numeros[i] = Integer.valueOf(botones[i].getText());
			}
		}
	    int contadorInversiones = 0;
	    for (int i = 0; i < 15; i++)
	    {
	        for (int j = i + 1; j < 16; j++)
	        {
	            if (numeros[j]!=0 && numeros[i]!=0 && numeros[i] > numeros[j]) {	            	
	            	contadorInversiones++;
	            }
	        }
	    }

	    return (contadorInversiones+filaEspacioVacio) % 2 == 1;
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

	private void verificarGanador() {
		boolean juegoTerminado = true;
		for(int i = 0; i < 15; i++) {
			if(botones[i].getText().equals("")) {
				juegoTerminado = false;
			} else {
				if(!botones[i].getText().equals(String.valueOf(i+1))) {
					juegoTerminado = false;
				}
			}
		}
		
		if(juegoTerminado) {
			cronometro.stop();
			String tiempo = String.format("%d:%02d:%02d", hora, minutos, segundos);
			JOptionPane.showMessageDialog(this, "Has ganado\n Tiempo: " + tiempo);
			reiniciar();
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
