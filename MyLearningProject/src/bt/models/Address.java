package bt.models;

public class Address {

	private String cityName;
	private String streetName;
	private String houseNo;
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	public Address(String cityName, String streetName, String houseNo) {
		super();
		this.cityName = cityName;
		this.streetName = streetName;
		this.houseNo = houseNo;
	}
	@Override
	public String toString() {
		return "Address [cityName=" + cityName + ", streetName=" + streetName + ", houseNo=" + houseNo + "]";
	}
	
}
