import java.io.*;
import java.util.*;

public class Main_17070 {
	static int N, set=0; //set: 현대 파이프가 놓인 상태(0:우,1:하,2:대)
	static int[][] board;

	public static void main(String[] args) throws Exception{
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		/* 초기화 */
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		/* 로직 */
		bfs(new int[] {0, 1});
		
		/* 출력 */
		
	}

	static void bfs(int[] start) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(start);
		
	}

}
