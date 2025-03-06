package com.boj.problem.gold;
import java.io.*;
import java.util.*;

public class Main_4386_kuruskal {
	static int N;
	static double result;
	static class Star {
		double x, y;

		public Star(double x, double y) {
			this.x = x;
			this.y = y;
		}
		
	}
	static class Edge implements Comparable<Edge>{
		int s, e;
		double w;

		public Edge(int s, int e, double w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}

		public int compareTo(Edge o) {
			return Double.compare(this.w, o.w);
		}

		@Override
		public boolean equals(Object obj) {
			Edge edge = (Edge)obj;
			if(this.w == edge.w) {
				if(this.s == edge.e && this.e == edge.s) return true;
			}
			return false;
		}
		
		
	}
	static Star[] stars;
	static PriorityQueue<Edge> zodiac;
	static int[] p;

	public static void main(String[] args) throws Exception{
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		/* 초기화 */
		zodiac = new PriorityQueue<>();
		stars = new Star[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			stars[i] = new Star(x, y);
		}
		
		/* 로직 */
		//각 별들의 간선을 저장
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(i == j) continue;
				double d = distance(stars[i].x, stars[i].y, stars[j].x, stars[j].y);
				Edge edge = new Edge(i, j, d);
				if(!zodiac.contains(edge)) zodiac.offer(edge);
			}
		}
		
		//Use Kuruskal
		init();
		while(!zodiac.isEmpty()) {
			Edge edge = zodiac.poll();
			if(unionFind(edge.s, edge.e)) {
				result += edge.w;
			}
		}
		
		/* 출력 */
		System.out.printf("%.2f", result);
	}

	static boolean unionFind(int x, int y) {
		x = find(x);
		y = find(y);
		if(x == y) return false;
		if(x < y) p[y] = x;
		else p[x] = y;
		return true;
	}

	static int find(int x) {
		if(x == p[x]) return p[x];
		else return p[x] = find(p[x]);
	}

	static void init() {
		p = new int[N];
		for (int i = 0; i < N; i++) {
			p[i] = i;
		}
	}

	static double distance(double x, double y, double x2, double y2) {
		double dx = Math.abs(x2-x);
		double dy = Math.abs(y2-y);
		return Math.sqrt((dx*dx)+(dy*dy));
	}

}
