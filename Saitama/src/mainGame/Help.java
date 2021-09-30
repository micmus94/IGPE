package mainGame;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import loader.LoadImage;

public class Help {

	public Rectangle back=new Rectangle(20,420,100,40);
	private BufferedImage image;
	
	public void drawTutorial(Graphics g) {
	//	Graphics2D g2= (Graphics2D) g;

		image=LoadImage.getImage("help.jpg");
		g.drawImage(image, 0, 0, null);
		Font font=new Font("Compacta D Normale",Font.BOLD,27);
		g.setFont(font);
		g.drawString("<<Back", back.x+5, back.y+32);
	//	g2.draw(back);
		
	}
}
