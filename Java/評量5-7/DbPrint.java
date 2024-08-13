package com.cathaybk.practice.nt50332.b;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbPrint {

	private static final String CONN_URL = "jdbc:oracle:thin:@//localhost:1521/XE";

	private static final String USER_NAME = "student";

	private static final String PASSWORD = "student123456";

	public static void main(String[] args) {

		try (Connection conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement("select * from STUDENT.CARS");
				ResultSet rs = pstmt.executeQuery();) {

		
			List<Map<String, String>> carLinkedList = new ArrayList<>();
			StringBuilder sb = new StringBuilder();

			// 拿出我要的資料
			while (rs.next()) {
				Map<String, String> carMap = new HashMap<>();

				// carMap.put("寫死我要的東西", rs.getString("我要的欄位的值"));
				carMap.put("MANUFACTURER", rs.getString("MANUFACTURER"));
				carMap.put("TYPE", rs.getString("TYPE"));
				carMap.put("MIN_PRICE", rs.getString("MIN_PRICE"));
				carMap.put("PRICE", rs.getString("PRICE"));

				carLinkedList.add(carMap);
			}

			// 用for each 迴圈把carList 資料取出
			for (Map<String, String> map : carLinkedList) {
				BigDecimal price = new BigDecimal(map.get("PRICE"));
				sb.append("製造商：").append(map.get("MANUFACTURER")).append("，型號：").append(map.get("TYPE")).append("，售價：")
						.append(price).append("，底價：").append(map.get("MIN_PRICE"));

				System.out.println(sb.toString());
				sb.setLength(0); // 壓縮sb變成0
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
