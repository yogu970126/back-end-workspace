package com.kh.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.dao.BookDAO;
import com.kh.model.vo.Book;
import com.kh.model.vo.Publisher;

public class BookController {
	
	private BookDAO dao = new BookDAO(); 
	
	// 1. 전체 책 조회
	public ArrayList<Book> printBookAll() {
//		Connection conn = getConnect();
//
//		String query = "SELECT * FROM tb_book LEFT JOIN tb_publisher USING (pub_no)";
//		PreparedStatement ps = conn.prepareStatement(query);
//
//		ResultSet rs = ps.executeQuery();
//
//		ArrayList<Book> list = new ArrayList<>();
//		while(rs.next()) {
//			Book book = new Book();
//			book.setBkNo(rs.getInt("bk_no"));
//			book.setBkTitle(rs.getString("bk_title"));
//			book.setBkAuthor(rs.getString("bk_author"));
//			book.setBkPrice(rs.getInt("bk_price"));
//			book.setPublisher(new Publisher(rs.getInt("pub_no"), 
//											rs.getString("pub_name"),
//											rs.getString("phone")));
//			list.add(book);
//		}
//		return list;
		
		try {
			return dao.printBookAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 2. 책 등록
	public boolean registerBook(String title, String author) {
//		Connection conn = getConnect();
//		String query = "INSERT INTO tb_book(bk_title, bk_author) VALUES(?, ?)";
//		PreparedStatement ps = conn.prepareStatement(query);
//		ps.setString(1, title);
//		ps.setString(2, author);
//		ps.executeUpdate();
//		close(ps, conn);
		
		try {
			if(dao.registerBook(title, author)==1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	// 3. 책 삭제
	public boolean sellBook(int no)  {
//		Connection conn = getConnect();
//		String query = "DELETE FROM tb_book WHERE bk_no=?";
//		PreparedStatement ps = conn.prepareStatement(query);
//		ps.setInt(1, no);
//
//		if(ps.executeUpdate() == 0) throw new SQLException();
//		close(ps, conn);
		
		try {
			if(dao.sellBook(no) == 1) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	
	
	
	
	
	
	
	
}












