package com.boj.problem.bronze;
import java.io.*;
import java.util.*;

public class Main_2420 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		System.out.print(Math.abs(Long.parseLong(st.nextToken())-Long.parseLong(st.nextToken())));
	}

}
