package com.boj.problem.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.StringTokenizer;

//A/B
public class Main_1008 {
	static BigDecimal A, B;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		A = new BigDecimal(st.nextToken());
		B = new BigDecimal(st.nextToken());
		System.out.println(A.divide(B, MathContext.DECIMAL128));
	}

}
