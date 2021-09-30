package mainGame;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

public class Music {


	public AudioClip onePunch;
	
	public Music() {
		try {
			onePunch =  Applet.newAudioClip(new URL("file","","music/onePunch.wav"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void musicON() {
		onePunch.play();
	}
	
	public void musicOFF() {
		onePunch.stop();
	}
}
