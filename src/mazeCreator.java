import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;


public class mazeCreator {
	public static void main(String[] args){
		for (int i = 0; i<4;i++){
			try{
				ArrayList<String> lines = new ArrayList<String>();
				Scanner scan = new Scanner(new File("/Users/Pavlos/Documents/EclipseWorkspace/PacMan/images/Level" + i + ".png"));
				while (scan.hasNextLine()){
					lines.add(scan.nextLine());
				}
				scan.close();
				
				
				int rows = lines.size();
				int columns = lines.get(0).length();
				int width = columns * 2;
				int height = rows * 2;
				BufferedImage maze = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
				Graphics2D g = maze.createGraphics();
				for (int r = 0; r < rows; r++){
					for (int c = 0; c < columns;c++){
						if (lines.get(r).charAt(c) != '0'){
							g.fillRect(c*2-14, r*2-14, 28, 28);
						}
					}
				}
				g.dispose();
				
				
				//save maze
				//ImageIO.write(maze, "png", new File("/Users/Pavlos/Documents/EclipseWorkspace/PacMan/images/MazesForPacman/" + i + ".png"));
			}
			catch (FileNotFoundException e){
				System.err.println("FileNotFoundException: " + e.getMessage());
				
			}
			catch (IOException e){
				System.err.println("IOException: " + e.getMessage());
			}
		}
	}
}
