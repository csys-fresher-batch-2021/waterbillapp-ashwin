package in.ashwin.model;

public class UserDetails {
	private String name;
	private String mobileNo;
	private String consumerNumber;
	private String password;
	private String confirmPassword;

	public String getName() {
		return name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public String getConsumerNumber() {
		return consumerNumber;
	}

	public String getPassword() {
		return password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public UserDetails(String name, String mobileNo, String consumerNumber, String password, String confirmPassword) {
		super();
		this.name = name;
		this.mobileNo = mobileNo;
		this.consumerNumber = consumerNumber;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

}