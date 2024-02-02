package com.kh;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

import com.kh.controller.MemberController;
import com.kh.model.Member;

public class Application {
	Scanner sc = new Scanner(System.in);
	MemberController mc = new MemberController();
	Member m = new Member();
		
	public static void main(String[] args) {
		Application app = new Application();
		app.mainMenu();
		
	}
	
	public void mainMenu() {
		
		System.out.println("===== KH 사이트 =====");
		boolean check = true;
		try {
			while(check) {
				System.out.println("****** 메인 메뉴 ******");
				System.out.println("1. 회원가입");
				System.out.println("2. 로그인");
				System.out.println("9. 종료");
				System.out.print("메뉴를 선택하세요 : ");
				int menu = Integer.parseInt(sc.nextLine());
				switch(menu) {
				case 1:
					signUp(m);
					break;
				case 2:
					login();
					break;
				case 9:
					System.out.println("프로그램을 종료합니다.");
					check = false;
					break;
				}
			}
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			mainMenu();
		} catch(NumberFormatException e) {
			System.out.println("올바른 메뉴를 입력해주세요");
			mainMenu();
		}
	}
		
	public void signUp(Member m) throws SQLException {
		// 아이디, 비밀번호, 이름을 사용자에게 입력받아 MemberController의 signUp 메서드 반환 결과에 따라
		// true면 "성공적으로 회원가입 완료하였습니다." 출력
		// false면 "중복된 아이디입니다. 다시 입력해주세요." 출력
		System.out.print("아이디 입력 : ");
		String id = sc.nextLine();
		
		System.out.print("비밀번호 입력 : ");
		String password = sc.nextLine();
		
		System.out.print("이름 입력 : ");
		String name = sc.nextLine();
		
		m.setId(id);
		m.setPassword(password);
		m.setName(name);
		
		if(mc.signUp(m) == true) {
			System.out.println(m.getName() + "님 회원가입 완료 되었습니다");
		};
		
		
	}
	
	public void login() {
		// 아이디, 비밀번호, 이름을 사용자에게 입력받아 MemberController의 login 메서드 반환 결과를 이름으로 받고
		// 이름이 null아 아니면 "~~님, 환영합니다!" 출력
		//   -->> login 성공했다면 memberMenu() 호출
		// null이면 "틀린 아이디 또는 비밀번호입니다. 다시 입력해주세요." 출력
		
	}
	
	public void memberMenu() {
		boolean check = true;
		while(check) {
			System.out.println("****** 회원 메뉴 ******");
			System.out.println("1. 비밀번호 바꾸기");
			System.out.println("2. 이름 바꾸기");
			System.out.println("3. 로그아웃");
			System.out.print("메뉴 번호 입력 : ");
			switch(Integer.parseInt(sc.nextLine())) {
			case 1:
				changePassword();
				break;
			case 2:
				changeName();
				break;
			case 3:
				// 로그아웃 처리 -> 메인 메뉴로 리턴
				break;
			}
		}
	}
	
	public void changePassword() {
		// 아이디, 현재 비밀번호, 새로운 비밀번호를 사용자한테 입력받아
		// MemberController의 changePassword 메서드 반환 결과에 따라
		// true면 "비밀번호 변경에 성공했습니다." 출력
		// false면 "비밀번호 변경에 실패했습니다. 다시 입력해주세요." 출력
		
	}
	
	public void changeName() {
		// 아이디, 비밀번호를 사용자에게 입력받아 사용자가 맞는지 확인 후 - memberController의 login 메서드 활용
		// 이름이 null이 아니면 --> "현재 설정된 이름 : OOO" 출력
		//				   --> 변경할 이름을 사용자한테 입력받아 
		//					   MemberController의 changeName 메서드로 이름 변경후 
		//					   "이름 변경에 성공하였습니다." 출력
		// 이름이 null 이면 "이름 변경에 실패했습니다. 다시 입력해주세요." 출력
		
	}
	
	

}














