package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import config.ServerInfo;

public class DBConnectionTest3 {

	public static void main(String[] args) {
		try {
			// 1. 드라이버 로딩
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("1. 드라이버 로딩 완료");
			
			// 2. DB 연결
			Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
			System.out.println("2. DB 연결 완료");
			
			// 3. 쿼리문 준비 - UPDATE
			// 쿼리문의 변경되는 값은 ? 로 적는다
			String query = "UPDATE employee_copy SET emp_name = ? WHERE emp_id = ?";
			PreparedStatement ps = conn.prepareStatement(query);			
			
			// 4. 쿼리문 실행  (순서,  넣을내용)
			ps.setString(1, "김웡카");
			ps.setInt(2, 700); 
			System.out.println(ps.executeUpdate() + "명 수정!");
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("DB 연결 실패");
		}
		
		
	}

}
