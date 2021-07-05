package in.ashwin.servlet;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ashwin.exception.ServiceException;

import javax.servlet.http.HttpSession;

import in.ashwin.dao.RegistrationDAO;
import in.ashwin.model.UserDetails;
import in.ashwin.validator.UserValidation;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ERROR_MESSAGE = "Registration.jsp";

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String emailid = request.getParameter("email");
		String mobile = request.getParameter("mobileNumber");
		String consumerNo = request.getParameter("ConsumerNumber");
		String address = request.getParameter("address");
		String password = request.getParameter("password");

		UserDetails user = new UserDetails();
		user.setName(name);
		user.setEmail(emailid);
		user.setMobileno(mobile);
		user.setConsumerno(consumerNo);
		user.setAddress(address);
		user.setPassword(password);
		user.setRoleid(2);

		if (!UserValidation.isValidName(name)) {
			String nmsg = "Please enter a valid name";
			request.setAttribute("nmsg", nmsg);
			request.getRequestDispatcher(ERROR_MESSAGE).forward(request, response);
		} else if (!UserValidation.isValidEmail(emailid)) {
			String emsg = "Please enter valid mail";
			request.setAttribute("emsg", emsg);
			request.getRequestDispatcher(ERROR_MESSAGE).forward(request, response);
		} else if (!UserValidation.isValidMobile(mobile)) {
			String mmsg = "Please enter valid mobile number";
			request.setAttribute("mmsg", mmsg);
			request.getRequestDispatcher(ERROR_MESSAGE).forward(request, response);
		} else if (!UserValidation.isValidConsumerNo(consumerNo)) {
			String cnmsg = "Please enter valid consumer number";
			request.setAttribute("cnmsg", cnmsg);
			request.getRequestDispatcher(ERROR_MESSAGE).forward(request, response);
		}

		 else if (!UserValidation.isValidPassword(password)) {
			String umsg = "Please enter Valid password";
			request.setAttribute("umsg", umsg);
			request.getRequestDispatcher(ERROR_MESSAGE).forward(request, response);
		} else {

			RegistrationDAO dao = new RegistrationDAO();
			try {
				int id = dao.addUser(user);
				System.out.println("called " + id);
				System.out.println(user);
				if (id == 0) {

				}
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("id", id);
				String regmsg = "Your User ID is " + id;
				request.setAttribute("regmsg", regmsg);
				request.getRequestDispatcher("Register.jsp").forward(request, response);
			} catch (ServiceException e) {
				e.printStackTrace();
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("ERROR", "User already exist");
				request.getRequestDispatcher(ERROR_MESSAGE).forward(request, response);
			}
		}
	}
}