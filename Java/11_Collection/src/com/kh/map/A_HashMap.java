package com.kh.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.kh.map.model.Snack;

/*
 * Map
 * - key-value 쌍으로 저장
 * - 순서 없음
 * - 중복 : 키(key) 중복 X, 값(value) 중복 O
 * 
 *  HashMap
 *  - Map 인터페이스를 구현한 대표적인 컬렉션 클래스
 * */

public class A_HashMap {

	public static void main(String[] args) {
		A_HashMap a = new A_HashMap();
//		a.method1();
		a.method2();
	}
	
	
	public void method1() {
		Map<String, Integer> map = new HashMap<>();
		map.put("웨하스", 250);
		map.put("고래밥", 180);
		map.put("칸쵸", 800);
		map.put("나쵸", 450);
		
		System.out.println(map);
		
		// 1. 키만 가져오기
		Set<String> key = map.keySet();
		System.out.println(key);
		
		// 2. 값만 가져오기
		Collection<Integer> col = map.values();
		System.out.println(col);
		
		// 3. 키에 해당하는 value 값 가져오기
		Iterator<String> it = key.iterator();
		while(it.hasNext()) {
			String name = it.next();
			System.out.println(name + " : " + map.get(name));
		}
		System.out.println("-------------------------------------");
		for(String s : key) {
			System.out.println(s + " : " + map.get(s));
		}
		
		/*
		 * 4. entrySet
		 *    - Map 컬렉션에 있는 Entry 객체(key, value 쌍으로 이루어진)를
		 *      Set 컬렉션에 담아서 반환
		 *    - 반환된 Set 컬렉션에서 반복자를 얻어서 반복 처리
		 * */
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		System.out.println(entrySet);
		
		for(Entry<String, Integer> e : entrySet) {
			System.out.println(e.getKey() + " : " + e.getValue());
		}
		
	}
	
	public void method2() {
		Map<String, Snack> map = new HashMap<>();
		
		map.put("웨하스", new Snack("치즈",240));
		map.put("웨하스", new Snack("딸기맛", 255));
		map.put("고래밥", new Snack("양념치킨", 173));
		map.put("자유시간", new Snack("아몬드", 232));
		map.put("칸쵸", new Snack("딸기 요거트", 880));
		map.put("홈런볼", new Snack("초코", 270));
		map.put("스윙칩", new Snack("볶음고추", 347));
		map.put("나쵸", new Snack("치즈", 486));
		map.put("꼬깔콘", new Snack("매콤달콤", 175));
		map.put("후렌치파이", new Snack("딸기", 900));
		
		System.out.println("과자의 개수 : " + map.size()); // 9

		// 웨하스에는 뭐가 들어 있을까요?
		System.out.println(map.get("웨하스"));
		
		// 키 값으로 삭제하기 - 꼬깔콘 삭제
		map.remove("꼬깔콘");
		System.out.println(map);
		System.out.println("과자의 갯수 : " + map.size());

		System.out.println();
		// 1. 홈런볼에 대한 과자 정보 출력
		System.out.println("Q1. ");
		System.out.println("홈런볼의 정보 : " + map.get("홈런볼"));
		
		// 2. 후렌치파이의 맛 정보 출력
		System.out.println("Q2. ");
		System.out.println("후렌치파이의 맛은 " + map.get("후렌치파이").getFlavor());
		
		// 3. 모든 과자의 칼로리 총합과 평균 출력
		System.out.println("Q3. ");
		int sum = 0;
		// Entry 방식 
		/*
		Set<Entry<String, Snack>> entrySet = map.entrySet();
		
		for(Entry<String, Snack> cal : entrySet) {
			sum += cal.getValue().getCalorie();
		}
		System.out.println("과자들의 평균 칼로리는 " + sum/entrySet.size());
		*/
		
		// 키값 방식
		for(String key : map.keySet()) {
			sum += map.get(key).getCalorie();
		}
		System.out.println("과자들의 평균 칼로리는 " + sum/map.size());
		
		
		System.out.println("--------------------------------------");
		// 모든 Entry 객체 삭제
		map.clear();
		System.out.println("비어있는가? " + map.isEmpty());
		System.out.println(map);
	
	}

}
























