package in.ashwin.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.ashwin.service.BillCalculator;


/**
 * Servlet implementation class BillGenerate
 */
@WebServlet("/BillGenerate")
public class BillGenerate extends HttpServlet {
	private static final long serialVersionUID = 1L;
@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int units=Integer.parseInt(request.getParameter("units"));
			String type = request.getParameter("type");
			double total=BillCalculator.getBillCalculator(type, units);
			response.sendRedirect("result.jsp?totalBill=" + total);
			}
		catch (NumberFormatException | IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
