package mainGame;



import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



public class Mouse extends Menu implements MouseListener {
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int mouseX=e.getX();
		int mouseY=e.getY();
		//menu
		//start
		if(Gameplay.state==Gameplay.State.MENU) {
		if(mouseX>=60 && mouseX<=160) {
			if(mouseY>=300 && mouseY<=340) {
				Gameplay.state=Gameplay.state.GAME;
			}
		}
		//exit
		 if(mouseX>=60 && mouseX<=160) {
			if(mouseY>=400 && mouseY<=440) {
				System.exit(1);
			}
		
		}//help
		 if(mouseX>=60 && mouseX<=160) {
			if(mouseY>=350 && mouseY<=390) {
				Gameplay.state=Gameplay.state.HELP;
			}
		}
		}
		//insideHelp
		if(Gameplay.state==Gameplay.state.HELP) {
		if(mouseX>=20 && mouseX<=120) {
			if(mouseY>=420 && mouseY<=460) {
				Gameplay.state=Gameplay.state.MENU;
			}
		}
		}
		//pause
		//resume
		if(Gameplay.state==Gameplay.state.PAUSE) {
			if(mouseX>=60 && mouseX<=210) {
				if(mouseY>=300 && mouseY<=340) {
				Gameplay.state=Gameplay.state.GAME;
			}
			}//menu 
			if(mouseX>=60 && mouseX<=160) {
				if(mouseY>=350 && mouseY<=390) {
					reset();
					Gameplay.state=Gameplay.state.MENU;
			}
				//music
			}if(mouseX>=730 && mouseX<=770) {
				if(mouseY>=400 && mouseY<=440) {
					if(Gameplay.isPlaying) {
						Gameplay.musicOFF();
					}else 
						Gameplay.musicON();
						
			}
			}
		}
			//game over
			//restart
		if(Gameplay.state==Gameplay.state.GAME_OVER) {
			if(mouseX>=60 && mouseX<=210) {
				if(mouseY>=300 && mouseY<=340) {
					reset();
					Gameplay.musicON();
					Gameplay.state=Gameplay.state.GAME;	
				}
			}//menu
			if(mouseX>=60 && mouseX<=160) {
				if(mouseY>=350 && mouseY<=390) {
					reset();
					Gameplay.state=Gameplay.state.MENU;	
				}
		}
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void reset() {
		Gameplay.vill.reset();
		Gameplay.player.reset();
		Gameplay.player.dead(false);
	}

}
