package com.boj.problem.silver;
import java.util.*;

public class Main_2839 {
	static int N, result = -1;

	public static void main(String[] args) {
		/* 입력 */
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		/* 로직 */
		//최대 5000이 들어와도 3으로 나눈 값이 1666
		//그래서 최악이라도 대충 1700*1700=2,890,000 언저리 (널널함)
		//그리디 느낌으로 
		int m = (int)Math.ceil(N/3);
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= m; j++) {
				int n = 5*i+3*j;
				if(n == N) {
					if(result == -1) result = i+j;
					else result = Math.min(result, i+j);
				}
			}
		}
		
		/* 출력 */
		System.out.print(result);
	}


}
