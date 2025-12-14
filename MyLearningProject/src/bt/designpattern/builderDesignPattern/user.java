package bt.designpattern.builderDesignPattern;

public class user {

	private final String fname;
	private final String lname;
	private final int age;
	private final long phone;
	private final String address;
	
	
	
	
	private user (UserBuilder builder) {
		this.fname = builder.fname;
		this.lname = builder.lname;
		
		this.age = builder.age;
		this.phone = builder.phone;
		this.address = builder.address;
	}
	
	
	public static class UserBuilder {
		
		String fname,lname,address;
		int age;
		long phone;
		
		
		// Only mandatory properties has to be created inside constructor
		public UserBuilder(String fname, String lname, int age) {
			this.fname=fname;
			this.lname = lname;
			this.age = age;
		}
		
		public UserBuilder phone(long phoneno) {
			
			this.phone = phoneno;
			return this;
		}
		
		public UserBuilder address(String add) {
			
			this.address = add;
			return this;
		}
		
		public user build () {
			user u = new user(this);
			
			return u;
		}
		
	}


	@Override
	public String toString() {
		return "user [fname=" + fname + ", lname=" + lname + ", age=" + age + ", phone=" + phone + ", address="
				+ address + "]";
	}
	
	
}
