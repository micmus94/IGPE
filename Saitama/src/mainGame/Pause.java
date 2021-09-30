package mainGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import loader.LoadImage;

public class Pause {
	
	public Rectangle resume=new Rectangle(60,300,150,40);
	public Rectangle menu=new Rectangle(60,350,100,40);
	
	public BufferedImage image;
	public BufferedImage music;
	
	public void drawPause(Graphics g) {
	//	Graphics2D g2= (Graphics2D) g;
		music=LoadImage.getImage("music/musicON.jpg");
		image=LoadImage.getImage("pause.jpg");
		g.drawImage(image, 0, 0, null);
		g.drawImage(music, 730, 400, null);
		
		Font font=new Font("Compacta D Normale",Font.BOLD,30);
		g.setFont(font);
		g.drawString("Resume", resume.x+10, resume.y+32);
	//	g2.draw(resume);
		g.drawString("Menu", menu.x+10, menu.y+32);
	//	g2.draw(menu);
	}
	public void drawMusicOFF(Graphics g1) {
		//	Graphics2D g2= (Graphics2D) g;
			music=LoadImage.getImage("music/musicOFF.jpg");
			g1.drawImage(music, 730, 400, null);
	}
}
