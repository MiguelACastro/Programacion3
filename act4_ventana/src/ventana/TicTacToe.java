package ventana;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TicTacToe extends JFrame{
	
	private JButton[][] tablero = new JButton[3][3];
	private boolean turno = true;
	private String jugador = "X";
	private boolean juegoTerminado = false;
	
	public TicTacToe() {
		this.setTitle("Tic-Tac-Toe");
		this.setVisible(true);
		this.setResizable(false);
		this.add(tablero());
		this.pack();
		this.setLocationRelativeTo(null);
		
		this.setMinimumSize(getMinimumSize());
		this.setPreferredSize(getPreferredSize());;
	}

	private JPanel tablero() {
		JPanel panelGato = new JPanel(new BorderLayout());
		JLabel etiquetaTurno = new JLabel("Turno: " + jugador);
		etiquetaTurno.setHorizontalAlignment(SwingConstants.CENTER);
		panelGato.add(etiquetaTurno, BorderLayout.NORTH);
		
		JPanel panelTablero = new JPanel(new GridLayout(3, 3, 10, 10));

		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				JButton boton = new JButton();
				boton.setPreferredSize(new Dimension(100, 100));
				
				boton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if(turno) {
							turno = false;
							jugador = "X";
						} else {
							turno = true;
							jugador = "O";
						}
						boton.setEnabled(false);
						etiquetaTurno.setText("Turno: " + (turno?"X":"O"));
						boton.setText(jugador);
						verificar();
					}
				});
				tablero[i][j] = boton;
				panelTablero.add(boton);
			}
		}
		panelGato.add(panelTablero, BorderLayout.CENTER);
		return panelGato;
	}

	private void verificar() {
		for(int i = 0; i < 3; i++) {
			System.out.println("\n");
			if(!juegoTerminado && !tablero[i][0].isEnabled() && tablero[i][0].getText().equals(tablero[i][1].getText()) && tablero[i][1].getText().equals(tablero[i][2].getText())) {
				JOptionPane.showMessageDialog(this, "Gana: " + jugador, "Juego terminado", JOptionPane.INFORMATION_MESSAGE);
				juegoTerminado = true;
			}	
		}
		for(int i = 0; i < 3; i++) {
			System.out.println("\n");
			if(!juegoTerminado && !tablero[0][i].isEnabled() && tablero[0][i].getText().equals(tablero[1][i].getText()) && tablero[1][i].getText().equals(tablero[2][i].getText())) {
				JOptionPane.showMessageDialog(this, "Gana: " + jugador, "Juego terminado", JOptionPane.INFORMATION_MESSAGE);
				juegoTerminado = true;
			}	
		}
		
		if(!juegoTerminado && !tablero[0][0].isEnabled() && tablero[0][0].getText().equals(tablero[1][1].getText()) && tablero[1][1].getText().equals(tablero[2][2].getText())) {
			JOptionPane.showMessageDialog(this, "Gana: " + jugador, "Juego terminado", JOptionPane.INFORMATION_MESSAGE);
			juegoTerminado = true;
		}
		
		if(!juegoTerminado && !tablero[0][2].isEnabled() && tablero[2][0].getText().equals(tablero[1][1].getText()) && tablero[1][1].getText().equals(tablero[0][2].getText())) {
			JOptionPane.showMessageDialog(this, "Gana: " + jugador, "Juego terminado", JOptionPane.INFORMATION_MESSAGE);
			juegoTerminado = true;
		}
		
		if(!juegoTerminado) {	
			boolean empate = true;
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					if(tablero[i][j].isEnabled()) {
						empate = false;
					}
				}
			}
			if(empate) {
				JOptionPane.showMessageDialog(this, "Empate", "Juego terminado", JOptionPane.INFORMATION_MESSAGE);
				juegoTerminado = true;
			}
		}
		if(juegoTerminado) {
			reiniciarJuego();
		}
	}

	private void reiniciarJuego() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				tablero[i][j].setText("");
				tablero[i][j].setEnabled(true);
			}
		}
		juegoTerminado = false;
		
	}
	
}
