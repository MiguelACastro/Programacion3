package ventana;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Ventana extends JFrame{
	
	private Font fuenteGrande = new Font("Cambria", Font.PLAIN, 28);
	private Font fuenteMediana = fuenteGrande.deriveFont(14f);
	private Font fuenteChica = fuenteGrande.deriveFont(10f);
	
	public Ventana(String titulo) {
		this.setTitle(titulo);
		this.setSize(500, 500);
		
		this.setResizable(true);
		this.setVisible(true);

		this.setLayout(null);
		this.setLocationRelativeTo(null);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setMinimumSize(new Dimension(400, 400));
		this.setMaximumSize(new Dimension(600, 600));
		
		this.add(login());
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
}
