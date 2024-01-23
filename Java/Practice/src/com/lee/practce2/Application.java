package com.lee.practce2;

import java.util.Scanner;

import com.lee.practce2.controller.EmployeeController;
import com.lee.practce2.model.Employee;

public class Application {
	
	Scanner sc = new Scanner(System.in);
	Employee viewEmployee  = new Employee();
	EmployeeController employeeController = new EmployeeController();

	public static void main(String[] args) {
		Application app = new Application();
		
		boolean check = true;
		
		while(check) {
			int memu = app.employeeMenu();
			switch(memu) {
			case 1:
				app.insertEmp();
				break;
			case 2:
				app.updateEmp();
				break;
			case 3:
				app.printEmp();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				check = false;
				break;
			}
		}

	}
	
	public int employeeMenu() {
		System.out.println("1. 사원 정보 추가");
		System.out.println("2. 사원 정보 수정");
		System.out.println("3. 사원 정보 출력");
		System.out.println("9. 프로그램 종료");
		System.out.print("메뉴 번호를 누르세요 : ");
		return Integer.parseInt(sc.nextLine());		
	}
	
	public void insertEmp() {
		System.out.print("사원 번호 : ");
		int empNo = Integer.parseInt(sc.nextLine());
		
		System.out.print("사원 이름 : ");
		String name = sc.nextLine();
		
		System.out.print("사원 성별 : ");
		char gender = sc.nextLine().charAt(0);
		
		System.out.print("전화 번호 : ");
		String phone = sc.nextLine();
		
		System.out.print("추가 정보를 더 입력하시겠습니까? (y / n) ");
		char add = sc.nextLine().charAt(0);
		
		if(add == 'y') {
			System.out.print("사원 부서 : ");
			String dept = sc.nextLine();
			
			System.out.print("사원 연봉 : ");
			int salary = Integer.parseInt(sc.nextLine());
			
			System.out.print("보너스 율 : ");
			double bonus = Double.parseDouble(sc.nextLine());
			
			employeeController.add(empNo, name, gender, phone, dept, salary, bonus);
		} 
		else {		
		employeeController.add(empNo, name, gender, phone);
		}
	}
	
	public void updateEmp() {
		System.out.println("사원의 어떤 정보를 수정하시겠습니까?");
		System.out.println("1. 전화 번호");
		System.out.println("2. 사원 연봉");
		System.out.println("3. 보너스 율");
		System.out.println("9. 돌아가기");
		System.out.print("메뉴 번호를 누르세요 : ");
		
		switch(Integer.parseInt(sc.nextLine())) {
		case 1:
			System.out.print("전화 번호 입력 : ");
			String phone = sc.nextLine();
			employeeController.modify(phone);
			break;
		case 2:
			System.out.print("사원 연봉 입력 : ");
			int salary = Integer.parseInt(sc.nextLine());
			employeeController.modify(salary);
			break;
		case 3: 
			System.out.print("보너스 율 입력 : ");
			double bonus = Double.parseDouble(sc.nextLine());
			employeeController.modify(bonus);
			break;
		case 9: 
			employeeMenu();
		}
		
		
	}
	
	public void printEmp() {
		System.out.println(employeeController.info());
	}

}
