package domainLayer;

/**
 * OVERVIEW:The cup class is a pure fabrication class that makes rolling easier
 * The cup class contains a regular and a speed die 
 * @author SAWCON
 */

public class Cup {

	private int secondDie;
	private int thirdDie;
	private String speedDieString;
	private Die die;
	private SpeedDie speedDie;
	public int dualCount;
	private int firstDie;
	int c=0;

	/**
	 * EFFECTS:Gets the speedDie object from the Cup object
	 * @return the speedDie object
	 */
	public SpeedDie getSpeedDie() {
		return speedDie;
	}

	/**
	 * EFFECTS:Sets the speedDie of this Cup object to the given speedDie object
	 * MODIFIES: this
	 * @param the speedDie object to be set 
	 */
	public void setSpeedDie(SpeedDie speedDie) {
		this.speedDie = speedDie;
	}

	/**
	 * EFFECTS:Sets the firstDie of this Cup object to the given firstDie object
	 * MODIFIES: this
	 * @param the firstDie object to be set 
	 */
	public void setFirstDie(int firstDie) {
		this.firstDie = firstDie;
	}

	/**
	 * EFFECTS: Sets the secondDie of this Cup object to the given secondDie object
	 * MODIFIES: this
	 * @param the secondDie object to be set
	 */
	public void setSecondDie(int secondDie) {
		this.secondDie = secondDie;
	}

	/**
	 * EFFECTS: Sets the thirdDie of this Cup object to the given thirdDie object
	 * MODIFIES: this
	 * @param the thirdDie object to be set 
	 */
	public void setThirdDie(int thirdDie) {
		this.thirdDie = thirdDie;
	}
	
	/**
	 * EFFECTS: Creates a Cup object initialized with a regular and a speed die
	 * Dual count is set to 0.
	 * MODIFIES: this
	 */
	public Cup() {
		die = new Die();
		speedDie = new SpeedDie();
		roll();
		dualCount=0;
	}

	/**
	 * EFFECTS: Rolls all the dice in the Cup
	 * Rolls three regular dice and a speed die
	 * If the rolls are dual, the dual count is incremented for the GoToJail check
	 * MODIFIES: this
	 */
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
	
	/**
	 * EFFECTS: Gets the sum of the face values of two regular dice
	 * @return the sum of the two regular dice rolls
	 */
	public int get2RollValue() {
		if(c==0) {
			c++;
			return 13;
		}else if(c==2) {
			c++;
			return 4;
		}else {
			c++;
			return 1;
		}
		//return firstDie+secondDie;
	}

	/**
	 * EFFECTS: Gets the sum of the face values of three regular dice
	 * @return the sum of the three regular dice rolls
	 */
	public int get3RollValue() {
		return firstDie+secondDie+thirdDie;
	}

	/**
	 * EFFECTS: Gets the face value of the first die
	 * @return the face value of the first die
	 */
	public int getFirstDie() {
		return firstDie;
	}
	
	/**
	 * EFFECTS: Gets the face value of the second die
	 * @return the face value of the second die
	 */
	public int getSecondDie() {
		return secondDie;
	}
	
	/**
	 * EFFECTS: Gets the face value of the thirds die
	 * @return the face value of the third die
	 */
	public int getThirdDie() {
		return thirdDie;
	}

	/**
	 * EFFECTS: Gets the string value of the speed die
	 * The possible string values are MrMonopoly and Bus
	 * @return the string value of the speed die
	 */
	public String getSpeedDieString() {
		return speedDieString;
	}
	
	/**
	 * EFFECTS: Gets the integer value of the speed die
	 * If the speed die string is either MrMonopoly or Bus returns 0
	 * @return the integer value of the speed die
	 */
	public int getSpeedDieInt() {
		if(getSpeedDieString()=="MrMonopoly" || getSpeedDieString()=="Bus") return 0;
		int roll=Integer.parseInt(getSpeedDieString());
		return roll;
	}

	/**
	 * EFFECTS: Checks if the regular dice rolls are dual rolls
	 * @return true if first die roll is equal to the second die roll, false otherwise
	 */
	public boolean isDualRoll() {
		if(firstDie==secondDie) return true;
		else return false;
	}

	/**
	 * EFFECTS: Sets the first and second die rolls according to the given roll values, increases dual count accordingly
	 * MODIFIES: this
	 * @param the first die roll
	 * @param the second die roll
	 */
	public void setDual(int f,int s) {
		firstDie=f;
		secondDie=s;
		if(f==s) dualCount++;

	}

	/**
	 * EFFECTS: Checks if the dual roll count is more than three
	 * MODIFIES: this
	 * @return true if dual count is greater than or equal to 3, false otherwise
	 */
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
	
	/**
	 * EFFECTS: Checks if the two regular dice rolls sum up to an even number
	 * @return true if two regular dice rolls sum up to an even number false otherwise
	 */
	public boolean rolledEven() {
		if((get2RollValue()/*+getSpeedDieInt()*/)%2==0) return true;
		return false;
	}

	/**
	 * EFFECTS: Checks if the two regular dice rolls sum up to an odd number
	 * @return true if two regular dice rolls sum up to an odd number false otherwise
	 */
	public boolean rolledOdd() {
		if((get2RollValue()/*+getSpeedDieInt()*/)%2==1) return true;
		return false;
	}


}
