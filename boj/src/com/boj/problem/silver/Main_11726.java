package com.boj.problem.silver;
import java.util.Scanner;

public class Main_11726 {
	static int N;
	static long result;
	static long[] m;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		m = new long[N+1];
		result = 1;
		
		if(N >= 2) {
			result = fibo(N);
		}
		
		
		System.out.println(result);
	}

	private static long fibo(int n) {
		if(n == 1 || n == 0) return 1;
		if(m[n] != 0) return m[n];
		m[n] = fibo(n-1)+fibo(n-2);
		return m[n]%10007;
	}

}
