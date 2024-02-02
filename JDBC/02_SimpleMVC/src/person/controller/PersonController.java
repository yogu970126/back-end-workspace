package person.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.ServerInfo;
import person.model.Person;

public class PersonController {
	
	public PersonController() {
		// 1. 드라이버 연결
		// 생성자 생성할때 드라이버 로딩을 같이 걸어버림 이러면 로딩 딱 한번만 실행
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패..");
		}
		System.out.println("드라이버 로딩 완료");
	}
	
	// DB 연결 메서드
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		return conn;
	}
	
	// 자원 반납 메서드
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}
	// 자원 반납 메서드
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		closeAll(ps, conn);
	}
	
	
	public int addPerson(int id, String name, String address) throws SQLException {
		Connection conn = getConnect();
		String query = "INSERT INTO person VALUES (?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		// 4. 쿼리문 실행
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setString(3, address);
		int result = ps.executeUpdate();
		
		closeAll(ps, conn);
		return result;
		
	}
	
	public int updatePerson(int id, String address) throws SQLException {
		Connection conn = getConnect();
		
		String query = "UPDATE person SET address = ? WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, address);
		ps.setInt(2, id);
		
		int result = ps.executeUpdate();
		closeAll(ps, conn);
		return result;
		

		
	}
	public int removePerson(int id) throws SQLException {
		Connection conn = getConnect();

		String query = "DELETE FROM person WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setInt(1, id);
		
		int result = ps.executeUpdate();
		closeAll(ps, conn);
		return result;
		

	}
	
	public ArrayList<Person> searchAllPerson() throws SQLException {
		Connection conn = getConnect();
		
		String query = "SELECT * FROM person";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		ArrayList<Person> list = new ArrayList<>();
		
		while(rs.next()) {
		// 생성자 방식
//			list.add(new Person(rs.getInt("id"), rs.getString("name"), rs.getString("address")));		
//		}
		
		// setter 방식
		Person person = new Person();
		person.setId(rs.getInt("id"));
		person.setName(rs.getString("name"));
		person.setAddress(rs.getString("address"));
		list.add(person);
		}
		
		closeAll(rs, ps, conn);
		return list;
	}
	
	public Person searchPerson(int id) throws SQLException {
		Connection conn = getConnect();
		
		String query = "SELECT * FROM person WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(query);

		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		Person person = null;
		
		if (rs.next()) {
			person = new Person(rs.getInt("id"),
								rs.getString("name"),
								rs.getString("address"));
		}
		
		closeAll(rs, ps, conn);
		return person;
	}
	

}



















