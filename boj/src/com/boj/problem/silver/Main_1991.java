package com.boj.problem.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//트리 순회
public class Main_1991 {
	static int N;
	static ArrayList[] tree;

	public static void main(String[] args) throws Exception{
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		/* 초기화 */
		tree = new ArrayList[27];
		for (int i = 1; i <= 26; i++) {
			tree[i] = new ArrayList<String>();
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			tree[i].add(st.nextToken());
		}
		
		/* 로직 */
		StringBuilder sb = new StringBuilder();
		perorder(0, sb);
		inorder(0, sb);
		postorder(0, sb);
		
		
		/* 출력 */
	}

	private static void postorder(int node, StringBuilder sb) {
		// TODO Auto-generated method stub
		
	}

	private static void inorder(int node, StringBuilder sb) {
		// TODO Auto-generated method stub
		
	}

	private static void perorder(int node, StringBuilder sb) {
		if(tree[node])
		//왼쪽 자식
		perorder(node*2, sb);
		
		//오른쪽 자식
		perorder(node*2+1, sb);
	}

}
