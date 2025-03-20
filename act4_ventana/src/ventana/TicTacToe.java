package ventana;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class TicTacToe extends JFrame{
	
	private Font fuenteEtiqueta = new Font("Cambria", Font.BOLD, 20);
	
	private final static int X = 0;
	private final static int O = 1;

	private JButton[][] tablero = new JButton[3][3];
	private int turno = O;
	String jugador = "X";
	private boolean juegoTerminado = false;
	private ImageIcon[] jugadores = new ImageIcon[2];
	private int[] contadorVictorias = {0,0};
	public TicTacToe() {
		loadIcons();
		this.setTitle("Tic-Tac-Toe");
		this.setVisible(true);
		this.setResizable(false);
		this.add(tablero());
		this.pack();
		this.setLocationRelativeTo(null);
		
		this.setMinimumSize(getMinimumSize());
		this.setPreferredSize(getPreferredSize());;
	}

	private void loadIcons() {
		ClassLoader cl = this.getClass().getClassLoader();
		
		URL UrlX = cl.getResource("x.png");
		Image imgX = new ImageIcon(UrlX).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		
		URL UrlO = cl.getResource("o.png");
		Image imgO = new ImageIcon(UrlO).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		
		jugadores[0] = new ImageIcon(imgX);
		jugadores[1] = new ImageIcon(imgO);
		
	}
	
	private JPanel tablero() {
		JPanel panelGato = new JPanel(new BorderLayout());
		
		JPanel panelEtiquetas = new JPanel();
		panelEtiquetas.setBackground(new Color(8, 115, 170));
		
		panelEtiquetas.setLayout(new BoxLayout(panelEtiquetas, BoxLayout.X_AXIS));
		
		JLabel etiquetaTurno = new JLabel("Turno: " + jugador);
		etiquetaTurno.setFont(fuenteEtiqueta);
		etiquetaTurno.setForeground(Color.WHITE);
		
		JLabel etiquetaVictoriasX = new JLabel("X: 0");
		etiquetaVictoriasX.setFont(fuenteEtiqueta);
		etiquetaVictoriasX.setForeground(Color.WHITE);
		
		JLabel etiquetaVictoriasO = new JLabel("O: 0");
		etiquetaVictoriasO.setFont(fuenteEtiqueta);
		etiquetaVictoriasO.setForeground(Color.WHITE);
		
		panelEtiquetas.add(etiquetaVictoriasX);
		panelEtiquetas.add(Box.createHorizontalGlue());
		panelEtiquetas.add(etiquetaTurno);
		panelEtiquetas.add(Box.createHorizontalGlue());
		panelEtiquetas.add(etiquetaVictoriasO);
		
		
		panelGato.add(panelEtiquetas, BorderLayout.NORTH);
		
		JPanel panelTablero = new JPanel(new GridLayout(3, 3, 10, 10));
		panelTablero.setBackground(new Color(8, 115, 170));
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				JButton boton = new JButton();
				boton.setBackground(new Color(94, 173, 232));
				boton.setPreferredSize(new Dimension(100, 100));
				boton.setActionCommand("");
				boton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if(turno == X) {
							turno = O;
							jugador = "X";
						} else {
							turno = X;
							jugador = "O";
						}
						etiquetaTurno.setText("Turno: " + jugador);
						
						boton.setEnabled(false);
						boton.setDisabledIcon(jugadores[turno]);
						boton.setIcon(jugadores[turno]);
						boton.setActionCommand(jugador);
						verificar();
						etiquetaVictoriasX.setText("X: " + contadorVictorias[X]);
						etiquetaVictoriasO.setText("O: " + contadorVictorias[O]);
					}
				});
				tablero[i][j] = boton;
				panelTablero.add(boton);
			}
		}
		panelGato.add(panelTablero, BorderLayout.CENTER);
		
		JButton reiniciar = new JButton("Reiniciar");
		reiniciar.setBackground(new Color(65, 202, 243));
		reiniciar.setForeground(Color.BLACK);
		
		reiniciar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				reiniciarJuego();
			}
		});
		panelGato.add(reiniciar, BorderLayout.SOUTH);
		
		return panelGato;
	}

	private void verificar() {
		jugador = (turno == X?"X":"O");
		for(int i = 0; i < 3; i++) {
			System.out.println("\n");
			if(!juegoTerminado && !tablero[i][0].isEnabled() && tablero[i][0].getActionCommand().equals(tablero[i][1].getActionCommand()) && tablero[i][1].getActionCommand().equals(tablero[i][2].getActionCommand())) {
				JOptionPane.showMessageDialog(this, "Gana: " + jugador, "Juego terminado", JOptionPane.INFORMATION_MESSAGE);
				juegoTerminado = true;
			}	
		}
		for(int i = 0; i < 3; i++) {
			System.out.println("\n");
			if(!juegoTerminado && !tablero[0][i].isEnabled() && tablero[0][i].getActionCommand().equals(tablero[1][i].getActionCommand()) && tablero[1][i].getActionCommand().equals(tablero[2][i].getActionCommand())) {
				JOptionPane.showMessageDialog(this, "Gana: " + jugador, "Juego terminado", JOptionPane.INFORMATION_MESSAGE);
				juegoTerminado = true;
			}	
		}
		
		if(!juegoTerminado && !tablero[0][0].isEnabled() && tablero[0][0].getActionCommand().equals(tablero[1][1].getActionCommand()) && tablero[1][1].getActionCommand().equals(tablero[2][2].getActionCommand())) {
			JOptionPane.showMessageDialog(this, "Gana: " + jugador, "Juego terminado", JOptionPane.INFORMATION_MESSAGE);
			juegoTerminado = true;
		}
		
		if(!juegoTerminado && !tablero[0][2].isEnabled() && tablero[2][0].getActionCommand().equals(tablero[1][1].getActionCommand()) && tablero[1][1].getActionCommand().equals(tablero[0][2].getActionCommand())) {
			JOptionPane.showMessageDialog(this, "Gana: " + jugador, "Juego terminado", JOptionPane.INFORMATION_MESSAGE);
			juegoTerminado = true;
		}
		
		boolean empate = false;
		if(!juegoTerminado) {	
			int cont = 0;
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					if(!tablero[i][j].isEnabled()) {
						cont++;
					}
				}
			}
			if(cont == 9) {
				empate = true;
			}
			if(empate) {
				JOptionPane.showMessageDialog(this, "Empate", "Juego terminado", JOptionPane.INFORMATION_MESSAGE);
				juegoTerminado = true;
			}
		}
		if(juegoTerminado) {
			if(!empate) {
				contadorVictorias[turno]++;
			}
			reiniciarJuego();
		}
	}

	private void reiniciarJuego() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				tablero[i][j].setIcon(null);
				tablero[i][j].setEnabled(true);
				tablero[i][j].setActionCommand("");
			}
		}
		juegoTerminado = false;
	}
	
}
