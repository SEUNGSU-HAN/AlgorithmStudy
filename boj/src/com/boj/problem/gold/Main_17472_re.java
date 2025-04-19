package com.boj.problem.gold;
import java.io.*;
import java.util.*;

public class Main_17472_re {
	static int N, M;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] board;
	static class Edge implements Comparable<Edge>{
		int s, e, w;

		public Edge(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
	}
	static PriorityQueue<Edge> bridges;
	static ArrayList<Integer>[] bridgeInfo;
	static int[] p;
	
	public static void main(String[] args) throws Exception{
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N  =Integer.parseInt(st.nextToken());
		M  =Integer.parseInt(st.nextToken());
				
		/* 초기화 */
		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 1) board[i][j] = -1;
			}
		}
		bridges = new PriorityQueue<>();
		
		/* 로직 */
		//1. 섬을 분리짓자 -> FF 사용
		int landNum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(board[i][j] == -1) {
					ff(new int[] {i, j}, ++landNum);
				}
			}
		}
		
		//2. 다리를 연결하자
		bridgeInfo = new ArrayList[landNum+1];
		for (int j = 0; j <= landNum; j++) {
			bridgeInfo[j] = new ArrayList<>();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(board[i][j] != 0) {
					makeBridge(new int[] {i, j});
				}
			}
		}
		
		
		//모든 다리가 서로 연결 되었는지 체크
		//-> 어디서 출발하든 다 연결되야함
		int visited = 1<<1;
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(1);
		while(!q.isEmpty()) {
			int cur = q.poll();
			for (int next : bridgeInfo[cur]) {
				if((visited & 1<<next) > 0) continue;
				visited |= 1<<next;
				q.offer(next);
			}
		}
		//모든 섬이 연결 안됬다면 -1출력 후 종료
		for (int i = 1; i <= landNum; i++) {
			if((visited & 1<<i) == 0) {
				System.out.print(-1);
				return;
			}
		}
		
		//3. 다리 길이 최솟값 구하기 -> Kruskal
		//초기화
		p = new int[landNum+1];
		for (int i = 0; i <= landNum; i++) {
			p[i] = i;
		}
		
		//최소 경로 구하기
		int ans = 0;
		while(!bridges.isEmpty()) {
			Edge edge = bridges.poll();
			if(union(edge.s, edge.e)) {
				ans += edge.w;
			}
		}
		
		
		/* 출력 */
		System.out.print(ans == 0 ? -1 : ans);
	}

	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x == y) return false;
		else if (x < y) p[y] = x;
		else p[x] = y;
		
		return true;
	}

	static int find(int x) {
		if(x == p[x]) return p[x];
		else return p[x] = find(p[x]);
	}

	static void makeBridge(int[] start) {
		int curLand = board[start[0]][start[1]];
		for (int i = 0; i < 4; i++) {
			int j = 1;
			while(true) {
				int nr = start[0]+dr[i]*j;
				int nc = start[1]+dc[i]*j;
				if(!check(nr, nc) || curLand == board[nr][nc]) break;
				if(board[nr][nc] != 0 && board[nr][nc] != curLand) {
					if(j <= 2) break;
					//다른 섬 발견 (연결하자!)
					bridges.offer(new Edge(curLand, board[nr][nc], j-1));
					if(!bridgeInfo[curLand].contains(board[nr][nc]))
							bridgeInfo[curLand].add(board[nr][nc]);
					break;
				}
				j++;
			}
		}
	}

	static void ff(int[] start, int landNum) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(start);
		board[start[0]][start[1]] = landNum;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = cur[0]+dr[i];
				int nc = cur[1]+dc[i];
				if(check(nr, nc) && board[nr][nc] == -1) {
					board[nr][nc] = landNum;
					q.offer(new int[] {nr, nc});
				}
			}
		}
	}

	static boolean check(int nr, int nc) {
		return (0 <= nr && nr < N) && (0 <= nc && nc < M);
	}

}
