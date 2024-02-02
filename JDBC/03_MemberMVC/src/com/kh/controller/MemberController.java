package com.kh.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kh.model.Member;

import config.ServerInfo;

public class MemberController {
	
	public MemberController() {
		// 드라이버 연결
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// DB 연결 메서드
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		return conn;
	}
	
	
	public boolean signUp(Member m) throws SQLException {
		//회원가입 기능 구현 -> member 테이블에 데이터 추가 (INSERT)
		// login 메서드 활용해서 null이 아닐 때만 해당 코드 실행
		Connection conn = getConnect();
		String query = "INSERT INTO member VALUES( ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, m.getId());
		ps.setString(2, m.getPassword());
		ps.setString(3, m.getName());
		
		int result = ps.executeUpdate();
		if(result == 1) {
			return true;
		}
		return false;
	}
	
	public String login(String id, String password) {
		// 로그인 기능 구현 -> member 테이블에서 id와 password로 멤버 정보 하나 가져오기 (SELECT)
		return null;
	}
	
	public boolean changePassword(String id, String oldPw, String newPw) {
		// 비밀번호 변경 기능 구현 
		// -> login 메서드 활용 후 사용자 이름이 null이 아니면 해당 UPDATE문 구현!
		// -> member 테이블에서 id로 새로운 패스워드로 변경 (UPDATE)
		return false;
	}
	
	public void changeName(String id, String changeName) {
		// 이름 변경 기능 구현 -> member 테이블에서 id로 새로운 이름으로 변경 (UPDATE)
	}

}















