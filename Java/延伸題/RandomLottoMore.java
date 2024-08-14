package com.cathaybk.morepractice.nt50332.b;

import java.util.Random;

public class RandomLotto {

	public static void main(String[] args) {

		int[] num = new int[6];
		Random rand = new Random();

		// 隨機產生6個不重複介於1~49的數字
		for (int i = 0; i < 6; i++) {
			num[i] = rand.nextInt(49) + 1;
		}

		System.out.print("排序前:");

		// 把num的值取出並列印
		for (int numbers : num) {
			System.out.print(numbers + " ");
		}

		System.out.println();

		// 比較方法，降冪排序
		// 做5輪的比較，第1輪比5次，把最小的放到最後面，第2輪比4次
		for (int i = 0; i < num.length - 1; i++) {
			for (int j = 0; j < num.length -1 - i; j++) {
				// 做交換，把最小的放到最後面
				if (num[j] < num[j + 1]) {
					int temp = num[j];
					num[j] = num[j + 1];
					num[j + 1] = temp;
				}
			}
		}

		System.out.print("排序後:");

		// 把treeSet的值取出並列印
		for (int numbers1 : num) {
			System.out.print(numbers1 + " ");
		}
	}
}
