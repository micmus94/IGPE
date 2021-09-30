package mainGame;


import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.MalformedURLException;
import java.net.URL;



import javax.swing.JPanel;


import objects.Street;
import objects.Cloud;
import objects.VillainCore;
import objects.Player;
import objects.Sky;

public class Gameplay extends JPanel implements Runnable, KeyListener{

	public static  Player player;
	public static Street street;
	public static Sky sky;
	public static Cloud cloud;
	public static VillainCore vill;
	
	
	private boolean keyPres;
	
	private int iMusic=0;
	
	private Menu menu;
	private Help help;
	private Pause pause;
	private GameOver gameOver;
	
	
	
	
	public static enum State{
		MENU, GAME, HELP, PAUSE ,GAME_OVER;
	}
	
	public static State state= State.MENU;
	
	
	public AudioClip punchSound;
	public AudioClip intro;
	public static AudioClip onePunch;
	public static boolean isPlaying=false;

	
	private Thread thread;

	
	public Gameplay() {
		
		player=new Player();
		street=new Street(MainWindow.WIDTH);
		sky=new Sky(MainWindow.WIDTH);
		cloud=new Cloud(MainWindow.WIDTH);
		vill=new VillainCore(player);
		
		this.addMouseListener(new Mouse());

		
		menu=new Menu();
		help=new Help();
		pause=new Pause();
		gameOver=new GameOver();
		
		
		
		try {
			punchSound =  Applet.newAudioClip(new URL("file","","music/punch.wav"));
			intro =  Applet.newAudioClip(new URL("file","","music/intro.wav"));
			onePunch =  Applet.newAudioClip(new URL("file","","music/onePunch.wav"));
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void start(){
		
		thread=new Thread(this);
		thread.start();
		
	}

	public void gameUpdate(boolean gaming) {
		
		if(gaming) {
		if(state==state.GAME) {
			sky.update();
			cloud.update();
			street.update();
			vill.updateO(true);
			player.update();
		
		//death
		if(player.getState()!=2 && vill.collide()) {
				state=state.GAME_OVER;
				player.dead(true);
				//System.out.println("dead");
			
			}
		//punch
			if(player.getState()==2 && vill.collide()){
					punchSound.play();
					vill.updateO(false);
				//	System.out.println("punch");
			}
		}
	}
}
	public static void musicON() {
		isPlaying=true;
		onePunch.play();
	}
	public static void musicOFF() {
		onePunch.stop();
		isPlaying=false;
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		if(state==state.GAME) {
				sky.draw(g);
			    cloud.draw(g);
				street.draw(g);
				vill.draw(g);
				player.draw(g);
				g.setColor(Color.WHITE);
				g.drawString("SCORE: " + vill.scoreV, 700, 20);
				
		}else if(state==state.MENU) {

				menu.drawMenu(g);
			
				while(iMusic<1) {
				intro.play();
				iMusic++;
			}
				musicON();
		}else if(state==state.HELP){
			help.drawTutorial(g);
				musicOFF();
		}else if(state==state.PAUSE) {
			pause.drawPause(g);
			if(!isPlaying)
				pause.drawMusicOFF(g);
		}else if(state==state.GAME_OVER) {
			gameOver.drawDeath(g);
			g.drawString("SCORE: " + vill.scoreV, 70, 200);
				musicOFF();
		}
				
	}
	
	public void run() {

		while (true) {
			
			gameUpdate(true);
			repaint();

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	
		}
	}


	@Override
	public void keyPressed(KeyEvent k) {
		// TODO Auto-generated method stub
		if(!keyPres) {
			keyPres=true;
			if(state==state.GAME) {
		if (k.getKeyCode() == KeyEvent.VK_W) {
			player.jump();
		}if(k.getKeyCode()==KeyEvent.VK_SPACE) {
				player.punch(true);	
				ThreadPunch t1=new ThreadPunch(player);
				t1.start();		
	}	
		
		if(k.getKeyCode()==KeyEvent.VK_ESCAPE) {
			gameUpdate(false);
			state=state.PAUSE;
		}
		}
		}
	}



	@Override
	public void keyReleased(KeyEvent k) {
		// TODO Auto-generated method stub
		keyPres=false;
		
	}

	@Override
	public void keyTyped(KeyEvent k) {
		// TODO Auto-generated method stub
		
	}

}

	
