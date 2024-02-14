package com.kh.object;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;

import com.kh.object.model.Person;

public class SerializationTest {
	
	String fileName = "src/person.obj";

	public static void main(String[] args) {

		SerializationTest s = new SerializationTest();
		//s.fileSave();
		//s.fileRead();
		//s.objectsSave();
		s.objectsRead();
	}
	
	// 직렬화(serialization) : 객체를 데이터 스트림으로 만드는 것
	public void fileSave() {

		try(
				// 1. 스트림 생성
				// FileOutputStream : 파일 출력에 사용되는 기본 바이트 스트림 클래스
				// ObjectOutputStream : 객체 단위로 출력 시에 사용되는 보조 바이트 스트림 클래스
				FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				
				// ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
				
				) {
			
			// 2. 파일에 저장할 객체 생성
			Person p = new Person("제니", 28, "jennierubyjane");
			
			// 3. 파일에 데이터(객체) 저장
			oos.writeObject(p);
			
			System.out.println("person.obj 파일에 정보 저장!");
			
		} catch(IOException e) {
			e.printStackTrace();
		}

	}
	
	// 역직렬화(deserialization) : 저장된 내용이나 전송받은 내용을 다시 복원하는 것
	public void fileRead() {
		
		try(
				// 1. 스트림 생성
				// FileInputStream : 파일 출력에 사용되는 기본 바이트 스트림 클래스
				// ObjectInputStream : 객체 단위로 출력 시에 사용되는 보조 바이트 스트림 클래스
				FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis);
				
				) {
			
			// 2. 보조 스트림에 담겨진 객체 가져오기
			Person p = (Person) ois.readObject();
			System.out.println(p);

		} catch(IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 여러 객체를 저장 (for문 이용) -> 위에 fileSave 참고
	public void objectsSave() {
		List<Person> list = Arrays.asList(
				new Person("제니", 28, "jennierubyjane"),
				new Person("지수", 29, "sooyaaa__"),
				new Person("로제", 26, "roses_are_rosie"),
				new Person("뷔", 28, "thv"),
				new Person("지민", 28, "j.m")
		);
		
		
		try(
				// 1. 스트림 생성 
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
		) {
			
			// 2. 객체 저장
			for(Person p : list) {
				oos.writeObject(p);
			}
			
			System.out.println("person.obj 파일에 정보 저장");
			
		} catch(IOException e) {
			
		}
		
		
		
		
	}
	
	// 파일에 저장한 데이터 읽기 (반복문 사용 : 무한루프 + try~catch)
	// -> 위에 fileRead 참고
	public void objectsRead() {
		try(
				// 1. 스트림 생성
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
				) {
			
			// 2. 객체 값 가져오기
			while(true) {
				System.out.println(ois.readObject());
			}
		} catch(Exception e) {
			
		}
	}
}













