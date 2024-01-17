package com.kh.example.practice1.model;


public class Member {
	public String memberId;
	public String memberPwd;
	public String memberName;
	public int age;
	public char gender;
	public String phone;
	public String email;
	
	public void changeName(String name) {
		memberName = name;
	} // String으로 name을 받아서 memberName에 넣어줌
	
	public void printName() {
		System.out.println(memberName);
	} 
}
