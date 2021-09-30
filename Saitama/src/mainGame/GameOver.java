package mainGame;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import loader.LoadImage;

public class GameOver {

	public Rectangle restart=new Rectangle(60,300,150,40);
	public Rectangle menu=new Rectangle(60,350,100,40);
	
	private BufferedImage image;
	
	public void drawDeath(Graphics g) {
	//	Graphics2D g2= (Graphics2D) g;
		
		image=LoadImage.getImage("gameover.jpg");
		g.drawImage(image, 0, 0, null);
		
		Font font=new Font("Compacta D Normale",Font.BOLD,30);
		g.setFont(font);
		g.drawString("Restart", restart.x+10, restart.y+32);
	//	g2.draw(restart);
		g.drawString("Menu", menu.x+10, menu.y+32);
	//	g2.draw(menu);
	}
}
