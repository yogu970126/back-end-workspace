package com.kh.array.practice2.controller;

import java.util.Arrays;

import com.kh.array.practice2.model.Member;

public class MemberController {
	
	private Member[] mArr = new Member[3];
	public int count = 0;
	
	// 멤버 추가
	public void insertMember(Member m) {
		mArr[count++] = new Member(m.getId(), m.getName(), m.getPassword(), m.getEmail(), m.getGender(), m.getAge()); // 임시 객체 입력값들을 get으로 받아옴
	//	System.out.println(Arrays.toString(mArr));
	}
	
	// 멤버 index를 아이디로 조회
	public int checkId(String id) {
		for(int i = 0; i<mArr.length; i++) {
			if(mArr[i] != null && mArr[i].getId().equals(id)) {
				return i;
			}
		}
		return -1;
	}
	
	// 멤버 수정
	public void updateMember(String id, String name, String email, String password) {
		int index = checkId(id);
		mArr[index].setName(name);
		mArr[index].setEmail(email);
		mArr[index].setPassword(password);
	}
	
	// 멤버 조회
	public Member[] printAll() {
		return mArr;
	}
	

}










