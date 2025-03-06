import java.io.*;
import java.util.*;

public class Main_17136 {
	static int N = 10;
	static int[][] board, temp;
	static int[] paper;

	public static void main(String[] args) throws Exception{
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		/* 초기화 */
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		temp = new int[N][N];
		paper = new int[] {0, 5, 5, 5, 5, 5};
		
		/* 로직 */
		//종이 붙이기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(board[i][j] == 1) attach(i, j, 5);
			}
		}
		이거 아닌듯...
		
		/* 출력 */
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(temp[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void attach(int r, int c, int size) {
		if(temp[r][c] >= size) return;
		
		if(r+size > N || c+size > N) {
			attach(r, c, size-1);
			return;
		}
		
		if(size == 1) {
			if(paper[size] > 0) {
				temp[r][c] = size;
				paper[size]--;
			}else temp[r][c] = -1;
			
			return;
		}
		
		int sum = 0;
		for (int i = r; i < r+size; i++) {
			for (int j = c; j < c+size; j++) {
				sum += board[i][j];
			}
		}
		if(sum == size*size) {
			if(paper[size] > 0) {
				int isOther = 0;
				for (int i = r; i < r+size; i++) {
					for (int j = c; j < c+size; j++) {
						if(temp[i][j] != 0) isOther = temp[i][j];
						temp[i][j] = size;
					}
				}
				
				paper[size]--;
			}else {
				for (int i = r; i < r+size; i++) {
					for (int j = c; j < c+size; j++) {
						temp[i][j] = -1;
					}
				}
			}
		}else attach(r, c, size-1);
	}

}
