package in.ashwin.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.ashwin.util.ConnectionUtil;
import in.ashwin.model.UserDetails;

import in.ashwin.exception.DBException;


public class EditUserDAO {

	public int editUser(UserDetails user) {
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try {
			con = ConnectionUtil.getConnection();
			int status = 0;
			String sql = "update user_details set name=?,email=?,address=?,mobileno=? where userid=?";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getAddress());
			preparedStatement.setString(4, user.getMobileno());
			preparedStatement.setInt(5, user.getUserid());
			status = preparedStatement.executeUpdate();
			if(status!=0)
			{
				return 1;
			}
			else {
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("unable to Update records into the user_details table");
		} finally {
			ConnectionUtil.close(preparedStatement, con);
		}
	}

}