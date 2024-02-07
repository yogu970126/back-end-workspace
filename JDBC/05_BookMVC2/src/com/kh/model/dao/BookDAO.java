package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.vo.Book;
import com.kh.model.vo.Publisher;

// DAO (Data Access Object)
// : DB에 접근하는 역할을 하는 객체 (CRUD)

public class BookDAO {
	
	public BookDAO() {
		try {
			// 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// 드라이버 연결 메서드
	public Connection getConnect() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/library2", "root", "1234");
	}
	// 자원반납 메서드1
	public void close(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
	}
	// 자원반납 메서드2
	public void close(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs!=null) rs.close();
		close(ps,conn);
	}
	
	// 1. 전체 책 조회
	public ArrayList<Book> printBookAll() throws SQLException {
		// 드라이버 연결
		Connection conn = getConnect();
		String query = "SELECT * FROM tb_book LEFT JOIN tb_publisher USING(pub_no)";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Book> list = new ArrayList<>();
		
		while(rs.next()) {
			Book book = new Book();
			// ResultSet에서 값을 하나씩 따옴
			book.setBkNo(rs.getInt("bk_no"));
			book.setBkTitle(rs.getString("bk_title"));
			book.setBkAuthor(rs.getString("bk_author"));
			book.setBkPrice(rs.getInt("bk_price"));
			book.setPublisher(new Publisher(rs.getInt("pub_no"),
										    rs.getString("pub_name"), 
										    rs.getString("phone")));
			// 따온 값을 리스트에 저장
			list.add(book);
		}
		close(rs, ps, conn);
		return list;
	}
	
	// 2. 책 등록
	public int registerBook(String title, String author) throws SQLException {
		Connection conn = getConnect();
		String query = "INSERT INTO tb_book(bk_title, bk_author) VALUES(?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, title);
		ps.setString(2, author);
		int result = ps.executeUpdate();
		close(ps,conn);
		return result;
		
	}
	// 3. 책 삭제
	public int sellBook(int no) throws SQLException {
		Connection conn = getConnect();
		String query = "DELETE FROM tb_book WHERE bk_no = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, no);
		ps.executeUpdate();
		
		int result = ps.executeUpdate();
		// 일부러 예외를 발생시켜서 출력
		if(ps.executeUpdate()==0) throw new SQLException();
		close(ps,conn);
		return result;
	}
	
	
	
	
	
	
	
	
	


}
