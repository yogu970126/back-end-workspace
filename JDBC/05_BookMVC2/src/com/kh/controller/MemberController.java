package com.kh.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

public class MemberController {

	private MemberDAO dao = new MemberDAO();
	
	// 4. 회원가입
	public boolean registerMember(String id, String pwd, String name)  {
//		Connection conn =getConnect();
//		String query = "INSERT INTO tb_member(member_id, member_pwd, member_name) VALUES(?, ?, ?)";
//		PreparedStatement ps = conn.prepareStatement(query);
//		ps.setString(1, id);
//		ps.setString(2, pwd);
//		ps.setString(3, name);
//		ps.executeUpdate();
//		close(ps, conn);
		try {
			if(dao.registerMember(id, pwd, name) == 1) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	// 5. 로그인
	public Member login(String id, String pwd) {
//		Connection conn =getConnect();
//		String query = "SELECT * FROM tb_member WHERE member_id = ? AND member_pwd = ?";
//		PreparedStatement ps = conn.prepareStatement(query);
//		ps.setString(1, id);
//		ps.setString(2, pwd);
//		ResultSet rs = ps.executeQuery();
//		
//		Member member = new Member();
//		
//		if(rs.next()) {
//			member.setMemberId(rs.getString("member_id"));
//			member.setMemberName(rs.getString("member_name"));
//			member.setMemberPwd(rs.getString("member_pwd"));
//			member.setMemberNo(rs.getInt("member_no"));
//			member.setStatus(rs.getString("status"));
//		} else {
//			throw new SQLException();
//		}
		Member member;
		try {
			member = dao.login(id, pwd);
			if(member.getStatus().equals("Y"))  return member;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;		
	}
//	
//	// 5. 회원탈퇴
	public boolean deleteMember(int no) {
//		Connection conn = getConnect();
//		String query = "UPDATE tb_member SET status='Y' WHERE member_no = ?"; // 회원 탈퇴 시 status='Y'
//		PreparedStatement ps = conn.prepareStatement(query);
//		ps.setInt(1, no);
//		ps.executeUpdate();
//		close(ps,conn);
		try {
			if(dao.deleteMember(no) == 1) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
	





