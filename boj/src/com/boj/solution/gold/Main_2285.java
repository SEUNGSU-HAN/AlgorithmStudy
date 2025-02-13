package com.boj.solution.gold;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

//젤다
public class Main_2285 {
	static int N;
	static int[][] map;
	static int[][] cost;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	//내부 클래스 활용법 (static 사용해서 만듬)
	static class Cell implements Comparable<Cell>{
		int r;
		int c;
		int cost;
		public Cell(int r, int c, int cost) {
			super();
			this.r = r;
			this.c = c;
			this.cost = cost;
		}
		public Cell() {

		}
		@Override
		public int compareTo(Cell o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = 1;
		while(true) {
			N = sc.nextInt();
			if(N == 0) break;
			map = new int[N][N];
			cost = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(cost[i], Integer.MAX_VALUE/100);
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int result = bfs();
			System.out.println("Problem " + (cnt++)+": "+result);
		}
				
	}


	//bfs지만 우선순위가 있으면 좋기에 우선순위 큐를 사용
	private static int bfs() {
		PriorityQueue<Cell> q = new PriorityQueue<>();
		q.offer(new Cell(0, 0, map[0][0]));
		cost[0][0] = map[0][0];
		while(!q.isEmpty()) {
			Cell cur = q.poll();
			int cr = cur.r;
			int cc = cur.c;
			if(cost[cr][cc] < cur.cost) continue;
			for (int i = 0; i < 4; i++) {
				int nr = cr+dr[i];
				int nc = cc+dc[i];
				if(!check(nr, nc)) continue;
				//다익스트라
				if(cost[nr][nc]>cost[cr][cc]+map[nr][nc]) {
					cost[nr][nc] = cost[cr][cc]+map[nr][nc];
					q.offer(new Cell(nr, nc, cost[nr][nc]));
				}
			}
		}

		return cost[N-1][N-1];
	}


	private static boolean check(int nr, int nc) {
		if((0 <= nr && nr < N) && (0 <= nc && nc < N)) return true;
		return false;
	}

}
