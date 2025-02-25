import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

//외판원 순회2
public class Main_10971 {
	static int N;
	static int[][] board;
	static boolean[] visited;
	static int minDis = Integer.MAX_VALUE;

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
		dfs(0);
		외판원 하는중...
		
		/* 출력 */
		System.out.print(minDis);
	}

	private static void dfs(int cnt) {
		if(cnt == N) {
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			
		}
	}

}
