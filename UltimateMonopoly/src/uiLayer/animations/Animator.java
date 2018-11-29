package uiLayer.animations;

import java.awt.Container;
import java.awt.Graphics;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

/** 
 *    Purpose:	This class extends the Generic Animator of 
 *		Program 7.3c to add a control panel to 
 *		control the speed, and add some buttons.
 */

@SuppressWarnings("serial")
public class Animator extends JPanel implements Runnable {

    @SuppressWarnings("rawtypes")
	private Vector elementsToDraw = new Vector();
    private long sleepTime = 100;
    private boolean animatorStopped = true, firstTime = true;
    private JFrame animFrame;

    /**
     *  Constructor that creates the JFrame for the animator.  Note
     *  the JFrame is shown in the show() method because this starts
     *  the GUI thread.  Starting the thread in the constructor
     *  can lead to a race condition.
     */
    public Animator() {
        // set up the frame to draw in.
        animFrame = new JFrame("Generic Animator");
        Container animContainer = animFrame.getContentPane();
        animContainer.add(this);
        animFrame.setSize(700, 450);
        animFrame.setLocation(0,100);
    }

    /**
     *  setVisible is called to display or hide the animator.
     *  Note that only display = true is implemented, and this
     *  function only works at this point if it is called once.
     *  It is left as an exercise to implement it correctly.
     *  If display = false, the Control Thread needs to be
     *  suspended.  If display = true, the control thread
     *  should be started only the first time, after that it
     *  should be unsuspended.  This can be accomplished as
     *  using control variables in the paint method for Program
     *  7.4 and after, and should not be done using the suspend
     *  and resume methods.
     */
    public void setVisible(boolean display) {
        if (display == true) {
            if (firstTime) {
                firstTime = false;

                // Show the animator.  This starts the GUI thread.
                animFrame.setVisible(true);

                // Put the animator in another thread so that the
                // calling object can continue.
                (new Thread(this)).start();
            }
        }
    }


    /** Thread that runs the animator.  This thread sleeps for some 
     *  amount of time specified by sleepTime, then calls repaint 
     *  which forces a call to the paint method, but in the GUI thread.
     *  Note that the animatorStopped button allows the animator to 
     *  single step and pause the animation.  The notify is done in 
     *  the control frame from the button.
     */
    public void run() {
        while (true) {
            try {
                synchronized(this) {
                    if (animatorStopped == true) {
                        wait();
                    }
                }
                if (animatorStopped != true)
                    Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                System.out.println("Program Interrupted");
                System.exit(0);
            }
            repaint();
        }
    }

    /**  
     *  The paint method redraws all the objects registered with this
     *  animator.  It is run in the GUI thread.  The repaint 
     *  command causes this to be called, and it passes the graphics 
     *  object g to each of the registered objects to have them draw 
     *  themselves.
     */
    @SuppressWarnings("rawtypes")
	public void paint(Graphics g) {
        super.paint(g);
        Enumeration e = elementsToDraw.elements();
        while (e.hasMoreElements())
            ((Drawable) e.nextElement()).draw(g);
    } 

    /** 
     *  addElement adds each drawable to the vector for use by the
     *   DrawElements method.
     */
    @SuppressWarnings("unchecked")
	public void addDrawable(Drawable d) {
        elementsToDraw.addElement(d);
    }

    /** 
     *  removeElement is used to remove drawables from the vector.  
     */
    public void removeDrawable(Drawable d) {
        elementsToDraw.removeElement(d);
    }