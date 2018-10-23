package control;

import java.awt.Image;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Button;

public class Control extends JFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Control();
	}
	
	public Control() {
		setResizable(false);
		
		this.setSize(1600,1000);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Sawcon Ultimate Monopoly");
		
		addBoardImage();
		
		this.setVisible(true);
	}
	
	
	public void addBoardImage() {
		ImageIcon imageIcon = new ImageIcon("graphics\\\\ultimatemonopolyboard.png"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(1000, 1000,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back

		
		//BufferedImage myPic = ImageIO.read(new File("graphics\\ultimatemonopolyboard.png"));
		JLabel picLabel = new JLabel(imageIcon);
		
		

		this.getContentPane().add(picLabel);
		
		JPanel panel = new JPanel();
		this.getContentPane().add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(4, 1, 10, 10));
		
		Button button = new Button("Roll Dice");
		panel.add(button);
		
		Button button_1 = new Button("Buy Deed/Build");
		panel.add(button_1);
		
		Button button_2 = new Button("Use Card");
		panel.add(button_2);
		
		Button button_3 = new Button("End Turn");
		panel.add(button_3);
		

		panel.setVisible(true);
	}
	

}
