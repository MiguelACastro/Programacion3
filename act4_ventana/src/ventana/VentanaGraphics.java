package ventana;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LinearGradientPaint;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaGraphics extends JFrame{
	private final Font fuente = new Font("Bauhaus 93", Font.PLAIN, 50);
	
	public VentanaGraphics() {
//		this.setSize(800, 600);
		this.setSize(1000, 750);
		this.setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		this.setLocationRelativeTo(null);
		
		JPanel canvas = new JPanel();
//		canvas.setBackground(new Color(1, 190, 254));
		
		this.add(canvas);
		
		this.setMinimumSize(getMinimumSize());
		this.setPreferredSize(getPreferredSize());;
		this.repaint();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D) g;
//		pintarCasa(g2d);
//		pintarSMB3(g2d);
		pintarSMW(g2d);
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
	
	private void pintarSMB3(Graphics2D g2d) {
		//Cielo
		GradientPaint gradienteCielo = new GradientPaint(0, 0, new Color(106, 153, 244),
				0, 673, new Color(146, 192, 244));
		g2d.setPaint(gradienteCielo);
		g2d.fillRect(0, 0, 1000, 673);
		
		//Fondo
		g2d.setColor(new Color(102, 173, 210));
		g2d.fillRoundRect(15, 550, 50, 220, 50, 50);
		g2d.fillRoundRect(65, 550, 40, 220, 50, 50);
		g2d.fillRoundRect(400, 550, 55, 220, 50, 50);
		g2d.fillRoundRect(455, 550, 30, 220, 50, 50);
		g2d.fillRoundRect(580, 570, 40, 200, 50, 50);
		g2d.fillRoundRect(620, 550, 35, 230, 50, 50);
		g2d.setColor(new Color(89, 160, 198));
		g2d.fillRoundRect(0, 570, 50, 200, 50, 50);
		g2d.fillRoundRect(50, 590, 50, 190, 50, 50);
		g2d.fillRoundRect(380, 600, 50, 170, 50, 50);
		g2d.fillRoundRect(430, 570, 50, 200, 50, 50);
		g2d.fillRoundRect(560, 550, 30, 220, 50, 50);
		g2d.fillRoundRect(590, 600, 55, 170, 50, 50);
		
		//Suelo
		g2d.setColor(new Color(173, 97, 36));
		g2d.fillRect(0, 700, 1000, 50);
		
		g2d.setColor(new Color(216, 127, 66));
		g2d.fillRect(0, 685, 1000, 15);
		
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(6));
	
		g2d.drawLine(0, 682, 1000, 682);
		
		GradientPaint gradienteSuelo = new GradientPaint(0, 672, new Color(241, 166, 110),
									0, 682, new Color(78, 43, 22));
		g2d.setPaint(gradienteSuelo);
		g2d.fillRect(0, 672, 1000, 10);
		
		g2d.setPaint(null);
		
		//Plataforma azul fondo
		g2d.setColor(new Color(128, 207, 236));
		g2d.fillRect(110, 490, 200, 180);
		
		g2d.setColor(new Color(83, 159, 209));
		g2d.fillRect(115, 495, 13, 13);
		g2d.setColor(new Color(155, 232, 246));
		g2d.setStroke(new BasicStroke(7));
		g2d.drawLine(110, 490, 310, 490);
		g2d.drawLine(110, 490, 110, 510);
		g2d.fillRect(113, 493, 10, 10);
		
		//Plataforma coral fondo
		g2d.setColor(new Color(242, 185, 131));
		g2d.fillRect(360, 550, 40, 120);
		
		g2d.setColor(new Color(230, 160, 103));
		g2d.drawLine(400, 550, 400, 665);
		g2d.drawLine(360, 550, 400, 550);
		
		g2d.setColor(new Color(225, 136, 81));
		g2d.setStroke(new BasicStroke(3));
		g2d.drawLine(402, 550, 402, 668);
		g2d.fillRect(393, 554, 11, 11);
		
		g2d.setColor(new Color(248, 208, 153));
		g2d.setStroke(new BasicStroke(5));
		g2d.drawLine(360, 553, 390, 553);
		g2d.fillRect(390, 551, 10, 10);
		//Plataforma azul
		this.drawPlataforma(g2d, 200, 400, 160, 270, new Color(88, 199, 244), new Color(8, 83, 177));
		
		//Sombra
		g2d.setColor(new Color(6, 79, 178));
		g2d.fillRect(250, 540, 30, 130);
		
		//Plataforma coral
		this.drawPlataforma(g2d, 90, 510, 160, 160, new Color(249, 144, 77), new Color(107, 43, 10));
		
		//Plataforma verde
		this.drawPlataforma(g2d, 645, 500, 355, 170, new Color(129, 184, 83), new Color(24, 56, 4));
		
		//Tuberia
		float[] fracciones = {0.0f, 0.20f, 0.30f, 0.50f, 0.70f, 1.0f};
		Color[] colores = {new Color(88, 143, 44), Color.WHITE, new Color(168, 224, 123),
							new Color(129, 184, 83), new Color(88, 143, 45), new Color(47, 102, 4)};
		LinearGradientPaint gradienteTuberia = new LinearGradientPaint(470, 550, 570, 550, fracciones, colores);
		g2d.setPaint(gradienteTuberia);
		
		g2d.fillRect(470, 550, 100, 120);
		g2d.fillRect(465, 500, 110, 50);
		g2d.setPaint(null);
		
		//Bloques
		this.drawBloque(g2d, 40, 300, 55, new Color(192, 147, 7), new Color(145, 98, 6));
		this.drawBloque(g2d, 94, 300, 55, new Color(192, 147, 7), new Color(145, 98, 6));
		//Bloque ?
		this.drawBloque(g2d, 700, 300, 55, new Color(192, 147, 7), new Color(145, 98, 6));
		g2d.setColor(Color.WHITE);
		g2d.setFont(fuente);
		g2d.drawString("?", 714, 343);
		
		//Mario y planta
		Image mario = new ImageIcon("img/mario.png").getImage();
		g2d.drawImage(mario, 400, 150, 90, 110, null);
		
		Image piranha = new ImageIcon("img/piranha.png").getImage();
		g2d.drawImage(piranha, 470, 405, 100, 100, null);
		
		//Linea del suelo
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(5));
		g2d.drawLine(0, 672, 1000, 672);
	}
	
	private void drawPlataforma(Graphics2D g2d, int x, int y, int width, int height, Color colorPlataforma, Color colorSombreado) {
		g2d.setColor(colorPlataforma);
		g2d.fillRect(x, y, width, height);
			
		float[] fracciones = {0.50f, 1.0f};
		Color[] colores = {colorPlataforma,  colorSombreado};
		LinearGradientPaint gradiente = new LinearGradientPaint(x, y, x+width-10, y+height, fracciones, colores);
		g2d.setPaint(gradiente);
		g2d.setStroke(new BasicStroke(7));
		g2d.drawRect(x, y, width, height);
			
		g2d.setPaint(null);
		this.drawTuerca(g2d, x+5, y+5, 15);
		this.drawTuerca(g2d, x+width-20, y+5, 15);
		this.drawTuerca(g2d, x+5, y+height-20, 15);
		this.drawTuerca(g2d, x+width-20, y+height-20, 15);
	}
	
	private void drawTuerca(Graphics2D g2d, int x, int y, int radio) {
		g2d.setColor(Color.WHITE);
		g2d.fillOval(x, y, radio, radio);
		g2d.setStroke(new BasicStroke(3));
		g2d.setColor(Color.BLACK);
		g2d.drawLine(x+3, y+radio-3, x+radio-3, y+3);
		g2d.drawOval(x, y, radio, radio);
	}

	private void drawBloque(Graphics2D g2d, int x, int y, int size, Color color, Color colorSombreado) {
		g2d.setColor(color);
		g2d.setStroke(new BasicStroke(4));
		g2d.fillRoundRect(x, y, size, size, 20, 20);
		
		float[] fraccionesBloque = {0.20f, 1.0f};
		Color[] coloresBloque = {color, colorSombreado};
		LinearGradientPaint gradienteBloque = new LinearGradientPaint(x, y, x+size, y+size, fraccionesBloque, coloresBloque);
		g2d.setPaint(gradienteBloque);
		g2d.drawRoundRect(x, y, size, size, 20, 20);
	}
	
	private void pintarSMW(Graphics2D g2d) {
		
		GradientPaint gradienteCielo = new GradientPaint(0, 0, new Color(6, 101, 192), 0, 800, new Color(90, 174, 255));
		g2d.setPaint(gradienteCielo);
		g2d.fillRect(0, 0, 1000, 800);
		
		//Nubes traseras
		this.drawNube(g2d, 300, 450);
		this.drawNube(g2d, 150, 500);
		this.drawNube(g2d, 330, 550);
		this.drawNube(g2d, 650, 250);
		this.drawNube(g2d, 600, 200);

		
		//Montañas traseras
		Color color3 = new Color(200, 232, 230);
		Color color4 = new Color(121, 182, 217);
		this.drawFondo(g2d, 50, 200, 200, 600, color3, color4);
		this.drawFondo(g2d, 400, 200, 180, 600, color3, color4);
		this.drawFondo(g2d, 580, 150, 180, 650, color3, color4);
		g2d.setColor(Color.WHITE);
		g2d.fillOval(75, 430, 25, 50);
		g2d.fillOval(155, 370, 25, 50);
		g2d.fillOval(155, 260, 25, 50);
		g2d.fillOval(450, 300, 25, 50);
		g2d.fillOval(450, 400, 25, 50);
		g2d.fillOval(510, 240, 25, 50);
		g2d.fillOval(610, 240, 25, 50);
		g2d.fillOval(700, 200, 25, 50);
		
		//Nube en medio
		this.drawNube(g2d, -50, 320);
		this.drawNube(g2d, 250, 350);
		this.drawNube(g2d, 480, 400);
		this.drawNube(g2d, 670, 470);
		this.drawNube(g2d, 700, 550);
		//Montañas enfrente
		Color color1 = new Color(118, 178, 217);
		Color color2 = new Color(21, 88, 117);
		this.drawFondo(g2d, -50, 500, 200, 220, color1, color2);
		this.drawFondo(g2d, 400, 500, 200, 220, color1, color2);
		this.drawFondo(g2d, 610, 300, 200, 500, color1, color2);
		this.drawFondo(g2d, 900, 400, 200, 500, color1, color2);
		g2d.setColor(Color.WHITE);
		g2d.fillOval(650, 350, 25, 50);
		g2d.fillOval(750, 500, 25, 50);
		this.drawTuberiaAzul(g2d, 470, 450);
		this.drawTuberiaAzul(g2d, 910, 500);
		
		this.drawBloque(g2d, 850, 550, 50, new Color(177, 180, 185), new Color(124, 121, 124));
		this.drawBloque(g2d, 850, 495, 50, new Color(177, 180, 185), new Color(124, 121, 124));
		this.drawBloque(g2d, 850, 440, 50, new Color(177, 180, 185), new Color(124, 121, 124));
		this.drawBloque(g2d, 850, 385, 50, new Color(177, 180, 185), new Color(124, 121, 124));
		
		this.drawBloque(g2d, 905, 385, 50, new Color(246, 216, 46), new Color(223, 162, 69));
		this.drawBloque(g2d, 960, 385, 50, new Color(246, 216, 46), new Color(223, 162, 69));
		g2d.setColor(Color.BLACK);
		g2d.fillOval(915, 395, 8, 20);
		g2d.fillOval(938, 395, 8, 20);
		g2d.fillOval(975, 395, 8, 20);
		
		GradientPaint gradientePasto = new GradientPaint(0, 600, new Color(19, 196, 18), 0, 620, new Color(30, 119, 56));
		g2d.setPaint(gradientePasto);
		g2d.fillRect(0, 600, 1000, 20);
		
		GradientPaint gradienteSuelo = new GradientPaint(0, 620, new Color(128, 115, 42), 0, 800, new Color(206, 156, 99));
		g2d.setPaint(gradienteSuelo);
		g2d.fillRect(0, 620, 1000, 180);
		
		Image mario = new ImageIcon("img/mario1.png").getImage();
		g2d.drawImage(mario, 360, 464, 90, 136, null);
		
		Image piranha = new ImageIcon("img/piranha.png").getImage();
		g2d.drawImage(piranha, 475, 280, 100, 100, null);
	}
	
	private void drawFondo(Graphics2D g2d, int x, int y, int width, int height, Color color, Color colorSombreado) {
		float[] fracciones = {0.0f, 1.0f};
		Color[] colores = {color, colorSombreado};
		
		LinearGradientPaint gradiente = new LinearGradientPaint(x, y, x+width, y, fracciones, colores);
		g2d.setPaint(gradiente);
		g2d.fillArc(x, y, width, 200, 0, 180);
		g2d.fillRect(x, y+100, width, height-100);
		g2d.setPaint(null);
 	}
	
	private void drawNube(Graphics2D g2d, int x, int y) {
		float[] fracciones = {0.20f, 1.0f};
		Color[] colores = {Color.WHITE, new Color(192, 222, 226)};
		
		LinearGradientPaint gradiente = new LinearGradientPaint(x, y, x+250, y+50, fracciones, colores);
		g2d.setPaint(gradiente);
		g2d.fillRoundRect(x, y, 250, 50, 120, 50);
		g2d.setPaint(null);
	}

	private void drawTuberiaAzul(Graphics2D g2d, int x, int y) {
		float[] fracciones = {0.10f, 0.30f, 0.40f, 0.50f, 0.70f, 1.0f};
		Color[] colores = {new Color(80, 78, 137), Color.WHITE, new Color(134, 131, 205),
							new Color(110, 106, 185), new Color(77, 78, 143), new Color(39, 40, 75)};
		LinearGradientPaint gradienteTuberia = new LinearGradientPaint(x, y, x+100, y, fracciones, colores);
		g2d.setPaint(gradienteTuberia);
		
		g2d.fillRect(x, y, 110, 50);
		g2d.fillRect(x+5, y+50, 100, 120);
		g2d.setPaint(null);
	}
}
