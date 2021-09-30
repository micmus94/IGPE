package mainGame;

import objects.Player;

public class ThreadPunch extends Thread {
	
	private Player player;
	
	   public ThreadPunch(Player player){
	       this.player=player;
	   }
	   
	   public void run(){
	            try {
					Thread.sleep(120);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	      player.punch(false);
	   }
	}

