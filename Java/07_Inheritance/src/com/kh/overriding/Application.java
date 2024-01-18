package com.kh.overriding;

import com.kh.overriding.model.Customer;
import com.kh.overriding.model.VIPCustomer;

public class Application {

	public static void main(String[] args) {
		
		Customer customer1 = new Customer("이상현");
		Customer customer2 = new Customer("이상현");
		
		System.out.println(customer1);
		System.out.println(customer2);
		
		System.out.println(customer1 == customer2);
		System.out.println(customer1.equals(customer2)); // true
		
		System.out.println();
		
		VIPCustomer customer3 = new VIPCustomer("정세영");
		VIPCustomer customer4 = new VIPCustomer("정회영");
		
		System.out.println(customer3.equals(customer4)); // 상속받아서 true
		
		// customer1 또는 customer2
		// customer3 또는 customer4
		// ~~님의 등급은 ~~이며, 지불해야 하는 금액은 ~원이며, 적립된 포인트는 ~~점입니다.
		
		
//		System.out.println(customer1.getName() + " 님의 등급은 " + customer1.getGrade() 
//							+ "이며, 지불해야 하는 금액은 " + customer1.calcPrice(30000) 
//							+ "원 이며, 적립된 포인트는 " + customer1.getBonusPoint() + "점 입니다.");
		
		System.out.printf("%s님의 등급은 %s이며, 지불해야 하는 금액은 %d원이며, 적립된 포인트는 %d점입니다\n",
							customer1.getName(), customer1.getGrade(), customer1.calcPrice(1000), customer1.getBonusPoint());
		
		System.out.printf("%s님의 등급은 %s이며, 지불해야 하는 금액은 %d원이며, 적립된 포인트는 %d점입니다",
				customer4.getName(), customer4.getGrade(), customer4.calcPrice(1000), customer4.getBonusPoint());

	}

}
