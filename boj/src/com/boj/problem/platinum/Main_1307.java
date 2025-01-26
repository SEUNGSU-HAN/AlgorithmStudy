package com.boj.problem.platinum;
import java.util.Scanner;

public class Main_1307 {
	public static int n;
	public static int[][] magic;
	public static int m;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		magic = new int[n][n];
		StringBuilder sb = new StringBuilder();
		
		if(n%2 == 1) {
			//홀수 마방진
			make3(sb);
		}else if(n%4 == 0) {
			//4n 마방진
			make4(sb);
		}else {
			//4n+2 마방진
			make6(sb);
		}
	}

	private static void make6(StringBuilder sb) {
		// 1사분면
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m/2; j++) {
				if(i == m/2) magic[i][j+1] = 3;
				else magic[i][j] = 3;
			}
		}
		
		// 2사분면
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				magic[i][j+m] = 1;
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m-(m/2-1); j++) {
				magic[i][j+m] = 2;
			}
		}
		
		// 3, 4사분면
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				if(magic[i][j] == 0) magic[i+m][j] = 3;
				else magic[i+m][j] = 0;
				
				if(magic[i][j+m] == 1) magic[i+m][j+m] = 2;
				else magic[i+m][j+m] = 1;
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				magic[i][j] *= (m*m);
			}
		}
		
		int temp_magic = magic.clone();
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				magic[i][j] += oddMagic[i][j]; // 1사분면
				magic[i][j+m] += oddMagic[i][j]; // 2사분면
				magic[i+m][j] += oddMagic[i][j]; // 3사분면
				magic[i+m][j+m] += oddMagic[i][j]; // 4사분면
			}
		}
		
	}

	private static void make4(StringBuilder sb) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				magic[i][j] = i*n + j + 1; //1~n*n까지 수 대입하는 법
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if((i >= 0 && i < n/4) || (i >= n/4*3)) {
					if(j >= n/4 && j < n/4*3) {
						magic[i][j] = n*n-(i*n+j);
					}
				}else {
					if((j >= 0 && j < n/4) || (j >= n/4*3)) {
						magic[i][j] = n*n-(i*n+j);
					}
				}
			}
		}
		
	}

	private static void make3(StringBuilder sb) {
		int r = 0;
		int c = n/2;
		
		for (int i = 1; i < n*n+1; i++) {
			magic[r][c] = i;
			
			int pre_r = r;
			int pre_c = c;
			
			if(r-1 < 0) r = n-1;
			else r--;
			
			if(c-1 < 0) c = n-1;
			else c--;
			
			if(magic[r][c] != 0) {
				r = pre_r + 1;
				c = pre_c;
			}
		}
	}

}
