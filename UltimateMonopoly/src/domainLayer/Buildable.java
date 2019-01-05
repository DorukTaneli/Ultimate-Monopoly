package domainLayer;

public interface Buildable {

	public void build(Player player, boolean canBuildSky);
	public void setBuildingNo(int buildingNo);
	public int getBuildingNo();
	public void demolish(Player player);
	public void demolishAll(Player player);
}
