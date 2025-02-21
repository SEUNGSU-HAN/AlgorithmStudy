package com.boj.problem.silver;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11051 {
	static int N, K;
	static int[][] dp;
	static final int MOD = 10_007;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		dp = new int[N+1][K+1];
		
		System.out.print(factorial(N, K));
	}

	private static int factorial(int n, int k) {
		if(dp[n][k] > 0) return dp[n][k];
		
		if(k == 0 || n == k) return 1;
		
		return dp[n][k] = (factorial(n-1, k-1)%MOD + factorial(n-1, k)%MOD)%MOD;
	}

}
