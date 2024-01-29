package com.kh.stream.intermediate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

import com.kh.stream.model.Student;

// 매핑 - 중간 처리 기능으로 스트림의 요소를 다른 요소로 대체하는 역할

public class C_Mapping {

	public static void main(String[] args) {
		C_Mapping c = new C_Mapping();
//		c.method1();
//		c.method2();
		c.method3();
	}
	
	// mapXXX : 요소를 대체하는 요소로 구성된 새로운 스트림 생성
	public void method1() {
		List<Student> students = Arrays.asList(
				new Student("이상현", 20, "남자", 80, 50),
				new Student("정대윤", 19, "남자", 75, 60),
				new Student("이상호", 21, "남자", 50, 100),
				new Student("권예빈", 18, "여자", 60, 45),
				new Student("손민정", 22, "여자", 70, 90)
			);
		
		students.stream()
				.map(student -> student.getName()) // map getName으로 이름만 넘겨서 출력
				.forEach(student -> System.out.println(student));
		
		System.out.println();
		
		// 수학 점수의 평균(최종처리 average)
		double avg = students.stream()
							.mapToInt(student -> student.getMath())
							.average() // average의 타입은 OptionalDouble
							.getAsDouble(); // 그래서 이걸 사용해 OptionalDouble을 double로 바꿔준다
		System.out.println("수학 점수의 평균 : " + avg);
				
	}
	
	// flatMapXXX : 하나의 요소를 복수의 요소들로 구성된 새로운 스트림을 생성한다.
	public void method2() {
		List<String> list = Arrays.asList("Java11 Lambda",
									"StreamAPI Filtering Sorted Mapping");
		list.stream()
		//	.forEach(str -> System.out.println(str));
			.forEach(System.out::println);
		
		System.out.println();
		
		list.stream()
			.flatMap((String str) -> {
				String[] array = str.split(" ");
				return Arrays.stream(array);
			})
			//.flatMap(str -> Arrays.stream(str.split(" "))) 
			// 공백 기준으로 잘라서 새로운 스트림 생성, 위 문장을 줄인거다
			.forEach(System.out::println);
	}
	
	
	// asDoubleStream(), asLongStream(), boxed()
	// - asDoubleStream : IntStream, LongStream을 DoubleStream 으로 변환
	// - asLongStream : IntStream을 LongStream으로 변환
	// - boxed : int, long, double 요소를 Integer, Long, Double 요소로 박싱
	public void method3() {
		int[] array1 = {1, 2, 3, 4, 5};
		double[] array2= {1.1, 2.2, 3.3, 4.4, 5.5};
		
		Arrays.stream(array1)
			  .asDoubleStream()
			  .forEach(System.out::println);
		
		System.out.println();
		
		Arrays.stream(array2)
//			  .sorted(Comparator.reverseOrder()) // 객체 애들만 쓸수있다, 지금은 기본자료형(double)
			  .boxed() // 클래스로 박싱
			  .sorted(Comparator.reverseOrder())
			  .forEach(System.out::println);
		
	}

}
















