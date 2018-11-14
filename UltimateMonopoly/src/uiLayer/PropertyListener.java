package uiLayer;

import domainLayer.Publisher;

public interface PropertyListener {

	public void onPropertyEvent(Publisher pb, String type, String val);
	
}
