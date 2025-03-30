import java.io.*;
import java.util.*;

public class Main_15683 {
	static int N, M, minArea;
	static int[][] board, temp1, temp2;
	static int[][][] dtv1 = {
			{},
			{{-1}, {0}},
			{{0}, {1}},
			{{1}, {0}},
			{{0}, {-1}}
	};
	static int[][][] dtv2 = {
			{},
			{{-1, 1}, {0, 0}},
			{{0, 0}, {1, -1}}
	};
	static int[][][] dtv3 = {
			{},
			{{-1, 0}, {0, 1}},
			{{0, 1}, {1, 0}},
			{{1, 0}, {0, -1}},
			{{0, -1}, {-1, 0}}
	};
	static int[][][] dtv4 = {
			{},
			{{-1, 0, 0}, {0, -1, 1}},
			{{0, -1, 1}, {1, 0, 0}},
			{{1, 0, 0}, {0, -1, 1}},
			{{0, -1, 1}, {-1, 0, 0}},
	};
	static int[][][] dtv5 = {
			{},
			{{-1, 0, 1, 0}, {0, 1, 0, -1}}
	};
	static ArrayList<int[]>[] cctv;
	static ArrayList<int[][][]> cctvDirection;
	
	public static void main(String[] args) throws Exception{
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		minArea = N*M;
		
		/* 초기화 */
		cctv = new ArrayList[6];
		for (int i = 0; i < 6; i++) {
			cctv[i] = new ArrayList<>();
		}
		temp1 = new int[N][M];
		temp2 = new int[N][M];
		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] != 0) minArea--;
				if(board[i][j] >= 1 && board[i][j] < 6)
					cctv[board[i][j]].add(new int[] {i, j});
			}
		}
		cctvDirection = new ArrayList<>();
		cctvDirection.add(new int[][][] {});
		cctvDirection.add(dtv1);
		cctvDirection.add(dtv2);
		cctvDirection.add(dtv3);
		cctvDirection.add(dtv4);
		cctvDirection.add(dtv5);
		
		/* 로직 */
		//숫자가 큰 cctv부터 감시 영역 체크
		//그리디하게 접근 -> 각 cctv 마다 최대로 감시할 수 있는 방향을 선택
		for (int num = 1; num <= 5 ; num++) {
			if(cctv[num].isEmpty()) continue;
			for (int[] cur : cctv[num]) {
				int watch = 0;
				int[][][] dtv = cctvDirection.get(num);
				for (int z = 1; z < dtv.length; z++) { //각도 별 확인
					deepCopy(board, temp2);
					int count = 0;
					for (int i = 0; i < dtv[z][0].length; i++) { //방향별 확인
						for (int j = 1; j < N*M; j++) {
							int nr = cur[0]+dtv[z][0][i]*j;
							int nc = cur[1]+dtv[z][1][i]*j;
							if(!check(nr, nc) || temp2[nr][nc] == 6) break;
							if(temp2[nr][nc] == 0) {
								count++;
								temp2[nr][nc] = 7;
							}
						}
					}
					System.out.println("num: " + num + ", z: " + z);
					print(temp2);
					if(count > watch) {
						deepCopy(temp2, temp1);
						watch = count;
					}
				}
				//최종적으로 가장 많이 감시하는걸로 업어침
				if(watch != 0) {
					deepCopy(temp1, board);
					minArea -= watch;
				}
			}
		}
		//그리디 완탐 말고 백트래킹? 으로 해야하나?
		//위 풀이 반례 (3이 좌상으로 봐야 더 최적임)
		/*
		 	8 3
			6 0 6
			0 0 0
			0 0 0
			0 0 2
			0 0 0
			0 3 0
			0 0 0
			6 5 0
			================
			7 6
			0 0 1 0 0 6
			0 0 0 0 0 2
			0 0 0 0 2 0
			0 0 0 5 5 6
			0 3 0 0 0 0
			6 0 1 0 0 0
			6 0 0 0 0 6

		 */
		
		/* 출력 */
		print(board);
		System.out.print(minArea);
	}

	static void print(int[][] b) {
		System.out.println("==================");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(b[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void deepCopy(int[][] src, int[][] dest) {
		for (int i = 0; i < N; i++) {
			System.arraycopy(src[i], 0, dest[i], 0, src[i].length);
		}
	}

	static boolean check(int nr, int nc) {
		return (0 <= nr && nr < N) && (0 <= nc && nc < M);
	}

}
