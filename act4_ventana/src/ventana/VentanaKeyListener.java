package ventana;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaKeyListener extends JFrame implements KeyListener{

	private PaintPanel panelMovimiento;
	private Player jugador = new Player(235, 235, 30, 30, Color.GREEN);
	private ArrayList<Player> paredes = new ArrayList<Player>();
	
	public VentanaKeyListener() {
		this.setTitle("");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(panel());
		this.setVisible(true);
		this.pack();
		this.setLocationRelativeTo(null);
		
		this.setMinimumSize(getMinimumSize());
		this.setPreferredSize(getPreferredSize());;
	}
	
	public JPanel panel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panelTiempo = new JPanel();
		panel.add(panelTiempo);
		
		JLabel etiquetaTiempo = new JLabel("00:00");
		etiquetaTiempo.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelTiempo.add(etiquetaTiempo);
		
		panelMovimiento = new PaintPanel();
		panelMovimiento.setPreferredSize(new Dimension(500,500));
		panelMovimiento.setMinimumSize(new Dimension(500,500));
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
				jugador.x = 235;
				jugador.y = 235;
				repaint();
				panelMovimiento.requestFocusInWindow();
			}
		});
		panelReiniciar.add(botonReiniciar);
		
		paredes.add(new Player(100, 100, 250, 50, Color.RED));
		paredes.add(new Player(100, 400, 250, 50, Color.RED));
		paredes.add(new Player(300, 100, 50, 250, Color.RED));
		
		return panel;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int codigo = e.getKeyCode();
		
		int direccion = 0;
		System.out.println(codigo);
		if(codigo == KeyEvent.VK_W || codigo == KeyEvent.VK_UP) {
			direccion = Player.UP;
		}
		else if(codigo == KeyEvent.VK_A || codigo == KeyEvent.VK_LEFT) {
			direccion = Player.LEFT;
		}
		else if(codigo == KeyEvent.VK_S || codigo == KeyEvent.VK_DOWN) {
			direccion = Player.DOWN;
		}
		else if(codigo == KeyEvent.VK_D|| codigo == KeyEvent.VK_RIGHT) {
			direccion = Player.RIGHT;
		}
		
		Player siguientePosicion = new Player(jugador.x,jugador.y, jugador.width, jugador.height, Color.RED);
		siguientePosicion.mover(direccion);
		boolean puedeMoverse = true;
		for (Iterator iterator = paredes.iterator(); iterator.hasNext();) {
			Player player = (Player) iterator.next();
			if(siguientePosicion.colision(player)) {
				puedeMoverse = false;
				System.out.println("Colision");
			}
		}
		if(puedeMoverse){	
			jugador.mover(direccion);	
		}
		this.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	class PaintPanel extends JPanel{
		
		public PaintPanel() {
			this.setBackground(Color.BLACK);
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			jugador.paint(g);
			for (Iterator iterator = paredes.iterator(); iterator.hasNext();) {
				Player player = (Player) iterator.next();
				player.paint(g);
			}
			
		}
		
	}
	
	class Player {
		private int x;
		private int y;
		private int width;
		private int height;
		private Color color = Color.GREEN;
		
		private final int velocidad = 5;
		
		public static final int UP = 1;
		public static final int LEFT = 2;
		public static final int RIGHT = 3;
		public static final int DOWN = 4;

		public Player(int x, int y, int width, int height, Color color) {
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
			this.color = color;
		}
		
		public void paint(Graphics g) {
			g.setColor(color);
			g.fillRect(x, y, width, height);
		}
		
		public boolean colision(Player target) {
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
	
}
