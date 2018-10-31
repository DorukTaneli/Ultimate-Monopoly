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
		Player playerHat = (Player)ctrl.getPlayers().get(0);
		Player playerCar = (Player)ctrl.getPlayers().get(1);

		Piece pieceHat = new Piece(new JLabel(new ImageIcon("graphics\\hat small.png")), playerHat, -25);
		Piece pieceCar = new Piece(new JLabel(new ImageIcon("graphics\\car small.png")), playerCar, 25);
		

		JLabel hatLbl = pieceHat.getJLabel();
		this.getContentPane().add(hatLbl);
		hatLbl.setBounds(1125, 825, 50, 50);
		hatLbl.setVisible(true);
		
		JLabel carLbl = pieceCar.getJLabel();
		this.getContentPane().add(carLbl);
		carLbl.setBounds(1125, 775, 50, 50);
		carLbl.setVisible(true);
	}
	
	
	public static final int Y_OFFSET = 0;
	public static final int X_OFFSET = 0;
	public static final int HALFSQ = 56;

	public int getPixelx(Square sq) {
		int ind = sq.getIndex();
		switch (ind) {
		case 0: case 19: case 18:
		case 17: case 16: case 15:
			return HALFSQ*11;
		case 5: case 6: case 7:
		case 8: case 9: case 10:
			return HALFSQ*1;
		case 4: case 11:
			return HALFSQ*3;
		case 3: case 12:
			return HALFSQ*5;
		case 2: case 13:
			return HALFSQ*7;
		case 1: case 14:
			return HALFSQ*9;
		default:
			return HALFSQ*6;
		}
	}

	public int getPixely(Square sq) {
		int ind = sq.getIndex();
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
