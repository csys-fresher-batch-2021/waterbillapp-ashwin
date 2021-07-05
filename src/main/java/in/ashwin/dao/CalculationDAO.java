package in.ashwin.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.ashwin.exception.DBException;
import in.ashwin.model.CalcBill;
import in.ashwin.service.TotalBill;
import in.ashwin.util.ConnectionUtil;

public class CalculationDAO {

	public void calculateBill(CalcBill bill) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String type = bill.getType();
		double unit = bill.getUnitConsumed();
		double totalamount = TotalBill.getTotalBill(type, unit);
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "INSERT INTO bill_calculate(userid,type,unitconsumed,consumernumber,mobileno,address,month,name,year,totalamount,status,payamt) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, bill.getUserid());
			preparedStatement.setString(2, bill.getType());
			preparedStatement.setDouble(3, bill.getUnitConsumed());
			preparedStatement.setString(4, bill.getConsumernumber());
			preparedStatement.setString(5, bill.getMobileno());
			preparedStatement.setString(6, bill.getAddress());
			preparedStatement.setString(7, bill.getMonth());
			preparedStatement.setString(8, bill.getName());
			preparedStatement.setString(9, bill.getYear());
			preparedStatement.setDouble(10,totalamount);
			preparedStatement.setString(11, bill.getStatus());
			preparedStatement.setDouble(12, bill.getPayamt());
		    preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("unable to insert records in table");
		} finally {
			ConnectionUtil.close(preparedStatement, connection);
		}

	}

	public boolean billExists(CalcBill exbill) {
		Connection connection = null;
		PreparedStatement pst = null;
		boolean isExists = false;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT USERID FROM bill_calculate WHERE USERID=? AND MONTH=? AND YEAR=?";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, exbill.getUserid());
			pst.setString(2, exbill.getMonth());
			pst.setString(3, exbill.getYear());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				isExists = true;
			}
		} catch (SQLException e) {
			throw new DBException("unable to find the bill");
		} finally {
			ConnectionUtil.close(pst, connection);
		}

		return isExists;
	}

	public CalcBill payAmount(CalcBill paybill) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "UPDATE bill_calculate SET payamt =?,status=? WHERE id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDouble(1, paybill.getPayamt());
			preparedStatement.setString(2, paybill.getStatus());
			preparedStatement.setInt(3, paybill.getId());
			int result = preparedStatement.executeUpdate();

			if (result != 0) {
				System.out.println("valid");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("unable to Update records in table");
		} finally {
			ConnectionUtil.close(preparedStatement, connection);
		}
		return paybill;
	}

	public static CalcBill getRecordById(int id) {
		CalcBill user = new CalcBill();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM bill_calculate where ID=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				user.setId(rs.getInt(1));
				user.setUserid(rs.getInt(2));
				user.setType(rs.getString(3));
				user.setUnitConsumed(rs.getDouble(4));
				user.setConsumernumber(rs.getString(5));
				user.setMobileno(rs.getString(6));
				user.setMonth(rs.getString(7));
				user.setName(rs.getString(8));
				user.setYear(rs.getString(9));
				user.setStatus(rs.getString(10));
				user.setPayamt(rs.getDouble(11));
				

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("unable to fetch all records from the table");
		} finally {
			ConnectionUtil.close(preparedStatement, connection);
		}
		return user;

	}

}