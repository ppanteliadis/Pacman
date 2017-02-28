import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Maze {
	
	ArrayList<String> lines;
	int rowY, columnX;
	int rows, columns;
	int width, height;
	public Maze(int m){
		try{
			int i = 0;
			lines = new ArrayList<String>();
			Scanner scan = new Scanner(new File("/Volumes/Macintosh HD 2/Documents/workspace/pacman/images/Level0.txt"));
			String tmp;
			
			while (scan.hasNextLine()){
				tmp = scan.nextLine();
				lines.add(tmp);
				//find initial position of pacman in maze
				if (tmp.contains("5")) {
					columnX = tmp.indexOf('5');
					rowY = i;
				}
				i++;
			}
			scan.close();
			rows = lines.size();
			columns = lines.get(0).length();
			width = columns * 2;
			height = rows * 2;
		}
		catch(FileNotFoundException e){
			System.err.println("FileNotFoundException : " + e.getMessage());
		}
	}
	public char isWalkable(int i, int j) {
		return lines.get(i).charAt(j);
	}
	public char[][] getFood() {
		char[][] food = new char[rows][columns];
		for (int i = 0; i<rows;i++){
			System.arraycopy(lines.get(i).toCharArray(), 0, food[i], 0, columns);
		}
		return food;
	}
}
