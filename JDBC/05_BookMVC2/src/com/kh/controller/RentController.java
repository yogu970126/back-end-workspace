package com.kh.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.dao.RentDAO;
import com.kh.model.vo.Book;
import com.kh.model.vo.Rent;

public class RentController {

	private RentDAO dao = new RentDAO();
	
	// 1. 책 대여
	// tb_rent에 추가한다
	public boolean rentBook(int bkNo, int memberNo) {
//		Connection conn = getConnect();
//		String query = "INSERT INTO tb_rent(member_no, bk_no) VALUES(?, ?)";
//		PreparedStatement ps = conn.prepareStatement(query);
//		ps.setInt(1, memberNo);
//		ps.setInt(2, bkNo);
//		ps.executeUpdate();
//		close(ps, conn);
		try {
			if(dao.rentBook(bkNo, memberNo)==1) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<Rent> printRentBook(int no) {
//		Connection conn = getConnect();
//		String query = "SELECT * FROM tb_rent JOIN tb_book USING(bk_no) WHERE member_no = ?";
//		PreparedStatement ps = conn.prepareStatement(query);
//		ps.setInt(1, no);
//		ResultSet rs = ps.executeQuery();
//		ArrayList<Rent> list = new ArrayList<>();
//		
//		while(rs.next()) {
//			Rent rent = new Rent();
//			rent.setRentNo(rs.getInt("rent_no"));
//			rent.setRentDate(rs.getDate("rent_date"));
//			rent.setBook(new Book(rs.getString("bk_title"), rs.getString("bk_author")));
//			list.add(rent);
//		}
//		return list;
		try {
			return dao.printRentBook(no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean deleteRent(int no)  {
//		Connection conn = getConnect();
//		String query = "DELETE FROM tb_rent WHERE rent_no = ?";
//		PreparedStatement ps = conn.prepareStatement(query);
//		ps.setInt(1, no);
//		
//		if(ps.executeUpdate()!=1) {
//			throw new SQLException();
//		}
//		close(ps,conn);
		try {
			if(dao.deleteRent(no) == 1) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}

















