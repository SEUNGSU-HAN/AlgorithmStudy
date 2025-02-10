package com.boj.solution.gold;

import java.util.Scanner;

public class Main_1914 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //옮길 원판 수
		hanoi(N, 1, 2, 3);

	}
	
	private static void hanoi(int n, int from, int temp, int to) { //옮길 원판 수, 시작기둥, 임시기둥, 목적기둥
		if(n == 0) return;
		hanoi(n-1, from, to, temp);
		System.out.println(n+ " : " + from + "->" + to); //출력량이 많다. => 출력 최적화 할 것!!
		hanoi(n-1, temp, from, to);
	}

}
