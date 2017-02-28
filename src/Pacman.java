import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;


class Pacman extends Game implements ActionListener{
	
	int SCORE = 0;
	int LIVES = 3;
	final int STEP = 2;
	int columnX, rowY;
	Image img;
	int rows, columns;
	int frame;
	BufferedImage pacman;
	Graphics g;
	int requestedDirection, currentDirection;
	//width and height of the screen i should play in
	int width, height;
	int MazeNo = 0;
	Maze[] mazes = new Maze[4];
	char[][] food;
	
	
	
	
	BufferedImage[] mazeImages = new BufferedImage[4];
	
	ArrayList<String> lines = new ArrayList<String>();
	public Pacman(){
		for (int m = 0; m < 4;m++){
			mazes[m] = new Maze(m);
		}
		
		food = mazes[MazeNo].getFood();
		
		
		rows = mazes[MazeNo].rows;
		columns = mazes[MazeNo].columns;
		//pacman init pos
		rowY = mazes[MazeNo].rowY;
		columnX = mazes[MazeNo].columnX;
		//game screen size
		width = mazes[MazeNo].width;
		height = mazes[MazeNo].height;
		
		
		frame = 0;
		currentDirection = requestedDirection = KeyEvent.VK_RIGHT;
		//initial position of pacman
		try{
			File file = new File("/Volumes/Macintosh HD 2/Documents/workspace/pacman/images/packman.png");
			pacman = ImageIO.read(file);
			for (int m = 0; m < 4; m++){
				mazeImages[m] = ImageIO.read(new File("/Volumes/Macintosh HD 2/Documents/workspace/pacman/images/Level" + m + ".png" ));
			}
		}
		catch (IOException e){
			System.err.println("IOException in Pacman: " + e.getMessage());
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e){
		int keypressed = e.getKeyCode();
		if (keypressed >= 37 && keypressed <=40 ) {
			requestedDirection = keypressed;
		}
	}
	

	
	@Override
	public void update(){
		frame++;
		if (frame > 5) {
			frame = 0;
		}
		//checks if you cant go one way, continue on the path you are in to
		if (moveTo(requestedDirection)){
			currentDirection = requestedDirection;
		}
		else{
			moveTo(currentDirection);
		}
		
		if (food[rowY][columnX] == '2'){
			//bon appetit
			food[rowY][columnX] = '1';
			SCORE = SCORE + 10;
		}
		else if (food[rowY][columnX] == '3'){
			//bon appetit
			food[rowY][columnX] = '1';
			SCORE = SCORE + 20;
		}
	}
	
	//checks if the direction i'm moving to is valid returns true, also moves the pacman to the direction
	private boolean moveTo(int i){
		switch (i){
			case KeyEvent.VK_LEFT: //37
				if (columnX > 0 && mazes[MazeNo].isWalkable(rowY, columnX-1) != '0') {
					columnX -= 1;		
					return true;
				}
				//pass through wall moving LEFT
				if (columnX == 0 && food[rowY][columns - 1] == '1'){
					columnX = columns-1;
					return true;
				}
				break;
			case KeyEvent.VK_RIGHT: //38
				if (columnX < columns - 1 && mazes[MazeNo].isWalkable(rowY, columnX + 1) != '0') {
					columnX += 1;
					return true;
				}
				//pass through wall moving right
				if (columnX == columns  && food[rowY][columns] == '1'){
					columnX = 0;
					return true;
				}
				break;
			case KeyEvent.VK_UP: //39
				if (rowY > 0 && mazes[MazeNo].isWalkable(rowY-1, columnX) != '0') {
					rowY -= 1;		
					return true;
				}
				break;
			case KeyEvent.VK_DOWN: //40
				if (rowY < rows - 1 && mazes[MazeNo].isWalkable(rowY + 1, columnX) != '0') {
					rowY += 1;		
					return true;
				}
				break;
		}
		return false;
	}
	

	
	@Override
	public void draw(Graphics2D g){   // To draw it, i need to make it pixel size and subtract the size of pacman
		g.drawImage(mazeImages[MazeNo],0,0,null);
		g.setColor(Color.white);
		for (int i = 0; i < mazes[MazeNo].rows; i++){
			for (int j = 0; j < mazes[MazeNo].columns; j++){
				if (food[i][j] == '2'){
					//simple food
					g.fillOval(j*STEP-3, i*STEP-3, 6, 6);
				}
				else if (food[i][j] == '3'){
					//enhanced food
					g.fillOval(j*STEP-6, i*STEP-6, 12, 12);
				}
			}
		}
		g.drawImage(pacman.getSubimage((frame/2)*30 , (currentDirection - 37)*30 , 28 , 28), columnX*STEP - 14, rowY*STEP - 14, null);
	}
	
	public boolean validTeleportL(int i, int j){
		if (lines.get(i).charAt(j) =='6'){
			return true;
		}
		return false;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	public static void main(String[] args){
		GameStart.start(new Pacman());
	}
}