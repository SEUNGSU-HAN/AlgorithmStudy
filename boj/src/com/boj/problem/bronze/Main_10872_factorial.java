package com.boj.problem.bronze;
import java.io.*;

public class Main_10872_factorial {
	static int N;
	static int[] dp;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		dp = new int[N+1];
		System.out.println(N == 0 ? 1 : factorial(N));
	}

	static int factorial(int n) {
		if(n <= 1) return dp[n] = 1;
		if(dp[n] == 0) return dp[n] = n*factorial(n-1);
		else return dp[n];
	}

}
