package bt.designpattern.abstractFactorydesign;

import bt.designpattern.factorydesign.Notification;
import bt.designpattern.factorydesign.NotificationEmail;

public class EmailNotificationGenerator extends AbstractNotificationGenerator {

	@Override
	public Notification generateNotification() {
		// TODO Auto-generated method stub
		return new NotificationEmail();
	}

}
