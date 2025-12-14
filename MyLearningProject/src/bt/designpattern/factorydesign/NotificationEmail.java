package bt.designpattern.factorydesign;

public class NotificationEmail implements Notification {

	@Override
	public void sendNotification() {
		System.out.println("Email notificaiton");		
	}

}
