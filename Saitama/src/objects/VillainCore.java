package objects;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import loader.LoadImage;

public class VillainCore {

	private BufferedImage hole;
	private BufferedImage villain1;
	private BufferedImage villain2;
	private BufferedImage villain3;
	

		
	private ArrayList<Obstacles>listObst;
	private Player player;
	
	public int scoreV=0;
	public int i200=200;
	public int index=5;
	public int i=1;
	
	private Random rand;
	Thread thread=new Thread();
	
	public VillainCore(Player player) {
		
		rand=new Random();
		hole=LoadImage.getImage("obstacles/hole.png");
		villain1=LoadImage.getImage("obstacles/villain1.png");
		villain2=LoadImage.getImage("obstacles/villain2.png");
		villain3=LoadImage.getImage("obstacles/villain3.png");

		listObst=new ArrayList<Obstacles>();
		this.player=player;
		listObst.add(oType());
	}
	
	public void updateO(boolean up) {
		if(up) {
			for(Obstacles o: listObst) {
				o.update();
			}
		}else{
			for(Obstacles o: listObst) {
				o.changePos();	
		}
	}
			Obstacles ob=listObst.get(0);
			if(ob.out()){
				scoreV+=20;
				listObst.clear();
				listObst.add(oType());
			}else if(ob.outPunch()) {
				scoreV+=30;
				listObst.clear();
				listObst.add(oType());
			}else if(ob.outFly()){
				listObst.clear();
				listObst.add(oType());
			}
		
}
	
	public void draw(Graphics g) {
		for(Obstacles o: listObst) {
			o.draw(g);
		}
	}
	
	public Obstacles oType() {
		int type=rand.nextInt(10);
		if(type>=0 && type<3) {
			return new Villain(900,400, hole.getWidth()-130, hole.getHeight()-30, hole);
	}else if(type>=3 && type<5){
		return new Villain(900,355, villain1.getWidth(), villain1.getHeight(), villain1);
		}else if(type>=5 && type<8) {
			return new Villain(900,282, villain2.getWidth(), villain2.getHeight(), villain2);
		}else {
			return new Villain(900,226, villain3.getWidth()-10, villain3.getHeight(), villain3);
		}
	}
	
	public boolean collide() {
		for(Obstacles o: listObst) {
			if(player.getRect().intersects(o.getRectO())) {
					return true;
			}
		}
		return false;
	}
	
	
	
	public int speed() {
		if(scoreV/200==i && i<6) {
			i++;
			index++;
		}return index;
		
	}
	public void reset() {
		listObst.clear();
		listObst.add(oType());
		scoreV=0;
		index=5;
		i=1;
		
	}

}
