package com.boj.problem.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

public class Main_1793 {
	static int N;
	static ArrayList<Integer> nlist;
	static BigInteger result;
	static BigInteger[] m;
	
	//타일링
	public static void main(String[] args) throws Exception{
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = "";
		StringBuilder sb = new StringBuilder();
		
		/* 초기화 */
		nlist = new ArrayList<>();
		//입력 개수 제한이 없는 입력 받기
		while((s = br.readLine()) != null && !s.isEmpty()) {
			nlist.add(Integer.parseInt(s));
		}
		m = new BigInteger[nlist.size()+1];
		
		/* 로직+출력 */
		for (int n : nlist) {
			if(n == 0) {
				//0일 때는 1임 (0아님을 주의)
				sb.append(1).append("\n");
				continue;
			}else if(n == 1) {
				sb.append(1).append("\n");
				continue;
			}
			m = new BigInteger[n+1];
			sb.append(fibo(n).toString()).append("\n");
		}
		System.out.println(sb.toString());
	}

	//f(n) = f(n-1)+f(n-2)*2
	private static BigInteger fibo(int n) {
		if(n == 1 || n == 0) return new BigInteger("1");
		if(m[n] != null) return m[n];
		m[n] = fibo(n-1).add(fibo(n-2).multiply(new BigInteger("2")));
		return m[n];
	}
	

}
