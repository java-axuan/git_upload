package com.cathaybk.practice.nt50332.b;

public class Sales extends Employee {

	private int performance;
	private int bouns;
	public int payment;

	public Sales(String name, String department, int salary, int performance) {

		super(name, department, salary);
		this.performance = performance;
		bouns = (int) (performance * 0.05);
		payment = salary + bouns;

	}

	@Override
	public void printInfo() {

		super.printInfo();
		System.out.println("月薪: " + getSalary());
		System.out.println("業績獎金: " + bouns);
		System.out.println("總計: " + payment);

	}

	public int getPerformance() {
		return performance;
	}

	public void setPerformance(int performance) {
		this.performance = performance;
	}

	public int getBouns() {
		return bouns;
	}

	public void setBouns(int bouns) {
		this.bouns = bouns;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}
}
