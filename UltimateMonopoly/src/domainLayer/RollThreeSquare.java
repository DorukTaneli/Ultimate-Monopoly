package domainLayer;

public class RollThreeSquare extends RegularSquare{
	private RollThreeCard[] cards={(new RollThreeCard("kart1",new int[] {1,2,4})),(new RollThreeCard("kart2",new int[] {1,2,5}))};
	Cup cup;
	public RollThreeSquare(String name, int index) {
		super(name, index);
		cup=new Cup();
	}
	
	public RollThreeCard drawRollThreeCard() {
		int len=cards.length;
		int card=(int) Math.floor(((Math.random() * len)+1));
		return cards[card];
	}
	
	public void landedOn(Player p) {
		cup.roll();
		int no1=cup.getFirstDie();
		int no2=cup.getSecondDie();
		int no3=cup.getThirdDie();
		RollThreeCard drawn=drawRollThreeCard();
		drawn.getReward(no1,no2,no3,p.haveRolled());
	}
	
	
	
}
