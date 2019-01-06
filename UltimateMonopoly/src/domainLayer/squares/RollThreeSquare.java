package domainLayer.squares;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import domainLayer.Cup;
import domainLayer.DomainController;
import domainLayer.Player;
import domainLayer.cards.RollThreeCard;
public class RollThreeSquare extends RegularSquare  implements Serializable{
	private ArrayList<RollThreeCard> cards=new ArrayList<RollThreeCard>();
	private RollThreeCard[] rtcards={(new RollThreeCard("rtcard1",new int[] {1,2,3})),(new RollThreeCard("rtcard2",new int[] {1,2,4}))
			,(new RollThreeCard("rtcard3",new int[] {1,2,5})),(new RollThreeCard("rtcard4",new int[] {1,2,6}))
			,(new RollThreeCard("rtcard5",new int[] {1,3,4})),(new RollThreeCard("rtcard6",new int[] {1,3,5}))
			,(new RollThreeCard("rtcard7",new int[] {1,4,5})),(new RollThreeCard("rtcard8",new int[] {1,4,6}))
			,(new RollThreeCard("rtcard9",new int[] {1,5,6})),(new RollThreeCard("rtcard10",new int[] {2,3,4}))
			,(new RollThreeCard("rtcard11",new int[] {2,4,5})),(new RollThreeCard("rtcard12",new int[] {2,4,6}))
			,(new RollThreeCard("rtcard13",new int[] {2,5,6})),(new RollThreeCard("rtcard14",new int[] {3,4,5}))
			,(new RollThreeCard("rtcard15",new int[] {3,4,6})),(new RollThreeCard("rtcard16",new int[] {3,5,6}))
			,(new RollThreeCard("rtcard17",new int[] {4,5,6})),(new RollThreeCard("rtcard18",new int[] {2,4,6}))
			,(new RollThreeCard("rtcard19",new int[] {2,5,6})),(new RollThreeCard("rtcard20",new int[] {3,4,5}))
			,(new RollThreeCard("rtcard121",new int[] {3,4,6})),(new RollThreeCard("rtcard22",new int[] {3,5,6}))
			,(new RollThreeCard("rtcard123",new int[] {4,5,6})),(new RollThreeCard("rtcard24",new int[] {1,3,6}))};
	Cup cup;
	
	public RollThreeSquare(String name, int index) {
		super(name, index);
		cup=new Cup();
		initializeDeck();
	}
	
	public RollThreeCard drawRollThreeCard() {
		int len=cards.size();
		int card=(int) Math.floor((Math.random() * len));
		RollThreeCard drawn=cards.get(card);
		cards.remove(card); // might remove this line
		return drawn;
	}
	
	
	public void initializeDeck() {
		for(int i=0;i<rtcards.length;i++) {
			cards.add(rtcards[i]);
		}
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
	}
	
	
	
}
