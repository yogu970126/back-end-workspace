package transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TXCommitTest2 {

	public static void main(String[] args) {
		/*
		 * 대윤 -> 대규 : 50만원씩 이체
		 * 이 관련 모든쿼리를 하나로 묶는다! 트랜잭션 사용!
		 * 대윤님의 잔액이 마이너스가 되면 이체 취소가 되어야 한다
		 * */
		
		
		try {
			// 1. 드라이버 연결
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2. DB 연결
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kh", "root", "1234");
			
			// 3. 쿼리문 + 트랜잭션 작성
			String query1 = "UPDATE bank SET balance = balance - ? WHERE name = ?";
			String query2 = "UPDATE bank SET balance = balance + ?  WHERE name = ?";
			String query3 = "SELECT balance FROM bank WHERE name = ?"; // 잔액 조회를 할 쿼리문 작성
			
			conn.setAutoCommit(false);
			
			PreparedStatement ps1 = conn.prepareStatement(query1);
			ps1.setInt(1, 500000);
			ps1.setString(2, "정대윤");
			ps1.executeUpdate();
			
			PreparedStatement ps2 = conn.prepareStatement(query2);
			ps2.setInt(1, 500000);
			ps2.setString(2, "신대규");
			ps2.executeUpdate();
			
			PreparedStatement ps3 = conn.prepareStatement(query3);
			ps3.setString(1, "정대윤");
			ResultSet rs = ps3.executeQuery();
			
			if(rs.next()) {
				// 대윤님의 잔액이 마이너스가 되면 이체 취소가 되어야 한다
				if(rs.getInt("balance") < 0) {
					conn.rollback();
					System.out.println("잔액이 부족하여 이체가 취소됩니다.");
				} else {
					conn.commit();
					System.out.println("이체가 완료되었습니다.");
				}
			}
			conn.setAutoCommit(true);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
