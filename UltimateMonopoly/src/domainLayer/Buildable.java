package domainLayer;

public interface Buildable {

	public void build();
	public void setBuildingNo(int buildingNo);
	public int getBuildingNo();
	public void demolish();
	public void demolishAll();
}
