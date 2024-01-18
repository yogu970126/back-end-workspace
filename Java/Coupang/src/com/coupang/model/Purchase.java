package com.coupang.model;

import java.util.Date;

// 구매 내역
public class Purchase {
	private int purCode;
	private Date purDate;
	private String purStatus;
	
	private Customer customer;
	private Product product;

}
