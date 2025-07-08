import java.io.*;
import java.util.*;

public class Main_3190 {
	static int N, K, L;
	static int[] dr = {-1, 0, 1, 0}; //북동남서, 시작은 동!
	static int[] dc = {0, 1, 0, -1};
	static class Pos {
		int r, c, d;

		public Pos(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}
	static int[][] board;

	public static void main(String[] args) throws Exception{
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		/* 초기화 */
		board = new int[N][N];
		board[0][0] = 1;
		Pos head = new Pos(0, 0, 1);
		Pos tail = new Pos(0, 0, 1);
		
		K = Integer.parseInt(br.readLine());
		while(K-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			board[r][c] = 2;
		}
		
		/* 로직 */
		L = Integer.parseInt(br.readLine());
		while(L-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			int cur_head_direction = head.d;
			int cur_tail_direction = tail.d;
			int next_direction = convertDirection(cur_head_direction, st.nextToken().charAt(0));
			head.d = next_direction;
			tail.d = next_direction;
			
			while(time-- > 0) {
				//뱀의 머리가 다음에 갈 곳이 안전한지 확인
				//1. 격자판 안이냐 2. 자기몸에 안닿느냐
				int hnr = head.r+dr[cur_head_direction];
				int hnc = head.c+dc[cur_head_direction];
				
				if(!check(hnr, hnc) || board[hnr][hnc] == 1) {
					//게임 오버
					break;
				}
				
				//안전하다면 머리 증가, 머리 위치 업뎃
				board[hnr][hnc] = 1;
				head.r = hnr;
				head.c = hnc;
				
				//사과가 없었다면 꼬리 감소
				int tnr = tail.
			}
		}
		
		/* 출력 */
	}

	static boolean check(int nr, int nc) {
		return (nr >= 0 && nr < N) && (nc >= 0 && nc <N);
	}

	static int convertDirection(int cd, char d) {
		int nd = 0;
		switch(d) {
			case 'D':
				nd = cd+1 == 4 ? 0 : cd+1;
			case 'L':
				nd = cd-1 < 0 ? 3 : cd-1;
		}
		return nd;
	}

}
