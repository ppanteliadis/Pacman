
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;


public abstract class Game implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {
	
	protected boolean over;
	protected String title = "Pacman";
	protected int width = 456, height = 520;
	protected int delay = 20;
	
	
	public void init() {}
	
	//will need these to to create the images on the canvas
	abstract public void update();
	abstract public void draw(Graphics2D g);
	
	
	public boolean isOver(){
		return over;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight() { 
		return height; 
	}
	public int getDelay() { 
		return delay; 
	}
	
	
	public void resize(int width, int height) {}

	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {}

	public void keyReleased(KeyEvent e) {}

	public void mouseClicked(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}

	public void mouseDragged(MouseEvent e) {}

	public void mouseMoved(MouseEvent e) {}

	public void mouseWheelMoved(MouseWheelEvent e) {}

}
