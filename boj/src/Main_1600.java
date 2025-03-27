import java.io.*;
import java.util.*;

public class Main_1600 {
	static int K, C, R, result=Integer.MAX_VALUE;
	static int dr[] = {0, 1, -1, 0}; //원숭이의 움직임
	static int dc[] = {1, 0, 0, -1};
	static int hdr[] = {-1, -2, 1, -2, 2, -1, 2, 1}; //말의 움직임
	static int hdc[] = {2, 1, 2, -1, 1, -2, -1, -2};
	static boolean[][] board, visited;

	public static void main(String[] args) throws Exception{
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		/* 초기화 */
		board = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				if(st.nextToken().equals("1")) board[i][j] = true;
			}
		}
		visited = new boolean[R][C];
		
		/* 로직 */
		bfs(new int[] {0, 0});
		
		/* 출력 */
		System.out.print(result == Integer.MAX_VALUE ? -1 : result);
	}

	

	static void bfs(int[] start) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(start);
		visited[start[0]][start[1]] = true;
		while(!q.isEmpty()) {
			
		}
	}



	static boolean check(int nr, int nc) {
		return (0 <= nr && nr < R) && (0 <= nc && nc < C);
	}

}
