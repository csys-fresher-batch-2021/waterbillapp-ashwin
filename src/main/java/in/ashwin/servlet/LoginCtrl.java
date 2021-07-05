package in.ashwin.servlet;

import java.io.IOException;

import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.ashwin.dao.LoginDAO;
import in.ashwin.model.UserDetails;

/**
 * Servlet implementation class LoginCtrl
 */
@WebServlet("/LoginCtrl")
public class LoginCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("inside post");
		String mobileno = request.getParameter("mobilenumber");
		String password = request.getParameter("password");
		UserDetails user = new UserDetails();
		user.setMobileno(mobileno);
		user.setPassword(password);
		LoginDAO dao = new LoginDAO();
		try {
			String result =dao.user(user);

			System.out.println("result " + result);
			if (result.equals("ADMIN_ROLE")) {
				System.out.println("inside admin");
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("admin", mobileno);
				request.setAttribute("mobileno", mobileno);
				System.out.println(mobileno);
				response.sendRedirect("viewusers.jsp");
			}
			if (result.equals("USER_ROLE")) {
				System.out.println("inside auser");
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("user", mobileno);
				request.setAttribute("mobileno", mobileno);
				System.out.println(mobileno);
				response.sendRedirect("PriceList.jsp");
			}
			if (result.equals("INVALID")) {
				System.out.println("invalid");
				String msg = "Please enter valid Username or password";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("login.jsp").forward(request, response);

			}
		} catch (SQLException | IOException | ServletException e) {
			e.printStackTrace();
		}
	}

}