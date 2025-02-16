package com.boj.problem.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//트리 순회
public class Main_1991 {
	static int N;
	static ArrayList<ArrayList<String>> tree;

	public static void main(String[] args) throws Exception{
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		/* 초기화 */
		tree = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			tree.add(new ArrayList<>());
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
		}
		
		/* 로직 */
		
		
		/* 출력 */
	}

}
