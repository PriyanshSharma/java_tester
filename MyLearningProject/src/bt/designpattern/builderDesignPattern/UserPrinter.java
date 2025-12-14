package bt.designpattern.builderDesignPattern;

public class UserPrinter {
public static void main(String[] args) {
	
	// Creating mandatory fields using construcotr and optional as builder
	user iuser = new user.UserBuilder("Priyansh", "sharma", 30)
									.phone(98769698).address("Bilaspur").build();
	
	System.out.println(iuser);
	//Not using phone for diffrent user, thus no need to set as null externally
	user euser = new user.UserBuilder("Ankush", "RAO", 31).address("HYD").build();
	System.out.println(euser);

}
}
