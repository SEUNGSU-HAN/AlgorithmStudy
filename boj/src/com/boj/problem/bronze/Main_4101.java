package com.boj.problem.bronze;
import java.io.*;
import java.util.StringTokenizer;

public class Main_4101 {
	static int A, B;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			if(A == 0 && B == 0) break;
			if(A > B) sb.append("Yes");
			else sb.append("No");
			sb.append("\n");
		}
		System.out.print(sb);
	}

}
