import java.io.*;
import java.util.*;

public class Main_2230 {
	static int N;
	static long M;
	static long[] nums;

	public static void main(String[] args) throws Exception{
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Long.parseLong(st.nextToken());
		
		/* 초기화 */
		nums = new long[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine().trim());
		}
		
		/* 로직 */
		Arrays.sort(nums);
		
		
		/* 출력 */
		
	}

}
