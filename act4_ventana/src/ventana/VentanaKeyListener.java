package ventana;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.geom.Rectangle2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class VentanaKeyListener extends JFrame implements KeyListener{

	private PaintPanel panelMovimiento;
	private Player jugador = new Player(30, 30, 20, 20, Color.GREEN);
	private ArrayList<Entidad> paredes = new ArrayList<Entidad>();
	private int direccionMovimiento;
	private Entidad meta;
	
	
	private Timer cronometro;
	private int segundos = 0;
	private int minutos = 0;
	private int horas = 0;

	private Timer movimiento;
	private final int ACTUALIZACIONES_POR_SEGUNDO = 120;
	private final int MS_PER_UPDATE = 1000/ACTUALIZACIONES_POR_SEGUNDO;
	
	private Icon imagenFinal;
	private JLabel etiquetaTiempo;
	
	public VentanaKeyListener() {
		this.setTitle("");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(panel());
		this.setVisible(true);
		this.pack();
		this.setLocationRelativeTo(null);
		
		this.setMinimumSize(getMinimumSize());
		this.setPreferredSize(getPreferredSize());;
		this.setResizable(false);
		movimiento = new Timer(MS_PER_UPDATE, new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				actualizar();
				repaint();
			}
		});
	}
	
	public JPanel panel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panelTiempo = new JPanel();
		panel.add(panelTiempo);
		
		etiquetaTiempo = new JLabel("00:00:00");
		etiquetaTiempo.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelTiempo.add(etiquetaTiempo);
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
					horas++;
				}
				String tiempo = String.format("%02d:%02d:%02d", horas, minutos, segundos);
				etiquetaTiempo.setText(tiempo);
			}
		});
		
		panelMovimiento = new PaintPanel();
		panelMovimiento.setPreferredSize(new Dimension(650,620));
		panelMovimiento.setMinimumSize(new Dimension(650,620));
		panelMovimiento.addKeyListener(this);
		panelMovimiento.setFocusable(true);
		panelMovimiento.requestFocusInWindow();
		panel.add(panelMovimiento);
		
		JPanel panelReiniciar = new JPanel();
		panel.add(panelReiniciar);
		
		JButton botonReiniciar = new JButton("Reiniciar");
		botonReiniciar.setAlignmentX(Component.CENTER_ALIGNMENT);
		botonReiniciar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				reiniciar();
			}
		});
		panelReiniciar.add(botonReiniciar);
		
		inicializarParedes();
		URL UrlMeta = this.getClass().getResource("sun.png");
		Image imgMeta = new ImageIcon(UrlMeta).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		meta = new Entidad(592, 585, 30, 30, imgMeta);
		
		URL UrlFinal = this.getClass().getResource("final.png");
		Image imgFinal = new ImageIcon(UrlFinal).getImage().getScaledInstance(150, 107, Image.SCALE_SMOOTH);
		imagenFinal = new ImageIcon(imgFinal);
		return panel;
	}
	
	private void reiniciar() {
		jugador.x = 30;
		jugador.y = 30;
		direccionMovimiento = 0;
		segundos = 0;
		minutos = 0;
		horas = 0;
		etiquetaTiempo.setText("00:00:00");
		cronometro.stop();
		repaint();
		panelMovimiento.requestFocusInWindow();
	}
	
	private void inicializarParedes() {
		Color colorPared = new Color(28, 54, 104);
		final int grosor = 5;
		paredes.add(new Entidad(20, 20, grosor, 600, colorPared));
		paredes.add(new Entidad(50, 20, grosor, 145, colorPared));
		paredes.add(new Entidad(50, 225, grosor, 60, colorPared));
		paredes.add(new Entidad(50, 405, grosor, 30, colorPared));
		paredes.add(new Entidad(50, 495, grosor, 60, colorPared));

		paredes.add(new Entidad(20, 20, 600,grosor, colorPared));
		paredes.add(new Entidad(110, 50, 35, grosor, colorPared));
		paredes.add(new Entidad(260, 50, 120, grosor, colorPared));
		paredes.add(new Entidad(440, 50, 30, grosor, colorPared));
		paredes.add(new Entidad(500, 50, 30, grosor, colorPared));
		paredes.add(new Entidad(560, 50, 30, grosor, colorPared));

		paredes.add(new Entidad(80, 20, grosor, 50, colorPared));
		paredes.add(new Entidad(80, 225, grosor, 30, colorPared));
		paredes.add(new Entidad(80, 315, grosor, 65, colorPared));
		paredes.add(new Entidad(80, 405, grosor, 35, colorPared));
		paredes.add(new Entidad(80, 470, grosor, 30, colorPared));
		paredes.add(new Entidad(80, 590, grosor, 30, colorPared));
		
		paredes.add(new Entidad(230, 75, 35,grosor, colorPared));
		paredes.add(new Entidad(320, 75, 90, grosor, colorPared));
		paredes.add(new Entidad(470, 75, 30, grosor, colorPared));
		paredes.add(new Entidad(530, 75, 30, grosor, colorPared));
		
		paredes.add(new Entidad(110, 50, grosor, 80, colorPared));
		paredes.add(new Entidad(110, 255, grosor, 60, colorPared));
		paredes.add(new Entidad(110, 345, grosor, 60, colorPared));
		paredes.add(new Entidad(110, 495, grosor, 90, colorPared));
		
		paredes.add(new Entidad(90, 105, 25, grosor, colorPared));
		paredes.add(new Entidad(170, 105, 30, grosor, colorPared));
		paredes.add(new Entidad(230, 105, 30, grosor, colorPared));
		paredes.add(new Entidad(320, 105, 60, grosor, colorPared));
		paredes.add(new Entidad(440, 105, 35, grosor, colorPared));
		paredes.add(new Entidad(500, 105, 30, grosor, colorPared));
		paredes.add(new Entidad(560, 105, 60, grosor, colorPared));
		
		paredes.add(new Entidad(140, 50, grosor, 85, colorPared));
		paredes.add(new Entidad(140, 195, grosor, 30, colorPared));
		paredes.add(new Entidad(140, 255, grosor, 30, colorPared));
		paredes.add(new Entidad(140, 435, grosor, 30, colorPared));
		paredes.add(new Entidad(140, 525, grosor, 90, colorPared));
		
		paredes.add(new Entidad(50, 135, 25, grosor, colorPared));
		paredes.add(new Entidad(140, 135, 90, grosor, colorPared));
		paredes.add(new Entidad(260, 135, 90, grosor, colorPared));
		paredes.add(new Entidad(440, 135, 60, grosor, colorPared));	
		paredes.add(new Entidad(530, 135, 30, grosor, colorPared));			
		
		paredes.add(new Entidad(170, 135, grosor, 50, colorPared));
		paredes.add(new Entidad(170, 80, grosor, 25, colorPared));
		paredes.add(new Entidad(170, 225, grosor, 30, colorPared));
		paredes.add(new Entidad(170, 285, grosor, 60, colorPared));
		paredes.add(new Entidad(170, 405, grosor, 60, colorPared));
		paredes.add(new Entidad(170, 560, grosor, 30, colorPared));
		
		paredes.add(new Entidad(50, 165, 120, grosor, colorPared));		
		paredes.add(new Entidad(200, 165, 90, grosor, colorPared));		
		paredes.add(new Entidad(560, 165, 30, grosor, colorPared));
		
		paredes.add(new Entidad(200, 20, grosor, 90, colorPared));
		paredes.add(new Entidad(200, 165, grosor, 60, colorPared));
		paredes.add(new Entidad(200, 255, grosor, 80, colorPared));
		paredes.add(new Entidad(200, 380, grosor, 30, colorPared));
		paredes.add(new Entidad(200, 465, grosor, 30, colorPared));
		paredes.add(new Entidad(200, 525, grosor, 30, colorPared));
		paredes.add(new Entidad(200, 585, grosor, 30, colorPared));
		
		paredes.add(new Entidad(20, 195, 120, grosor, colorPared));
		paredes.add(new Entidad(235, 195, 25, grosor, colorPared));
		paredes.add(new Entidad(290, 195, 30, grosor, colorPared));
		paredes.add(new Entidad(380, 195, 60, grosor, colorPared));
		paredes.add(new Entidad(500, 195, 50, grosor, colorPared));
		
		paredes.add(new Entidad(230, 50, grosor, 25, colorPared));
		paredes.add(new Entidad(230, 105, grosor, 35, colorPared));
		paredes.add(new Entidad(230, 255, grosor, 25, colorPared));
		paredes.add(new Entidad(230, 315, grosor, 25, colorPared));
		paredes.add(new Entidad(230, 405, grosor, 60, colorPared));
		paredes.add(new Entidad(230, 495, grosor, 90, colorPared));
		
		paredes.add(new Entidad(50, 225, 30, grosor, colorPared));
		paredes.add(new Entidad(120, 225, 170, grosor, colorPared));
		paredes.add(new Entidad(470, 225, 30, grosor, colorPared));
		paredes.add(new Entidad(530, 225, 65, grosor, colorPared));
		
		paredes.add(new Entidad(260, 80, grosor, 30, colorPared));
		paredes.add(new Entidad(260, 140, grosor, 30, colorPared));
		paredes.add(new Entidad(260, 195, grosor, 30, colorPared));
		paredes.add(new Entidad(260, 285, grosor, 90, colorPared));
		paredes.add(new Entidad(260, 405, grosor, 30, colorPared));
		paredes.add(new Entidad(260, 465, grosor, 30, colorPared));
		
		paredes.add(new Entidad(80, 255, 30, grosor, colorPared));
		paredes.add(new Entidad(200, 255, 120, grosor, colorPared));
		paredes.add(new Entidad(350, 255, 60, grosor, colorPared));
		paredes.add(new Entidad(440, 255, 70, grosor, colorPared));
		paredes.add(new Entidad(560, 255, 30, grosor, colorPared));
		
		paredes.add(new Entidad(290, 50, grosor, 90, colorPared));
		paredes.add(new Entidad(290, 315, grosor, 30, colorPared));
		paredes.add(new Entidad(290, 375, grosor, 30, colorPared));
		paredes.add(new Entidad(290, 435, grosor, 30, colorPared));
		paredes.add(new Entidad(290, 495, grosor, 60, colorPared));
		
		paredes.add(new Entidad(50, 285, 30, grosor, colorPared));
		paredes.add(new Entidad(140, 285, 60, grosor, colorPared));
		paredes.add(new Entidad(260, 285, 90, grosor, colorPared));
		paredes.add(new Entidad(380, 285, 60, grosor, colorPared));
		paredes.add(new Entidad(470, 285, 30, grosor, colorPared));
		paredes.add(new Entidad(530, 285, 30, grosor, colorPared));
		
		paredes.add(new Entidad(320, 80, grosor, 25, colorPared));
		paredes.add(new Entidad(320, 165, grosor, 95, colorPared));
		paredes.add(new Entidad(320, 315, grosor, 60, colorPared));
		paredes.add(new Entidad(320, 435, grosor, 65, colorPared));
		
		paredes.add(new Entidad(20, 315, 30, grosor, colorPared));
		paredes.add(new Entidad(80, 315, 60, grosor, colorPared));
		paredes.add(new Entidad(230, 315, 30, grosor, colorPared));
		paredes.add(new Entidad(290, 315, 30, grosor, colorPared));
		paredes.add(new Entidad(380, 315, 90, grosor, colorPared));
		paredes.add(new Entidad(500, 315, 90, grosor, colorPared));
		
		paredes.add(new Entidad(350, 135, grosor, 210, colorPared));
		paredes.add(new Entidad(350, 495, grosor, 30, colorPared));
		paredes.add(new Entidad(350, 555, grosor, 30, colorPared));
		//115
		paredes.add(new Entidad(50, 345, 30, grosor, colorPared));
		paredes.add(new Entidad(110, 345, 65, grosor, colorPared));
		paredes.add(new Entidad(410, 345, 90, grosor, colorPared));
		paredes.add(new Entidad(530, 345, 60, grosor, colorPared));
		
		paredes.add(new Entidad(380, 105, grosor, 120, colorPared));
		paredes.add(new Entidad(380, 285, grosor, 90, colorPared));
		paredes.add(new Entidad(380, 405, grosor, 30, colorPared));
		paredes.add(new Entidad(380, 465, grosor, 30, colorPared));
		paredes.add(new Entidad(380, 525, grosor, 60, colorPared));
		
		paredes.add(new Entidad(20, 375, 60, grosor, colorPared));
		paredes.add(new Entidad(140, 375, 150, grosor, colorPared));
		paredes.add(new Entidad(320, 375, 90, grosor, colorPared));
		paredes.add(new Entidad(470, 375, 30, grosor, colorPared));
		paredes.add(new Entidad(560, 375, 60, grosor, colorPared));
		
		paredes.add(new Entidad(410, 20, grosor, 140, colorPared));
		paredes.add(new Entidad(410, 225, grosor, 35, colorPared));
		paredes.add(new Entidad(410, 375, grosor, 30, colorPared));
		paredes.add(new Entidad(410, 435, grosor, 30, colorPared));
		paredes.add(new Entidad(410, 495, grosor, 60, colorPared));
		paredes.add(new Entidad(410, 585, grosor, 30, colorPared));
		
		paredes.add(new Entidad(80, 405, 120, grosor, colorPared));
		paredes.add(new Entidad(260, 405, 120, grosor, colorPared));
		paredes.add(new Entidad(410, 405, 35, grosor, colorPared));
		paredes.add(new Entidad(500, 405, 60, grosor, colorPared));
		
		paredes.add(new Entidad(440, 50, grosor, 30, colorPared));
		paredes.add(new Entidad(440, 135, grosor, 155, colorPared));
		paredes.add(new Entidad(440, 375, grosor, 30, colorPared));
		paredes.add(new Entidad(440, 525, grosor, 60, colorPared));		
		
		paredes.add(new Entidad(50, 435, 30, grosor, colorPared));
		paredes.add(new Entidad(110, 435, 30, grosor, colorPared));
		paredes.add(new Entidad(200, 435, 30, grosor, colorPared));
		paredes.add(new Entidad(290, 435, 30, grosor, colorPared));
		paredes.add(new Entidad(350, 435, 120, grosor, colorPared));

		paredes.add(new Entidad(470, 20, grosor, 35, colorPared));		
		paredes.add(new Entidad(470, 75, grosor, 30, colorPared));		
		paredes.add(new Entidad(470, 175, grosor, 55, colorPared));		
		paredes.add(new Entidad(470, 345, grosor, 95, colorPared));		
		paredes.add(new Entidad(470, 495, grosor, 30, colorPared));		
		paredes.add(new Entidad(470, 585, grosor, 30, colorPared));		

		paredes.add(new Entidad(20, 465, 125, grosor, colorPared));
		paredes.add(new Entidad(170, 465, 30, grosor, colorPared));
		paredes.add(new Entidad(230, 465, 65, grosor, colorPared));
		paredes.add(new Entidad(320, 465, 30, grosor, colorPared));
		paredes.add(new Entidad(410, 465, 90, grosor, colorPared));
		paredes.add(new Entidad(560, 465, 35, grosor, colorPared));

		paredes.add(new Entidad(500, 50, grosor, 30, colorPared));		
		paredes.add(new Entidad(500, 105, grosor, 60, colorPared));		
		paredes.add(new Entidad(500, 195, grosor, 35, colorPared));		
		paredes.add(new Entidad(500, 285, grosor, 65, colorPared));		
		paredes.add(new Entidad(500, 405, grosor, 30, colorPared));		
		paredes.add(new Entidad(500, 465, grosor, 60, colorPared));		
		paredes.add(new Entidad(500, 555, grosor, 30, colorPared));	

		paredes.add(new Entidad(110, 495, 120, grosor, colorPared));
		paredes.add(new Entidad(290, 495, 30, grosor, colorPared));
		paredes.add(new Entidad(350, 495, 120, grosor, colorPared));
		paredes.add(new Entidad(560, 495, 35, grosor, colorPared));
		
		paredes.add(new Entidad(530, 50, grosor, 60, colorPared));	
		paredes.add(new Entidad(530, 135, grosor, 60, colorPared));	
		paredes.add(new Entidad(530, 225, grosor, 60, colorPared));	
		paredes.add(new Entidad(530, 345, grosor, 60, colorPared));	
		paredes.add(new Entidad(530, 435, grosor, 120, colorPared));	

		paredes.add(new Entidad(50, 525, 30, grosor, colorPared));
		paredes.add(new Entidad(140, 525, 30, grosor, colorPared));
		paredes.add(new Entidad(230, 525, 30, grosor, colorPared));
		paredes.add(new Entidad(320, 525, 35, grosor, colorPared));
		paredes.add(new Entidad(500, 525, 30, grosor, colorPared));
		paredes.add(new Entidad(590, 525, 30, grosor, colorPared));
		
		paredes.add(new Entidad(560, 105, grosor, 35, colorPared));	
		paredes.add(new Entidad(560, 405, grosor, 60, colorPared));	
		paredes.add(new Entidad(560, 495, grosor, 90, colorPared));	

		paredes.add(new Entidad(50, 555, 60, grosor, colorPared));
		paredes.add(new Entidad(170, 555, 60, grosor, colorPared));
		paredes.add(new Entidad(260, 555, 120, grosor, colorPared));
		paredes.add(new Entidad(410, 555, 90, grosor, colorPared));
		
		paredes.add(new Entidad(590, 50, grosor, 60, colorPared));	
		paredes.add(new Entidad(590, 135, grosor, 90, colorPared));	
		paredes.add(new Entidad(590, 255, grosor, 95, colorPared));	
		paredes.add(new Entidad(590, 375, grosor, 60, colorPared));	
		paredes.add(new Entidad(590, 465, grosor, 30, colorPared));	
		paredes.add(new Entidad(590, 525, grosor, 60, colorPared));	
		paredes.add(new Entidad(620, 20, grosor, 600, colorPared));	
		
		paredes.add(new Entidad(50, 585, 35, grosor, colorPared));
		paredes.add(new Entidad(230, 585, 90, grosor, colorPared));
		paredes.add(new Entidad(380, 585, 30, grosor, colorPared));
		paredes.add(new Entidad(500, 585, 65, grosor, colorPared));
		paredes.add(new Entidad(20, 615, 570, grosor, colorPared));
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		cronometro.start();
		movimiento.start();
		int codigo = e.getKeyCode();
		
		System.out.println(codigo);
		if(codigo == KeyEvent.VK_W || codigo == KeyEvent.VK_UP) {
			direccionMovimiento = Entidad.UP;
		}
		else if(codigo == KeyEvent.VK_A || codigo == KeyEvent.VK_LEFT) {
			direccionMovimiento = Entidad.LEFT;
		}
		else if(codigo == KeyEvent.VK_S || codigo == KeyEvent.VK_DOWN) {
			direccionMovimiento = Entidad.DOWN;
		}
		else if(codigo == KeyEvent.VK_D|| codigo == KeyEvent.VK_RIGHT) {
			direccionMovimiento = Entidad.RIGHT;
		}
		else if(codigo == KeyEvent.VK_SPACE) {
			direccionMovimiento = 0;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void actualizar() {
		Entidad siguientePosicion = new Entidad(jugador.x,jugador.y, jugador.width, jugador.height, Color.RED);
		siguientePosicion.mover(direccionMovimiento);
		boolean puedeMoverse = true;
		for (Iterator iterator = paredes.iterator(); iterator.hasNext();) {
			Entidad player = (Entidad) iterator.next();
			if(siguientePosicion.colision(player)) {
				puedeMoverse = false;
				System.out.println("Colision");
			}
		}
		if(jugador.colision(meta)) {
			puedeMoverse = false;
			cronometro.stop();
			JOptionPane.showMessageDialog(this, "Tiempo: "+horas+":"+minutos+":"+segundos, "Has ganado!", 
					JOptionPane.INFORMATION_MESSAGE, imagenFinal);
			reiniciar();
		}
		if(puedeMoverse){	
			jugador.mover(direccionMovimiento);	
		}
	}
	
	class PaintPanel extends JPanel{
		
		public PaintPanel() {
			this.setBackground(new Color(17, 151, 101));
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			jugador.paint(g);
			for (Iterator iterator = paredes.iterator(); iterator.hasNext();) {
				Entidad player = (Entidad) iterator.next();
				player.paint(g);
			}
			meta.paint(g);
		}
		
	}
	
	class Entidad {
		protected int x;
		protected int y;
		protected int width;
		protected int height;
		protected Color color = Color.GREEN;
		protected Image sprite;
		
		protected final int velocidad = 1;
		public static final int UP = 1;
		public static final int LEFT = 2;
		public static final int RIGHT = 3;
		public static final int DOWN = 4;
		
		public Entidad(int x, int y, int width, int height, Color color) {
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
			this.color = color;
		}
		
		public Entidad(int x, int y, int width, int height, Image sprite) {
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
			this.sprite = sprite;
		}
		
		public void paint(Graphics g) {
			g.setColor(color);
			if(sprite != null ) {
				g.drawImage(sprite, x, y, null);
			}
			else {				
				g.fillRect(x, y, width, height);
			}
		}
		
		public boolean colision(Entidad target) {
			return (this.x < target.x + target.width &&
	                 this.x+ this.width > target.x &&
	                 this.y < target.y + target.height &&
	                 this.y + this.height > target.y);
		}
		
		public void mover(int direccion) {
			switch (direccion) {
			case UP:
				if(y <= -height) {
					y = panelMovimiento.getHeight();
				} else {				
					y-=velocidad;
				}	
				break;
			case LEFT:
				if(x <= -width) {
					x = panelMovimiento.getWidth();
				} else {				
					x-=velocidad;
				}
				break;
			case RIGHT:		
				if(x >= panelMovimiento.getWidth()+width) {
					x = 0;
				} else {				
					x+=velocidad;
				}
				break;
			case DOWN: 
				if(y >= panelMovimiento.getHeight()+height) {
					y = 0;
				} else {				
					y+=velocidad;
				}
				break;
			};	
		}
	}
	
	class Player extends Entidad {

		private Image imagenUp;
		private Image imagenLeft;
		private Image imagenRight;
		private Image imagenDown;
		
		public Player(int x, int y, int width, int height, Color color) {
			super(x, y, width, height, color);
			URL UrlUp = this.getClass().getResource("nikoUp.png");
			imagenUp = new ImageIcon(UrlUp).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
			
			URL UrlDown = this.getClass().getResource("nikoDown.png");
			imagenDown = new ImageIcon(UrlDown).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
			
			URL UrlLeft = this.getClass().getResource("nikoLeft.png");
			imagenLeft = new ImageIcon(UrlLeft).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
			
			URL UrlRight = this.getClass().getResource("nikoRight.png");
			imagenRight = new ImageIcon(UrlRight).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
			sprite = imagenDown;
		}
		
		@Override
		public void paint(Graphics g) {
			switch (direccionMovimiento) {
			case UP:
				sprite = imagenUp;
				break;
			case LEFT:
				sprite = imagenLeft;
				break;
			case RIGHT:
				sprite = imagenRight;
				break;
			case DOWN:
				sprite = imagenDown;
				break;	
			}
			g.drawImage(sprite, x, y, null);
		}
	}
	
}
