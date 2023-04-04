package com.yedam.app.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {

	private String jdbcDriver = "org.sqlite.JDBC";
	private String jdbcUrl = "jdbc:sqlite:/D:/resume/MemberManagementSystem.db";

	protected Connection conn;
	protected Statement stmt;
	protected PreparedStatement pstmt;
	protected ResultSet rs;

	public void connect() {
		try {

			Class.forName(jdbcDriver);
			// 매개값으로 주어진 클래스가 존재하면 class객체 리턴,
			// 존재하지않으면 ClassNotFoundException일으킴

			conn = DriverManager.getConnection(jdbcUrl);

		} catch (ClassNotFoundException e) {
			System.out.println("JDBC DRIVER LOADING FAIL");
		} catch (SQLException e) {
			System.out.println("DATABASE CONNECTION FAIL");
		}
	}

	public void disconnect() {
		try {

			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();

		} catch (SQLException e) {
			System.out.println("*정상적으로 자원이 해제되지 않았습니다.*");
		}

	}
}