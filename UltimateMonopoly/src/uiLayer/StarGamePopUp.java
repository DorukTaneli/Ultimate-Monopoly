package uiLayer;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class StarGamePopUp extends Thread{
	
	private JFrame popFrame=new JFrame("StartGame");
	public boolean gameReady=false;
	public int gamePlayerNum=2;
	
	public void run() {
		StarGamePopUp s = new StarGamePopUp();
		popFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		popFrame.setAlwaysOnTop(true);
		popFrame.setBounds(200, 100, 400, 200);
		
		Container cont = popFrame.getContentPane();
		cont.setLayout(null);
		
		JLabel numofPlayer = new JLabel("Enter number of Players(2-12): ");
		numofPlayer.setBounds(60, 5, 250, 30);
		
		JTextField num = new JTextField("2");
		num.setBounds(65, 30, 250, 30);
		
		JButton button = new JButton("OK");
		button.setBounds(150, 90, 100, 30);
		button.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				gameReady=true;
				gamePlayerNum=Integer.parseInt(num.getText());
				
				new AppWindow();
				popFrame.dispose();
			} 
			} );
		
		
		cont.add(button);
		cont.add(numofPlayer);
		cont.add(num);
		popFrame.setVisible(true);
	}
	
	public StarGamePopUp(){
		
		
	}
	
	
	
}
