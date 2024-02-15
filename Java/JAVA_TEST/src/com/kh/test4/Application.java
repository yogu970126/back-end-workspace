package com.kh.test4;

import com.kh.test4.model.Person;

public class Application {

	public static void main(String[] args) {
		Person[] pArr = new Person[3];
		
		pArr[0] = new Person("이상현");
		pArr[1] = new Person("박건우");
		pArr[2] = new Person("조근철");
		
		for(int i=0; i <pArr.length; i++) {
			System.out.println(pArr[i].getName());
		}
	}

}
