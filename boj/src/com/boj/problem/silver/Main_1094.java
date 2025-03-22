package com.boj.problem.silver;
import java.io.*;
import java.util.*;

public class Main_1094 {
	static int X;
	
	public static void main(String[] args) throws Exception{
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		X = Integer.parseInt(br.readLine().trim());
		
		/* 로직 + 출력 */
		//재귀 풀이
//		System.out.print(findStick(64, X));
		
		/* 로직 + 출력 */
		//비트마스킹 풀이
//		int idx = 0;
//		int count = 0;
//		while((1<<idx) <= X) if((X & 1<<idx++) != 0) count++;
//		System.out.print(count);
		
		
		/* 로직 + 출력 */
		//라이브러리 활용 풀이
		System.out.print(Integer.bitCount(X));
		
	}

	static int findStick(int s, int x) {
		if(s == x) return 1;
		
		if(x == 0) return 0;

		int half = s/2;
		if(x >= half)
			return findStick(half, x-half) + 1;
		else return findStick(half, x);
	}

}
