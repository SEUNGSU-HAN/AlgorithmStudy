package com.swea.solution.d4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_방향전환 {
	static int T, N=200;
	static int x1, x2, y1, y2;
	static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
	static int[][][] visited;

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t < T; t++) {
			x1 = sc.nextInt() + 100;
			y1 = sc.nextInt() + 100;
			x2 = sc.nextInt() + 100;
			y2 = sc.nextInt() + 100;
			visited = new int[N+1][N+1][2];
			Queue<int[]> q = new LinkedList<>();
			q.offer(new int[] {x1, y1, 0, 0});
			q.offer(new int[] {x1, y1, 0, 1}); //거리 방향
			visited[x1][y1][0] = 1;
			visited[x1][y1][1] = 1;
			int value = -1;
			//---------------------------------
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				int r = cur[0];
				int c = cur[1];
				int cnt = cur[2];
				int dir = cur[3];
				if(r == x2 && c == y2) {
					value = cnt;
					break;
				}
				for (int d = 1; d < 4; d+=2) {
					int s = (dir+d)%4; //1+0 => 1
					int u = (dir+d)%2; 
					int nr = r+dr[s];
					int nc = c+dc[s];
					if(!check(nr, nc)) continue;
					if(visited[nr][nc][u] == 0) {
						visited[nr][nc][u] = 1;
						q.offer(new int[] {nr, nc, cnt+1, u});
					}
				}
			}
			
			
		}
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N+1 && c>=0 && c<N+1;
	}

}
