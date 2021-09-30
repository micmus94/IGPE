package mainGame;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import loader.LoadImage;

public class Menu {
	
	public static boolean red=false;
	
	public Rectangle start=new Rectangle(60,300,100,40);
	public Rectangle help=new Rectangle(60,350,100,40);
	public Rectangle exit=new Rectangle(60,400,100,40);

	
	public  BufferedImage image;
	
	public void drawMenu(Graphics g) {
	//	Graphics2D g2= (Graphics2D) g;
		image=LoadImage.getImage("saitama.jpg");
		g.drawImage(image, 0, 0, null);
		
		Font font=new Font("Compacta D Normale",Font.BOLD,30);
		g.setFont(font);
		g.drawString("Start", start.x+10, start.y+32);
	//	g2.draw(start);
		g.drawString("Help", help.x+10, help.y+32);
	//	g2.draw(help);
		g.drawString("Exit", exit.x+10, exit.y+32);
	//	g2.draw(exit);	
	}
}
