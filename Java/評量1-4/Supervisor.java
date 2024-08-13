package com.cathaybk.practice.nt50332.b;

public class Supervisor extends Employee {

	public int payment;

	public Supervisor(String name, String department, int salary) {
		super(name, department, salary);
		payment = salary;
	}

	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println("月薪: " + payment);
		System.out.println("總計: " + payment);
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

}
