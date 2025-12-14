package bt.designpattern.abstractFactorydesign;

import bt.designpattern.factorydesign.Notification;
import bt.designpattern.factorydesign.NotificationSMS;

public class SMSNotificationGenFactory extends AbstractNotificationGenerator {

	@Override
	public Notification generateNotification() {

		return new NotificationSMS();
	}

}
