package in.ashwin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.ashwin.exception.DBException;
import in.ashwin.util.ConnectionUtil;
import in.ashwin.model.UserDetails;

public class LoginDAO{

	public String user(UserDetails user) throws SQLException {
		String mobileno = user.getMobileno();
		String password = user.getPassword();
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select*from user_details where mobileno=? and password=?";
			statement = con.prepareStatement(sql);
			statement.setString(1, mobileno);
			statement.setString(2, password);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String mob = resultSet.getString("mobileno");
				String pass = resultSet.getString("password");
				int role = resultSet.getInt("roleid");
				if (mobileno.equals(mob) && password.equals(pass) && role == 1) {
					return "ADMIN_ROLE";
				} else if (mobileno.equals(mob) && password.equals(pass) && role == 2) {
					return "USER_ROLE";
				}
			}
			return "INVALID";

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("unable to fetch record from database");
		} finally {
			ConnectionUtil.close(statement, con);
		}
	}
}