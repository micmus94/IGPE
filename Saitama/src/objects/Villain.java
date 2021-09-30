package objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import mainGame.Gameplay;
import mainGame.MainWindow;


public class Villain extends Obstacles {
	
	//private static final int GROUND=280;
	private int posX;
	private int posY;
	private int width;
	private int height;
	
	
	private BufferedImage image;

	
	public Rectangle rect;
	
	public Villain(int posX ,int posY, int width, int height, BufferedImage image) {
		this.posX=posX;
		this.posY=posY;
		this.width=width;
		this.height=height;
		this.image=image;
		rect=new Rectangle();
	}
	
	public void update() {
			posX -= Gameplay.vill.speed();
	}
	

	public void changePos() {
			posX += 200 ;
			posY -= 500 ;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(image, posX, posY , null);
		//g.drawRect((int) posX + (image.getWidth() - width)/2,posY  + (image.getHeight() - height)/2, width, height);
	}

	@Override
	public Rectangle getRectO() {	
		// TODO Auto-generated method stub
		rect=new Rectangle();
		rect.x=(int) posX + (image.getWidth() - width)/2;
		rect.y=posY + (image.getHeight() - height)/2;
		rect.width=width;
		rect.height=height;
		return rect;
	}
	//enemy was jumped and go out of the screen
	@Override
	public boolean out() {
		// TODO Auto-generated method stub
		if(posX < -image.getWidth() && posY>300)
			return true;
		return false;
	}
	//flying enemy go out of the screen
	@Override
	public boolean outFly() {
		// TODO Auto-generated method stub
		if(posX < -image.getWidth() && posY<300)
			return true;
		return false;
	}
	//enemy was punched
	@Override
	public boolean outPunch() {
		if( posY<= 0)
			return true;
		return false;
	}

}
