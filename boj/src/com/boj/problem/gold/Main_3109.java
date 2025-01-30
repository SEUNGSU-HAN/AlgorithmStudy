package com.boj.problem.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

틀림... 뭐가 틀렸을까..?
public class Main_3109 {
	static int R, C;
	static char[][] board;
	static int[] dr = {-1, 0, 1};
	static int pipe;

	public static void main(String[] args) throws Exception{
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		//초기화
		board = new char[R][C];
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				board[i] = line.toCharArray();
			}
		}
		int r = 0;
		int c = 0;
		int count = 0;
		
		//로직
		for (int i = 0; i < R; i++) {
			r = i;
			c = 0;
			count = 0;
			for (int j = 0; j < C; j++) {
				for (int k = 0; k < 3; k++) {
					int nr = r+dr[k];
					int nc = c+1;
					if((nr >= 0 && nr < R) && (nc < C) && board[nr][nc] == '.') {
						board[nr][nc] = 'a';
						r = nr;
						c = nc;
						count = 0;
						break;
					}else count++;
				}
				if(count == 3) break;
			}
		}
		
		for (int i = 0; i < R; i++) {
			if(board[i][C-1] == 'a') pipe++;
		}
		
		//출력
//		StringBuilder sb = new StringBuilder();
//		for (int i = 0; i < R; i++) {
//			sb.append(board[i]).append("\n");
//		}
//		System.out.println(sb.toString());
		System.out.println(pipe);
		
	}

}
