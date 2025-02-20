package ventana;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class VentanaCalculadora extends JFrame{
	private Font fuente = new Font("Cambria Math", Font.PLAIN, 18);
	
	public VentanaCalculadora() {
		this.setTitle("Calculadora");
		this.add(calculadora(), SwingConstants.CENTER);
		this.setVisible(true);
		
		
		this.pack();
		this.setLocationRelativeTo(null);
		
		this.setMinimumSize(getMinimumSize());
		this.setPreferredSize(getPreferredSize());
	}
	
	private JPanel calculadora(){
		JPanel panelCalculadora = new JPanel();
		panelCalculadora.setBackground(Color.BLACK);
		panelCalculadora.setBorder(new EmptyBorder(10, 10, 10, 10));
		panelCalculadora.setLayout(new BorderLayout(10, 10));
		
		JLabel areaResultados = new JLabel("300.00");
		areaResultados.setFont(fuente);
		areaResultados.setOpaque(true);
		panelCalculadora.add(areaResultados, BorderLayout.NORTH);
		
		JPanel panelBotones = new JPanel();
		panelBotones.setBackground(Color.BLACK);
		panelBotones.setLayout(new GridLayout(5, 4, 10, 10));
		
		String[] textoBotones = { "CE", " ", " ", " ",
									"7", "8", "9", "/",
									"4", "5", "6", "*",
									"1", "2", "3", "-",
									"0", ".", "=", "+"};
		for(int i = 0; i < 20; i++) {
			JButton boton = new JButton(textoBotones[i]);
			boton.setSize(new Dimension(60, 60));
			boton.setFont(fuente);
			if(textoBotones[i].equals("CE") || textoBotones[i].equals(" ")) {
				boton.setBackground(Color.GRAY);
			}
			else if(textoBotones[i].equals("/") || textoBotones[i].equals("*") || textoBotones[i].equals("-") || textoBotones[i].equals("+") || textoBotones[i].equals("=")) {
				boton.setBackground(new Color(255, 128, 13));
			}
			else {
				boton.setBackground(Color.DARK_GRAY);
			}
			boton.setForeground(Color.WHITE);
			panelBotones.add(boton);
		}
		
		panelCalculadora.add(panelBotones, BorderLayout.CENTER);
		
		return panelCalculadora;
	}
}
