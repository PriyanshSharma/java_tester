package bt.designpattern.abstractFactorydesign;

public class AbstractFactoryConsumer {

	public static void main(String[] args) {
		
		AbstractNotificationGenerator notification = null;
		String type = "SMS";
		
		if("SMS".equalsIgnoreCase(type)) {
			notification= new SMSNotificationGenFactory();
		}
		else if("PUSH".equalsIgnoreCase(type)) {
			notification= new PushNotificationGenerator();
		}
		else if("EMAIL".equalsIgnoreCase(type)) {
			notification= new EmailNotificationGenerator();
		}
		
		notification.generateNotification().sendNotification();;
	}
}
