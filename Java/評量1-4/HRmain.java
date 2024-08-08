package com.cathaybk.practice.nt50332.b;

import java.util.ArrayList;
import java.util.List;

public class HRmain {

	public static void main(String[] args) {
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Sales("張志誠", "信用卡部", 35000, 6000));
		employeeList.add(new Sales("林大鈞", "保代部", 38000, 4000));
		employeeList.add(new Supervisor("李中白", "資訊部", 65000));
		employeeList.add(new Supervisor("林小中", "理財部", 80000));
		for(Employee employee : employeeList) {
			employee.printInfo();
		}
	}

}
