package com.cathaybk.morepractice.nt50332.b;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Db {
	private static final String SELECT_CARS_SQL = "select * from STUDENT.CARS where MANUFACTURER = ? and TYPE = ?";

	private static final String INSERT_CARS_SQL = "insert into STUDENT.CARS (MANUFACTURER, TYPE, MIN_PRICE, PRICE) values (?, ?, ?, ?)";

	private static final String UPDATE1_CARS_SQL = "update STUDENT.CARS set MIN_PRICE = ? where MANUFACTURER = ? and TYPE = ?";

	private static final String UPDATE2_CARS_SQL = "update STUDENT.CARS set PRICE = ? where MANUFACTURER = ? and TYPE = ?";

	private static final String UPDATE3_CARS_SQL = "update STUDENT.CARS set MIN_PRICE = ?, PRICE = ? where MANUFACTURER = ? and TYPE = ?";

	private static final String DELETE_CARS_SQL = "delete from STUDENT.CARS where MANUFACTURER = ? and TYPE = ?";

	private static final String CONN_URL = "jdbc:oracle:thin:@//localhost:1521/XE";

	private static final String USER_NAME = "student";

	private static final String PASSWORD = "student123456";

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {
			// 輸入指令
			System.out.println("請選擇以下指令輸入:select、insert、update、delete");
			String toDo = scanner.next();

			// 依照指令做事
			switch (toDo) {
			case "select": {
				System.out.println("請輸入製造商:");
				String manufacturer = scanner.next();
				System.out.println("請輸入類型:");
				String type = scanner.next();

				doQuery(manufacturer, type);
				break;
			}
			case "insert": {
				// 輸入資訊準備確認是否有這筆資料
				System.out.println("請根據指示輸入資訊，我們先為您查詢資料庫是否已有這筆資料");
				System.out.println("請輸入製造商:");
				String manufacturer = scanner.next();
				System.out.println("請輸入類型:");
				String type = scanner.next();

				// doQuery 會回傳的Map<String, String> 放 = 的左邊，然後定義一個map 變數去接這個Map<String, String>
				Map<String, String> map = doQuery(manufacturer, type);

				// 確認是否有資料
				if (!map.isEmpty()) {
					System.out.println("資料庫已有這筆資料");
					return;
				} else {
					System.out.println("請根據指示輸入要新增的車子資訊");
				}

				// 輸入insert資訊
				System.out.println("請輸入新增的車子底價:");
				String minPrice1 = scanner.next();
				System.out.println("請輸入新增的車子售價:");
				String price1 = scanner.next();

				doInsert(manufacturer, type, minPrice1, price1);
				break;
			}
			case "update": {
				// 輸入資訊準備確認是否有這筆資料
				System.out.println("請根據指示輸入資訊，我們先為您查詢資料庫是否已有這筆資料");
				System.out.println("請輸入製造商:");
				String manufacturer = scanner.next();
				System.out.println("請輸入類型:");
				String type = scanner.next();

				// doQuery 會回傳的Map<String, String> 放 = 的左邊，然後定義一個map 變數去接這個Map<String, String>
				Map<String, String> map = doQuery(manufacturer, type);

				// 確認是否有資料
				if (!map.isEmpty()) {
					System.out.println();
					System.out.println("您要更新何種資訊? 請回答1、2、3");
				} else {
					return;
				}

				// 輸入update資訊
				System.out.println("1:底價，2:售價，3:底價及售價");
				String update = scanner.next();
				String newMinPrice = null;
				String newPrice = null;
				String updateSQL = null;
				switch (update) {
				case "1": {
					updateSQL = UPDATE1_CARS_SQL;
					System.out.println("請輸入更新後的底價:");
					newMinPrice = scanner.next();
					break;
				}
				case "2": {
					updateSQL = UPDATE2_CARS_SQL;
					System.out.println("請輸入更新後的售價:");
					newPrice = scanner.next();
					break;
				}
				case "3": {
					updateSQL = UPDATE3_CARS_SQL;
					System.out.println("請輸入更新後的底價:");
					newMinPrice = scanner.next();
					System.out.println("請輸入更新後的售價:");
					newPrice = scanner.next();
					break;
				}
				default:
					System.out.println("請重新執行，並確認輸入的指令為1、2、3。");
				}

				doUpdate(update, updateSQL, manufacturer, type, newMinPrice, newPrice);
				break;
			}
			case "delete": {
				// 輸入資訊準備確認是否有這筆資料
				System.out.println("請根據指示輸入資訊，我們先為您查詢資料庫是否已有這筆資料");
				System.out.println("請輸入製造商:");
				String manufacturer = scanner.next();
				System.out.println("請輸入類型:");
				String type = scanner.next();

				// doQuery 會回傳的Map<String, String> 放 = 的左邊，然後定義一個map 變數去接這個Map<String, String>
				Map<String, String> map = doQuery(manufacturer, type);

				// 確認是否有資料
				if (map.isEmpty()) {
					return;
				}

				doDelete(manufacturer, type);
				break;
			}
			default:
				System.out.print("您輸入的指令無效");
			}
		}
	}

	// 回傳Map<String, String>
	private static Map<String, String> doQuery(String manufacturer, String type) {

		ResultSet rs = null;
		Map<String, String> map = new HashMap<>();

		try (Connection conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(SELECT_CARS_SQL);) {

			pstmt.setString(1, manufacturer);
			pstmt.setString(2, type);
			rs = pstmt.executeQuery();

			if (!rs.next()) {
				System.out.println("資料庫沒有這筆資料");
				return map;
			}
			map.put("MANUFACTURER", rs.getString("MANUFACTURER"));
			map.put("TYPE", rs.getString("TYPE"));
			map.put("MIN_PRICE", rs.getString("MIN_PRICE"));
			map.put("PRICE", rs.getString("PRICE"));

			// Map存好了，我把字串加好印出來，先建立sb
			StringBuilder sb = new StringBuilder();

			// .append(" ") 寫死的
			// .append(map.get("欄位名稱")) 把map裡面的東西拿出來
			BigDecimal price = new BigDecimal(map.get("PRICE"));
			sb.append("製造商：").append(map.get("MANUFACTURER")).append("，型號：").append(map.get("TYPE")).append("，底價：")
					.append(map.get("MIN_PRICE")).append("，售價：").append(price);

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
		return map;
	}

	private static void doInsert(String manufacturer, String type, String minPrice1, String price1) {
		// 1. 取得連線
		// 2. 寫入 SQL 指令
		try (Connection conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT_CARS_SQL);) {
			// try 兩層讓catch 後的rollback 抓的到conn
			try {
				conn.setAutoCommit(false);

				pstmt.setString(1, manufacturer);
				pstmt.setString(2, type);
				pstmt.setString(3, minPrice1);
				pstmt.setString(4, price1);

				pstmt.executeUpdate(); // 3. 執行 SQL（上一步寫入的）指令
				conn.commit();
				System.out.println("新增成功");
			} catch (Exception e) {
				if (conn != null) {
					conn.rollback();
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void doUpdate(String update, String updateSQL, String manufacturer, String type, String newMinPrice,
			String newPrice) {
		try (Connection conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(updateSQL);) {
			try {
				conn.setAutoCommit(false);

				switch (updateSQL) {
				case "update STUDENT.CARS set MIN_PRICE = ? where MANUFACTURER = ? and TYPE = ?": {
					pstmt.setString(1, newMinPrice);
					pstmt.setString(2, manufacturer);
					pstmt.setString(3, type);
					break;
				}
				case "update STUDENT.CARS set PRICE = ? where MANUFACTURER = ? and TYPE = ?": {
					pstmt.setString(1, newPrice);
					pstmt.setString(2, manufacturer);
					pstmt.setString(3, type);
					break;
				}
				case "update STUDENT.CARS set MIN_PRICE = ?, PRICE = ? where MANUFACTURER = ? and TYPE = ?": {
					pstmt.setString(1, newMinPrice);
					pstmt.setString(2, newPrice);
					pstmt.setString(3, manufacturer);
					pstmt.setString(4, type);
					break;
				}
				}
				pstmt.executeUpdate();
				conn.commit();
				System.out.println("更新成功");
			} catch (Exception e) {
				if (conn != null) {
					conn.rollback();
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void doDelete(String manufacturer, String type) {
		try (Connection conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(DELETE_CARS_SQL);) {
			try {
				conn.setAutoCommit(false);
				pstmt.setString(1, manufacturer);
				pstmt.setString(2, type);

				pstmt.executeUpdate();
				conn.commit();
				System.out.println("刪除成功");
			} catch (Exception e) {
				if (conn != null) {
					conn.rollback();
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
