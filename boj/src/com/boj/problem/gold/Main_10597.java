package com.boj.problem.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_10597 {
	static String P;
	static int N;
	static boolean[] visited;
	static ArrayList<Integer> list;

	public static void main(String[] args) throws Exception{
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		P = br.readLine();
		
		/* 초기화 */
		//순열 최댓 값 (max = 50)
		if(P.length() < 10) N = P.length();
		else {
			N = 9+(P.length()-9)/2;
		}
		visited = new boolean[N+1];
		list = new ArrayList<>();
		
		/* 로직 */
		findPerm(0, P.toCharArray());
		
		
		/* 출력 */
	}

	
	

	private static void findPerm(int cnt, char[] cl) {
		if(cnt == P.length()-1) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				sb.append(list.get(i)).append(" ");
			}
			System.out.print(sb);
			return;
		}
		String str = "";
		for (int i = cnt; i <= cnt+1; i++) {
			str += String.valueOf(cl[i]);
			int num = Integer.parseInt(str);
			if(num > N || visited[num]) continue;
			visited[num] = true;
			list.add(num);
			if(i+1 < P.length()-1) findPerm(i+1, cl);
			visited[num] = false;
			list.remove(list.size()-1);
		}
	}




}
