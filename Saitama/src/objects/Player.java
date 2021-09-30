package objects;


import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;

import loader.Animation;
import loader.LoadImage;


public class Player {
	
	
		private float posX;
		private float posY;
		private float speedY;
		
		
		public static final int STREET=380;
		public static final double GRAVITY=0.6f;
			
		
		private static final int RUN=0;
		private static final int JUMP=1;
		private static final int PUNCH=2;
		private static final int DEAD=3;
		
		
		public Rectangle rect;

		private int state=RUN;
		
		private Animation run;
		private BufferedImage jump;
		private BufferedImage punch;
		
		private AudioClip jumpSound;
		private AudioClip deadSound;
		
		public Player() {


			posX=45;
			posY=STREET;
				
			rect=new Rectangle();

			run=new Animation(90);
			run.addFrame(LoadImage.getImage("run/run1.png"));
			run.addFrame(LoadImage.getImage("run/run2.png"));
			run.addFrame(LoadImage.getImage("run/run3.png"));
			run.addFrame(LoadImage.getImage("run/run4.png"));
			
			jump=LoadImage.getImage("jump.png");
			punch=LoadImage.getImage("punch.png");
			
			try {
				jumpSound =  Applet.newAudioClip(new URL("file","","music/jump.wav"));
				deadSound =  Applet.newAudioClip(new URL("file","","music/dead.wav"));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		
	
			
		public void draw(Graphics g) {
			switch(state) {
				case RUN:
					g.drawImage(run.getFrame(), (int)posX,(int) posY, null);
				//	g.drawRect((int) posX +20, (int) posY, (int) run.getFrame().getWidth()-15,(int)run.getFrame().getHeight() );
					break;
				case JUMP:
					g.drawImage(jump,(int)posX,(int) posY, null);
				//	g.drawRect((int) posX +20, (int) posY, (int) jump.getWidth()-25,(int)jump.getHeight() );
					break;
				case PUNCH:
					g.drawImage(punch,(int)posX,(int)posY,null);
				//	g.drawRect((int) posX+70, (int) posY+5, (int) punch.getWidth()-70,(int)punch.getHeight()-51  );
			}
		}

		
		public int getState() {
			int numState;
			if(state==RUN) {
				numState=0;
			}else if(state==JUMP) {
				numState=1;
			}else if(state==PUNCH) {
				numState=2;
			}else {
				numState=3;
			}
			return numState;
		}
		
		public void update() {
			run.updateFrame();
			if(posY >= STREET) {
				posY = STREET;
				if(state != PUNCH) {
					state = RUN;
				}
			} else {
				speedY += GRAVITY;
				posY += speedY;
				
			}
		}
		public void jump() {
				if(posY>=STREET) { 
					jumpSound.play();
					speedY=-11;
					posY+=speedY;
					state=JUMP;
			}
		}

		public void punch(boolean pun) {
			if(pun) {
			if (state!=PUNCH) {
					state=PUNCH;
			}
			}
			else {
				state=RUN;		
		}
}
		
		public void dead(boolean dead) {
			if(dead) {
				state = DEAD;
					deadSound.play();
			} else {
				state = RUN;
			}
		}
		
		public Rectangle getRect() {
			if(state==RUN) {
				rect=new Rectangle();
				rect.x= (int) posX +20;
				rect.y=(int) posY;
				rect.width=(int) run.getFrame().getWidth()-15;
				rect.height=(int)run.getFrame().getHeight();
			}else if(state==JUMP) {
				rect=new Rectangle();
				rect.x= (int) posX +20;
				rect.y=(int) posY;
				rect.width=(int) jump.getWidth()-25;
				rect.height=(int)jump.getHeight();
			}else if(state==PUNCH) {
				rect=new Rectangle();
				rect.x= (int) posX+70 ;
				rect.y=(int) posY+5;
				rect.width=(int) punch.getWidth()-70;
				rect.height=(int)punch.getHeight()-51;

			}
			return rect;
		}
		public void reset() {
			posY= STREET;
		}
}
