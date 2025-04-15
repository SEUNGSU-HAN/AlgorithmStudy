package com.swea.problem.d4;
import java.io.*;
import java.util.*;

public class Solution_오름차순_줄_세우기 {
	static int T, N;
	static int[] kids;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			/* 입력 */
			N = Integer.parseInt(br.readLine().trim());
			
			/* 초기화 */
			StringTokenizer st = new StringTokenizer(br.readLine());
			kids = new int[N];
			for (int i = 0; i < N; i++) {
				kids[i] = Integer.parseInt(st.nextToken());
			}
			
			/* 로직 */
			
			/* 출력 */
		}
		
		
	}

}
