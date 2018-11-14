package domainLayer;

import domainLayer.Cup;
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
		RollThreeCard drawn=drawRollThreeCard();
		p.addCash(drawn.getReward(no1,no2,no3,true));
		drawn.getReward(no1,no2,no3,p.haveRolled());
		System.out.println("Player rolled: "+no1+" "+no2+" "+no3);
		System.out.println("Card drawn "+drawn.numbers[0]+" "+drawn.numbers[1]+" "+drawn.numbers[2]);
	}
	
	
	
}
