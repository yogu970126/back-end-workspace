package com.kh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.kh.model.Book;

public class Application {
	
	private Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Application app = new Application();
			app.mainMenu();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		
	}
	
	public void mainMenu() throws SQLException {
		System.out.println("===== 도서 관리 프로그램 =====");
		
		boolean check = true;
		while(check) {
			System.out.println("1. 전체 책 조회");
			System.out.println("2. 책 등록");
			System.out.println("3. 책 삭제");
			System.out.println("4. 회원가입");
			System.out.println("5. 로그인");
			System.out.println("9. 종료");
			
			System.out.print("메뉴 번호 입력 : ");
			switch(Integer.parseInt(sc.nextLine())) {
			case 1:
				printBookAll();
				break;
			case 2:
				registerBook();
				break;
			case 3:
				sellBook();
				break;
			case 4:
				registerMember();
				break;
			case 5:
				login();
				break;
			case 9:
				System.out.println("프로그램 종료");
				check = false;
			}
		}
	}
	
	public void printBookAll() throws SQLException {
		// 1. 전체 책 조회
		// 반복문을 이용해서 책 리스트 출력
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "1234");
		String query = "SELECT * FROM tb_book";
		PreparedStatement ps = conn.prepareStatement(query);
	
		ResultSet rs = ps.executeQuery();
		ArrayList<Book> list = new ArrayList<>();
		
		while(rs.next()) {
			list.add(new Book(rs.getInt("bk_no"), rs.getString("bk_title"), rs.getString("bk_author"), rs.getInt("bk_price"), rs.getInt("bk_pub_no")));
		}
		for(Book b : list) {
			System.out.println(b);
		}
	}
	
	public void registerBook () throws SQLException {
		// 2. 책 등록
		// 책 제목, 책 저자를 사용자한테 입력받아 
		// 등록에 성공하면 "성공적으로 책을 등록했습니다." 출력
		// 실패하면 "책을 등록하는데 실패했습니다." 출력
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "1234");
		String query = "INSERT INTO tb_book VALUES(?, ?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		
	}
	
	public void sellBook() {
		// 3. 책 삭제
		// printBookAll(전체 책 조회)를 한 후
		// 삭제할 책 번호 선택을 사용자에게 입력 받아
		// 삭제에 성공하면 "성공적으로 책을 삭제했습니다." 출력
		// 실패하면 "책을 삭제하는데 실패했습니다." 출력
	}
	
	public void registerMember() {
		// 4. 회원가입
		// 아이디, 비밀번호, 이름을 사용자에게 입력 받아
		// 성공하면 "성공적으로 회원가입을 완료하였습니다." 출력
		// 실패하면 "회원가입에 실패하였습니다." 출력
	}
	
	public void login() {
		// 5. 로그인
		// 아이디, 비밀번호를 사용자한테 입력 받아
		// 로그인에 성공하면 "~~님, 환영합니다!" 출력 후
		// --> memberMenu() 호출
		// 실패하면 "로그인에 실패했습니다." 출력
	}
	
	public void memberMenu() {
		boolean check = true;
		while(check) {
			System.out.println("1. 책 대여");
			System.out.println("2. 내가 대여한 책 조회");
			System.out.println("3. 대여 취소");
			System.out.println("4. 로그아웃");
			System.out.println("5. 회원 탈퇴");
			System.out.print("메뉴 번호 입력 : ");
			switch(Integer.parseInt(sc.nextLine())) {
			case 1:
				rentBook();
				break;
			case 2:
				printRentBook();
				break;
			case 3:
				deleteRent();
				break;
			case 4:
				check = false;
				break;
			case 5:
				deleteMember();
				check = false;
				break;
			}
		}
	}
	
	public void rentBook() {
		// 1. 책 대여
		// printBookAll(전체 책 조회) 출력 후
		// 대여할 책 번호 선택을 사용자한테 입력 받아
		// 대여에 성공하면 "성공적으로 책을 대여했습니다." 출력
		// 실패하면 "책을 대여하는데 실패했습니다." 출력
	}
	
	public void printRentBook() {
		// 2. 내가 대여한 책 조회
		// 내가 대여한 책들을 반복문을 이용하여 조회
		// 단 반납 기한도 같이 조회
		// 반납 번호, 책 제목, 책 저자, 대여 날짜, 반납 기한 조회
	}
	
	public void deleteRent() {
		// 3. 대여 취소
		// printRentBook(내가 대여한 책 조회) 출력 후
		// 취소할 대여 번호 선택을 사용자한테 입력 받아
		// 취소에 성공하면 "성공적으로 대여를 취소했습니다." 출력
		// 실패하면 "대여를 취소하는데 실패했습니다." 출력
	}
	
	public void deleteMember() {
		// 4. 회원탈퇴
		// 회원탈퇴에 성공하면 "회원탈퇴 하였습니다." 출력
		// 실패하면 "회원탈퇴하는데 실패했습니다." 출력
	}
 	
	

}
