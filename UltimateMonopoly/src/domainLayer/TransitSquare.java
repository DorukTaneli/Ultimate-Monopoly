package domainLayer;

public class TransitSquare extends PropertySquare{

	private TransitSquare brother;
	private int baseRent;
	
	public TransitSquare(String name, int index, int price,int rent) {
		super(name, index,price,rent);
		type="TransitSquare";
		baseRent=rent;
		// TODO Auto-generated constructor stub
		
		
	}
	
	public Square getNextSquare(int f) {
		if(f%2==0) {
			System.out.println("Transit Station is working!\n Player rolled: "+f+" which is even"
					+ "\n Sending him to my brothers next square!");
			return brother.getNextSquareFromSuper(f);
		}else {
			System.out.println("Transit Station is working!\n Player rolled: "+f+" which is odd"
					+ "\n Sending him to my own next square!");
			return this.getNextSquareFromSuper(f);
		}
	}
	
	
	public void setOwner(Player p) {
		this.setSuperOwner(p);
		brother.setSuperOwner(p);
		
	}
	
	private void setSuperOwner(Player p) {
		super.setOwner(p);
	}

	@Override
	public void landedOn(Player p) {
		if (owner != null && owner != p)
			payRent(p);
		
	}
	
	public void payRent(Player p) {
		owner.addCash(baseRent);
		p.reduceCash(baseRent);
	}

	public void passedOn(Player p) {
		
	}

	public Square getNextSquareFromSuper(int f) {
		return super.getNextSquare(f);
	}

	public TransitSquare getBrother() {
		return brother;
	}

	public void setBrother(TransitSquare brother) {
		this.brother = brother;
	}
	
	public void setBrothers(TransitSquare brother) {
		this.brother = brother;
		brother.setBrother(this);
	}
}
