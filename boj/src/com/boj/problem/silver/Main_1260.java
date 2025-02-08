package com.boj.problem.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
//import java.util.ArrayList;
//import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

//DFS와 BFS
//ArrayList -> 고정 배열로 개선 (N이 커봐야 1000이라 가능)
//인접 행렬
public class Main_1260 {
	static int N, M, V;
//	static ArrayList<Integer>[] board;
	static int[][] board;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception{
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		/* 초기화 */
//		board = new ArrayList[N+1];
//		for (int i = 0; i <= N; i++) {
//			board[i] = new ArrayList<Integer>();
//		}
		board = new int[N+1][N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
//			board[s].add(d);
//			board[d].add(s);
			board[s][d] = board[d][s] = 1;
		}
		visited = new boolean[N+1];
		
		/* 로직+출력 */
//		for (int i = 1; i <= N; i++) {
//			Collections.sort(board[i]);
//		}
		
		dfs(V, sb);
		System.out.println(sb.toString());
		visited = new boolean[N+1];
		sb.setLength(0);
		bfs(V, sb);
	}

	private static void bfs(int d, StringBuilder sb) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(d);
		visited[d] = true;
		while(!q.isEmpty()) {
			int n = q.poll();
			sb.append(n + " ");
//			for (int i = 0; i < board[n].size(); i++) {
//				if(visited[board[n].get(i)])continue;
//				q.offer(board[n].get(i));
//				visited[board[n].get(i)] = true;
//			}
			for (int i = 0; i < board.length; i++) {
				if(!visited[i] && board[n][i] == 1) {
					visited[i] = true;
					q.offer(i);
				}
			}
		}
		System.out.println(sb.toString());
		
	}

	private static void dfs(int depth, StringBuilder sb) {
//		if(visited[depth]) return;
		
		visited[depth] = true;
		sb.append(depth + " ");
		
//		for (int i = 0; i < board[depth].size(); i++) {
//			dfs(board[depth].get(i), sb);
//		}
		for (int i = 0; i < board.length; i++) {
			if(!visited[i] && board[depth][i] == 1) dfs(i, sb);
		}
	}

}
