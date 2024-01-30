package com.kh.object;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.kh.object.model.Person;

public class SerializationTest {

	public static void main(String[] args) {
		
		SerializationTest s =new SerializationTest();
		s.fileSave();
		s.fileRead();
	}
	
	// 직렬화(serialization) : 객체를 데이터 스트림으로 만드는 것
	public void fileSave() {
		
		String fileName = "src/person.obj";
		
		try(
				// 1. 스트림 생성
				// FileOutputStream : 파일 출력에 사용되는 기본 바이트 스트림 클래스
				// ObjectOutputStream : 객체 단위로 출력 시에 사용되는 보조 바이트 스트림 클래스
				FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				
				) {
			// 2. 파일에 저장할 객체 생성
			Person p = new Person("제니", 28, "jennierubjane");
			
			// 3. 파일에 데이터(객체) 저장
			oos.writeObject(p);
			
			System.out.println("person.obj 파일에 정보 저장!");
			
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void fileRead() {
		
		try(	// 1. 스트림 생성
				// FileInputStream
				// ObjectInputStream
				) {
			
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}













