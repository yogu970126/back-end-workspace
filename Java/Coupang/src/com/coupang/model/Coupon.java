package com.coupang.model;

import java.util.Date;

// 쿠폰
public class Coupon {
	private int couponCode;
	private String couponName;
	private Date expiryDate;

	private Customer customer;
	private Product product;

}
