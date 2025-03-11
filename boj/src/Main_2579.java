import java.io.*;
import java.util.*;

public class Main_2579 {
	static int N;
	static int[] nums, dp;

	public static void main(String[] args) throws Exception{
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		
		/* 초기화 */
		nums = new int[N+1];
		dp = new int[N+1];
		for (int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(br.readLine().trim());
//			dp[i] = nums[i];
		}
		dp[1] = nums[1];
		
		/* 로직 */
//		if(N != 1) {
//			int oneCount = 0;
//			for (int i = 2; i <= N ; i++) {
//				
//				dp[i] = Math.max(nums[i] + dp[i-1], nums[i] + dp[i-2]);
//				
//				if(oneCount == 2) {
//					dp[i] = Math.max(dp[i], nums[i]+dp[i-2]);
//				}
//			}
//		}
		
		upStairs(N, 1);
//		System.out.println(Arrays.toString(dp));
		
		/* 출력 */
		System.out.print(dp[N]);
	}

	static int upStairs(int cnt, int count) {
//		System.out.println("cnt: " + cnt + ", count: " + count);
//		System.out.println(Arrays.toString(dp));
		if(cnt == 0) return 0;
		if(cnt == 1) return dp[1];	
//		if(dp[cnt] != 0) return Math.max(dp[cnt];
		
		if(count == 2) dp[cnt] = nums[cnt]+upStairs(cnt-2, 1);
		else dp[cnt] = Math.max(nums[cnt]+upStairs(cnt-1, count+1), nums[cnt]+upStairs(cnt-2, 1));
		
		return dp[cnt];
	}

}
