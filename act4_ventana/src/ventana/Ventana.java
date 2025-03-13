package ventana;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Flow;

import javax.imageio.ImageIO;
import javax.print.attribute.standard.JobOriginatingUserName;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class Ventana extends JFrame{
	
	private Font fuenteGrande = new Font("Cambria", Font.PLAIN, 28);
	private Font fuenteMediana = fuenteGrande.deriveFont(14f);
	private Font fuenteChica = fuenteGrande.deriveFont(10f);
	
	private Font fuenteTitulo = new Font("Cambria", Font.BOLD, 36);
	private Font fuenteSubtitulo = fuenteTitulo.deriveFont(32f);
	
	private String usuario = "Osy";
	private String password = "MAP0803";
	
	public static final int LOGIN = 0;
	public static final int REGISTRO = 1;
	public static final int RECUPERACION = 2;
	public static final int ALTA_USUARIO = 3;
	public static final int BAJA_USUARIO = 4;
	public static final int CONSULTA_USUARIO = 5;
	public static final int AYUDA_CREAR_USUARIO = 6;
	public static final int AYUDA_ACCESO = 7;
	public static final int AYUDA_RECUPERACION = 8;
	
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
		
		
		JMenu menuCuenta = new JMenu("Cuenta");
		JMenuItem opcionLogin = new JMenuItem("Login");
		opcionLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				manager(LOGIN);
			}
		});
		JMenuItem opcionRegistro = new JMenuItem("Registro");
		opcionRegistro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				manager(REGISTRO);
			}
		});
		JMenuItem opcionRecuperacion = new JMenuItem("Recuperar cuenta");
		opcionRecuperacion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				manager(RECUPERACION);
			}
		});
		menuCuenta.add(opcionLogin);
		menuCuenta.add(opcionRegistro);
		menuCuenta.add(opcionRecuperacion);
		
		JMenu menuUsuario = new JMenu("Usuario");
		
		
		JMenuItem opcionAlta = new JMenuItem("Alta");
		opcionAlta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				manager(ALTA_USUARIO);
			}
		});
		JMenuItem opcionBaja = new JMenuItem("Baja");
		opcionBaja.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				manager(BAJA_USUARIO);
			}
		});
		JMenuItem opcionConsulta = new JMenuItem("Consulta");
		opcionConsulta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				manager(CONSULTA_USUARIO);
			}
		});
		menuUsuario.add(opcionAlta);
		menuUsuario.add(opcionBaja);
		menuUsuario.add(opcionConsulta);
		
		JMenu menuAyuda = new JMenu("Ayuda");
		JMenuItem opcionAyudaCrearCuenta = new JMenuItem("¿Cómo crear un usuario?");
		opcionAyudaCrearCuenta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				manager(AYUDA_CREAR_USUARIO);
			}
		});
		JMenuItem opcionAyudaAcceso = new JMenuItem("¿Cómo acceder al sistema?");
		opcionAyudaAcceso.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				manager(AYUDA_ACCESO);
			}
		});
		JMenuItem opcionAyudaRecuperacion = new JMenuItem("¿Qué pasa si olvidé mi contraseña?");
		opcionAyudaRecuperacion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				manager(AYUDA_RECUPERACION);
			}
		});
		menuAyuda.add(opcionAyudaCrearCuenta);
		menuAyuda.add(opcionAyudaAcceso);
		menuAyuda.add(opcionAyudaRecuperacion);
		
		barra.add(menuCuenta);
		barra.add(menuUsuario);
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
		
		JPanel panelEtiquetas = new JPanel();
		
		JLabel etiquetaRecuperacion= new JLabel("¿Olvidó su contraseña?");
		etiquetaRecuperacion.setFont(fuenteChica);
		etiquetaRecuperacion.setBounds(250, 210, 120, 20);
		panelEtiquetas.add(etiquetaRecuperacion);
		panelEtiquetas.add(Box.createHorizontalStrut(50));
		
		
		JLabel etiquetaCrearCuenta = new JLabel("Crear cuenta");
		etiquetaCrearCuenta.setFont(fuenteChica);
		etiquetaCrearCuenta.setBounds(250, 210, 120, 20);
		panelEtiquetas.add(etiquetaCrearCuenta);
		
		JFrame frame = this;
		etiquetaCrearCuenta.addMouseListener(new MouseListener() {
			
			
			
			@Override
			public void mouseEntered(MouseEvent e) {
				etiquetaCrearCuenta.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				manager(REGISTRO);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
		});
		
		
		panelEtiquetas.setAlignmentX(LEFT_ALIGNMENT);
		panelLogin.add(panelEtiquetas);
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
		botonLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean flag1 = false;;
				boolean flag2 = false;;
				if(campoUsuario.getText().length() == 0 || campoUsuario.getText().chars().anyMatch(c -> c == ' ')) {
					campoUsuario.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
				} else {
					campoUsuario.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
					flag1 = true;
				}
				
				String paswd = new String(campoPassword.getPassword()); 
				if(paswd.length() < 6 || paswd.chars().anyMatch(c->c ==' ')) {
					campoPassword.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
				} else {
					campoPassword.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
					flag2 = true;
				}
				
				if(flag1 && flag2) {
					if(campoUsuario.getText().equals(usuario) && paswd.equals(password)) {
						JOptionPane.showMessageDialog(null, "Bienvenido!", "Credenciales correctas", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Credenciales incorrectas", JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
		});
		
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
		botonAceptar.setActionCommand("Si");
		panelRegistro.add(botonAceptar);
		
		JRadioButton botonRechazar = new JRadioButton("No acepto los términos");
		botonRechazar.setFont(fuenteChica);
		botonRechazar.setBounds(260, 280, 130, 20);
		botonRechazar.setActionCommand("No");
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
		
		botonRegistro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(campoUsuario.getText().length() == 0 || campoUsuario.getText().chars().anyMatch(c -> c == ' ')) {
					campoUsuario.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
				} else {
					campoUsuario.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
				}
				
				if(campoBio.getText().length() > 0 && campoBio.getText().length() < 5) {
					campoBio.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
				} else {
					campoBio.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
				}
				
				if(!checkBoxDulce.isSelected() && !checkBoxSalado.isSelected() && !checkBoxSaludable.isSelected()) {
					textoPreferencias.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
				} else {
					textoPreferencias.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
				}
				
				if(opcionesTerminos.getSelection() == null || opcionesTerminos.getSelection().getActionCommand().equals("No")) {
					textoTerminos.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
				} else {
					textoTerminos.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
				}
				
			}
		});
		
		JLabel etiquetaCrearCuenta = new JLabel("¿Ya tiene una cuenta? Iniciar sesión");
		etiquetaCrearCuenta.setFont(fuenteChica);
		etiquetaCrearCuenta.setBounds(170, 400, 160, 20);
		panelRegistro.add(etiquetaCrearCuenta);
		
		JFrame frame = this;
		etiquetaCrearCuenta.addMouseListener(new MouseListener() {
			
			
			
			@Override
			public void mouseEntered(MouseEvent e) {
				etiquetaCrearCuenta.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				manager(LOGIN);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
		});
		
		panelRegistro.revalidate();
		
		return panelRegistro;		
	}
	
	public JPanel recuperacion() {
		JPanel panelRecuperacion = new JPanel(new BorderLayout());
		JLabel titulo = new JLabel("Recuperar cuenta");
		titulo.setFont(fuenteTitulo);
		panelRecuperacion.add(titulo, BorderLayout.NORTH);
		return panelRecuperacion;
	}
	
	public JPanel alta() {
		JPanel panelAlta = new JPanel(new BorderLayout());
		JLabel titulo = new JLabel("Dar de alta usuario");
		titulo.setFont(fuenteTitulo);
		panelAlta.add(titulo, BorderLayout.NORTH);
		return panelAlta;
	}
	
	public JPanel baja() {
		JPanel panelBaja = new JPanel(new BorderLayout());
		JLabel titulo = new JLabel("Dar de baja usuario");
		titulo.setFont(fuenteTitulo);
		panelBaja.add(titulo, BorderLayout.NORTH);
		return panelBaja;
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
		scrollPane.setMinimumSize(new Dimension(500, 200));
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
	
	public JPanel ayudaCrearCuenta() {
		JPanel panelAyuda = new JPanel(new BorderLayout());
		JLabel titulo = new JLabel("¿Cómo crear un usuario?");
		titulo.setFont(fuenteTitulo);
		panelAyuda.add(titulo, BorderLayout.NORTH);
		return panelAyuda;
	}
	
	public JPanel ayudaAcceso() {
		JPanel panelAyuda = new JPanel(new BorderLayout());
		JLabel titulo = new JLabel("¿Cómo acceder al sistema?");
		titulo.setFont(fuenteTitulo);
		panelAyuda.add(titulo, BorderLayout.NORTH);
		return panelAyuda;
	}
	
	public JPanel ayudaRecuperacion() {
		JPanel panelAyuda = new JPanel(new BorderLayout());
		JLabel titulo = new JLabel("¿Qué pasa si olvidé mi contraseña?");
		titulo.setFont(fuenteTitulo);
		panelAyuda.add(titulo, BorderLayout.NORTH);
		return panelAyuda;
	}
	
	public void manager(int target) {
		this.getContentPane().removeAll();
		this.setMinimumSize(new Dimension(600, 600));
		switch (target) {
		case LOGIN:
			this.add(login());
			break;
		case REGISTRO:
			this.add(registro());
			break;
		case RECUPERACION:
			this.add(recuperacion());
			break;
		case ALTA_USUARIO:
			this.add(alta());
			break;
		case BAJA_USUARIO:
			this.add(baja());
			break;
		case CONSULTA_USUARIO:
			this.add(dashboard());
			break;
		case AYUDA_CREAR_USUARIO:
			this.add(ayudaCrearCuenta());
			break;
		case AYUDA_ACCESO:
			this.add(ayudaAcceso());
			break;
		case AYUDA_RECUPERACION:
			this.add(ayudaRecuperacion());
			break;
		default:
			break;
		}
		this.pack();
		this.setLocationRelativeTo(null);
		this.setMinimumSize(getMinimumSize());
		this.setPreferredSize(getPreferredSize());
		this.revalidate();
		
	}
	
//	public void paint(Graphics g) {
//		super.paint(g);
//		Graphics2D g2d = (Graphics2D) g;
//		
//		g2d.setColor(Color.RED);
//		
//		g2d.drawRect(80, 80, 200, 200);
//		g2d.fillRect(100, 100, 100, 100);
//		g2d.clearRect(120, 120, 20, 20);
//		
//		g2d.setColor(Color.GREEN);
//		
//		g2d.fillRoundRect(200, 100 , 100, 100, 30, 30);
//		
//		g2d.setColor(Color.BLUE);
//		g2d.setStroke(new BasicStroke(5));
//		
//		g2d.drawLine(100, 100, 500, 300);
//		
//		g2d.drawOval(300, 150, 100, 70);
//		g2d.fillOval(300, 100, 50, 20);
//		
//		g2d.drawArc(50, 200, 100, 100, 0, -180);
//		g2d.fillArc(50, 170, 20, 20, 0, 360);
//		g2d.fillArc(130, 170, 20, 20, 0, 360);
//		
//		g2d.setColor(Color.BLACK);
//		g2d.setFont(new Font("Arial", Font.BOLD, 50));
//		g2d.drawString("HOLA", 200, 300);
//		
//		AffineTransform transform = AffineTransform.getTranslateInstance(200, 100);
//		transform.concatenate(AffineTransform.getScaleInstance(0.1, 0.1));
//		
//		g2d.drawImage(getIconImage(), transform, null);
//		
//		int[] xs = {100, 100, 250};
//		int[] ys = {100, 200, 250};
//		
//		g2d.drawPolygon(xs, ys, 3);
//		
//		int[] xs2 = {500, 450, 500};
//		int[] ys2 = {300, 220, 150};
//		
//		g2d.fillPolygon(xs2, ys2, 3);
//	}
}
