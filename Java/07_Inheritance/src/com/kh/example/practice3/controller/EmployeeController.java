package com.kh.example.practice3.controller;

import com.kh.example.practice3.model.Employee;

public class EmployeeController {
	private Employee employee = new Employee();
	
	public void add(int empNo, String name, char gender, String phone) {
		employee.setEmpNo(empNo);
		employee.setName(name);
		employee.setGender(gender);
		employee.setPhone(phone);
	}
	
	public void add(int empNo, String name, char gender, String phone, String dept, int salary, double bonus) {
		employee.setEmpNo(empNo);
		employee.setName(name);
		employee.setGender(gender);
		employee.setPhone(phone);
		employee.setDept(dept);
		employee.setSalary(salary);
		employee.setBonus(bonus);
	}
	
	public void modify(String phone) {
		employee.setPhone(phone);
	}
	
	public void modify(int salary) {
		employee.setSalary(salary);
	}
		
	public void modify(double bonus) {
		employee.setBonus(bonus);
	}
	
	// Employee에 toString으로 정의를 해 둬서 employee 그대로 넘기기만 하면됨
	public Employee info() {
		return employee;
	}
	
}