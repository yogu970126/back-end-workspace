package com.kh.model;

public class Book {
	private int bkNo;
	private String bkTitle;
	private String bkAuthor;
	private int bkPrice;
	private int bkPubNo;
	
	public Book() {}

	public Book(int bkNo, String bkTitle, String bkAuthor, int bkPrice, int bkPubNo) {
		this.bkNo = bkNo;
		this.bkTitle = bkTitle;
		this.bkAuthor = bkAuthor;
		this.bkPrice = bkPrice;
		this.bkPubNo = bkPubNo;
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

	public int getBkPubNo() {
		return bkPubNo;
	}

	public void setBkPubNo(int bkPubNo) {
		this.bkPubNo = bkPubNo;
	}

	@Override
	public String toString() {
		return "책 번호 : " + bkNo + " / 제목 : " + bkTitle + " / 저자 : " + bkAuthor + " / 가격 : " + bkPrice + " / 퍼블리셔 번호 : " + bkPubNo;
	}

	
}
