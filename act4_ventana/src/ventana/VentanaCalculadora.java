package ventana;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

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
		panelCalculadora.setLayout(new GridBagLayout());
		GridBagConstraints reglas = new GridBagConstraints();
		
		
		JLabel areaResultados = new JLabel("300.00");
		areaResultados.setFont(fuente);
		areaResultados.setOpaque(true);
		//El componente se encuentra en la celda (0, 0)
		reglas.gridx = 0;
		reglas.gridy = 0;
		//El componente solo ocupa una celda de espacio
		reglas.gridheight = 1;
		reglas.gridwidth = 1; 
		//Dimensiones de la celda
		reglas.weightx = 1.0; //Ancho, es su valor maximo
		reglas.weighty = 0.5; //Altura, es la mitad de su valor maximo
		//Ambos componentes ocupan todo el espacio posible
		reglas.fill = GridBagConstraints.BOTH;
		//Espacio entre la etiqueta y los botones
		reglas.insets = new Insets(0, 0, 10, 0);
		
		panelCalculadora.add(areaResultados, reglas);
		reglas.insets = new Insets(0, 0, 0, 0); //Reiniciar los insets
		
		JPanel panelBotones = new JPanel();
		panelBotones.setBackground(Color.BLACK);
		panelBotones.setLayout(new GridLayout(5, 4, 10, 10));
		
		String[] textoBotones = { "MC", "M+", "+/-", "CE",
									"7", "8", "9", "/",
									"4", "5", "6", "*",
									"1", "2", "3", "-",
									"0", ".", "=", "+"};
		for(int i = 0; i < 20; i++) {
			JButton boton = new JButton(textoBotones[i]);
			boton.setSize(new Dimension(60, 60));
			boton.setFont(fuente);
			if(textoBotones[i].equals("MC") || textoBotones[i].equals("M+")) {
				boton.setBackground(Color.RED);
			}
			else if(textoBotones[i].equals("CE") || textoBotones[i].equals("+/-")) {
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
		reglas.gridx = 0;
		reglas.gridy = 1;
		reglas.gridheight = 1;
		reglas.gridwidth = 1;
		reglas.weighty = 1;
		reglas.fill = GridBagConstraints.BOTH;

		panelCalculadora.add(panelBotones, reglas);
		
		return panelCalculadora;
	}
}
