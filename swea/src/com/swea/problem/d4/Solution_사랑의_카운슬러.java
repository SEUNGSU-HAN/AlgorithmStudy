package com.swea.problem.d4;
import java.io.*;
import java.util.*;

public class Solution_사랑의_카운슬러 {
	static int T, N;
	static long[] x;
	static long[] y;
	static long[][] loveLine;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			/* 입력 */
			N = Integer.parseInt(br.readLine().trim());
			
			/* 초기화 */
			x = new long[N];
			y = new long[N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				x[i] = Integer.parseInt(st.nextToken());
				y[i] = Integer.parseInt(st.nextToken());
			}
			loveLine = new long[N][N];
			
			/* 로직 */
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(i == j) continue;
					loveLine[i][j] = x[i]*x[j]+y[i]*y[j];
				}
			}
			
			/* 출력 */
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.printf("% 3d", loveLine[i][j]);
				}
				System.out.println();
			}
			System.out.println("================");
		}
	}
}
