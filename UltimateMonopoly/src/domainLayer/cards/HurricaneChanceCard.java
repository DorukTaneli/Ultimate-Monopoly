package domainLayer.cards;

import java.util.List;
import java.util.Scanner;

import domainLayer.DomainController;
import domainLayer.Player;
import domainLayer.squares.DeedSquare;
import domainLayer.squares.Square;

public class HurricaneChanceCard extends ChanceCard {

	public HurricaneChanceCard(String name, Boolean keepable) {
		super(name, keepable);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void cardAction() {
		// TODO Auto-generated method stub
		List<Player> playerList=DomainController.getInstance().getPlayers();
		if(usable(playerList)) {
			System.out.println("Enter a color group to use Hurricane: ");
			Scanner scanner = new Scanner(System.in);
			String color = scanner.nextLine();
			System.out.println("Enter a player index: ");
			int playerIndex=scanner.nextInt();
			if(playerIndex>=0 && playerIndex<playerList.size()) {
				Player p=playerList.get(playerIndex);
				List<Square> properties=p.getPlayerProperties();
				for(Square sq:properties) {
					if(sq instanceof DeedSquare) {
						DeedSquare dsq=(DeedSquare) sq;
						if(dsq.getColor()==color) {
							dsq.demolish(p, true);
							System.out.println("A building is demolished from "+ dsq.getName());
						}
					}
				}
			}
		}
	}


	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean usable(List<Player> playerList) {
		for(Player p: playerList) {
			List<Square> properties= p.getPlayerProperties();
			for(Square sq:properties) {
				if(sq instanceof DeedSquare) {
					DeedSquare dsq=(DeedSquare) sq;
					if(dsq.getBuildingNo()>0) {
						return true;
					}
				}
			}
		}
		return false;

	}

}
