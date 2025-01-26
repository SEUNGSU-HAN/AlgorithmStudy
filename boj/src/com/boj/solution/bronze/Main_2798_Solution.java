package com.boj.solution.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2798_Solution {
	static int N, R=3, M;
	static int[] nums;
//	static int[] su;
	static int sum;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];
//		su = new int[R];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		sum = 1;
		combi(0, 0, 0);
		System.out.println(sum);

	}

	private static void combi(int cnt, int start, int tot) {
		if(tot > M) return; //pruning (가지치기)
		if(cnt == R) {
			if(tot <= M) {
				//M보다 작으면서 가장 큰 값
				sum = Math.max(tot, sum);
			}
			return;
		}
		for (int i = start; i < N; i++) {
//			su[cnt] = nums[i];
			combi(cnt+1, i+1, tot+nums[i]);
//			su[cnt] = 0;
		}
	}

}
