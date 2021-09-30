package objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;

import loader.LoadImage;
import mainGame.Gameplay;


public class Sky {

	public static final int SKY=-58;

	private ArrayList<ImageSky> listSky;
	private BufferedImage sky;

	
	public Sky(int width) {
		
		sky=LoadImage.getImage("background/sky.png");

		int numSky=2;
		listSky=new ArrayList<ImageSky>();
		for(int i = 0; i < numSky; i++) {
			ImageSky imageSky = new ImageSky();
			imageSky.x = i * sky.getWidth();
			listSky.add(imageSky);
		}
	}
	
	public void update() {
		Iterator<ImageSky>it=listSky.iterator();
		ImageSky firstElem=it.next();
		firstElem.x -= Gameplay.vill.speed()/4;
		float lastPosX = firstElem.x;

		while(it.hasNext()) {
			ImageSky elem=it.next();
			elem.x=lastPosX+sky.getWidth();
			lastPosX=elem.x;
		}
		if(firstElem.x < -sky.getWidth()) {
			listSky.remove(firstElem);
			firstElem.x = lastPosX + sky.getWidth();
			listSky.add(firstElem);
		}
		
	}
	
	public void draw(Graphics g) {
		for(ImageSky imgStreet : listSky) {
			g.drawImage(sky, (int) imgStreet.x, SKY, null);
		}
	}
	
	private class ImageSky {
		float x;
	}
	
}
