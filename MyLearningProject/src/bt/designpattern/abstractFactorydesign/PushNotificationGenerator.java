package bt.designpattern.abstractFactorydesign;

import bt.designpattern.factorydesign.Notification;
import bt.designpattern.factorydesign.NotificationPush;

public class PushNotificationGenerator extends AbstractNotificationGenerator {

	@Override
	public Notification generateNotification() {
		
		return new NotificationPush();
	}

}
