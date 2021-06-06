package in.ashwin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.ashwin.exception.ServiceException;
import in.ashwin.service.UserLogin;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLoginFeature extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mobileNumber = request.getParameter("mobileNumber");
		String password = request.getParameter("password");
		try {
			if (UserLogin.validLogin(mobileNumber, password)) {
				HttpSession session = request.getSession();
				session.setAttribute("LOGINUSER", "USER");
				response.sendRedirect("PriceList.jsp");
			}
			else {
					String errorMessage = "Invalid Details";
					response.sendRedirect("UserLogin.jsp?errorMessage=" + errorMessage);
			}
		} catch (ServiceException e) {
			String message = e.getMessage();
			response.sendRedirect("UserLogin.jsp?message=" + message);
		}
		
	
	}
}
