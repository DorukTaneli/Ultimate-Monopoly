package domainLayer.squares;

import java.util.ArrayList;
import java.util.List;

import domainLayer.Cup;
import domainLayer.DomainController;
import domainLayer.Player;
import domainLayer.cards.RollThreeCard;
public class RollThreeSquare extends RegularSquare{
	private RollThreeCard[] cards={(new RollThreeCard("kart1",new int[] {1,2,4})),(new RollThreeCard("kart2",new int[] {1,2,5}))};
	Cup cup;
	public RollThreeSquare(String name, int index) {
		super(name, index);
		cup=new Cup();
	}
	
	public RollThreeCard drawRollThreeCard() {
		int len=cards.length;
		int card=(int) Math.floor((Math.random() * len));
		return cards[card];
	}
	
	public void landedOn(Player p) {
	
		cup.roll();
		int no1=cup.getFirstDie();
		int no2=cup.getSecondDie();
		int no3=cup.getThirdDie();
		List<Player> plyrs=DomainController.getInstance().getPlayers();
		for(int i=0;i<plyrs.size();i++) {
			RollThreeCard drawn=drawRollThreeCard();
			if(plyrs.get(i)==p) {
				p.keepCard(drawn);
				for(int j=0;j<p.getRollThreeCards().size();j++) {
					RollThreeCard crd=(RollThreeCard) p.getRollThreeCards().get(j);
					p.addCash(crd.getReward(no1, no2, no3, true));
					System.out.println("Player rolled: "+no1+" "+no2+" "+no3);
					System.out.println("Card drawn "+drawn.numbers[0]+" "+drawn.numbers[1]+" "+drawn.numbers[2]);
				}
			}else {
				for(int j=0;j<plyrs.get(i).getRollThreeCards().size();j++) {
					RollThreeCard crd=(RollThreeCard) plyrs.get(i).getRollThreeCards().get(j);
					plyrs.get(i).addCash(crd.getReward(no1, no2, no3, false));
					System.out.println("Player:"+plyrs.get(i).getName()+" won "+crd.getReward(no1, no2, no3, false));
				}
			}
			
			//p.addCash(drawn.getReward(no1,no2,no3,true));
			//drawn.getReward(no1,no2,no3,p.haveRolled());
		}
		//System.out.println("Player rolled: "+no1+" "+no2+" "+no3);
		//System.out.println("Card drawn "+drawn.numbers[0]+" "+drawn.numbers[1]+" "+drawn.numbers[2]);
	}
	
	
	
}
