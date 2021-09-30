package objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;

import loader.LoadImage;
import mainGame.Gameplay;
import mainGame.MainWindow;

public class Cloud {

	private ArrayList<ImageCloud> list;
	private BufferedImage cloud;
	
	
	public Cloud(int width) {
	
		cloud=LoadImage.getImage("background/cloud.png");
		list=new ArrayList<ImageCloud>();
		
		ImageCloud image= new ImageCloud();
		image.x=20;
		image.y=140;
		list.add(image);
		
		image=new ImageCloud();
		image.x=100;
		image.y=90;
		list.add(image);
		
		image= new ImageCloud();
		image.x=250;
		image.y=10;
		list.add(image);
		
		image= new ImageCloud();
		image.x=425;
		image.y=50;
		list.add(image);
		
		image= new ImageCloud();
		image.x=700;
		image.y=80;
		list.add(image);
	
	}
		public void update() {
			Iterator<ImageCloud> it = list.iterator();
			ImageCloud firstElement = it.next();
			firstElement.x -= Gameplay.vill.speed()/2;
			while(it.hasNext()) {
				ImageCloud element = it.next();
				element.x -= Gameplay.vill.speed()/2;
			}
			if(firstElement.x < -cloud.getWidth()) {
				list.remove(firstElement);
				firstElement.x = MainWindow.WIDTH;
				list.add(firstElement);
			}
		}
		public void draw(Graphics g) {
			for(ImageCloud img : list) {
				g.drawImage(cloud, (int) img.x, img.y, null);
			}
		}
	private class ImageCloud{
		float x;
		int y;
	}
}

