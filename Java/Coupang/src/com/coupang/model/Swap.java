package com.coupang.model;

import java.util.Date;

// 교환/반품
public class Swap {
	private int swapCode;
	private String reason;
	private Date swapDate;
	private int price;
	private String swapStatus;
	
	private Customer customer;
	private Product product;

}
