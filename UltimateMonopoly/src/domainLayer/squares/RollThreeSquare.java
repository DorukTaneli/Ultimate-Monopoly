package domainLayer.squares;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import domainLayer.Cup;
import domainLayer.DomainController;
import domainLayer.Player;
import domainLayer.cards.RollThreeCard;
import uiLayer.AppWindow;

public class RollThreeSquare extends RegularSquare{
	int[] d={0,0,0};
	RollThreeCard dummy=new RollThreeCard("dummy",d);
	Cup cup;
	
	public RollThreeSquare(String name, int index) {
		super(name, index);
		cup=new Cup();
	}
	
	public RollThreeCard drawRollThreeCard() {
		
		if(AppWindow.getInstance().ctrl.getRollThreeDeck().size()==0) {
			return dummy;
		}else {
			int len=AppWindow.getInstance().ctrl.getRollThreeDeck().size();
			int card=(int) Math.floor((Math.random() * len));
			RollThreeCard drawn=AppWindow.getInstance().ctrl.getRollThreeDeck().get(card);
			AppWindow.getInstance().ctrl.getRollThreeDeck().remove(card);
			return drawn;
		}
	}
	
	
	public void landedOn(Player p) {
	
		cup.roll();
		int no1=cup.getFirstDie();
		int no2=cup.getSecondDie();
		int no3=cup.getThirdDie();
		List<Player> plyrs=AppWindow.getInstance().ctrl.getPlayers();
		RollThreeCard drawn=drawRollThreeCard();
		if(drawn!=dummy) {
		for(int i=0;i<plyrs.size();i++) {
			if(plyrs.get(i)==p) {
				p.keepCard(drawn);
				int c=0;
				int a=c;
				for(int j=0;j<p.getRollThreeCards().size();j++) {
					RollThreeCard crd=(RollThreeCard) p.getRollThreeCards().get(j);
					//p.addCash(crd.getReward(no1, no2, no3, true));
					c=crd.getReward(no1, no2, no3, true);
					if(a<c) {
						a=c;
					}
					System.out.println("Player rolled: "+no1+" "+no2+" "+no3);
					System.out.println("Card drawn "+drawn.numbers[0]+" "+drawn.numbers[1]+" "+drawn.numbers[2]);
				}
				p.addCash(a);
			}else {
				int c=0;
				int a=c;
				for(int j=0;j<plyrs.get(i).getRollThreeCards().size();j++) {
					RollThreeCard crd=(RollThreeCard) plyrs.get(i).getRollThreeCards().get(j);
					//plyrs.get(i).addCash(crd.getReward(no1, no2, no3, false));
					c=crd.getReward(no1, no2, no3, false);
					if(a<c) {
						a=c;
					}
				}
				System.out.println("Player:"+plyrs.get(i).getName()+" won "+a);
				plyrs.get(i).addCash(a);
			}
			
			//p.addCash(drawn.getReward(no1,no2,no3,true));
			//drawn.getReward(no1,no2,no3,p.haveRolled());
		}
		//System.out.println("Player rolled: "+no1+" "+no2+" "+no3);
		//System.out.println("Card drawn "+drawn.numbers[0]+" "+drawn.numbers[1]+" "+drawn.numbers[2]);
	}else {
		System.out.println("No cards left to draw!!!");
		}	
	}
	
	
}
