package in.ashwin.service;

import java.util.List;

import in.ashwin.dao.RegistrationDAO;
import in.ashwin.exception.DBException;
import in.ashwin.exception.RegistrationException;
import in.ashwin.exception.ServiceException;
import in.ashwin.model.UserDetails;
import in.ashwin.validator.RegistrationValidation;

public class UserRegistration {
	private UserRegistration() {

	}

	public static boolean userRegistration(UserDetails userDetail) {
		boolean validRegistration = false;
		try {
			if (RegistrationValidation.validRegistration(userDetail)) {
				RegistrationDAO dao = new RegistrationDAO();
				dao.addUserDetail(userDetail);
				validRegistration = true;
			}
		} catch (DBException | RegistrationException e) {
			throw new ServiceException("unable to register");
		}
		return validRegistration;

	}

	public static boolean existingUser(UserDetails userDetail) {
		boolean isMatched = false;
		try {
			RegistrationDAO dao = new RegistrationDAO();
			List<UserDetails> userList = dao.getAllUser();
			for (UserDetails user : userList) {

				if (user.getName().equalsIgnoreCase(userDetail.getName())
						&& user.getMobileNo().equals(userDetail.getMobileNo())
						&& user.getConsumerNumber().equals(userDetail.getConsumerNumber())
						&& user.getPassword().equalsIgnoreCase(userDetail.getPassword())
						&& user.getConfirmPassword().equalsIgnoreCase(userDetail.getConfirmPassword())) {
					isMatched = true;
					break;

				}

			}
		} catch (DBException e) {
			throw new ServiceException("unable to fetch userdetails");
		}
		return isMatched;
	}
}