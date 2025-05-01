import java.io.*;
import java.util.*;

public class Main_30804 {
	static int N, tot;
	static int[] S, fruits;

	public static void main(String[] args) throws Exception{
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		
		/* 초기화 */
		tot = N;
		S = new int[N+1];
		fruits = new int[10];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			S[i] = Integer.parseInt(st.nextToken());
			fruits[S[i]]++;
		}
		
		/* 로직 */
		
		/* 출력 */
		
	}

}
