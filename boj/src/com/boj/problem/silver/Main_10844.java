package com.boj.problem.silver;
import java.io.*;

public class Main_10844 {
	static final long MOD = 1_000_000_000;
	static int N;
	static long result;
	static long[][] dp;
	public static void main(String[] args) throws Exception{
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		
		/* 초기화 */
		dp = new long[N+1][10];
		for (int i = 0; i < 10; i++) {
			dp[1][i] = 1;
		}
		
		/* 로직 */
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				if(j == 0) dp[i][j] = dp[i-1][1];
				else if(j == 9) dp[i][j] = dp[i-1][8];
				else {
					dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1])%MOD;
				}
			}
		}
		for (int i = 1; i < 10; i++) {
			result = (result + dp[N][i])%MOD;
		}
		
		/* 출력 */
		System.out.print(result);
	}

}
