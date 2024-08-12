package com.cathaybk.practice.nt50332.b;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HRmainBufferWriter {

	public static void main(String[] args) {
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Sales("張志誠", "信用卡部", 35000, 6000));
		employeeList.add(new Sales("林大鈞", "保代部", 38000, 4000));
		employeeList.add(new Supervisor("李中白", "資訊部", 65000));
		employeeList.add(new Supervisor("林小中", "理財部", 80000));

		// 對employeeList 做排序
		Collections.sort(employeeList, new Comparator<Employee>() {
			@Override
			public int compare(Employee a, Employee b) {
				return b.getDepartment().compareTo(a.getDepartment());
			}
		});

		// 找桌面路徑
		String userHome = System.getProperty("user.home");
		String desktopPath = Paths.get(userHome, "Desktop", "output.csv").toString();

		// 寫入csv
		try (BufferedWriter bufferedWriter = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(desktopPath), "UTF-8"))) {

			// 寫入員工的資料
			for (Employee employee : employeeList) {
				
				StringBuilder sb1 = new StringBuilder();
				Supervisor supervisor1 = (Supervisor)employee;
//				sb1.append(employee.getName()).append(",").append(supervisor1.getPayment());
				sb1.append(employee.getName()).append(",").append(((Supervisor) employee).getPayment());
				
				String supervisor = sb1.toString();
				
//				StringBuilder sb2 = new StringBuilder();
//				sb2.append(employee.getName()).append(",").append(((Sales) employee));
//				String sales = sb2.toString();
			
				
				// 判斷employee 是sales 還是supervisor
				// 寫入員工的name,salary
				if (employee instanceof Supervisor) {
					bufferedWriter.write(supervisor);
					bufferedWriter.newLine();
					;
				} 
//				else {
//					bufferedWriter.write(sales);
//					bufferedWriter.newLine();
//				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
