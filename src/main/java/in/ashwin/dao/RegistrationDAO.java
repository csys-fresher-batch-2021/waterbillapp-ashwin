package in.ashwin.dao;

import java.sql.*;

import in.ashwin.exception.DBException;
import in.ashwin.model.UserDetails;
import in.ashwin.util.ConnectionUtil;

public class RegistrationDAO {

	public int addUser(UserDetails user) {
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "insert into user_details(name,email,mobileno,consumerno,address,password,roleid)values(?,?,?,?,?,?,?)";
			preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getMobileno());
			preparedStatement.setString(4, user.getConsumerno());
			preparedStatement.setString(5, user.getAddress());
			preparedStatement.setString(6, user.getPassword());
			preparedStatement.setInt(7, user.getRoleid());
			preparedStatement.executeUpdate();
			int id = 0;

			ResultSet rs = preparedStatement.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getInt(1);
			}

			return id;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("unable to add records into the database");
		} finally {
			ConnectionUtil.close(preparedStatement, con);
		}

	}

	public static UserDetails getRecordById(int id) {
		UserDetails user = new UserDetails();
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select * from user_details where userid=?";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				user.setUserid(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setMobileno(rs.getString(4));
				user.setConsumerno(rs.getString(5));
				user.setAddress(rs.getString(6));
				user.setPassword(rs.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("unable to fetch all records from database");
		} finally {
			ConnectionUtil.close(preparedStatement, con);
		}

		return user;

	}

}
