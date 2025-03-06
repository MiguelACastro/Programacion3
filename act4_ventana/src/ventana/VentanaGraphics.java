package ventana;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaGraphics extends JFrame{
	
	public VentanaGraphics() {
		this.setSize(800, 600);
		this.setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		this.setLocationRelativeTo(null);
		
		JPanel canvas = new JPanel();
		canvas.setBackground(new Color(1, 190, 254));
		
		this.add(canvas);
		
		this.setMinimumSize(getMinimumSize());
		this.setPreferredSize(getPreferredSize());;
		this.repaint();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D) g;
		pintarCasa(g2d);
	}
	
	public void pintarCasa(Graphics2D g2d) {
		//Suelo
		g2d.setColor(new Color(103, 75, 2));
		g2d.fillRect(0, 570, 800, 30);
		
		g2d.setColor(new Color(214, 183, 90));
		g2d.fillRect(0, 540, 800, 30);
		
		g2d.setColor(new Color(104, 150, 6));
		g2d.fillRect(0, 510, 800, 30);
		
		g2d.setColor(new Color(53, 77, 0));
		g2d.fillRect(0, 500, 800, 10);
		
		g2d.setColor(new Color(224, 145, 28));
		g2d.fillRect(0, 380, 800, 100);
		
		//Cerco
		int[] xCerco = {18, 18, 38, 58, 58};
		int[] yCerco = {500, 350, 330, 350, 500};
		
		Polygon cerco = new Polygon(xCerco, yCerco, 5);
		
		g2d.setColor(new Color(255, 181, 51));
		g2d.fillPolygon(cerco);
		
		while(cerco.getBounds2D().getMaxX() <= 800) {
			cerco.translate(60, 0);
			g2d.fillPolygon(cerco);
		}
		
		//Base
		g2d.setColor(new Color(102, 102, 102));
		g2d.fillRect(200, 470, 400, 30);
		
		//Pared
		g2d.setColor(new Color(255, 213, 98));
		g2d.fillRect(220, 250, 360, 220);
		
		//Textura
		g2d.setColor(new Color(100, 74, 3));
		g2d.setStroke(new BasicStroke(2));
		int y = 230;
		while(y <= 470) {
			g2d.drawLine(220, y, 580, y);
			y+=40;
		}
		
		//Puerta
		g2d.setColor(new Color(159, 110, 0));
		g2d.fillRect(250, 300, 80, 170);
		
		//Perilla
		g2d.setColor(Color.LIGHT_GRAY);
		g2d.fillOval(310, 375, 10, 10);
		
		//Cristal
		g2d.setColor(Color.WHITE);
		g2d.fillRect(460, 300, 90, 90);
		
		//Marco
		g2d.setColor(new Color(162, 36, 37));
		g2d.setStroke(new BasicStroke(5));
		
		g2d.drawRect(460, 300, 90, 90);
		g2d.drawLine(505, 300, 505, 390);
		g2d.drawLine(460, 345, 550, 345);
		
		//Chimenea
		g2d.setColor(new Color(128, 128, 128));
		g2d.fillRect(490, 150, 60, 100);
		
		g2d.setColor(new Color(102, 102, 102));
		g2d.fillRect(480, 120, 80, 30);
		
		//Techo
		g2d.setColor(new Color(162, 36, 37));
		
		int[] xTecho = {190, 350, 610};
		int[] yTecho = {250, 100, 250};
		Polygon techo = new Polygon(xTecho, yTecho, 3);
		
		g2d.fillPolygon(techo);
	}
	
	
}
