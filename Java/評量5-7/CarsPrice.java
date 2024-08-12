package com.cathaybk.practice.nt50332.b;

import java.io.File;
import java.math.BigDecimal;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CarsPrice {

	public static void main(String[] args) {

		// 找桌面存放的cars.csv路徑
		String userHome = System.getProperty("user.home");
		String desktopPath = Paths.get(userHome, "Desktop", "cars.csv").toString();

		// new 出一個可以排序的Treemap。以manufacturer 當k值，裝每筆car 的資料
		Map<String, List<Cars>> manufacturerCarsMap = new TreeMap<>();
		BigDecimal grandMinTotal = BigDecimal.ZERO;
		BigDecimal grandTotal = BigDecimal.ZERO;

		// 讀取csv
		try (Scanner sc = new Scanner(new File(desktopPath))) {
			// 跳過欄位名稱
			if (sc.hasNextLine()) {
				sc.nextLine();
			}
			// 讀取剩餘的資料行
			while (sc.hasNextLine()) {

				// 分割每一行數據
				String[] values = sc.nextLine().split(",");

				// values[i].trim(): 對應欄位的數據值
				String manufacturer = values[0].trim();
				String type = values[1].trim();
				BigDecimal minPrice = new BigDecimal(values[2].trim());
				BigDecimal price = new BigDecimal(values[3].trim());

				// 把剛剛讀到的數據裝到new 出的cars 裡面
				Cars cars = new Cars(manufacturer, type, minPrice, price);

				// 使用computeIfAbsent 方法，按照manufacturer 分成不同的arrarylist
				// 會先看這個 manufacturer 是否出現過，沒有就創新的arraylist 並塞值，有就把值返回再一起把值塞回去
				manufacturerCarsMap.computeIfAbsent(manufacturer, k -> new ArrayList<>()).add(cars);

				// 讀資料的同時去做合計的計算
				grandMinTotal = grandMinTotal.add(minPrice);
				grandTotal = grandTotal.add(price);
			}

			// 印欄位名稱 -20s 寬度10，左對齊
			System.out.printf("%-16s %-10s %-11s %-10s\n", "Manufacturer", "TYPE", "Min.PRICE", "Price");

			// 對manufacturerCarsMap ，取得manufacturer, arraylist 資訊
			for (Map.Entry<String, List<Cars>> entry : manufacturerCarsMap.entrySet()) {
				List<Cars> carsList = entry.getValue();

				BigDecimal totalMinManufacturer = BigDecimal.ZERO;
				BigDecimal totalManufacturer = BigDecimal.ZERO;
				
				// 對carsList ，取得每筆car 的資訊
				// %10.2f 寬度10，右對齊，小數點2位
				for (Cars cars1 : carsList) {
					System.out.printf("%-16s %-10s %8.1f %8.1f\n", cars1.getManufacturer(), cars1.getType(),
							cars1.getMinPrice(), cars1.getPrice());
					
					// 讀資料的同時去做小計的計算
					totalMinManufacturer = totalMinManufacturer.add(cars1.getMinPrice());
					totalManufacturer = totalManufacturer.add(cars1.getPrice());
				}

				System.out.printf("小計: %31.1f %8.1f\n", totalMinManufacturer.doubleValue(),
						totalManufacturer.doubleValue());
			}

			System.out.printf("合計: %31.1f %8.1f\n", grandMinTotal.doubleValue(), grandTotal.doubleValue());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

class Cars {
	private String manufacturer;
	private String type;
	private BigDecimal minPrice;
	private BigDecimal price;

	public Cars(String manufacturer, String type, BigDecimal minPrice, BigDecimal price) {
		this.manufacturer = manufacturer;
		this.type = type;
		this.minPrice = minPrice;
		this.price = price;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(BigDecimal minPrice) {
		this.minPrice = minPrice;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
