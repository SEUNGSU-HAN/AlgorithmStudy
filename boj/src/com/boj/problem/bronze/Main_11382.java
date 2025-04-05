package com.boj.problem.bronze;
import java.io.*;
import java.util.*;

public class Main_11382 {
	static long A, B, C;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		System.out.print(Long.parseLong(st.nextToken())
				+ Long.parseLong(st.nextToken())
				+ Long.parseLong(st.nextToken())
				);
	}
}
