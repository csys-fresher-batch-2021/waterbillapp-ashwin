package in.ashwin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.ashwin.dao.CalculationDAO;
import in.ashwin.model.CalcBill;

/**
 * Servlet implementation class paymentservlet
 */
@WebServlet("/paymentservlet")
public class paymentservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		if (request.getParameter("Action").equals("Pay Bill")) {
			System.out.println("inside pay bill");
			try {
				CalcBill paybill = new CalcBill();
				paybill.setId(Integer.parseInt(request.getParameter("id")));
				paybill.setPayamt(Double.parseDouble(request.getParameter("bamt")));
				paybill.setStatus("PAID");
				CalculationDAO calcDAO2 = new CalculationDAO();
				paybill = calcDAO2.payAmount(paybill);
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("pay", paybill);
				request.setAttribute("msg", "Bill Paid Successfully!!!");
				request.getRequestDispatcher("PaymentSuccess.jsp").forward(request, response);
			} catch (ServletException | IOException | NumberFormatException e) {
				e.printStackTrace();
			}
		}
	}
}