package bt.designpattern.factorydesign;

public class NotificationFactoryService {

	public static Notification getNotification(String type) {
		
		if("SMS".equalsIgnoreCase(type)) {
			return new NotificationSMS();
		}
		
		else if("PUSH".equalsIgnoreCase(type)) {
			return new NotificationPush();
		}
		else if("EMAIL".equalsIgnoreCase(type)) {
			return new NotificationEmail();
			
		}
		else {
			return null;
		}
	}
}
