package domainLayer;

public class Cup {
	
	private int firstDie;
	

	public SpeedDie getSpeedDie() {
		return speedDie;
	}

	public void setSpeedDie(SpeedDie speedDie) {
		this.speedDie = speedDie;
	}

	public void setFirstDie(int firstDie) {
		this.firstDie = firstDie;
	}

	public void setSecondDie(int secondDie) {
		this.secondDie = secondDie;
	}

	public void setThirdDie(int thirdDie) {
		this.thirdDie = thirdDie;
	}
	private int secondDie;
	private int thirdDie;
	private String speedDieString;
	private Die die;
	private SpeedDie speedDie;
	
	public int dualCount;
	
	public Cup() {
		die = new Die();
		speedDie = new SpeedDie();
		roll();
		dualCount=0;
	}
	
	public void roll() {
		die.roll();
		firstDie = die.getFaceValue();
		die.roll();
		secondDie=die.getFaceValue();
		die.roll();
		thirdDie=die.getFaceValue();
		
		speedDie.roll();
		speedDieString = speedDie.getFaceValueString();
		
		if(firstDie==secondDie) dualCount++;
		
	}
	int c=0;
	public int get2RollValue() {
		return firstDie+secondDie;
	}
	
	public int get3RollValue() {
		return firstDie+secondDie+thirdDie;
	}

	public int getFirstDie() {
		return firstDie;
	}

	public int getSecondDie() {
		return secondDie;
	}

	public int getThirdDie() {
		return thirdDie;
	}

	public String getSpeedDieString() {
		return speedDieString;
	}
	public int getSpeedDieInt() {
		if(getSpeedDieString()=="MrMonopoly" || getSpeedDieString()=="Bus") return 0;
		int roll=Integer.parseInt(getSpeedDieString());
		return roll;
	}
	
	
	public boolean isDualRoll() {
		if(firstDie==secondDie) return true;
		else return false;
	}
	
	public void setDual(int f,int s) {
		firstDie=f;
		secondDie=s;
		if(f==s) dualCount++;
		
	}
	
	public boolean isThirdDualRoll() {
		if(dualCount>=3) {
			dualCount=0;
			return true;
		}
		else return false;
		
	}
	
//	public int rollThreeCommon(int match1, int match2, int match3) {
//		int totalMatch=0;
//		if(rollThreeSingle(match1)) totalMatch++;
//		if(rollThreeSingle(match2)) totalMatch++;
//		if(rollThreeSingle(match3)) totalMatch++;
//		return totalMatch;
//	}
//	
//	private boolean rollThreeSingle(int match) {
//		if(match==firstDie || match==secondDie || match==thirdDie) return true;
//		else return false;
//	}
//	
	public boolean rolledEven() {
		if((get2RollValue()/*+getSpeedDieInt()*/)%2==0) return true;
		return false;
	}
	
	public boolean rolledOdd() {
		if((get2RollValue()/*+getSpeedDieInt()*/)%2==1) return true;
		return false;
	}
	
	
}
