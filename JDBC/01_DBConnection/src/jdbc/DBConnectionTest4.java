package jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import config.ServerInfo;

public class DBConnectionTest4 {

	public static void main(String[] args) {
		try {
			
			Properties p = new Properties();
			p.load(new FileInputStream("src/config/jdbc.properties"));
			
			// 1. 드라이버 로딩
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("1. 드라이버 로딩 완료");
			
			// 2. DB 연결
			Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
			System.out.println("2. DB 연결 완료");
			
			// 3. 쿼리문 준비 - DELETE
			// 쿼리문의 변경되는 값은 ? 로 적는다
			String query = p.getProperty("delete");
			PreparedStatement ps = conn.prepareStatement(query);			
			
			// 4. 쿼리문 실행  (순서,  넣을내용)
			ps.setInt(1, 900); 
			System.out.println(ps.executeUpdate() + "명 삭제!");
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("DB 연결 실패");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
