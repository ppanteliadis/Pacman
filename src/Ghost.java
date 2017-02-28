import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;




public class Ghost extends Game implements ActionListener {

	final int STEP = 2;
	int posX, posY;
	Image img;
	int direction;
	int frame;
	BufferedImage ghost;
	
	Graphics g;
	
	
	public Ghost(String path){
		frame = 0;
		direction = KeyEvent.VK_LEFT;
		posX = 150;
		posY = 250;
		try{///Users/Pavlos/Documents/EclipseWorkspace/PacMan/images/Ghost_red.png
			File file = new File(path);
			ghost = ImageIO.read(file);
		}
		catch (FileNotFoundException e){
			System.err.println("FileNotFoundException in Ghost: " + e.getMessage());
		}
		catch (IOException e){
			System.err.println("IOException in Ghost: " + e.getMessage());
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e){
		direction = e.getKeyCode();
	}
	
	
	
	@Override
	public void update() {
		frame++;
		if (frame >5) {
			frame=0;
		}
		
		switch (direction){
			case KeyEvent.VK_LEFT:
				posX -= STEP;		//37
				break;
			case KeyEvent.VK_RIGHT:
				posX += STEP;		//38
				break;
			case KeyEvent.VK_UP:
				posY -= STEP;		//39
				break;
			case KeyEvent.VK_DOWN:
				posY += STEP;		//40
				break;
		}
		//X-axis out of bounds
		if (posX < 0) {
			posX = 0;
		}
		
		else if (posX > width - 28 - STEP){
			posX = width - 28 - STEP;
		}
		
		//Y-axis out of bounds
		if (posY < 0) {
			posY = 0;
		}
		else if (posY > height - 28 - STEP){
			posY = height - 28 - STEP;
		}
		
	}
		

	@Override
	public void draw(Graphics2D g) {
		g.drawImage(ghost.getSubimage((frame/2)*30 , (direction - 37)*30 , 28 , 28), posX, posY, null);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	public int getX(){
		return this.posX;
	}
	public int getY(){
		return this.posY;
	}
	public void setX(int x){
		this.posX = x;
	}
	public void setY(int y){
		this.posY = y;
	}
	private ArrayList<Ghost> ghosts = new ArrayList<Ghost>(4);
	
	private void CreateGhosts(){
		Ghost red = new Ghost("/Users/Pavlos/Documents/EclipseWorkspace/PacMan/images/Ghost_red.png");
		Ghost cyan = new Ghost("/Users/Pavlos/Documents/EclipseWorkspace/PacMan/images/Ghost_cyan.png");
		Ghost pink = new Ghost("/Users/Pavlos/Documents/EclipseWorkspace/PacMan/images/Ghost_pink.png");
		Ghost orange = new Ghost("/Users/Pavlos/Documents/EclipseWorkspace/PacMan/images/Ghost_orange.png");
		ghosts.add(red);
		ghosts.add(cyan);
		ghosts.add(pink);
		ghosts.add(orange);
	}
	
	
	
	public static void main(String[] args){
		GameStart.start(new Ghost("/Users/Pavlos/Documents/EclipseWorkspace/PacMan/images/Ghost_eaten.png"));
	}

}
