package in.ashwin.validator;

import in.ashwin.exception.RegistrationException;
import in.ashwin.exception.ValidationException;
import in.ashwin.model.UserDetails;

public class RegistrationValidation {
	
	private RegistrationValidation()
	{
		
	}
	public static boolean validRegistration(UserDetails userDetail)
	{
		boolean isValidRegistration=true;
		try {
			if (!(UserValidation.isValidName(userDetail.getName()) && UserValidation.isValidMobile(userDetail.getMobileNo())&& UserValidation.isValidConsumerNo(userDetail.getConsumerNumber())) ) {
				isValidRegistration=false;
			}
			if(!UserValidation.isValidPassword(userDetail.getPassword()) 
					&& !UserValidation.isValidPassword(userDetail.getConfirmPassword())) {
				isValidRegistration=false;
			}
		} catch (ValidationException e) {
			e.printStackTrace();
			throw new RegistrationException("Enter valid details");
		}
		return isValidRegistration;
	}

}
