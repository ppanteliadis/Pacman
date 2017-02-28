
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JComponent;

public class GameCanvas extends JComponent implements ComponentListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Game game;
	//protected Image img0 = Toolkit.getDefaultToolkit().createImage("/Users/Pavlos/Documents/EclipseWorkspace/PacMan/images/Level1.png");
	//protected Image img1 = Toolkit.getDefaultToolkit().createImage("/Users/Pavlos/Documents/EclipseWorkspace/PacMan/images/11.png");
	//protected Image img2 = Toolkit.getDefaultToolkit().createImage("/Users/Pavlos/Documents/EclipseWorkspace/PacMan/images/22.png");
	//protected Image img3 = Toolkit.getDefaultToolkit().createImage("/Users/Pavlos/Documents/EclipseWorkspace/PacMan/images/33.png");
	/*default constructor*/
	public GameCanvas(){}
	
	public GameCanvas(Game game){
		this.game = game;
		addKeyListener(game);
		addMouseListener(game);
		addMouseMotionListener(game);
		addMouseWheelListener(game);
		requestFocus();
		addComponentListener(this);
	}
	
	
	public void setGame(Game game) {
		this.game = game;
		addKeyListener(game);
		addMouseListener(game);
		addMouseMotionListener(game);
		requestFocus();
		addComponentListener(this);
	}
	
	
	@Override
	public void paintComponent(Graphics g){
		game.draw((Graphics2D)g);
	}
	
	@Override
	public void componentResized(ComponentEvent ce) {
		game.resize(ce.getComponent().getWidth(), ce.getComponent().getHeight());
	}
	
	
	@Override
	public void componentMoved(ComponentEvent ce) {
		
	}

	@Override
	public void componentShown(ComponentEvent ce) {
		game.resize(ce.getComponent().getWidth(), ce.getComponent().getHeight());
	}

	@Override
	public void componentHidden(ComponentEvent ce) {
		
	}
}
