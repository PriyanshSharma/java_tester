package bt.designpattern.factorydesign;

public class NotificationSMS implements Notification {

	
	@Override
	public void sendNotification() {
		System.out.println("SMS notificaiton");		
	}
}
