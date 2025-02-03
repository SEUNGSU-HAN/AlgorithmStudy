package com.boj.solution.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178_Solution {
	static int N, M;
	static int[][] map;
	static int[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = c[j]-'0';
			}
		}
		
		bfs();
	}

	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0,0}); //큐 넣기
		visited[0][0] = 1; //시작 방문 표시
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			if(r == N-1 && c == M-1) break;
			
			for (int i = 0; i < 4; i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				if(!isValid(nr, nc)) continue;
				if(map[nr][nc] == 1 && visited[nr][nc] == 0) {
					q.offer(new int[] {nr, nc});
					visited[nr][nc] = visited[r][c]+1;
				}
			}
		}
		System.out.println(visited[N-1][M-1]);
	}
	
	private static boolean isValid(int r, int c) {
		if((0 <= r && r < N) && (0 <= c && c < M)) return true;
		return false;
	}

}
