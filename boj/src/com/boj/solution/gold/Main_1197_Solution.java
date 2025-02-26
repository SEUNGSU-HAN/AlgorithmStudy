package com.boj.solution.gold;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//MST(Minimum Spanning Tree) 코드
//크루스칼 알고리즘
//boj 1197번
public class Main_1197_Solution {
	static int V, E;
	static long min;
	
	static class Edge implements Comparable<Edge>{
		int s;
		int e;
		int w;
		
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
	
	static PriorityQueue<Edge> points;
	static int[] p;
	static int[] r;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		points = new PriorityQueue<>();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			points.offer(new Edge(s, e, w));
		}
		
		makeSet();
		int cnt = 0;
		min = 0L;
		//섬이 10개면 간선 9개만 연결하면된다.
		while(cnt != V-1) {
			Edge edge = points.poll();
			//연결할 수 있으면 -> union find
			if(union(edge.s, edge.e)) {
				cnt++; //연결이 됬음
				min += edge.w; //연결된 간선 값 더하기
			}
		}
		
		System.out.print(min);
		 
	}

	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x == y) return false; //이미 연결되 있다면
		if(r[x] < r[y]) {
			r[y] += r[x]; // 인원 더 많은 쪽이 적은 쪽을 흡수
			p[x] = y; //흡수한 놈이 흡수 당한놈의 부모가 되는 것!
		}else {
			r[x] += r[y]; // 인원 더 많은 쪽이 적은 쪽을 흡수
			p[y] = x; //흡수한 놈이 흡수 당한놈의 부모가 되는 것!
		}
		return true;
	}

	static int find(int x) {
		if(x == p[x]) return p[x]; //x가 보스면 그대로 전송
		else return p[x] = find(p[x]); //최종 보스(부모)를 찾아 올라가서 찾음 (재귀)
	}

	//사전 세팅 함수 (init 용)
	static void makeSet() {
		p = new int[V+1];
		r = new int[V+1];
		for (int i = 0; i < V+1; i++) {
			p[i] = i; //자기 자신이 보스
			r[i] = 1; //조직 인원 수
		}
	}


}
