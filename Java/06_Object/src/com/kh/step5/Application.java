package com.kh.step5;

import com.kh.step5.model.Book;

public class Application {

	public static void main(String[] args) {
		Book b = new Book();

		
		b.setTitle("처음부터 시작하는 주식투자 단타전략"); //b.title="처음부터 ...";
		b.setAuthor("홍인기");
		b.setPrice(21000);
		b.setDiscountRate(0.2);
		
		Book b2 = new Book("나는 메트로폴리탄 미술관의 경비원입니다",
							17500,
							0.1,
							"패트릭 브링리");
		
		// getter를 이용해서 두 객체 각각 할인율을 적용한 책 제목과 책 가격을 계산해서 출력
		// 할인된 가격 = 가격 - (가격*할인율)
		int discountPrice = (int)(b.getPrice() - (b.getPrice() * b.getDiscountRate()));
		int discountPrice2 = (int)(b2.getPrice() - (b2.getPrice() * b2.getDiscountRate()));
		
		System.out.println("책 제목 : " + b.getTitle());
		System.out.printf("책 가격 : %d원\n", discountPrice);
		System.out.println("책 제목 : " + b2.getTitle());
		System.out.printf("책 가격 : %d원\n", discountPrice2);
		System.out.println("-----------------------");
		// 책의 제목과 원래 가격, 할인 가격 같이 출력
		System.out.println("책 제목 : " + b.getTitle());
		System.out.println("할인 전 책 가격 : " + b.getPrice() + "원");
		System.out.printf("할인 후 책 가격 : %d원\n", discountPrice);
		System.out.println("책 제목 : " + b2.getTitle());
		System.out.println("할인 전 책 가격 : " + b2.getPrice() + "원");
		System.out.printf("할인 후 책 가격 : %d원", discountPrice2);
		

	}
}
