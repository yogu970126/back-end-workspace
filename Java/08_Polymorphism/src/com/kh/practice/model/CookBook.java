package com.kh.practice.model;

public class CookBook extends Book{
	
	private boolean coupon; // 요리 쿠폰 유무

	@Override
	public String toString() {
		return super.toString() + "CookBook [coupon=" + coupon + "]";
	}

	

}
