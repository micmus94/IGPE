package loader;


import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Animation  {

	private List<BufferedImage> list;
	
	private int frame=0;
	
	private long fps;
	private long lastTime=0;
	
	public Animation(long fps) {
		this.fps = fps;
		list = new ArrayList<BufferedImage>();
		
	}
	
	public void updateFrame(){
		if(System.currentTimeMillis()-lastTime>=fps) {
			frame++;
			if(frame>=list.size()) {
				frame=0;
			}
			lastTime=System.currentTimeMillis();
		}
	}

	


	
	public void addFrame(BufferedImage image) {
		list.add(image);
	}

	public BufferedImage getFrame() {
		return list.get(frame);
	}

}

