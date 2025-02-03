package com.boj.problem.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15953 {
	static int N;
	static int[][] rank;
	static int[] prize;

	public static void main(String[] args) throws Exception{
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		
		/* 초기화 */
		prize = new int[N];
		rank = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				rank[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		/* 로직 */
		for (int i = 0; i < N; i++) {
			//2017
			if( rank[i][0] != 0 && (0 < rank[i][0] && rank[i][0] < 2)) {
				prize[i] += 5000000;
			}else if (2 <= rank[i][0] && rank[i][0] < 4) {
				prize[i] += 3000000;
			}else if (4 <= rank[i][0] && rank[i][0] < 7) {
				prize[i] += 2000000;
			}else if (7 <= rank[i][0] && rank[i][0] < 11) {
				prize[i] += 500000;
			}else if (11 <= rank[i][0] && rank[i][0] < 16) {
				prize[i] += 300000;
			}else if (16 <= rank[i][0] && rank[i][0] < 22) {
				prize[i] += 100000;
			}
			//2018
			if(rank[i][1] != 0 && (0 < rank[i][1] && rank[i][1] < 2)) {
				prize[i] += 5120000;
			}else if (2 <= rank[i][1] && rank[i][1] < 4) {
				prize[i] += 2560000;
			}else if (4 <= rank[i][1] && rank[i][1] < 8) {
				prize[i] += 1280000;
			}else if (8 <= rank[i][1] && rank[i][1] < 16) {
				prize[i] += 640000;
			}else if (16 <= rank[i][1] && rank[i][1] < 32) {
				prize[i] += 320000;
			}
			
			sb.append(prize[i] + "\n");
		}
		
		/* 출력 */
		System.out.println(sb.toString());
	}

}
