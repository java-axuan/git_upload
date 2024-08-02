package com.cathaybk1;

public class Triangle {

	public static void main(String[] args) {
		int size = 10;
		for (int j = 1; j <= size; j++) { //橫列
			for (int i = 1; i <= j; i++) { //直行
				System.out.print("*");
			}
			System.out.println();
		}
	}

}



