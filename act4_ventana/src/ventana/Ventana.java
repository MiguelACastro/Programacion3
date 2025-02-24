package ventana;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.concurrent.Flow;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Ventana extends JFrame{
	
	private Font fuenteGrande = new Font("Cambria", Font.PLAIN, 28);
	private Font fuenteMediana = fuenteGrande.deriveFont(14f);
	private Font fuenteChica = fuenteGrande.deriveFont(10f);
	
	private Font fuenteTitulo = new Font("Cambria", Font.BOLD, 42);
	
	public Ventana(String titulo) {
		this.setTitle(titulo);
		
		this.setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		this.add(login());
//		this.add(registro());
		this.add(dashboard());
		
		this.pack();
		this.setLocationRelativeTo(null);
		
		this.setMinimumSize(getMinimumSize());
		this.setPreferredSize(getPreferredSize());;
		this.repaint();
	}
	
	public JPanel login() {
		JPanel panelLogin = new JPanel();
		
		panelLogin.setLayout(null);
		panelLogin.setSize(500, 500);
		
		JLabel etiqueta = new JLabel("Bienvenido");
		
		etiqueta.setFont(fuenteGrande);
		etiqueta.setBounds(172, 40, 140, 30);
		etiqueta.setOpaque(true);
		etiqueta.setBackground(Color.ORANGE);		
		etiqueta.setHorizontalAlignment(JLabel.CENTER);
		
		panelLogin.add(etiqueta);
		
		JLabel textoUsuario = new JLabel("Nombre de usuario");
		textoUsuario.setFont(fuenteMediana);
		textoUsuario.setBounds(140, 100, 120, 20);
		panelLogin.add(textoUsuario);
		
		JTextField campoUsuario = new JTextField();
		campoUsuario.setBounds(140, 120, 204, 20);
		panelLogin.add(campoUsuario);
		
		JLabel textoPassword = new JLabel("Contraseña");
		textoPassword.setFont(fuenteMediana);
		textoPassword.setBounds(140, 160, 120, 20);
		panelLogin.add(textoPassword);
		
		JPasswordField campoPassword = new JPasswordField();
		campoPassword.setBounds(140, 180, 204, 20);
		panelLogin.add(campoPassword);
		
		JCheckBox recordar = new JCheckBox("Recordarme");
		recordar.setFont(fuenteChica);
		recordar.setBounds(140, 210, 80, 20);
		panelLogin.add(recordar);
		
		JLabel textoRecuperacion= new JLabel("¿Olvidó su contraseña?");
		textoRecuperacion.setFont(fuenteChica);
		textoRecuperacion.setBounds(250, 210, 120, 20);
		panelLogin.add(textoRecuperacion);
		
		JButton botonLogin = new JButton("Acceder");
		botonLogin.setFont(fuenteMediana);
		botonLogin.setBounds(192, 250, 100, 30);
		panelLogin.add(botonLogin);
		
		panelLogin.revalidate();
		
		return panelLogin;			
	}
	
	public JPanel registro() {
		JPanel panelRegistro = new JPanel();
		
		panelRegistro.setLayout(null);
		panelRegistro.setPreferredSize(new Dimension(500, 500));
		
		JLabel etiqueta = new JLabel("Registro");
		etiqueta.setFont(fuenteGrande);
		etiqueta.setBounds(172, 30, 140, 30);
		etiqueta.setOpaque(true);
		etiqueta.setBackground(Color.ORANGE);		
		etiqueta.setHorizontalAlignment(JLabel.CENTER);
		
		panelRegistro.add(etiqueta);
		
		//Nombre de usuario
		JLabel textoUsuario = new JLabel("Nombre de usuario");
		textoUsuario.setFont(fuenteMediana);
		textoUsuario.setBounds(140, 80, 120, 20);
		textoUsuario.setBackground(Color.ORANGE);
		textoUsuario.setOpaque(true);
		panelRegistro.add(textoUsuario);
		
		JTextField campoUsuario = new JTextField();
		campoUsuario.setBounds(140, 100, 204, 20);
		panelRegistro.add(campoUsuario);
		
		
		//Biografia
		JLabel textoBio = new JLabel("Biografia");
		textoBio.setFont(fuenteMediana);
		textoBio.setBounds(140, 120, 120, 20);
		panelRegistro.add(textoBio);
		
		JTextArea campoBio = new JTextArea();
		campoBio.setBounds(140, 140, 204, 80);
		campoBio.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panelRegistro.add(campoBio);
		
		
		//Preferencias
		JLabel textoPreferencias= new JLabel("Preferencias");
		textoPreferencias.setFont(fuenteMediana);
		textoPreferencias.setBounds(140, 220, 120, 20);
		panelRegistro.add(textoPreferencias);
					
		JCheckBox checkBoxDulce = new JCheckBox("Dulce");
		checkBoxDulce.setFont(fuenteMediana);
		checkBoxDulce.setBounds(140, 240, 80, 20);
		panelRegistro.add(checkBoxDulce);
		
		JCheckBox checkBoxSalado = new JCheckBox("Salado");
		checkBoxSalado.setFont(fuenteMediana);
		checkBoxSalado.setBounds(220, 240, 80, 20);
		panelRegistro.add(checkBoxSalado);
		
		JCheckBox checkBoxSaludable = new JCheckBox("Saludable");
		checkBoxSaludable.setFont(fuenteMediana);
		checkBoxSaludable.setBounds(300, 240, 100, 20);
		panelRegistro.add(checkBoxSaludable);
		
		
		//Terminos
		JLabel textoTerminos = new JLabel("Terminos");
		textoTerminos.setFont(fuenteMediana);
		textoTerminos.setBounds(140, 260, 60, 20);
		textoTerminos.setBackground(Color.ORANGE);
		textoTerminos.setOpaque(true);
		panelRegistro.add(textoTerminos);
		
		JRadioButton botonAceptar = new JRadioButton("Acepto los términos");
		botonAceptar.setFont(fuenteChica);
		botonAceptar.setBounds(140, 280, 120, 20);
		panelRegistro.add(botonAceptar);
		
		JRadioButton botonRechazar = new JRadioButton("No acepto los términos");
		botonRechazar.setFont(fuenteChica);
		botonRechazar.setBounds(260, 280, 130, 20);
		panelRegistro.add(botonRechazar);
		
		ButtonGroup opcionesTerminos = new ButtonGroup();
		opcionesTerminos.add(botonAceptar);
		opcionesTerminos.add(botonRechazar);
		
		
		//Elegir colonia
		JLabel textoColonia = new JLabel("Colonia");
		textoColonia.setFont(fuenteMediana);
		textoColonia.setBounds(140, 300, 50, 20);
		textoColonia.setBackground(Color.ORANGE);
		textoColonia.setBackground(Color.ORANGE);
		textoColonia.setOpaque(true);
		panelRegistro.add(textoColonia);
		
		String[] coloniasDataset = {"Ayuntamiento", "Balandra", "Calafia", "Diana Laura", "El Progreso"};
		
		JComboBox<String> elegirColonia = new JComboBox<String>(coloniasDataset);
		elegirColonia.setBounds(140, 320, 120, 30);
		panelRegistro.add(elegirColonia);
		
		//Boton Crear Cuenta
		JButton botonRegistro = new JButton("Crear Cuenta");
		botonRegistro.setFont(fuenteMediana);
		botonRegistro.setBounds(182, 360, 120, 30);
		panelRegistro.add(botonRegistro);
		
		panelRegistro.revalidate();
		
		return panelRegistro;		
	}
	
	public JPanel dashboard() {
		JPanel panelDashboard = new JPanel(new GridBagLayout());
		panelDashboard.setBorder(new EmptyBorder(0, 20, 20, 20));
		panelDashboard.setBackground(Color.CYAN);
		GridBagConstraints reglas = new GridBagConstraints();
		
		JLabel etiquetaTitulo = new JLabel("Usuarios");
		etiquetaTitulo.setFont(fuenteTitulo);
		etiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaTitulo.setOpaque(true);
		etiquetaTitulo.setBackground(Color.BLACK);
		etiquetaTitulo.setForeground(Color.WHITE);
		reglas.gridx = 1;
		reglas.gridy = 0;
		reglas.gridheight = 1;
		reglas.gridwidth = 1;
		reglas.fill = GridBagConstraints.BOTH;
		reglas.insets = new Insets(20, 20, 20, 20);
		panelDashboard.add(etiquetaTitulo, reglas);
		reglas.insets = new Insets(0, 0, 0, 0);
		
		JLabel etiquetaContador = new JLabel("<html><center>Numero de usuarios<br>100</center></html>");
		etiquetaContador.setFont(fuenteGrande);
		etiquetaContador.setOpaque(true);
		etiquetaContador.setBackground(Color.BLACK);
		etiquetaContador.setForeground(Color.WHITE);
		reglas.gridx = 0;
		reglas.gridy = 1;
		reglas.gridheight = 1;
		reglas.gridwidth = 1;
		reglas.weightx= 1;
		reglas.weighty = 1;
		reglas.fill = GridBagConstraints.NONE;
		reglas.anchor = GridBagConstraints.WEST;
		panelDashboard.add(etiquetaContador, reglas);
		
		JButton botonExportar = new JButton("Exportar");
		botonExportar.setFont(fuenteMediana);
		
		JButton botonAgregar = new JButton("Añadir");
		botonAgregar.setFont(fuenteMediana);
		
		JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
		panelBotones.setBackground(Color.CYAN);
		panelBotones.add(botonExportar);
		panelBotones.add(botonAgregar);
		reglas.gridx = 2;
		reglas.gridy = 2;
		reglas.gridheight = 1;
		reglas.gridwidth = 1;
		reglas.insets = new Insets(0, 50, 0, 0);
		reglas.fill= GridBagConstraints.NONE;
		reglas.anchor = GridBagConstraints.SOUTHEAST;
		panelDashboard.add(panelBotones, reglas);
		reglas.insets = new Insets(0, 0, 0, 0);
		
		String[] nombreColumnas = {"Nombre", "Apellido", "Deporte", "Edad", "Vegetariano"};
		
		Object[][] datos = {
				{"Juan", "Perez", "Futbol", 19, false},
				{"Juan", "Perez", "Futbol", 19, false},
				{"Juan", "Perez", "Futbol", 19, false},
				{"Juan", "Perez", "Futbol", 19, false},
				{"Juan", "Perez", "Futbol", 19, false},
				{"Juan", "Perez", "Futbol", 19, false},
				{"Juan", "Perez", "Futbol", 19, false},
				{"Juan", "Perez", "Futbol", 19, false},
				{"Juan", "Perez", "Futbol", 19, false},
				{"Juan", "Perez", "Futbol", 19, false},
				{"Juan", "Perez", "Futbol", 19, false},
				{"Juan", "Perez", "Futbol", 19, false},
				{"Juan", "Perez", "Futbol", 19, false},
				{"Juan", "Perez", "Futbol", 19, false},
				{"Juan", "Perez", "Futbol", 19, false},
				{"Juan", "Perez", "Futbol", 19, false},
				{"Juan", "Perez", "Futbol", 19, false},
				{"Juan", "Perez", "Futbol", 19, false},
				{"Juan", "Perez", "Futbol", 19, false},
				{"Juan", "Perez", "Futbol", 19, false},
				{"Juan", "Perez", "Futbol", 19, false}
		};
		
		JTable tabla = new JTable(datos, nombreColumnas);
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		JScrollPane scrollPane = new JScrollPane(tabla);
		scrollPane.setPreferredSize(new Dimension(400, 260));
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.setBackground(Color.CYAN);
		reglas.gridx = 0;
		reglas.gridy = 3;
		reglas.gridheight = 1;
		reglas.gridwidth = 3;
		reglas.fill = GridBagConstraints.HORIZONTAL;
		reglas.anchor = GridBagConstraints.NORTH;
		panelDashboard.add(scrollPane, reglas);
		
		return panelDashboard;
	}
}
