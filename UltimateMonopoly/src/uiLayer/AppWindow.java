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
	private int BOARD_SIZE = 830;
	private int WINDOW_X = 1400;
	private int WINDOW_Y = 850;
	private int Y_OFFSET = 0;
	private int X_OFFSET = 0;
	private int HALFSQ;
	private int PIECESIZE = 50;
	private int MIDLAYER;
	private int INNERLAYER;
	private int OUTERLAYER;
	private DomainController ctrl;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AppWindow();

	}

	public AppWindow() {
		setResizable(false);
		ctrl = new DomainController(this);
		this.setSize(WINDOW_X, WINDOW_Y);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Sawcon Ultimate Monopoly");


		addButtons();
		addPieces();
		addPlayerLabels();
		addBoardImage();
		updatePieceGUILocation();

		System.out.println("midlayer: " + MIDLAYER);
		System.out.println("halfsq: " + HALFSQ);


		this.setVisible(true);
	}



	public void addBoardImage() {
		ImageIcon imageIcon = new ImageIcon("graphics/ultimatemonopolyboard.png"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(BOARD_SIZE, BOARD_SIZE,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back
		HALFSQ = (int) (BOARD_SIZE/34.5);
		MIDLAYER = (int) (BOARD_SIZE/7.9);
		INNERLAYER = (int) (BOARD_SIZE/3.95);
		OUTERLAYER = (int) (BOARD_SIZE/103.75);
		boardLabel = new JLabel(imageIcon);
		boardLabel.setHorizontalAlignment(SwingConstants.LEFT);
		boardLabel.setBounds(0, 0, BOARD_SIZE, BOARD_SIZE);
		this.getContentPane().add(boardLabel);
	}

	public void addPlayerLabels() {
		JPanel panel = new JPanel();
		panel.setBounds(840, 0, 585, 750);
		this.getContentPane().add(panel);

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
		getContentPane().setLayout(null);			
		//BufferedImage myPic = ImageIO.read(new File("graphics\\ultimatemonopolyboard.png"));
		JPanel panel = new JPanel();
		panel.setBounds(900, 500, 366, 95);
		this.getContentPane().add(panel);
		panel.setLayout(new GridLayout(2, 4, 10, 10));

		Button button = new Button("Roll Dice");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==button) {
					System.out.println("**Roll button pressed!");
					ctrl.rollPressed();
				}

			}
		});
		panel.add(button);

		Button button_1 = new Button("Buy Deed");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==button_1) {
					System.out.println("**Buy Deed button pressed!");
					ctrl.buyPressed();
				}

			}
		});
		panel.add(button_1);

		Button button_2 = new Button("Build");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==button_2) {
					System.out.println("**Build button pressed!");
					ctrl.buildPressed();
				}

			}
		});
		panel.add(button_2);

		Button button_3 = new Button("End Turn");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==button_3) {
					System.out.println("**End Turn button pressed!");
					ctrl.endTurnPressed();
				}

			}
		});
		panel.add(button_3);
	}


	public void addPieces() {
		//		Player playerHat = (Player)ctrl.getPlayers().get(0);
		//		Player playerCar = (Player)ctrl.getPlayers().get(1);
		//
		//		Piece pieceHat = new Piece(new JLabel(new ImageIcon("graphics/hat small.png")), playerHat, -25);
		//		Piece pieceCar = new Piece(new JLabel(new ImageIcon("graphics/car small.png")), playerCar, 25);

		hatLbl = new JLabel(new ImageIcon("graphics/hat small.png"));
		this.getContentPane().add(hatLbl);
		hatLbl.setBounds(0, 0, 50, 50);
		hatLbl.setVisible(true);

		carLbl = new JLabel(new ImageIcon("graphics/car small.png"));
		this.getContentPane().add(carLbl);
		carLbl.setBounds(0, 0, 50, 50);
		//		carLbl.setBounds(getPixelX(0), getPixelY(0), 50, 50);
		carLbl.setVisible(true);
	}


	public void updatePieceGUILocation(){	
		int playerLocIndex = ctrl.getPlayers().get(1).piece.getLocation().getIndex();
		//		System.out.println("******** carLbl location should be: "+getPixelX(playerLocIndex));
		//		System.out.println("******** playerLocIndex: "+(playerLocIndex));
		//
		carLbl.setLocation(getPixelX(playerLocIndex) - PIECESIZE/2, getPixelY(playerLocIndex) - PIECESIZE/2);
		carLbl.setVisible(true);
		//		System.out.println("******** carLbl location: "+carLbl.getLocation());

		playerLocIndex = ctrl.getPlayers().get(0).piece.getLocation().getIndex();
		hatLbl.setLocation(getPixelX(playerLocIndex) - PIECESIZE/2, getPixelY(playerLocIndex) - PIECESIZE/2);
		hatLbl.setVisible(true);

	}




	public int getPixelX(int ind) {
		//		System.out.println("Current variables: "
		//				+ "\n X_OFFSET: "+ X_OFFSET
		//				+ "\n HALFSQ: "+HALFSQ
		//				+"\n MIDLAYER: "+MIDLAYER);
		//middleLayer
		if ((ind >= 30 && ind <= 39) || ind == 0)
			return X_OFFSET + HALFSQ*24 + MIDLAYER;
		else if ((ind >= 10 && ind <= 20))
			return X_OFFSET + HALFSQ*2 + MIDLAYER;
		//innerLayer
		if ((ind >= 58 && ind <= 63) || ind == 40)
			return X_OFFSET + HALFSQ*16 + INNERLAYER;
		else if ((ind >= 46 && ind <= 52))
			return X_OFFSET + HALFSQ*2 + INNERLAYER;
		//middleLayer
		if ((ind >= 106 && ind <= 119) || ind == 65)
			return X_OFFSET + HALFSQ*32 + OUTERLAYER;
		else if ((ind >= 78 && ind <= 92))
			return X_OFFSET + HALFSQ*2 + OUTERLAYER;
		
		switch (ind) {
		case 103: case 29: case 1: case 67:
			return X_OFFSET + HALFSQ*21 + MIDLAYER;
		case 102: case 28: case 2: case 68:
			return X_OFFSET + HALFSQ*19 + MIDLAYER;
		case 101: case 27: case 57: case 41: case 3: case 69:
			return X_OFFSET + HALFSQ*17 + MIDLAYER;
		case 100: case 26: case 56: case 42: case 4: case 70:
			return X_OFFSET + HALFSQ*15 + MIDLAYER;
		case 99: case 25: case 55: case 43: case 5: case 71:
			return X_OFFSET + HALFSQ*13 + MIDLAYER;
		case 98: case 24: case 54: case 44: case 6: case 72:
			return X_OFFSET + HALFSQ*11 + MIDLAYER;
		case 97: case 23: case 53: case 45: case 7: case 73:
			return X_OFFSET + HALFSQ*9 + MIDLAYER;
		case 96: case 22: case 8: case 74:
			return X_OFFSET + HALFSQ*7 + MIDLAYER;
		case 95: case 21: case 9: case 75:
			return X_OFFSET + HALFSQ*5 + MIDLAYER;
		case 94: case 76:
			return X_OFFSET + HALFSQ*7 + OUTERLAYER;
		case 93: case 77:
			return X_OFFSET + HALFSQ*5 + OUTERLAYER;
		case 104: case 66:
			return X_OFFSET + HALFSQ*27 + OUTERLAYER;
		case 105: case 65:
			return X_OFFSET + HALFSQ*29 + OUTERLAYER;
		default:
			return HALFSQ*18;
		}
	}

	public int getPixelY(int ind) {
		//middle Layer ifs
		if ((ind >= 0 && ind <= 10))
			return Y_OFFSET + HALFSQ*24 + MIDLAYER;
		else if ((ind >= 20 && ind <= 29))
			return Y_OFFSET + HALFSQ*2 + MIDLAYER;
		//inner Layer ifs
		if ((ind >= 40  && ind <= 46))
			return Y_OFFSET + HALFSQ*16 + INNERLAYER;
		else if ((ind >= 52 && ind <= 58))
			return Y_OFFSET + HALFSQ*2 + INNERLAYER;
		//outer Layer ifs
		if ((ind >= 64  && ind <= 78))
			return Y_OFFSET + HALFSQ*32 + OUTERLAYER;
		else if ((ind >= 92 && ind <= 106))
			return Y_OFFSET + HALFSQ*2 + OUTERLAYER;
		
		//switches
		switch (ind) {
		case 89: case 19: case 31: case 109:
			return Y_OFFSET + HALFSQ*5 + MIDLAYER;
		case 88: case 18: case 32: case 110:
			return Y_OFFSET + HALFSQ*7 + MIDLAYER;
		case 87: case 17:  case 51: case 59: case 33: case 111: 
			return Y_OFFSET + HALFSQ*9 + MIDLAYER;
		case 86: case 16: case 50: case 60: case 34: case 112:
			return Y_OFFSET + HALFSQ*11 + MIDLAYER;
		case 85: case 15: case 49: case 61: case 35: case 113:
			return Y_OFFSET + HALFSQ*13 + MIDLAYER;
		case 84: case 14: case 48: case 62: case 36: case 114:
			return Y_OFFSET + HALFSQ*15 + MIDLAYER;
		case 83: case 13: case 47: case 63: case 37: case 115:
			return Y_OFFSET + HALFSQ*17 + MIDLAYER;
		case 82: case 12: case 38: case 116:
			return Y_OFFSET + HALFSQ*19 + MIDLAYER;
		case 81: case 11: case 39: case 117:
			return Y_OFFSET + HALFSQ*21 + MIDLAYER;
		case 91: case 107:
			return Y_OFFSET + HALFSQ*5 + OUTERLAYER;
		case 90: case 108:
			return Y_OFFSET + HALFSQ*7 + OUTERLAYER;
		case 80: case 118:
			return Y_OFFSET + HALFSQ*25 + OUTERLAYER;
		case 79: case 119:
			return Y_OFFSET + HALFSQ*27 + OUTERLAYER;
		default:
			return HALFSQ*18;
		}
	}
}
