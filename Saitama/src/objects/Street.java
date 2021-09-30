package objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;

import loader.LoadImage;
import mainGame.Gameplay;


public class Street{
	
	public static final int STREET=173;

	private ArrayList<ImageStreet> listStreet;

	private BufferedImage street;


	
	public Street(int width) {
		
		street=LoadImage.getImage("background/street.png");

		int numStreet=2;
		listStreet=new ArrayList<ImageStreet>();
		for(int i = 0; i < numStreet; i++) {
			ImageStreet imageStreet = new ImageStreet();
			imageStreet.x = i * street.getWidth();
			listStreet.add(imageStreet);
		}

	}

	
	public void update() {
		
		Iterator<ImageStreet>it=listStreet.iterator();
		ImageStreet firstElem=it.next();
		firstElem.x -= Gameplay.vill.speed();
		float lastPosX = firstElem.x;

		while(it.hasNext()) {
			ImageStreet elem=it.next();
			elem.x=lastPosX+street.getWidth();
			lastPosX=elem.x;
		}
		if(firstElem.x < -street.getWidth()) {
			listStreet.remove(firstElem);
			firstElem.x = lastPosX + street.getWidth();
			listStreet.add(firstElem);
		}
	}

	
	public void draw(Graphics g) {
		for(ImageStreet imgStreet : listStreet) {
			g.drawImage(street, (int) imgStreet.x, STREET, null);
		}
	}
	

	private class ImageStreet {
		float x;
	}
	
}
