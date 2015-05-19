package com.game.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;

public class LoginDB {

	@Autowired
	private static UserInfo user;
	
	public LoginDB() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Cannot find driver");
			e.printStackTrace();
		}
	}
	
	public static void populateDB(String setName, String setEmail, String setPass) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Cannot find driver");
			e.printStackTrace();
		}
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","password");
		String name = setName; //user.getUserName();
		String password = setEmail; //user.getPassWord();
		String email = setPass; //user.getEmail();
		
		Statement stmt = (Statement) connection.createStatement();
		
		String sql = "INSERT INTO GameDB.userInfo (user_name, email, password) "
				+ "VALUES ('"+name+"','"+email+"','"+password+"');";
		stmt.execute(sql);
	
		// Clean up environment
		stmt.close();
		connection.close();

	}
	
	public static String getPassword(String name) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Cannot find driver");
			e.printStackTrace();
		}
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","password");
		Statement stmt = (Statement) connection.createStatement();
		
		String sql = "SELECT password FROM GameDB.userInfo WHERE user_name='"+name+"';";
		ResultSet rs = stmt.executeQuery(sql);
		String passWord = "";
		while(rs.next()) {
			passWord = rs.getString("password");
		}
		// Clean up environment
		rs.close();
		stmt.close();
		connection.close();
		
		return passWord;
	}
}
