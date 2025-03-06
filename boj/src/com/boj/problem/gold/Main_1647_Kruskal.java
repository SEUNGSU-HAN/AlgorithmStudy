package com.boj.problem.gold;
import java.io.*;
import java.util.*;

public class Main_1647_Kruskal {
	static int N, M;
	static class Kedge implements Comparable<Kedge> {
		int s, e;
		int w;

		public Kedge(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Kedge o) {
			return Long.compare(this.w, o.w);
		}		
	}
	static int[] p;
	static PriorityQueue<Kedge> kuru_road;

	public static void main(String[] args) throws Exception{
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
				
		/* 초기화 */
		kuru_road = new PriorityQueue<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			Kedge kedge = new Kedge(s, e, w);
			/**
			 * 원래 크루스칼 쓸 때 contains를 써서 이미 기록한 경로
			 * 즉, 중복된 경로면 추가하지 않으려고 헀는데
			 * 오히려 저 contains로 검사하는게 시간을 더 오래 잡아먹음
			 * O(n^2)이 나올 수 있음 그래서 contains안해야함
			 * 어차피 크루스칼은 중복된 간선이 들어와도 상관없음
			 * 유니온 파인드로 인해 중복된건 다 쳐낼거니까
			 * */
			kuru_road.offer(kedge);
		}
		
		/* 로직 */
		/*========Use Kruskal ver========*/
		init();
		long result = 0;
		int maxW = 0;
		int count = 0;
		while(!kuru_road.isEmpty() && count < N-1) {
			Kedge edge = kuru_road.poll();
			if(union(edge.s, edge.e)) {
				maxW = Math.max(maxW, edge.w);
				count++;
				result += edge.w;
			}
		}
		//가장 가중치가 큰 간선을 제거
		result -= maxW;

		/* 출력 */
		System.out.print(result);
	}


	static void init() {
		p = new int[N+1];
		for (int i = 1; i <= N; i++) {
			p[i] = i;
		}
	}


	static boolean union(int x, int y) {
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

}
