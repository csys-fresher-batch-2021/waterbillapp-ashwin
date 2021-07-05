package in.ashwin.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ashwin.dao.EditUserDAO;
import in.ashwin.model.UserDetails;

@WebServlet("/EditSevlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("inside edit section");
		try {
			UserDetails user = new UserDetails();
			user.setUserid(Integer.parseInt(request.getParameter("id")));
			user.setEmail(request.getParameter("email"));
			user.setName(request.getParameter("name"));
			user.setAddress(request.getParameter("address"));
			user.setMobileno(request.getParameter("mobile"));
			EditUserDAO dao2 = new EditUserDAO();
			int result = dao2.editUser(user);
			System.out.println("result is " + result);
			String msg = "User edited successfully!!";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("edituser.jsp").forward(request, response);
		} catch (ServletException | IOException | NumberFormatException e) {
			e.printStackTrace();
		}
	}
}