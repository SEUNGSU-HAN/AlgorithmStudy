import java.io.*;
import java.util.*;

public class Main_2568 {
	static int M, max;
	static int[] A, B, arr, lis;
	
	public static void main(String[] args) throws Exception{
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		M = Integer.parseInt(br.readLine().trim());
		
		/* 초기화 */
		A = new int[500001];
		B = new int[500001];
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			A[a] = b;
			B[b] = a;
			max = Math.max(b, Math.max(max, a));
		}
		arr = new int[M+1];
		lis = new int[M+1];
		
		
		/* 로직 */

		
		

		/* 출력 */
		System.out.print("m: " + m);
	}

}
