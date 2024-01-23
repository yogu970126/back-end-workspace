package com.kh.practice2.exception;

public class RecordNotFoundException extends Exception{

	public RecordNotFoundException() {
		this("회원 정보가 없에서 에러 발생!");
	}

	public RecordNotFoundException(String message) {
		super(message);
	}
	
	

}
