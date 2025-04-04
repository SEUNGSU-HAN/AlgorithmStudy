package com.boj.problem.silver;
import java.io.*;

public class Main_11727 {
	static final int MOD = 10_007;
	static int N;
	static long[] dp;

	public static void main(String[] args) throws Exception{
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		
		/* 초기화 */
		dp = new long[N+1];
		dp[0] = dp[1] = 1;
		
		/* 로직 */
		for (int i = 2; i <= N; i++) {
			dp[i] = (dp[i-1]+dp[i-2]*2)%MOD;
		}
		
		/* 출력 */
		System.out.print(dp[N]);
	}

}
