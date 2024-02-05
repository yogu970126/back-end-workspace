package com.kh;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

import com.kh.controller.MemberController;
import com.kh.model.Member;

public class Application {
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	Member m = new Member();
		
	public static void main(String[] args) {
		Application app = new Application();
		try {
			app.mainMenu();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void mainMenu() throws SQLException {
		
		System.out.println("===== KH 사이트 =====");
		boolean check = true;
		
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
		} 
		
	public void signUp(Member m) throws SQLException {
		// 아이디, 비밀번호, 이름을 사용자에게 입력받아 MemberController의 signUp 메서드 반환 결과에 따라
		System.out.print("아이디 입력 : ");
		String id = sc.nextLine();
		
		System.out.print("비밀번호 입력 : ");
		String password = sc.nextLine();
		
		System.out.print("이름 입력 : ");
		String name = sc.nextLine();
		
		m.setId(id);
		m.setPassword(password);
		m.setName(name);
		
		if(mc.signUp(m)) {
			// true면 "성공적으로 회원가입 완료하였습니다." 출력
			System.out.println(m.getName() + "님 성공적으로 회원가입 완료하였습니다.");
		} else {
			// false면 "중복된 아이디입니다. 다시 입력해주세요." 출력
			System.out.println("중복된 아이디입니다. 다시 입력해주세요.");
		}
	}
	
	public void login() throws SQLException {
		// 아이디, 비밀번호, 이름을 사용자에게 입력받아 MemberController의 login 메서드 반환 결과를 이름으로 받고
		// 이름이 null아 아니면 "~~님, 환영합니다!" 출력
		//   -->> login 성공했다면 memberMenu() 호출
		// null이면 "틀린 아이디 또는 비밀번호입니다. 다시 입력해주세요." 출력
		System.out.println("****** 로그인 ******");
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		
		System.out.print("패스워드 : ");
		String password = sc.nextLine();
		
		// MemberController의 login 메서드 반환 결과를 이름으로 받고
		String name = mc.login(id, password);
		
		if(name != null) {
			System.out.println(name + "님, 환영합니다.");
			// -->> login 성공했다면 memberMenu() 호출
			memberMenu();
		} else {
			// null이면 "틀린 아이디 또는 비밀번호입니다. 다시 입력해주세요." 출력
			System.out.println("틀린 아이디 또는 비밀번호입니다. 다시 입력해주세요");
		}
		
		
		
	}
	
	public void memberMenu() throws SQLException {
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
				System.out.println("로그아웃 실행");
				check = false;
				break;
			}
		}
	}
	
	public void changePassword() throws SQLException {
		// 아이디, 현재 비밀번호, 새로운 비밀번호를 사용자한테 입력받아
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		
		System.out.print("현재 비밀번호 : ");
		String password = sc.nextLine();
		
		System.out.print("새로운 비밀번호 : ");
		String newPassword = sc.nextLine();
		
		// MemberController의 changePassword 메서드 반환 결과에 따라
		if(mc.changePassword(id, password, newPassword)) {
			// true면 "비밀번호 변경에 성공했습니다." 출력
			System.out.println("비밀번호 변경에 성공했습니다.");
		} else {
			// false면 "비밀번호 변경에 실패했습니다. 다시 입력해주세요." 출력
			System.out.println("비밀번호 변경에 실패했습니다.");
		}
		
	}
	
	public void changeName() throws SQLException {
		// 아이디, 비밀번호를 사용자에게 입력받아 사용자가 맞는지 확인 후 - memberController의 login 메서드 활용
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		
		System.out.print("비밀번호 : ");
		String password = sc.nextLine();
		
		String name = mc.login(id, password);
		// 이름이 null이 아니면 --> "현재 설정된 이름 : OOO" 출력
		if(name != null) {
			System.out.println("현재 설정된 이름 : " + name);
			
        //	--> 변경할 이름을 사용자한테 입력받아 
			System.out.print("변경할 이름 : ");
			String newName = sc.nextLine();
			
			if(newName != "") {
		// MemberController의 changeName 메서드로 이름 변경후 
		// "이름 변경에 성공하였습니다." 출력
			mc.changeName(id, newName);
			System.out.println("이름 변경에 성공하였습니다.");
			} else {
				// 이름이 null 이면 "이름 변경에 실패했습니다. 다시 입력해주세요." 출력
				System.out.println("이름 변경에 실패하였습니다.");
			}
		} 
		
		
		
		
		
		
		
		
		
	}
	
	

}














