package com.cathaybk.practice.nt50332.b;

import java.util.Calendar;
import java.util.Scanner;

public class Calender {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		// 輸入月份
		System.out.print("輸入介於1-12間的整數m:");
		int month = scanner.nextInt();

		// Calendar.getInstance() 根據系統的默認時區創建 Calendar
		Calendar calendar = Calendar.getInstance();
		// calender從0月開始計算，因此要month-1，比如8月，要給的值=7
		calendar.set(2024, month - 1, 1);

		// 該月第一天是星期幾，從日計算
		// 日 1 | 一 2 | 二 3 | 三 4 | 四 5 | 五 6 | 六 7 
		int startDay = calendar.get(Calendar.DAY_OF_WEEK);
		// 該月份的總天數
		int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

		// 創sb 存 2024年 + month + 月
		StringBuilder sb = new StringBuilder();
		System.out.println(sb.append("      ").append("2024年").append(month).append("月"));
		// 印月曆的最上面 -- 星期幾 ==
		System.out.println("---------------------");
		System.out.println("日  一  二 三  四 五 六");
		System.out.println("=====================");

		// 第一天之前都先空格，空三格為一個單位
		for (int i = 1; i < startDay; i++) {
			System.out.print("   "); // 空三格
		}

		// 當day <= 月總天數，印出day，用%2d 自動補空格做對齊
		for (int day = 1; day <= daysInMonth; day++) {
			System.out.printf("%2d ", day);

			// 當day 指到(六)，換行
			if ((startDay + day - 1) % 7 == 0) {
				System.out.println();
			}
		}
		scanner.close();
	}
}
