package tools;

import java.util.ArrayList;
import java.util.List;

import view.interfaces.KPanel;

public class Commander {
	static Commander instance = null;
	private List<KPanel> subscriber;
	
	private Commander() {
		this.subscriber = new ArrayList<KPanel>();
	}
	
	static public Commander getInstance() {
		if(instance==null) instance = new Commander();
		return instance;
	}
	
	public void addSubscriber(KPanel kp) {
		this.subscriber.add(kp);
	}
	
	public void broadcastMessage(String message, Object object) {
		for(KPanel kp : this.subscriber) {
			kp.readMessage(message, object);
		}
	}
}
