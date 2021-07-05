package in.ashwin.servlet;

import java.io.IOException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.ashwin.dao.CalculationDAO;
import in.ashwin.model.CalcBill;
import in.ashwin.util.ConnectionUtil;

@WebServlet("/CalcBillCtrl")
public class CalcBillCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String BILL = "bill";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("CalculateBillView.jsp").forward(request, response);
		request.getRequestDispatcher("paybill.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		if (request.getParameter("Action").equals("Calculate Bill")) {
			try {
				CalcBill bill = new CalcBill();
				bill.setUserid(Integer.parseInt(request.getParameter("userid")));
				bill.setType(request.getParameter("type"));
				bill.setUnitConsumed(Double.parseDouble(request.getParameter("unitConsumed")));
				bill.setAddress(request.getParameter("address"));
				bill.setConsumernumber(request.getParameter("consumerno"));
				bill.setMobileno(request.getParameter("mobileno"));
				bill.setMonth(request.getParameter("month"));
				bill.setName(request.getParameter("name"));
				bill.setYear(request.getParameter("year"));
				bill.setStatus("Pending");
				LocalDate date = LocalDate.now();
				String year = String.valueOf(date.getYear());
				CalculationDAO calcDAO = new CalculationDAO();
				if (bill.getYear().equals(year)) {
					if (!calcDAO.billExists(bill)) {
						calcDAO.calculateBill(bill);
						HttpSession httpSession = request.getSession();
						httpSession.setAttribute("bill", BILL);
						String msg = "Bill Calculated";
						request.setAttribute("msg", msg);
						request.getRequestDispatcher("CalculateBillView.jsp").forward(request, response);

					} else {
						String msg = "Bill  Already Calculated";
						request.setAttribute("msg", msg);
						request.getRequestDispatcher("CalculateBillView.jsp").forward(request, response);
					}
				} else {
					String msg = "Enter Year correctly";
					request.setAttribute("msg", msg);
					request.getRequestDispatcher("CalculateBillView.jsp").forward(request, response);
				}
			} catch (ServletException | IOException e) {
				e.printStackTrace();

			}

		}

		if (request.getParameter("Action").equals("Search")) {
			Connection connection = null;
			Statement st = null;
			connection = ConnectionUtil.getConnection();
			System.out.println("inside search");
			try {
				int id = Integer.parseInt(request.getParameter(("userid")));
				connection = ConnectionUtil.getConnection();
				st = connection.createStatement();
				ArrayList list = null;
				ArrayList uid = new ArrayList();
				String query = "SELECT * FROM user_details WHERE userid='" + id + "'";
				ResultSet rs = st.executeQuery(query);
				while (rs.next()) {

					list = new ArrayList();
					list = new ArrayList();
					list.add(rs.getInt("userid"));
					list.add(rs.getString("name"));
					list.add(rs.getString("consumerno"));
					list.add(rs.getString("mobileno"));
					list.add(rs.getString("address"));

					uid.add(list);
				}
				request.setAttribute("UList", uid);

				RequestDispatcher view = request.getRequestDispatcher("CalculateBillView.jsp");
				view.forward(request, response);

			} catch (SQLException | ServletException | IOException | NumberFormatException e) {
				e.printStackTrace();
			} finally {
				ConnectionUtil.close(st, connection);
			}

		}

	
	}
}