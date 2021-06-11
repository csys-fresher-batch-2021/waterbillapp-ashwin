package in.ashwin.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import in.ashwin.exception.DBException;
import in.ashwin.util.ConnectionUtil;

public class LoginDao {
	public boolean loginDao(String mobileNumber, String password) {

		boolean validLogin=false;
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection=ConnectionUtil.getConnection();
			String sql="select * from user_details where mobile_No=? AND user_password=?";
			pst=connection.prepareStatement(sql);
			pst.setString(1, mobileNumber);
			pst.setString(2, password);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				validLogin=true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DBException("unable to fetch record from database");
		}
		 finally {
				ConnectionUtil.close(pst, connection);
		}

		return validLogin;
	}
}


