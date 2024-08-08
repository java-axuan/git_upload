package com.cathaybk.practice.nt50332.b;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class RandomLotto {

	public static void main(String[] args) {

		Random rand = new Random();
		Set<Integer> hashSet = new HashSet<Integer>();
		Set<Integer> treeSet = new TreeSet<Integer>();

		// 隨機產生6個不重複介於1~49的數字
		while (hashSet.size() < 6) {
			hashSet.add(rand.nextInt(49) + 1);
		}
		
		System.out.print("排序前:");
		
		//把hashSet的值取出並列印
		for (int rand1 : hashSet) {
			System.out.print(rand1 + " ");
		}

		System.out.println();

		// 把hashSet的值全部裝到treeSet，讓它自然排序
		treeSet.addAll(hashSet);
		
		System.out.print("排序後:");
		
		//把treeSet的值取出並列印
		for (int rand2 : treeSet) {
			System.out.print(rand2 + " ");
		}
	}
}
