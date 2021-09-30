package objects;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Obstacles {

	public abstract void update();
	public abstract void draw(Graphics g);
	public abstract Rectangle getRectO();
	public abstract boolean out();
	public abstract void changePos();
	public abstract boolean outPunch();
	public abstract boolean outFly();
}
