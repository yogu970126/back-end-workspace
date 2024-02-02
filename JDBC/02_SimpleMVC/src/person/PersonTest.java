package person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import config.ServerInfo;
import person.controller.PersonController;
import person.model.Person;

public class PersonTest {
	Person p = new Person();
	PersonController pc = new PersonController();

	public static void main(String[] args) {
		PersonTest pt = new PersonTest();

		
		try {
			
			// DB 연결
			// DB 연결부터 각각의 메서드에 기능구현 필요
			
//			// person 테이블에 추가
			pt.addPerson(555, "김강우", "서울");
			pt.addPerson(222, "고아라", "제주도");
			pt.addPerson(333, "강태주", "경기도");
//			
//			// person 테이블에서 데이터 수정
			pt.updatePerson(222, "두비두비");
//			
//			// person 테이블에서 데이터 삭제
//			pt.removePerson(333);
//			
//			// person 테이블에 있는 데이터 전체 보여주기
//			pt.searchAllPerson();
//			
//			// person 테이블에서 데이터 한개만 가져오기
			pt.searchPerson(555);
//			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}	
	
	// 변동적인 반복 -- 비즈니스 로직 DAO (Database Access Object)
	// person 테이블에 추가
	public void addPerson(int id, String name, String address) throws SQLException {
		int result = pc.addPerson(id, name, address);
		if(result==1) {
			System.out.println(name + "님 회원가입 완료");
		} else {
			System.out.println("올바른 정보를 입력해주세요");
		}
	
	}
	
	public void updatePerson(int id, String address) throws SQLException {
		int result = pc.updatePerson(id, address);
		if(result == 1) {
			System.out.println("회원정보 수정 완료!");
		};
	}
	
	public void removePerson(int id) throws SQLException {
		int result = pc.removePerson(id);
		if(result == 1) {
			System.out.println("회원정보 삭제 완료!");
		}
	}
	
	public void searchAllPerson() throws SQLException {
		ArrayList<Person> list = pc.searchAllPerson();
			for (Person p : list) {
			System.out.println(p.getName() + " / " + p.getAddress());
		}
	}
	public void searchPerson(int id) throws SQLException {
		Person p = pc.searchPerson(id);
		System.out.println(p);
	}

	
}
