package com.boj.problem.bronze;
import java.io.*;
import java.util.*;

public class Main_1264 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().toLowerCase();
		

		StringBuilder sb = new StringBuilder();
		while(!str.equals("#")) {
			int cnt = 0;
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (c == 'a' || c == 'e' || c == 'i' || c =='o' || c =='u') cnt++;
			}
			sb.append(cnt).append("\n");
			str = br.readLine().toLowerCase();
		}
		
		System.out.println(sb.toString());
	}

}
