package domainLayer;

import uiLayer.PropertyListener;

public interface Publisher {

	public void addPropertyListener(PropertyListener listener);
	public void removePropertyListener(PropertyListener listener);
	public void publishPropertyEvent(String type);
	
}
