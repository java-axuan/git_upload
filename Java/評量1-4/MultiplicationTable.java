package com.cathaybk.practice.nt50332.b;

public class MultiplicationTable {

	public static void main(String[] args) {

		int product; // 乘積
		/*
		 * int multiplicand 被乘數 , int multiplier 乘數
		 */

		for (int multiplier = 1; multiplier < 10; multiplier++) {
			for (int multiplicand = 2; multiplicand < 10; multiplicand++) {
				product = multiplicand * multiplier;
				System.out.print(multiplicand + "*" + multiplier + "=");
				if (product < 10) {
					System.out.print(" " + product + " ");
				} else {
					System.out.print(product + " ");
				}
			}
			System.out.println();
		}
	}

}
