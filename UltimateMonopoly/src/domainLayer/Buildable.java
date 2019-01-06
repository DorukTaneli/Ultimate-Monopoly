package domainLayer;

import java.io.Serializable;

public interface Buildable {

	public void build(Player player, boolean canBuildSky);
	public void setBuildingNo(int buildingNo);
	public int getBuildingNo();
	public void demolish(Player player, boolean isHurricane);
	public void demolishAll(Player player);
}

