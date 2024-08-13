package com.cathaybk.practice.nt50332.b;

public class MultiplicationTable {

	public static void main(String[] args) {

		for (int i = 1; i < 10; i++) {
			for (int j = 2; j < 10; j++) {
				System.out.printf("%d * %d = %2d ", i, j, i * j);
			}
			System.out.println();
		}
	}

}
