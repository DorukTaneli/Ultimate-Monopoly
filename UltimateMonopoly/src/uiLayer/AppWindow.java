package uiLayer;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import domainLayer.DomainController;
import domainLayer.Player;
import domainLayer.Square;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Button;

public class AppWindow extends JFrame{
	
	private JLabel boardLabel;
	private JLabel hatLbl;
	private JLabel carLbl;
	private int Y_OFFSET;
	private int X_OFFSET;
	private int HALFSQ;
	private int MIDLAYER;
	private DomainController ctrl;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AppWindow();
		
	}
	
	public AppWindow() {
		setResizable(false);
		ctrl = new DomainController(this);
		this.setSize(1600,1050);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Sawcon Ultimate Monopoly");
		
		addButtons();
		
		addPieces();
		addPlayerLabels();
		addBoardImage();
				
		this.setVisible(true);
	}
	
	
	public void addBoardImage() {
		ImageIcon imageIcon = new ImageIcon("graphics/ultimatemonopolyboard.png"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(1000, 1000,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back

		
		//BufferedImage myPic = ImageIO.read(new File("graphics\\ultimatemonopolyboard.png"));
		boardLabel = new JLabel(imageIcon);
		X_OFFSET = 375;
		//System.out.println("X_OFFSET is" +X_OFFSET);
		Y_OFFSET = 75;
		HALFSQ = (int) (1000/35);
		MIDLAYER = (int) (HALFSQ*1.1);

		this.getContentPane().add(boardLabel);
	}
	
	public void addPlayerLabels() {
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
	
	public void addButtons() {
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
	
	
	public void addPieces() {
//		Player playerHat = (Player)ctrl.getPlayers().get(0);
//		Player playerCar = (Player)ctrl.getPlayers().get(1);
//
//		Piece pieceHat = new Piece(new JLabel(new ImageIcon("graphics/hat small.png")), playerHat, -25);
//		Piece pieceCar = new Piece(new JLabel(new ImageIcon("graphics/car small.png")), playerCar, 25);

		hatLbl = new JLabel(new ImageIcon("graphics/hat small.png"));
		this.getContentPane().add(hatLbl);
		hatLbl.setBounds(1025, 825, 50, 50);
		hatLbl.setVisible(true);
		
		carLbl = new JLabel(new ImageIcon("graphics/car small.png"));
		this.getContentPane().add(carLbl);
		carLbl.setBounds(1025, 775, 50, 50);
		carLbl.setVisible(true);
	}
	

	public void updatePieceGUILocation(){	
		int playerLocIndex = ctrl.getPlayers().get(1).piece.getLocation().getIndex();
		//System.out.println("******** carLbl location should be: "+getPixelX(playerLocIndex));
		//System.out.println("******** playerLocIndex: "+(playerLocIndex));
		//
		carLbl.setLocation(getPixelX(playerLocIndex), getPixelY(playerLocIndex));
		carLbl.setVisible(true);
		//System.out.println("******** carLbl location: "+carLbl.getLocation());
		
		playerLocIndex = ctrl.getPlayers().get(0).piece.getLocation().getIndex();
		hatLbl.setLocation(getPixelX(playerLocIndex), getPixelY(playerLocIndex));
		hatLbl.setVisible(true);

	

	}
		
	

	
	public int getPixelX(int ind) {
		//System.out.println("Current variables: "
		//		+ "\n X_OFFSET: "+ X_OFFSET
//				+ "\n HALFSQ: "+HALFSQ
//				+"\n MIDLAYER: "+MIDLAYER);
		if ((ind <= 39 && ind >= 30) || ind == 0) {
			return X_OFFSET + HALFSQ*24 + MIDLAYER;
		} else if ((ind >= 10 && ind <= 20)) {
			return X_OFFSET + HALFSQ*2 + MIDLAYER;
		}
		switch (ind) {
		case 1: case 29:
			return X_OFFSET + HALFSQ*21 + MIDLAYER;
		case 2: case 28:
			return X_OFFSET + HALFSQ*19 + MIDLAYER;
		case 3: case 27:
			return X_OFFSET + HALFSQ*17 + MIDLAYER;
		case 4: case 26:
			return X_OFFSET + HALFSQ*15 + MIDLAYER;
		case 5: case 25:
			return X_OFFSET + HALFSQ*13 + MIDLAYER;
		case 6: case 24:
			return X_OFFSET + HALFSQ*11 + MIDLAYER;
		case 7: case 23:
			return X_OFFSET + HALFSQ*9 + MIDLAYER;
		case 8: case 22:
			return X_OFFSET + HALFSQ*7 + MIDLAYER;
		case 9: case 21:
			return X_OFFSET + HALFSQ*5 + MIDLAYER;
		default:
			return X_OFFSET + HALFSQ*14 + MIDLAYER;
		}
	}

	public int getPixelY(int ind) {
		if ((ind <= 10 && ind >= 0)) {
			return Y_OFFSET + HALFSQ*24 + MIDLAYER;
		} else if ((ind >= 20 && ind <= 29)) {
			return Y_OFFSET + HALFSQ*2 + MIDLAYER;
		}
		switch (ind) {
		case 19: case 31:
			return Y_OFFSET + HALFSQ*5 + MIDLAYER;
		case 18: case 32:
			return Y_OFFSET + HALFSQ*7 + MIDLAYER;
		case 17: case 33:
			return Y_OFFSET + HALFSQ*9 + MIDLAYER;
		case 16: case 34:
			return Y_OFFSET + HALFSQ*11 + MIDLAYER;
		case 15: case 35:
			return Y_OFFSET + HALFSQ*13 + MIDLAYER;
		case 14: case 36:
			return Y_OFFSET + HALFSQ*15 + MIDLAYER;
		case 13: case 37:
			return Y_OFFSET + HALFSQ*17 + MIDLAYER;
		case 12: case 38:
			return Y_OFFSET + HALFSQ*19 + MIDLAYER;
		case 11: case 39:
			return Y_OFFSET + HALFSQ*21 + MIDLAYER;
		default:
			return Y_OFFSET + HALFSQ*14 + MIDLAYER;
		}
	}
}
