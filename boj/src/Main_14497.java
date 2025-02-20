import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14497 {
	static int N, M;
	static int[] j, c; //주난, 초코바 위치
	static char[][] board;
	static char[][] tmpBoard;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int jump;

	public static void main(String[] args) throws Exception{
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		j = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		c = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		
		/* 초기화 */
		board = new char[N][M];
		tmpBoard = new char[N][M];
		for (int i = 0; i < N; i++) {
			char[] cl = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				board[i][j] = cl[j];
				tmpBoard[i][j] = cl[j];
			}
		}
		
		/* 로직 */
		하는중
		
		/* 출력 */
	}

	private static void bfs() {
		Queue<>
	}

}
