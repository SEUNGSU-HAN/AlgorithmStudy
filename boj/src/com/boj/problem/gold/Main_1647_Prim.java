package com.boj.problem.gold;
import java.io.*;
import java.util.*;

public class Main_1647_Prim {
	static int N, M;
	static class Edge implements Comparable<Edge> {
		int v, w;

		public Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}	
		
	}
	static ArrayList<Edge>[] graph;
	static PriorityQueue<Edge> prim_road;
	static boolean[] visited;
	

	public static void main(String[] args) throws Exception{
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
				
		/* 초기화 */
		graph = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[s].add(new Edge(e, w));
			graph[e].add(new Edge(s, w));
		}
		prim_road = new PriorityQueue<>();
		visited = new boolean[N+1];
		
		/* 로직 */
		/*========Use Prim ver========*/
		//프림 알고리즘을 사용하여 모든 노드의 최소 연결 엣지를 찾음
		//간선 가중치들의 합을 저장해 두었다가
		//완성된 경로에서 가장 가중치가 높은 간선을 제거 해줌
		
		prim_road.offer(new Edge(1, 0));
		long result = 0;
		int count = 0;
		int maxW = 0;
		while(!prim_road.isEmpty()) {
			Edge edge = prim_road.poll();
			int v = edge.v;
			if(visited[v]) continue;
			result += edge.w;
			maxW = Math.max(maxW, edge.w);
			visited[v] = true;
			if(N == ++count) break;
			//현재 노드와 연결되있는 모든 노드의 간선 추가
			//간선 값 적은 순 우선 정렬됨
			for (int i = 0; i < graph[v].size(); i++) {
				Edge next = graph[v].get(i);
				if(visited[next.v]) continue;
				prim_road.offer(next);
			}
		}
		result -= maxW;
		
		/* 출력 */
		System.out.print(result);
	}
}
