package in.ashwin.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ashwin.exception.ServiceException;
import in.ashwin.model.UserDetails;
import in.ashwin.service.UserRegistration;

/**
 * Servlet implementation class RegistrationAction
 */
@WebServlet("/RegistrationAction")
public class RegistrationAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String mobileNumber=request.getParameter("mobileNumber");
		String consumerNumber=request.getParameter("ConsumerNumber");
		String password=request.getParameter("password");
		String confirmPassword=request.getParameter("confirmpassword");
		UserDetails user=new UserDetails(name,mobileNumber,consumerNumber,password,confirmPassword);

		try {
			if(!UserRegistration.existingUser(user))
			{
				if(UserRegistration.userRegistration(user))
				{
					response.sendRedirect("Register.jsp");
				}
				else {
					String errorMessage = "Invalid Details";
					response.sendRedirect("Registration.jsp?errorMessage=" + errorMessage);
				}
				
			}
			else {
				String existsMessage = "Already Registered";
				response.sendRedirect("Registration.jsp?existsMessage=" + existsMessage);
				
			}
		} catch (ServiceException e) {
			String message = e.getMessage();
			response.sendRedirect("Registration.jsp?message=" + message);
			e.printStackTrace();
		}
		
		
		
		
	}

}
