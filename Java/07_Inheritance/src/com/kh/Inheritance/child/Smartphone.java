package com.kh.Inheritance.child;

import com.kh.Inheritance.parent.Product;

public class Smartphone extends Product{

	private String mobileAgency;

	public Smartphone() {}

	public Smartphone(String brand, String pCode, String name, int price, String mobileAgency) {
		super(brand, pCode, name, price);
		this.mobileAgency = mobileAgency;		
	}

	public String getMobileAgency() {
		return mobileAgency;
	}

	public void setMobileAgency(String mobileAgency) {
		this.mobileAgency = mobileAgency;
	}

	@Override
	public String toString() {
		return super.toString() + ", Smartphone [mobileAgency=" + mobileAgency + "]";
	}
	
	
}


