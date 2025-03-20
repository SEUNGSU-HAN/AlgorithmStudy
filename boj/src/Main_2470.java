import java.io.*;
import java.util.*;

public class Main_2470 {
	static int N;
	static int[] chemi, result;
	public static void main(String[] args) throws Exception{
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		/* 초기화 */
		chemi = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			chemi[i] = Integer.parseInt(st.nextToken());
		}
		result = new int[2];
		
		/* 로직 */
		Arrays.sort(chemi);
		for (int i = 0; i < N; i++) {
			int s =i, e = i;
			if(chemi[i] < 0) {
				int lb = lowerBound(Math.abs(chemi[i]))-1;
				if(lb == i)
			}
		}
		
		/* 출력 */
		
	}
	static int upperBound(int target) {
		// TODO Auto-generated method stub
		return 0;
	}
	static int lowerBound(int target) {
		// TODO Auto-generated method stub
		return 0;
	}

}
