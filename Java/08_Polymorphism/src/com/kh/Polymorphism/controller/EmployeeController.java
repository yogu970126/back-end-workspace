package com.kh.Polymorphism.controller;

import com.kh.Polymorphism.model.child.Engineer;
import com.kh.Polymorphism.model.parent.Employee;

public class EmployeeController {
	
	// 이름으로 사람 찾기
	
	public Employee findEmployeeByName(String name, Employee[] empArr) {
		for(Employee employee : empArr) {
			if(employee.getName().equals(name)) {
				return employee; // 찾은 직원 리턴
			}
		}
		return null; // 조건값에 해당하지 않으면 null 리턴
	}
	
	// 찾은 사람의 연봉은?
	public int getAnnualSalary(Employee result) {
		int annualSalary = result.getSalary() * 12;
		if(result instanceof Engineer) {
			Engineer engineer = (Engineer) result; // 부모 -> 자식 : 강제 형 변환!
			return annualSalary + engineer.getBonus();
		}
		return annualSalary;
	}
	
	// 전체 사람들의 연봉 총합은?
	public int getTotalSalary(Employee[] empArr) {
			int sum = 0;
			for(Employee employee : empArr) {
				sum += getAnnualSalary(employee);
			}	
		return sum;
	}

}
