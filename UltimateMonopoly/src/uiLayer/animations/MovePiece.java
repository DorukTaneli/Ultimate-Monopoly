package uiLayer.animations;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import uiLayer.AppWindow;
import uiLayer.animations.*;

public class MovePiece {

	public static void main(String args[]) {
		Animator animator = new Animator();
		Piece mb = new Piece(Piece.LEFT, 0);
		animator.addDrawable(mb);
		animator.setVisible(true);
	}
}

/**
 *  Purpose: 	This class implements a ball that moves itself
 *  		on subsequent call to the draw method.
 */
class Piece implements Drawable {

    static final int LEFT=0;
    static final int UP = 1;
    static final int RIGHT=2;
    static final int DOWN = 3;
    static final int START_SQ_X=AppWindow.getInstance().getPixelX(0);
    static final int START_SQ_Y=AppWindow.getInstance().getPixelY(0);
    private int direction = LEFT;
    
	private IPath myPath;
	private Point myPosition=new Point(START_SQ_X,START_SQ_Y);
	private int myNumber;

	/** 
	 *  Constructor, simply save the initial values.
	 */
	public Piece(int direction, int myNumber) {
		
		this.direction = direction;
		this.myNumber = myNumber;
	}

	/** Draw is called each time through the animator loop to draw the
	 *   object. Use the path to calculate the position of this object, 
	 *   and then draws the object at that position.
	 */
	public void draw(Graphics g) {
		if (myPath != null && myPath.hasMoreSteps())
			myPosition = myPath.nextPosition();
		else {
			// Get a random number of steps to make the balls move
			// at different speeds.  Note there has to be at least
			// 1 step in each path, but for appearances we used at least
			// 10 steps.
			int numberOfSteps = (int) (10.0 + (Math.random() * 100.0));

			if (direction == DOWN) {
				myPath = new StraightLinePath(410, 410, 10, 10, numberOfSteps);
				myPosition = myPath.nextPosition();
				direction = UP;
			}
			else {
				myPath = new StraightLinePath(10, 10, 410, 410, numberOfSteps);
				myPosition = myPath.nextPosition();
				direction = DOWN;
			}
		}
		g.setColor(Color.RED);
		g.fillOval((int)myPosition.getX(), (int)myPosition.getY(), 15, 15);
		g.setColor(Color.BLACK);
		g.drawString("" + myNumber,
				(int)myPosition.getX()+3, (int)myPosition.getY()+12);
	}
}
