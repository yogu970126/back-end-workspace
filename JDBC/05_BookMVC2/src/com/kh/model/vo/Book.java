package com.kh.model.vo;

// VO (Value Object) : 한개 또는 그 이상의 속성들을 묶어서 특정 값을 나타내는 객체

public class Book {
	private int bkNo;
	private String bkTitle;
	private String bkAuthor;
	private int bkPrice;
	private Publisher Publisher;
	
	public Book() {
	}

	public Book(int bkNo, String bkTitle, String bkAuthor, int bkPrice, com.kh.model.vo.Publisher publisher) {
		this.bkNo = bkNo;
		this.bkTitle = bkTitle;
		this.bkAuthor = bkAuthor;
		this.bkPrice = bkPrice;
		Publisher = publisher;
	}

	public Book(String bkTitle, String bkAuthor) {
		this.bkTitle = bkTitle;
		this.bkAuthor = bkAuthor;
	}

	public int getBkNo() {
		return bkNo;
	}

	public void setBkNo(int bkNo) {
		this.bkNo = bkNo;
	}

	public String getBkTitle() {
		return bkTitle;
	}

	public void setBkTitle(String bkTitle) {
		this.bkTitle = bkTitle;
	}

	public String getBkAuthor() {
		return bkAuthor;
	}

	public void setBkAuthor(String bkAuthor) {
		this.bkAuthor = bkAuthor;
	}

	public int getBkPrice() {
		return bkPrice;
	}

	public void setBkPrice(int bkPrice) {
		this.bkPrice = bkPrice;
	}

	public Publisher getPublisher() {
		return Publisher;
	}

	public void setPublisher(Publisher publisher) {
		Publisher = publisher;
	}

	@Override
	public String toString() {
		return "책 번호 : " + bkNo + " | 책 제목 : " + bkTitle + " | 책 저자 : " + bkAuthor + " | 책 가격 : " + bkPrice
				+ " | 퍼블리셔 : " + Publisher.getPubName();
	}

	
	
}
