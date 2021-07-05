package in.ashwin.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidation {
	private UserValidation() {

	}

	public static boolean isValidName(String name) {
		boolean validName = false;

		Pattern pattern = Pattern.compile("[a-zA-Z+\\s]{3,50}");
		Matcher matcher = pattern.matcher(name);
		if (matcher.matches()) {
			validName = true;

		}
		return validName;

	}

	public static boolean isValidMobile(String mobileNo) {
		boolean validMobile = false;

		Pattern pattern = Pattern.compile("(0/91)?[6-9][0-9]{9}");
		Matcher matcher = pattern.matcher(mobileNo);
		if (matcher.matches()) {
			validMobile = true;

		}
		return validMobile;

	}

	public static boolean isValidConsumerNo(String consumerNo)

	{
		boolean validConsumerNo = false;
		Pattern pattern = Pattern.compile("[0]{1}[1-9]{1}[0-9]{8}");
		Matcher matcher = pattern.matcher(consumerNo);
		if (matcher.matches()) {
			validConsumerNo = true;
		}
		return validConsumerNo;

	}

	public static boolean isValidPassword(String password) {
		boolean validPassword = false;

		Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^)])(?=\\S+$).{8,20}$");
		Matcher matcher = pattern.matcher(password);
		if (matcher.matches()) {
			validPassword = true;
		}
		return validPassword;

	}

	public static boolean isNumeric(double number) {
		boolean validNumber = false;

		if (number >= 0 && number <= 100) {
			validNumber = true;
		}
		return validNumber;

	}

	public static boolean isValidEmail(String email) {
		boolean validEmail = false;

		Pattern pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
		Matcher matcher = pattern.matcher(email);
		if (matcher.matches()) {
			validEmail = true;
		}
		return validEmail;

	}
}