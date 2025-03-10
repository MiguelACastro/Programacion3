package ventana;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Flow;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
	
	private Font fuenteTitulo = new Font("Cambria", Font.BOLD, 36);
	private Font fuenteSubtitulo = fuenteTitulo.deriveFont(32f);
	
	public Ventana(String titulo) {
		this.setTitle(titulo);
		this.setIconImage(new ImageIcon("img/logo.png").getImage());		
		this.setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.add(login());
//		this.add(registro());
//		this.add(dashboard());
		this.setJMenuBar(menu());
		
		this.pack();
		this.setLocationRelativeTo(null);
		
		this.setMinimumSize(getMinimumSize());
		this.setPreferredSize(getPreferredSize());;
		
		this.revalidate();
		this.repaint();
	}
	
	public JMenuBar menu() {
		JMenuBar barra = new JMenuBar();
		
		JMenu menuArchivo = new JMenu("Archivo");
		
		JMenuItem opcionNuevo = new JMenuItem("Nuevo");	
		JMenuItem opcionAbrir = new JMenuItem("Abrir");	
		JMenuItem opcionGuardar = new JMenuItem("Guardar");	
		JCheckBoxMenuItem opcionGuardadoAutomatico = new JCheckBoxMenuItem("Guardado automatico");
		JMenuItem opcionCerrar = new JMenuItem("Cerrar");	
		
		menuArchivo.add(opcionNuevo);
		menuArchivo.add(opcionAbrir);
		menuArchivo.addSeparator();
		menuArchivo.add(opcionGuardar);
		menuArchivo.add(opcionGuardadoAutomatico);
		menuArchivo.addSeparator();
		menuArchivo.add(opcionCerrar);
		
		barra.add(menuArchivo);
		
		JMenu menuAyuda = new JMenu("Ayuda");
		
		barra.add(menuAyuda);
		
		return barra;
	}
	public JPanel login() {
		JPanel panelFondo = new JPanel(new BorderLayout());
		panelFondo.setBackground(Color.RED);
		panelFondo.setBorder(new EmptyBorder(30, 30, 30, 30)); //Margenes 
		
		JPanel panelImagen = new JPanel(new BorderLayout());
		panelImagen.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
	
		JLabel etiquetaBienvenida = new JLabel("¡Bienvenido de nuevo!");
		etiquetaBienvenida.setFont(fuenteTitulo);
		panelImagen.add(etiquetaBienvenida, BorderLayout.NORTH);
		
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(new File("img/logo.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image imagenLogo = bufferedImage.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		JLabel logo = new JLabel(new ImageIcon(imagenLogo));	
		panelImagen.add(logo, BorderLayout.SOUTH);
		
		JPanel panelLogin = new JPanel();
		panelLogin.setLayout(new BoxLayout(panelLogin, BoxLayout.Y_AXIS));
		
		JLabel etiquetaLogin = new JLabel("Iniciar sesión");
		etiquetaLogin.setFont(fuenteSubtitulo);	
		etiquetaLogin.setHorizontalAlignment(JLabel.CENTER);
		panelLogin.add(etiquetaLogin);
		panelLogin.add(Box.createRigidArea(new Dimension(0, 30)));
		
		JLabel etiquetaUsuario = new JLabel("Nombre de usuario");
		etiquetaUsuario.setFont(fuenteMediana);
		panelLogin.add(etiquetaUsuario);
		
		try {
			bufferedImage = ImageIO.read(new File("img/usuario.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image imagenUsuario = bufferedImage.getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		JTextField campoUsuario = new JTextField(){  
            protected void paintComponent(Graphics g) {  
                super.paintComponent(g);  
                int y = (getHeight() - imagenUsuario.getHeight(null))/2;  
                g.drawImage(imagenUsuario, 0, y, this);  
            }  
        };  ;
		campoUsuario.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		panelLogin.add(campoUsuario);
		panelLogin.add(Box.createRigidArea(new Dimension(0, 10)));
		
		JLabel etiquetaPassword = new JLabel("Contraseña");
		etiquetaPassword.setFont(fuenteMediana);
		etiquetaPassword.setBounds(140, 160, 120, 20);
		panelLogin.add(etiquetaPassword);
		
		try {
			bufferedImage = ImageIO.read(new File("img/password.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image imagenPassword = bufferedImage.getScaledInstance(18, 18, Image.SCALE_DEFAULT);
		JPasswordField campoPassword = new JPasswordField(){  
            protected void paintComponent(Graphics g) {  
                super.paintComponent(g);  
                int y = (getHeight() - imagenPassword.getHeight(null))/2;  
                g.drawImage(imagenPassword, 0, y, this);  
            }  
        };;
		campoPassword.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		campoPassword.setBounds(140, 180, 204, 20);
		panelLogin.add(campoPassword);
		panelLogin.add(Box.createRigidArea(new Dimension(0, 5)));
		
		JLabel etiquetaRecuperacion= new JLabel("¿Olvidó su contraseña?");
		etiquetaRecuperacion.setFont(fuenteChica);
		etiquetaRecuperacion.setBounds(250, 210, 120, 20);
		panelLogin.add(etiquetaRecuperacion);
		panelLogin.add(Box.createRigidArea(new Dimension(0, 10)));
		
		JCheckBox recordar = new JCheckBox("Recordarme");
		recordar.setFont(fuenteChica);
		recordar.setBounds(140, 210, 80, 20);
		panelLogin.add(recordar);
		panelLogin.add(Box.createRigidArea(new Dimension(0, 10)));
		
		
		JButton botonLogin = new JButton("Acceder");
		botonLogin.setFont(fuenteMediana);
		botonLogin.setBounds(192, 250, 100, 30);
		panelLogin.add(botonLogin);
		
		JPanel panelInterfaz = new JPanel(new GridBagLayout());
		panelInterfaz.add(panelImagen);
		panelInterfaz.add(panelLogin);
		panelLogin.revalidate();
		
		panelFondo.add(panelInterfaz, BorderLayout.CENTER);
		return panelFondo;			
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
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(Color.RED);
		
		g2d.drawRect(80, 80, 200, 200);
		g2d.fillRect(100, 100, 100, 100);
		g2d.clearRect(120, 120, 20, 20);
		
		g2d.setColor(Color.GREEN);
		
		g2d.fillRoundRect(200, 100 , 100, 100, 30, 30);
		
		g2d.setColor(Color.BLUE);
		g2d.setStroke(new BasicStroke(5));
		
		g2d.drawLine(100, 100, 500, 300);
		
		g2d.drawOval(300, 150, 100, 70);
		g2d.fillOval(300, 100, 50, 20);
		
		g2d.drawArc(50, 200, 100, 100, 0, -180);
		g2d.fillArc(50, 170, 20, 20, 0, 360);
		g2d.fillArc(130, 170, 20, 20, 0, 360);
		
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("Arial", Font.BOLD, 50));
		g2d.drawString("HOLA", 200, 300);
		
		AffineTransform transform = AffineTransform.getTranslateInstance(200, 100);
		transform.concatenate(AffineTransform.getScaleInstance(0.1, 0.1));
		
		g2d.drawImage(getIconImage(), transform, null);
		
		int[] xs = {100, 100, 250};
		int[] ys = {100, 200, 250};
		
		g2d.drawPolygon(xs, ys, 3);
		
		int[] xs2 = {500, 450, 500};
		int[] ys2 = {300, 220, 150};
		
		g2d.fillPolygon(xs2, ys2, 3);
	}
}
