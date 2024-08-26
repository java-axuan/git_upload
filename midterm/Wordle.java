package com.cathaybk.midterm;

import java.util.Scanner;

public class Wordle {

	public static void main(String[] args) {

		// 測試java可以玩遊戲
		Scanner scanner = new Scanner(System.in);

		String answer = "HAPPY";
		String myAnswer = scanner.next();

		char[] answerCharArr = answer.toCharArray();
		char[] myAnswerCharArr = myAnswer.toCharArray();

		System.out.println(myAnswer);
		System.out.println(answer);

		int i = 1;

		// 從我的答案依序抓字元去一一比對答案
		for (char charMyAnswer : myAnswerCharArr) {
			
			int j = 1;

			for (char charAnswer : answerCharArr) {
				if (charMyAnswer == charAnswer && i == j) {
					System.out.print("A");
					break;
				} else if (charMyAnswer == charAnswer) {
					System.out.print("B");
					break;
				}

				if (j == 5) {
					System.out.print("X");
				}
				j++;
			}
			i++;
		}

	}

}
