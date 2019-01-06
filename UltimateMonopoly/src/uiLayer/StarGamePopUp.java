package uiLayer;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import domainLayer.LoadSave;

public class StarGamePopUp extends Thread  implements Serializable{
	
	private JFrame popFrame=new JFrame("StartGame");
	public boolean gameReady=false;
	public int gamePlayerNum=2;
	public int gameBotNum=0;
	
	public void run() {
		StarGamePopUp s = new StarGamePopUp();
		popFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		popFrame.setAlwaysOnTop(true);
		popFrame.setBounds(200, 100, 400, 200);
		
		Container cont = popFrame.getContentPane();
		cont.setLayout(null);
		
		
		//Player num UI
		JLabel numofPlayer = new JLabel("Enter number of Players(2-12): ");
		numofPlayer.setBounds(60, 5, 250, 30);
		
		JTextField num = new JTextField("3");
		num.setBounds(65, 30, 250, 30);
		
		
		//Bot num UI
		JLabel numofBots = new JLabel("Enter number of Bots(2-12): ");
		numofBots.setBounds(60, 55, 250, 30);
		
		JTextField num2 = new JTextField("0");
		num2.setBounds(65, 80, 250, 30);
		
		JButton button = new JButton("Start New Game");
		button.setBounds(60, 115, 140, 30);
		button.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				gameReady=true;
				gamePlayerNum=Integer.parseInt(num.getText());
				gameBotNum=Integer.parseInt(num2.getText());
				new AppWindow();
				popFrame.dispose();
			} 
			} );
		
		JButton button2 = new JButton("Load Game");
		button2.setBounds(210, 115, 100, 30);
		button2.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				LoadSave ls = new LoadSave(1);
				gameReady=true;
				AppWindow game = ls.load(1); 
				game.setVisible(true);
				//game.initialize();
				popFrame.dispose();
			} 
			} );
		
		
		cont.add(button);
		cont.add(numofPlayer);
		cont.add(num);
		cont.add(numofBots);
		cont.add(num2);
		cont.add(button2);
		popFrame.setVisible(true);
	}
	
	public StarGamePopUp(){
		
		
	}
	
	
	
}
