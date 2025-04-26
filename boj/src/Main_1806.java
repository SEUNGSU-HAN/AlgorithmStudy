import java.io.*;
import java.util.*;

public class Main_1806 {
	static int N, S;
	static int[] nums;

	public static void main(String[] args) throws Exception{
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		/* 초기화 */
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		/* 로직 */
		int s = 0; e = 0;
		 
		
		/* 출력 */
		
	}

}
