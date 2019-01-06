package uiLayer;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.*;

import domainLayer.DomainController;
import domainLayer.Player;
import domainLayer.Publisher;
import domainLayer.SaveLoad;
import domainLayer.squares.Square;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Button;


public class AppWindow extends JFrame implements PropertyListener,Serializable{

	private static StarGamePopUp pop;
	private JLabel[] playerPieceLabels;
	private Button[] allButtons;
	public int numOfPlayers;
	public int numOfBots;
	private JLabel boardLabel;
	private JLabel[] playerUILabels;
	private JLabel[] playerMoneyLabels;
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
	public static volatile AppWindow instance;

	public static void main(String[] args) {
		instance=null;
		pop = new StarGamePopUp();
		pop.start();
	}



	public AppWindow() {
		numOfPlayers = pop.gamePlayerNum;
		numOfBots = pop.gameBotNum;
		instance=this;
		setResizable(false);
		this.setSize(WINDOW_X, WINDOW_Y);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Sawcon Ultimate Monopoly");
		setDomain(new DomainController(numOfPlayers,numOfBots));
		ctrl.addPropertyListeners(instance);
		this.initialize();

	}
	
	public void setDomain(DomainController dmn) {
		this.ctrl=dmn;
	}
	
	public AppWindow(DomainController apw) { //Used when loading the game
		numOfPlayers = apw.PLAYERS_TOTAL;
		numOfBots = apw.BOTS_NUM_TOTAL;
		instance=this;
		System.out.println("Loading player num: "+apw.PLAYERS_TOTAL+" \nLoading bot num: "+apw.BOTS_NUM_TOTAL);
		setResizable(false);
		this.setSize(WINDOW_X, WINDOW_Y);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Sawcon Ultimate Monopoly");
		setDomain(apw);
		ctrl.addPropertyListeners(instance);
		
		
		this.initialize();
		ctrl.publishPlayers();
	}
	

	public void initialize() {
		System.out.println("Setting up AppWindow with "+numOfPlayers+" players.");
		setUpLabels(numOfPlayers);
		addButtons();
		addPlayerLabels();
		addBoardImage();
		updatePieceGUILocation();
		System.out.println("Game Starting...");		
		this.setVisible(true);
	}

	public static AppWindow getInstance() {
		if(instance == null) {
			instance = new AppWindow();
		}

		return instance;

	}
	public int getNumOfPlayers() {
		return numOfPlayers;
	}

	public int getNumOfBots() {
		return numOfBots;
	}

	private String[] imagePaths= {"graphics/hat small.png",
			"graphics/car small.png",
			"graphics/presentRed.png",
			"graphics/car smalBluel.png",
			"graphics/greenBoot.png",
			"graphics/car smallGreen.png",
			"graphics/presentBlue.png",
			"graphics/yellowBoot.png",
			"graphics/car smallLightBlue.png",
			"graphics/presentGreen.png",
			"graphics/saw.png","graphics/redBoot.png" };

	public void setUpLabels(int no) {
		playerPieceLabels=new JLabel[no];
		playerUILabels=new JLabel[no];
		playerMoneyLabels= new JLabel[no];
		int k=0;

		for(int i=0;i<no;i++) {	
			if(i%3==0) k+=80; //For Vertical placement
			playerPieceLabels[i] = new JLabel(new ImageIcon(imagePaths[i]));
			playerPieceLabels[i].setBounds(0, 0, 50, 50);
			playerPieceLabels[i].setVisible(true);

			playerMoneyLabels[i] = new JLabel("1500");
			playerMoneyLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
			playerMoneyLabels[i].setBounds(150+(i%3)*100, k+54, 46, 16);

			playerUILabels[i] = new JLabel("Player "+i);
			playerUILabels[i].setBounds(150+(i%3)*100, k+27, 56, 16);
			playerUILabels[i].setToolTipText(generateHTML(new ArrayList<Square>()));

		}


	}

	public void addBoardImage() {
		ImageIcon imageIcon = new ImageIcon("graphics/ultimatemonopolyboard.png"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(BOARD_SIZE, BOARD_SIZE,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back
		HALFSQ = (int) (BOARD_SIZE/34.5);
		MIDLAYER = (int) (BOARD_SIZE/7.9);
		INNERLAYER=(int) (BOARD_SIZE/3.95);
		OUTERLAYER=(int) (BOARD_SIZE/103.75);
		boardLabel = new JLabel(imageIcon);
		boardLabel.setHorizontalAlignment(SwingConstants.LEFT);
		boardLabel.setBounds(0, 0, BOARD_SIZE, BOARD_SIZE);
		this.getContentPane().add(boardLabel);
	}

	public void addPlayerLabels() {
		JPanel playerPanel = new JPanel();
		playerPanel.setBounds(840, 0, 585, 500);
		this.getContentPane().add(playerPanel);
		playerPanel.setLayout(null);
		for(int i=0;i<numOfPlayers;i++) {
			this.getContentPane().add(playerPieceLabels[i]);
			playerPanel.add(playerUILabels[i]);
			playerPanel.add(playerMoneyLabels[i]);
			playerPieceLabels[i].setVisible(true);
			playerUILabels[i].setVisible(true);
			playerMoneyLabels[i].setVisible(true);
		}


	}

	public void addButtons() {
		allButtons= new Button[6];
		getContentPane().setLayout(null);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(930, 550, 366, 200);
		buttonPanel.setLayout(new GridLayout(4, 2, 10, 10));
		getContentPane().add(buttonPanel);
		buttonPanel.setVisible(true);

		Button button = new Button("Roll Dice");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==button) {
					System.out.println("**Roll button pressed!");
					ctrl.rollPressed(instance);
				}

			}
		});
		
		buttonPanel.add(button);
		allButtons[0]=button;

		Button button_1 = new Button("Buy Deed");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==button_1) {
					System.out.println("**Buy Deed button pressed!");
					ctrl.buyPressed();
				}

			}
		});
		buttonPanel.add(button_1);
		allButtons[1]=button_1;

		Button button_2 = new Button("Build");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==button_2) {
					System.out.println("**Build button pressed!");
					ctrl.buildPressed();
				}

			}
		});
		buttonPanel.add(button_2);
		allButtons[2]=button_2;

		Button button_3 = new Button("End Turn");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==button_3) {
					System.out.println("**End Turn button pressed!\n");
					ctrl.endTurnPressed();
				}

			}
		});
		buttonPanel.add(button_3);
		allButtons[3]=button_3;

		Button button_4 = new Button("Pause");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand() == "Pause") {
					System.out.println("**Pause button pressed!\n");
					button.setEnabled(false);
					button_1.setEnabled(false);
					button_2.setEnabled(false);
					button_3.setEnabled(false);
					button_4.setLabel("Unpause");	
				}

				if(e.getActionCommand() == "Unpause") {
					System.out.println("**Unpause button pressed!\n");
					button.setEnabled(true);
					button_1.setEnabled(true);
					button_2.setEnabled(true);
					button_3.setEnabled(true);
					button_4.setLabel("Pause");
				}
			}
		});
		buttonPanel.add(button_4);
		allButtons[4]=button_4;

		
		
		Button button_5 = new Button("Save Game");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("**Save button pressed\n.");
				ctrl.savePressed();
				
			}
		});
		buttonPanel.add(button_5);
		allButtons[5]=button_5;

	}



	public void updatePieceGUILocation(){	
		if(!ctrl.playersAreSet) return;
		for(int i=0;i<numOfPlayers;i++) {
			int playerLocIndex = ctrl.getPlayers().get(i).piece.getLocation().getIndex();
			playerPieceLabels[i].setLocation(getPixelX(playerLocIndex) - PIECESIZE/2, getPixelY(playerLocIndex) - PIECESIZE/2);

		}

	}


	public String generateHTML(ArrayList<Square> sqrs) { //should this be a new class?
		String[] names = new String[sqrs.size()];
		int[] buildings = new int[sqrs.size()];

		for(int i=0;i<sqrs.size();i++) {
			Square sq = sqrs.get(i);
			names[i]=sq.getName();
			//buildings[i]=sq.getBuildingNum();
		}

		String str = "<html>"
				+ "<p width=\"200\"></p>"
				+ "<ul>Owned Places:"+generateHTMLList(Arrays.asList(names))+"</ul>"
				+ "</html>\"";


		return str;
	}

	public String generateHTMLList(List<String> lst) {
		String ret="";
		for(int i=0;i<lst.size();i++) {
			ret+="<li>"+lst.get(i)+"</li>";

		}
		return ret;
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


	@Override
	public void onPropertyEvent(Publisher pb, String type, Object val) {
		// TODO Auto-generated method stub
		System.out.println("Observer got the message "+ val);
		if(type=="Money") {
			switch(((Player)pb).getName()) {
			case "Player0": playerMoneyLabels[0].setText((String)val); break;
			case "Player1": playerMoneyLabels[1].setText((String)val); break;
			case "Player2": playerMoneyLabels[2].setText((String)val); break;
			case "Player3": playerMoneyLabels[3].setText((String)val); break;
			case "Player4": playerMoneyLabels[4].setText((String)val); break;
			case "Player5": playerMoneyLabels[5].setText((String)val); break;
			case "Player6": playerMoneyLabels[6].setText((String)val); break;
			case "Player7": playerMoneyLabels[7].setText((String)val); break;
			case "Player8": playerMoneyLabels[8].setText((String)val); break;
			case "Player9": playerMoneyLabels[9].setText((String)val); break;
			case "Player10": playerMoneyLabels[10].setText((String)val); break;
			case "Player11": playerMoneyLabels[11].setText((String)val); break;
			}
		}
		else if(type=="Location") {

		}
		else if(type=="Purchase") {
			switch(((Player)pb).getName()) {
			case "Player0": playerUILabels[0].setToolTipText(generateHTML((ArrayList<Square>)val)); break;
			case "Player1": playerUILabels[1].setToolTipText(generateHTML((ArrayList<Square>)val)); break;
			case "Player2": playerUILabels[2].setToolTipText(generateHTML((ArrayList<Square>)val)); break;
			case "Player3": playerUILabels[3].setToolTipText(generateHTML((ArrayList<Square>)val)); break;
			case "Player4": playerUILabels[4].setToolTipText(generateHTML((ArrayList<Square>)val)); break;
			case "Player5": playerUILabels[5].setToolTipText(generateHTML((ArrayList<Square>)val)); break;
			case "Player6": playerUILabels[6].setToolTipText(generateHTML((ArrayList<Square>)val)); break;
			case "Player7": playerUILabels[7].setToolTipText(generateHTML((ArrayList<Square>)val)); break;
			case "Player8": playerUILabels[8].setToolTipText(generateHTML((ArrayList<Square>)val)); break;
			case "Player9": playerUILabels[9].setToolTipText(generateHTML((ArrayList<Square>)val)); break;
			case "Player10": playerUILabels[10].setToolTipText(generateHTML((ArrayList<Square>)val)); break;
			case "Player11": playerUILabels[11].setToolTipText(generateHTML((ArrayList<Square>)val)); break;

			}
		}
		else {

		}
	}
}
