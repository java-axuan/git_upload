package com.cathaybk.practice.nt50332.b;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Db {
	public static final String SELECT_CARS_SQL = "select * from STUDENT.CARS where MANUFACTURER = ? and TYPE = ?";

	public static final String INSERT_CARS_SQL = "insert into STUDENT.CARS (MANUFACTURER, TYPE, MIN_PRICE, PRICE) values (?, ?, ?, ?)";

	public static final String UPDATE_CARS_SQL = "update STUDENT.CARS set MIN_PRICE = ?, PRICE = ? where MANUFACTURER = ? and TYPE = ?";

	public static final String DELETE_CARS_SQL = "delete from STUDENT.CARS where MANUFACTURER = ? and TYPE = ?";

	public static final String CONN_URL = "jdbc:oracle:thin:@//localhost:1521/XE";

	public static final String USER_NAME = "student";

	public static final String PASSWORD = "student123456";

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		// 輸入指令
		System.out.println("請選擇以下指令輸入:select、insert、update、delete");
		String toDo = scanner.next();

		// 依照指令做事
		if (toDo.equals("select")) {
			doQuery();
		} else if (toDo.equals("insert")) {
			doInsert();
		} else if (toDo.equals("update")) {
			doUpdate();
		} else if (toDo.equals("delete")) {
			doDelete();
		} else {
			System.out.print("您輸入的指令無效");
		}

		scanner.close();
	}

	// Select ok
	private static void doQuery() {
		
		ResultSet rs = null;
		
		try (Connection conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(SELECT_CARS_SQL);
				Scanner scanner = new Scanner(System.in);) {

			// 輸入資訊
			System.out.println("請輸入製造商:");
			String manufacturer = scanner.next();
			pstmt.setString(1, manufacturer);
			System.out.println("請輸入類型:");
			String type = scanner.next();
			pstmt.setString(2, type);

			// ResultSet物件儲存查詢結果
			rs = pstmt.executeQuery();

			Map<String, String> map = new HashMap<>();

			// 拿出我要的資料
			while (rs.next()) {
				// map.put(欄位名稱，我要的值) 把值推進去
				// rs.getString() 我要拿的欄位
				map.put("MANUFACTURER", rs.getString("MANUFACTURER"));
				map.put("TYPE", rs.getString("TYPE"));
				map.put("MIN_PRICE", rs.getString("MIN_PRICE"));
				map.put("PRICE", rs.getString("PRICE"));
			}

			// Map存好了，我把字串加好印出來，先建立sb
			StringBuilder sb = new StringBuilder();

			// .append(" ") 寫死的
			// .append(map.get("欄位名稱")) 把map裡面的東西拿出來
			if (!map.isEmpty()) {
				BigDecimal price = new BigDecimal(map.get("PRICE"));
				sb.append("製造商：").append(map.get("MANUFACTURER")).append("，型號：").append(map.get("TYPE")).append("，底價：")
						.append(map.get("MIN_PRICE")).append("，售價：").append(price);
			} else {
				sb.append("查無結果");
			}
			// 轉成String型別 打印
			System.out.println(sb.toString());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// Insert ok
	private static void doInsert() {
		// 1. 取得連線
		// 2. 寫入 SQL 指令
		try (Connection conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT_CARS_SQL);
				Scanner scanner = new Scanner(System.in);) {

			// 輸入資訊
			System.out.println("請輸入製造商:");
			String manufacturer = scanner.next();
			pstmt.setString(1, manufacturer);
			System.out.println("請輸入類型:");
			String type = scanner.next();
			pstmt.setString(2, type);
			System.out.println("請輸入底價:");
			String minPrice = scanner.next();
			pstmt.setString(3, minPrice);
			System.out.println("請輸入售價:");
			String price = scanner.next();
			pstmt.setString(4, price);

			pstmt.executeUpdate(); // 3. 執行 SQL（上一步寫入的）指令
			System.out.println("新增成功");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Update ok
	private static void doUpdate() {
		try (Connection conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(UPDATE_CARS_SQL);
				Scanner scanner = new Scanner(System.in);) {

			// 輸入資訊
			System.out.println("請輸入製造商:");
			String manufacturer = scanner.next();
			pstmt.setString(3, manufacturer);
			System.out.println("請輸入類型:");
			String type = scanner.next();
			pstmt.setString(4, type);

			// 輸入update資訊
			System.out.println("請輸入更新後的底價:");
			String newMinPrice = scanner.next();
			pstmt.setString(1, newMinPrice);
			System.out.println("請輸入更新後的售價:");
			String newPrice = scanner.next();
			pstmt.setString(2, newPrice);

			pstmt.executeUpdate(); // 3. 執行 SQL（上一步寫入的）指令
			System.out.println("更新成功");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Delete ok
	private static void doDelete() {
		try (Connection conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(DELETE_CARS_SQL);
				Scanner scanner = new Scanner(System.in);) {

			// 輸入資訊
			System.out.println("請輸入製造商:");
			String manufacturer = scanner.next();
			pstmt.setString(1, manufacturer);
			System.out.println("請輸入類型:");
			String type = scanner.next();
			pstmt.setString(2, type);

			pstmt.executeUpdate(); // 3. 執行 SQL（上一步寫入的）指令
			System.out.println("刪除成功");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
