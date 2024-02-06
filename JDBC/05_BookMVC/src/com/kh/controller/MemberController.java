package com.kh.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MemberController {
	
	public MemberController() {
	// 드라이버 연결
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnect() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/library2", "root", "1234");
	}
	
	public void close(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps != null) ps.close();
		if(conn != null) conn.close();
	}
	
	public void close(ResultSet rs ,PreparedStatement ps, Connection conn) throws SQLException {
		if(rs != null) rs.close();
		close(ps, conn);
	}
	
	public boolean idCheck(String id) throws SQLException {
		Connection conn = getConnect();
		String query = "SELECT member_id FROM tb_member WHERE member_id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		
		String checkId = null;
		if(rs.next()) {
			checkId = rs.getString("id");
		}
		close(ps, conn); // 리턴 전에 닫아주면 된다
		if(checkId != null) {
			return true;
		}
		
		return false;
	}
	public ResultSet myBook(int bookNo) throws SQLException {
		Connection conn = getConnect();
		String query = "SELECT bk_title FROM tb_book WHERE bk_no = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, bookNo);
		
		ResultSet rs = ps.executeQuery();
		return rs;
	}

}