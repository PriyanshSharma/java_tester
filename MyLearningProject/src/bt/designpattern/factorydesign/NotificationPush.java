package bt.designpattern.factorydesign;

public class NotificationPush implements Notification {

	
	@Override
	public void sendNotification() {
		System.out.println("Push notificaiton");		
	}
}
