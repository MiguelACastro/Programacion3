package ventana;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class VentanaKeyListener extends JFrame implements KeyListener{

	private int x = 235, y=235;
	
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
		
		PaintPanel panelMovimiento = new PaintPanel();
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
				panelMovimiento.requestFocusInWindow();
			}
		});
		panelReiniciar.add(botonReiniciar);
		
		return panel;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int codigo = e.getKeyCode();
		System.out.println(codigo);
		if(codigo == KeyEvent.VK_W || codigo == KeyEvent.VK_UP) {
			y-=5;
			
		}
		else if(codigo == KeyEvent.VK_A || codigo == KeyEvent.VK_LEFT) {
			x-=5;
			
		}
		else if(codigo == KeyEvent.VK_S || codigo == KeyEvent.VK_DOWN) {
			y+=5;
			
		}
		else if(codigo == KeyEvent.VK_D|| codigo == KeyEvent.VK_RIGHT) {
			x+=5;
			
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
			g.setColor(Color.GREEN);
			g.fillRect(x, y, 30, 30);
		}
		
	}
}
