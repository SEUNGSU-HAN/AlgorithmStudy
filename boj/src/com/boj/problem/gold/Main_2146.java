package com.boj.problem.gold;
import java.io.*;
import java.util.*;

public class Main_2146 {
	static int N, landCount;
	static int[][] board;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static class Node {
		int r, c, w, l;

		public Node(int r, int c, int w, int l) {
			this.r = r;
			this.c = c;
			this.w = w;
			this.l = l;
		}
	}
	static Queue<Node> land;
	static int bridge = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception{
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		/* 초기화 */
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 1) board[i][j] = -1;
			}
		}
		land = new ArrayDeque<>();
		
		/* 로직 */
		//1.단 FF 돌려서 섬을 나눠
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(board[i][j] == -1) {
					landCount++;
					visited = new boolean[N][N];
					bfs(new int[] {i, j});
				}
			}
		}
		//섬 별로 bfs 돌려서 다른 섬 찾으면 다리 연결
		//연결 시 거리 체크
		createBridge();

		
		/* 출력 */
		System.out.print(bridge);
	}

	static void createBridge() {
		while(!land.isEmpty()) {
			Node cur = land.poll();
			if(cur.w > bridge) continue;
			for (int i = 0; i < 4; i++) {
				int nr = cur.r+dr[i];
				int nc = cur.c+dc[i];
				if(check(nr, nc) && !visited[nr][nc]) {
					if(board[nr][nc] == cur.l) {
						visited[nr][nc] = true;
						continue;
					}
					if(board[nr][nc] == 0) {
						land.offer(new Node(nr, nc, cur.w+1, 0));
						visited[nr][nc] = true;
					}else {
						//다른 섬을 만남 -> 다리 최소 길이 체크
						bridge = Math.min(bridge, cur.w);
					}
				}
			}
		}
	}

	static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void bfs(int[] start) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(start);
		visited[start[0]][start[1]] = true;
		board[start[0]][start[1]] = landCount;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			boolean isEdge = false;
			for (int i = 0; i < 4; i++) {
				int nr = cur[0]+dr[i];
				int nc = cur[1]+dc[i];
				if(check(nr, nc) && !visited[nr][nc]) {
					if(board[nr][nc] == 0) {
						//바다 근처 육지만 고름
						if(!isEdge)
							land.offer(new Node(cur[0], cur[1], 0, landCount));
						isEdge = true;
						continue;
					}
					q.offer(new int[] {nr, nc});
					visited[nr][nc] = true;
					board[nr][nc] = landCount;
				}
			}
		}
	}

	static boolean check(int nr, int nc) {
		return(0 <= nr && nr < N) && (0 <= nc && nc < N);
	}

}
