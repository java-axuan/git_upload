package com.cathaybk.morepractice.nt50332.b;


public class Diamond {

	public static void main(String[] args) {
		for (int i = 1; i < 6; i++) {
			if (i < 6) {
				for (int a = 0; a < 5 - i; a++) {
					System.out.print(" ");
				}
				// 印*
				for (int b = 0; b < i + i - 1; b++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}

		for (int i = 4; i >= 1; i--) {
			// 印空白
			for (int a = 4; a >= i; a--) {
				System.out.print(" ");
			}
			// 印*
			for (int b = 1; b <= 2 * i - 1; b++) {
				System.out.print("*");
			}
			System.out.println();

		}
	}

}
