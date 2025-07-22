package com.boj.problem.silver;
import java.io.*;
import java.util.*;

public class Main_11659 {
	static int N, M;
	static int[] nums, dp;

	public static void main(String[] args) throws Exception{
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		/* 초기화 */
		nums = new int[N+1];
		dp = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			dp[i] = nums[i] + dp[i-1];
		}
		
		/* 로직 */
		StringBuilder sb = new StringBuilder();
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			sb.append(i == j ? nums[j] : dp[j]-dp[i-1]).append("\n");
		}
		
		
		/* 출력 */
		System.out.println(sb.toString());

	}

}
