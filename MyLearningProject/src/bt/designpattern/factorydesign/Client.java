package bt.designpattern.factorydesign;

public class Client {
public static void main(String[] args) {
	
	String smsType = "SMS";
	
	String emailType = "EMAIL";
	
	String pushType = "PUSH";
	
	Notification notification = NotificationFactoryService.getNotification(pushType);
	notification.sendNotification();
}
}
