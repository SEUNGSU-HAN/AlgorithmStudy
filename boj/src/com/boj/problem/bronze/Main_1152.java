package com.boj.problem.bronze;
import java.io.*;

public class Main_1152 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		String[] sl = br.readLine().trim().split(" ");
		System.out.print(sl[0].equals("") ? 0 : sl.length);
	}
}
