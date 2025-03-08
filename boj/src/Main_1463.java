import java.io.*;
import java.util.*;

public class Main_1463 {
	static int N;
	static int[] dp;

	public static void main(String[] args) throws Exception{
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		
		/* 초기화 */
		dp = new int[N+1];
		
		/* 로직 */
		System.out.print(find(N));
		
		/* 출력 */
	}

	static int find(int n) {
		if(n == 1) return dp[n] = 0;
		
		if(dp[n] != 0) return dp[n];
		
		if(n%3 == 0) return dp[n] = find(n/3)+1;
		else if(n%2 == 0) return dp[n] = find(n/2)+1;
		else return dp[n] = find(n-1)+1;
	}

}
