package ventana;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class CalculadoraInteres extends JFrame{
	private Font fuenteTitulo = new Font("Cambria", Font.BOLD, 36);
	private Font fuenteSubtitulo = fuenteTitulo.deriveFont(24f);
	
	private Color lightGreen = new Color(144, 238, 144);
	private Color salmon = new Color(250, 128, 114);
	
	public CalculadoraInteres() {
		this.setTitle("Calculadora de Interés");
		this.add(calculadora(), SwingConstants.CENTER);
		this.setVisible(true);
		
		
		this.pack();
		this.setLocationRelativeTo(null);
		
		this.setMinimumSize(getMinimumSize());
		this.setPreferredSize(getPreferredSize());
	}

	private JPanel calculadora() {
		JPanel panelCalculadora = new JPanel(new BorderLayout(0, 20));
		panelCalculadora.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		panelCalculadora.setBackground(Color.WHITE);
		
		JLabel etiquetaTitulo = new JLabel("Interés");
		etiquetaTitulo.setFont(fuenteTitulo);
		etiquetaTitulo.setForeground(Color.RED);
		panelCalculadora.add(etiquetaTitulo, BorderLayout.NORTH);
		
		JPanel panelSuperior = new JPanel(new BorderLayout(0, 10));
		panelSuperior.setBackground(lightGreen);
		panelSuperior.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Calcular interés", 
								TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.ABOVE_TOP, fuenteSubtitulo));
		panelCalculadora.add(panelSuperior, BorderLayout.CENTER);
		
		JPanel panelEntrada = new JPanel(new GridLayout(3, 2, 5, 10));
		panelEntrada.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
		panelEntrada.setBackground(lightGreen);
		
		JLabel etiquetaCapital = new JLabel("Capital:");
		JTextField campoCapital = new JTextField("1500");
		campoCapital.setMinimumSize(new Dimension(300, 20));
		
		JLabel etiquetaTiempo = new JLabel("Tiempo:");
		JTextField campoTiempo = new JTextField("2");
		
		JLabel etiquetaTasa = new JLabel("Tasa:");
		JTextField campoTasa = new JTextField("0.1");
		
		panelEntrada.add(etiquetaCapital);
		panelEntrada.add(campoCapital);
		panelEntrada.add(etiquetaTiempo);
		panelEntrada.add(campoTiempo);
		panelEntrada.add(etiquetaTasa);
		panelEntrada.add(campoTasa);
		panelSuperior.add(panelEntrada, BorderLayout.NORTH);
		
		JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 100, 0));
		panelBotones.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
		panelBotones.setBackground(lightGreen);
		
		JButton botonCalcular = new JButton("Calcular");
		botonCalcular.setForeground(Color.WHITE);
		botonCalcular.setBackground(Color.DARK_GRAY);
		
		JButton botonCancelar = new JButton("Cancelar");
		botonCancelar.setForeground(Color.WHITE);
		botonCancelar.setBackground(Color.DARK_GRAY);
		
		panelBotones.add(botonCalcular);
		panelBotones.add(botonCancelar);
		panelSuperior.add(panelBotones, BorderLayout.SOUTH);
		
		JPanel panelInferior = new JPanel(new GridLayout(2, 2, 5, 10));
		panelInferior.setBorder(BorderFactory.createEmptyBorder(20, 25, 20, 20));
		panelInferior.setBackground(salmon);
		
		JLabel etiquetaInteres = new JLabel("Interés:");
		JTextField campoInteres = new JTextField("315");
		
		JLabel etiquetaMonto = new JLabel("Monto:");
		JTextField campoMonto = new JTextField("1815");
		
		panelInferior.add(etiquetaInteres);
		panelInferior.add(campoInteres);
		panelInferior.add(etiquetaMonto);
		panelInferior.add(campoMonto);
		panelCalculadora.add(panelInferior, BorderLayout.SOUTH);
		
		return panelCalculadora;
	}
}
