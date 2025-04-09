package com.boj.problem.gold;
import java.io.*;
import java.util.*;

public class Main_2458_re {
	static final long INF = (500*(500-1)/2)*500+1;
	static int N, M, count;
	static long[][] graph;

	public static void main(String[] args) throws Exception{
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		/* 초기화 */
		graph = new long[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(graph[i], INF);
			graph[i][i] = 0;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken())-1;
			int e = Integer.parseInt(st.nextToken())-1;
			graph[s][e] = 1;
		}
		
		/* 로직 */
		//플로이드 워샬
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			int check = 0;
			for (int j = 0; j < N; j++) {
				if(graph[i][j] != INF || graph[j][i] != INF) check++;;
			}
			if(check == N) count++;
		}
		
		/* 출력 */
		System.out.println(count);
	}

}
