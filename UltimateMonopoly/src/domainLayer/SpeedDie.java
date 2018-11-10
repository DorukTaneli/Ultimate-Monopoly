package domainLayer;

public class SpeedDie {
	
	public static final int MAX = 6;
	private int faceValue;
	private String faceValueString;
	
	public SpeedDie() {
		roll();
	}
	
	public void roll() {
		faceValue = (int) (Math.random() * (MAX + 1));
		switch(faceValue) {
		case 1: faceValueString = "1"; break;
		case 2: faceValueString = "2"; break;
		case 3: faceValueString = "3"; break;
		case 4: faceValueString = "Bus"; break;
		case 5: faceValueString = "MrMonopoly"; break;
		case 6: faceValueString = "MrMonopoly"; break;
		
		}
		
	}
	
	public int getFaceValue() {
		return faceValue;
	}
	
	public String getFaceValueString() {
		return faceValueString;
	}
	
}
