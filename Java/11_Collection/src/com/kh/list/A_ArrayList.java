package com.kh.list;

import java.util.ArrayList;
import java.util.List;

import com.kh.list.model.Person;

// 배열 대신사용
// 중요하다

/*
 * - Collection : 자바에서 제공하는 자료구조를 담당하는 프레임워크
 * - 자료구조 : 데이터를 효율적으로 이용하는 방법으로 데이터에 편리하게 접근하고,
 * 			  효율적으로 사용하기 위해서 데이터를 저장하거나 조직하는 방법
 * - java.util 패키지에 컬렉션과 관련된 인터페이스와 클래스들이 포함
 * - 컬렉션을 사용하면 데이터의 추가, 삭제, 정렬 등의 처리가 간단하게 해결되어 자료구조적 알고리즘을 구현할 필요 없음
 * 
 * * 컬렉션의 장점
 * - 저장하는 크기의 제약이 없다.
 * - 데이터의 추가, 삭제, 정렬 등의 기능 처리가 간단하게 해결
 * - 여러 타입의 데이터가 저장 가능
 * 
 * * List
 * - 자료들을 순차적으로 늘어놓은 구조
 * - 저장되는 객체를 인덱스로 관리하기 때문에 인덱스로 객체를 검색, 삭제할 수 있는 기능
 * - 중복되는 객체 저장 가능하고, null 값도 저장 가능
 * 
 * * ArrayList
 * - 저장 용량(capacity)을 초과한 객체들이 들어오면 자동적으로 저장 용량이 늘어난다.
 * - 동기화(Synchronized)를 제공하지 않는다.
 * - 동기화 : 하나의 자원(데이터)에 대해 여러 개의 스레드가 접근하려 할 때 
 * 			한 시점에서 하나의 스레드만 사용할 수 있도록	하는 것을 말한다.
 * */

public class A_ArrayList {

	public static void main(String[] args) {
		A_ArrayList a = new A_ArrayList();
//		a.method1();
		a.method2();
	}

	public void method1() {
		List list = new ArrayList();
		
		list.add("신대규");
		list.add("정대윤");
		list.add("조세미");
		list.add("정세영");
		list.add("권예빈");
		
		System.out.println(list);
	}
	
	public void method2() {
		ArrayList<Person> list = new ArrayList();
		
		/*
		 * 제네릭스(Generics)
		 * - 컴파일시 타입을 체크해 주는 기능
		 * - <> 다이아몬드 연산자 사용
		 * 
		 * * 컬렉션에서 사용하는 이유
		 * - 명시된 타입의 객체만 저장하도록 제한을 두기 위해 사용
		 * - 
		 * */
		
		// list.add("강호동222");
		// --->  <Person> 제네릭스로 리스트의 데이터 타입을 강제했기 때문에 오류 발생
		// 제네릭스로 타입을 강제하지 않으면 어떤 타입이든 리스트에 싸그리 들어간다.
		
		// 1. add : 리스트 끝에 추가
		list.add(new Person("전현무", "삼성동", 46));
		list.add(new Person("남궁민", "서울숲", 45));
		list.add(new Person("이시영", "상도동", 41));
		list.add(new Person("이제훈", "삼성동", 39));
		
		// 2. add : 인덱스를 지정하여 해당 인덱스에 추가하는 방식
		//    -> 내부적으로 기존에 있는 것들은 뒤로 땡기고 해당 인덱스에 값 추가
		list.add(1, new Person("유재석", "압구정", 51));
		list.add(3, new Person("강호동", "도곡동", 53));
		
		// 3. set : 해당 인덱스의 값을 변경
		list.set(3, new Person("오은영", "삼성동", 57));
		
		// 4. size : 리스트 안에 몇 개의 데이터가 있는지
		System.out.println("사람 수 : " + list.size());
		System.out.println(list);
		
		// 5. remove : 해당 인덱스의 객체 삭제
		//	  -> 알아서 크기 줄어들고 뒤에 객체가 앞으로 다 땡겨옴
		list.remove(0);
		
		System.out.println("삭제 후 사람 수 : " + list.size());		
		System.out.println(list);
		
		
		// 6. get : 해당 인덱스의 객체를 가져오기		
		System.out.println(list.get(0));
		
		// 7. subList : 기존 리스트에서 원하는 만큼 추출해서 새로운 리스트 반환
		List sub = list.subList(0, 2);
		System.out.println(sub);
		
		// 8. addAll : 컬렉션을 통째로 뒤에 추가
		list.addAll(sub);
		System.out.println(list);
		
		// 9. isEmpty : 컬렉션이 비어있는지
		System.out.println("리스트가 비어있는가? " + list.isEmpty());
	}
}
















