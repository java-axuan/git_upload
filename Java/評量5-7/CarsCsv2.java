package com.cathaybk.practice.nt50332.b;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class CarsCsv2 {

	public static void main(String[] args) {

		LinkedList<Map<String, String>> carsLinkedList = new LinkedList<>();

		// 找桌面存放的cars.csv路徑
		String userHome = System.getProperty("user.home");
		String desktopPath = Paths.get(userHome, "Desktop", "cars.csv").toString();
		String desktopPath2 = Paths.get(userHome, "Desktop", "cars2.csv").toString();

		// 讀取csv並把資料存到carsLinkedList
		try (Scanner sc = new Scanner(new File(desktopPath))) {

			String[] headers = null;

			// 讀取第一行欄位名稱
			if (sc.hasNextLine()) {
				// sc.nextLine() 讀取文件第一行
				// .split(",") 分割數據
				headers = sc.nextLine().split(",");

				// 去掉每個欄位名稱的前後空白字符
				for (int i = 0; i < headers.length; i++) {
					headers[i] = headers[i].trim();
				}
			}

			// 讀取剩餘的資料行
			while (sc.hasNextLine()) {

				// 分割每一行數據
				String[] values = sc.nextLine().split(",");
				// 建立Map 用來存取數據
				Map<String, String> carsMap = new HashMap<>();

				// 在Map 裡裝入資料
				for (int i = 0; i < headers.length; i++) {
					// values[i].trim(): 對應欄位的數據值
					carsMap.put(headers[i], values[i].trim());
				}

				// 把Map 裝進List
				carsLinkedList.add(carsMap);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// 對carsLinkedList 做排序，price 由大到小排序
		Collections.sort(carsLinkedList, new Comparator<Map<String, String>>() {
			@Override
			public int compare(Map<String, String> carMap1, Map<String, String> carMap2) {
				return carMap2.get("Price").compareTo(carMap1.get("Price"));
			}
		});

		// 打印確認
		// 用for each 迴圈把carsList 資料取出
		StringBuilder sb = new StringBuilder();
		for (Map<String, String> map : carsLinkedList) {
			BigDecimal price = new BigDecimal(map.get("Price"));
			sb.append("製造商：").append(map.get("Manufacturer")).append("，型號：").append(map.get("Type")).append("，底價：")
					.append(map.get("Min.Price")).append("，售價：").append(price);

			System.out.println(sb.toString());
			sb.setLength(0); // 壓縮sb變成0
		}

		// 寫入csv
		try (BufferedWriter bufferedWriter = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(desktopPath2), "UTF-8"))) {

			// 寫入欄位行稱
			bufferedWriter.write("Manufacturer" + "," + "TYPE" + "," + "Min.PRICE" + "," + "Price");
			bufferedWriter.newLine();

			// for each 迴圈對list 資料做bufferedWriter資料寫入
			for (Map<String, String> map : carsLinkedList) {

				bufferedWriter.write(map.get("Manufacturer") + "," + map.get("Type") + "," + map.get("Min.Price") + ","
						+ map.get("Price"));
				bufferedWriter.newLine();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
