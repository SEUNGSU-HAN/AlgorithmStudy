import java.io.*;
import java.util.*;

public class Main_3600 {
	static final long INF = Long.MAX_VALUE;
	static int N, M;
	static long[] jump;
	
	public static void main(String[] args) throws Exception{
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		/* 초기화 */
		jump = new long[N+1];
		Arrays.fill(jump, INF);
		for (int i = 0; i < M; i++) {
			int n = Integer.parseInt(br.readLine().trim());
			jump[n] = -1;
		}
		for (int i = 2; i <= N; i++) {
			jump[i] = i-1;
		}
		jump[0] = jump[1] = 0;
		
		
		/* 로직 */
		if(N < 3) {
			System.out.print(jump[N]);
			return;
		}
		for (int x = 1; x <= N; x++) {
			for (int i = 2+x; i <= N; i++) {
				if(jump[i] == -1) continue;
				if(x > 1 && i+(x-1) <= N) jump[i+(x-1)] = Math.min(jump[i+(x-1)], jump[i]+1);
				if(i+x <= N) jump[i+x] = Math.min(jump[i+x], jump[i]+1);
				if(i+(x+1) <= N) jump[i+(x+1)] = Math.min(jump[i+(x+1)], jump[i]+1);
//				System.out.println(Arrays.toString(jump));
			}
		}
		
		
		/* 출력 */
		System.out.print(jump[N]);
	}

}
