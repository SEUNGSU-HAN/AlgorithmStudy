package com.boj.problem.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1325 {
	static int N, M;
	static ArrayList<ArrayList<Integer>> B;

	public static void main(String[] args) throws Exception{
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		/* 초기화 */
		B = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < N+1; i++) {
			B.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			B.get(a).add(b);
		}
		
		/* 로직 */
		int max = 0;
		ArrayList<Integer> result = null;
		for (ArrayList<Integer> a : B) {
			max = Math.max(max, a.size());
			result = a;
		}
		
		하는 중
		N과M이 1일경우를 생각해야할 듯?
		
		/* 출력 */
		StringBuilder sb = new StringBuilder();
		if(result != null) {
			for (int i = 0; i < result.size(); i++) {
				sb.append(result.get(i) + " ");
			}
		}
		System.out.println(sb.toString());
	}

}
