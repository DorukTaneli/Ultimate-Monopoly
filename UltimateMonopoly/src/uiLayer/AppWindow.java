package uiLayer;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import domainLayer.DomainController;
import domainLayer.Player;
import domainLayer.Square;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Button;

public class AppWindow extends JFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AppWindow();
	}
	
	public AppWindow() {
		DomainController ctrl = new DomainController();
		
		setResizable(false);
		
		this.setSize(1600,1050);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Sawcon Ultimate Monopoly");
		
		addButtons(ctrl);
		
		addPieces(ctrl);
		addPlayerLabels(ctrl);
		addBoardImage();
		
		this.setVisible(true);
	}
	
	
	public void addBoardImage() {
		ImageIcon imageIcon = new ImageIcon("graphics/ultimatemonopolyboard.png"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(1000, 1000,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back

		
		//BufferedImage myPic = ImageIO.read(new File("graphics\\ultimatemonopolyboard.png"));
		JLabel picLabel = new JLabel(imageIcon);
		
		

		this.getContentPane().add(picLabel);
	}
	
	public void addPlayerLabels(DomainController ctrl) {
		JPanel panel = new JPanel();
		this.getContentPane().add(panel, BorderLayout.EAST);
		
		JLabel lbl = new JLabel("Player 1");
		lbl.setToolTipText("<html>"
				+ "<p width=\"200\"> Player1</p>"
				+ "<p width=\"200\">Money: 2000</p>"
				+ "<ul>Owned Places:<li>Kentucky</li><li>Fried</li><li>Chiken</li></ul>"
				+ "</html>\"");
		panel.add(lbl);
		
		JLabel lbl_1 = new JLabel("Player 2");
		lbl_1.setToolTipText("<html>"
				+ "<p width=\"200\"> Player2</p>"
				+ "<p width=\"200\">Money: 9000</p>"
				+ "<ul>Owned Places:<li>Smells</li><li>Like</li><li>Teen</li><li>Spirit</li></ul>"
				+ "</html>\"");
		panel.add(lbl_1);
		
		JLabel lbl_2 = new JLabel("Player 3");
		lbl_2.setToolTipText("<html>"
				+ "<p width=\"200\"> Player3</p>"
				+ "<p width=\"200\">Money: 9001</p>"
				+ "<ul>Owned Places:<li>Fire</li><li>Water</li><li>Earth</li><li>Wood</li></ul>"
				+ "</html>\"");
		panel.add(lbl_2);
		
	}
	
	public void addButtons(DomainController ctrl) {
		JPanel panel = new JPanel();
		this.getContentPane().add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(4, 1, 10, 10));
		
		Button button = new Button("Roll Dice");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.rollPressed();
				
			}
		});
		panel.add(button);
		
		Button button_1 = new Button("Buy Deed");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.buyPressed();
			}
		});
		panel.add(button_1);
		
		Button button_2 = new Button("Build");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.buildPressed();
			}
		});
		panel.add(button_2);
		
		Button button_3 = new Button("End Turn");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.endTurnPressed();
			}
		});
		panel.add(button_3);
		

		panel.setVisible(true);
	}
	
	
	public void addPieces(DomainController ctrl) {
//		Player playerHat = (Player)ctrl.getPlayers().get(0);
//		Player playerCar = (Player)ctrl.getPlayers().get(1);
//
//		Piece pieceHat = new Piece(new JLabel(new ImageIcon("graphics/hat small.png")), playerHat, -25);
//		Piece pieceCar = new Piece(new JLabel(new ImageIcon("graphics/car small.png")), playerCar, 25);

		JLabel hatLbl = new JLabel(new ImageIcon("graphics/hat small.png"));
		this.getContentPane().add(hatLbl);
		hatLbl.setBounds(1025, 825, 50, 50);
		hatLbl.setVisible(true);
		
		JLabel carLbl = new JLabel(new ImageIcon("graphics/car small.png"));
		this.getContentPane().add(carLbl);
		carLbl.setBounds(1025, 775, 50, 50);
		carLbl.setVisible(true);
	}
	
	
	public static final int Y_OFFSET = 0;
	public static final int X_OFFSET = 0;
	public static final int HALFSQ = 56;

	public int getPixelx(int ind) {
		if ((ind <= 39 && ind >= 30) || ind == 0) {
			return X_OFFSET + HALFSQ*24;
		} else if ((ind >= 10 && ind <= 20)) {
			return X_OFFSET + HALFSQ*2;
		}
		switch (ind) {
		case 1: case 29:
			return X_OFFSET + HALFSQ*21;
		case 2: case 28:
			return X_OFFSET + HALFSQ*19;
		case 3: case 27:
			return X_OFFSET + HALFSQ*17;
		case 4: case 26:
			return X_OFFSET + HALFSQ*15;
		case 5: case 25:
			return X_OFFSET + HALFSQ*13;
		case 6: case 24:
			return X_OFFSET + HALFSQ*11;
		case 7: case 23:
			return X_OFFSET + HALFSQ*9;
		case 8: case 22:
			return X_OFFSET + HALFSQ*7;
		case 9: case 21:
			return X_OFFSET + HALFSQ*5;
		default:
			return X_OFFSET + HALFSQ*14;
		}
	}

	public int getPixely(int ind) {
		if ((ind <= 10 && ind >= 0)) {
			return X_OFFSET + HALFSQ*24;
		} else if ((ind >= 20 && ind <= 29)) {
			return X_OFFSET + HALFSQ*2;
		}
		
		
		switch (ind) {
		case 0: case 1: case 2:
		case 3: case 4: case 5:
			return Y_OFFSET + 11*HALFSQ;
		case 10: case 11: case 12:
		case 13: case 14: case 15:
			return Y_OFFSET + HALFSQ;
		case 9: case 16:
			return Y_OFFSET + HALFSQ*3;
		case 8: case 17:
			return Y_OFFSET + HALFSQ*5;
		case 7: case 18:
			return Y_OFFSET + HALFSQ*7;
		case 6: case 19:
			return Y_OFFSET + HALFSQ*9;
		default:
			return Y_OFFSET + HALFSQ*6;
		}
	}
	

}
