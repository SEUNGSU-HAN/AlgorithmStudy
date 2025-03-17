import java.io.*;
import java.util.*;

public class Main_1938 {
	static int N, count, set; //set: 현재 기차 상태(0=가로, 1=세로)
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static char[][] board;
	static class Train {
		int r, c;

		public Train(int r, int c) {
			this.r = r;
			this.c = c;
		}		
	}
	static ArrayList<Train>	trains;
	static ArrayList<int[]> endPoints;

	public static void main(String[] args) throws Exception{
		//--------------솔루션 코드를 작성하세요.--------------------------------
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine().trim());
		
		/* 초기화 */
		board = new char[N][N];
		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}
		trains = new ArrayList<>();
		endPoints = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(board[i][j] == 'B') trains.add(new Train(i, j));
				if(board[i][j] == 'E') endPoints.add(new int[] {i, j});
			}
		}
		
		/* 로직 */
		//현재 기차가 어떤 상태인지 파악 (가로 or 세로)
		set = checkTrain() ? 0 : 1;
		//예제 통과용 입력 문자열
		char[] cl = {'R', 'R', 'D', 'D', 'R', 'T', 'D', 'L', 'L'};
		for (char c : cl) {
			//기차 이동(이동 명령어)
			if(moveTrain(c)) count++;
//			printBoard();
		}
		
		/* 츨력 */
		System.out.print(count);
	}

	/**
	 * 보드 출력용
	 * */
	static void printBoard() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	static boolean moveTrain(char c) {
		if(set == 1) {
			if(c == 'U') {
				//위에 나무가 있는지 체크
				for (Train t : trains) {
					int nr = t.r+dr[0];
					if(nr >= 0 && board[nr][t.c] == '1') {
						return false;
					}
				}
				//나무가 없다면 이동
				for (Train t : trains) {
					int nr = t.r+dr[0];
					board[t.r][t.c] = '0';
					board[nr][t.c] = 'B'; 
					t.r = nr;
				}
			} else if(c == 'D') {
				//아래에 나무가 있는지 체크
				for (Train t : trains) {
					int nr = t.r+dr[2];
					if(nr < N && board[nr][t.c] == '1') {
						return false;
					}
				}
				//나무가 없다면 이동
				for (int i = 2; i >= 0; i--) {
					int nr = trains.get(i).r+dr[2];
					board[trains.get(i).r][trains.get(i).c] = '0';
					board[nr][trains.get(i).c] = 'B'; 
					trains.get(i).r = nr;
				}

			}else if(c == 'L') {
				//왼쪽에 나무가 있는지 체크
				for (Train t : trains) {
					int nc = t.c+dc[3];
					if(nc >= 0 && board[t.r][nc] == '1') {
						return false;
					}
				}
				//나무가 없다면 이동
				for (Train t : trains) {
					int nc = t.c+dc[3];
					board[t.r][t.c] = '0';
					board[t.r][nc] = 'B'; 
					t.c = nc;
				}
			}else if(c == 'R') {
				//오른쪽에 나무가 있는지 체크
				for (Train t : trains) {
					int nc = t.c+dc[1];
					if(nc < N && board[t.r][nc] == '1') {
						return false;
					}
				}
				//나무가 없다면 이동
				for (Train t : trains) {
					int nc = t.c+dc[1];
					board[t.r][t.c] = '0';
					board[t.r][nc] = 'B'; 
					t.c = nc;
				}
			}else {
				//좌,우에 나무가 있는지 체크
				for (Train t : trains) {
					for (int i = 1; i < 4; i+=2) {
						int nc = t.c+dc[i];
						if(nc >= 0 && nc < N && board[t.r][nc] == '1') {
							return false;
						}
					}
				}
				//나무가 없다면 돌려
				//보드 갱신 및 기차 값 수정
				board[trains.get(0).r][trains.get(0).c] = '0';
				trains.get(0).r += dr[2];
				trains.get(0).c += dc[1];
				board[trains.get(0).r][trains.get(0).c] = 'B';
				board[trains.get(2).r][trains.get(2).c] = '0';
				trains.get(2).r += dr[0];
				trains.get(2).c += dc[3];
				board[trains.get(2).r][trains.get(2).c] = 'B';
				//열 기준 정렬
				Collections.sort(trains, (t1, t2) -> Integer.compare(t1.c, t2.c));
				//나무 상태 갱신
				set = 0;
			}
		}else {//가로 상태
			if(c == 'U') {
				//위에 나무가 있는지 체크
				for (Train t : trains) {
					int nr = t.r+dr[0];
					if(nr >= 0 && board[nr][t.c] == '1') {
						return false;
					}
				}
				//나무가 없다면 이동
				for (Train t : trains) {
					int nr = t.r+dr[0];
					board[t.r][t.c] = '0';
					board[nr][t.c] = 'B'; 
					t.r = nr;
				}
			} else if(c == 'D') {
				//아래에 나무가 있는지 체크
				for (Train t : trains) {
					int nr = t.r+dr[2];
					if(nr < N && board[nr][t.c] == '1') {
						return false;
					}
				}
				//나무가 없다면 이동
				for (Train t : trains) {
					int nr = t.r+dr[2];
					board[t.r][t.c] = '0';
					board[nr][t.c] = 'B'; 
					t.r = nr;
				}
			}else if(c == 'L') {
				//왼쪽에 나무가 있는지 체크
				for (Train t : trains) {
					int nc = t.c+dc[3];
					if(nc >= 0 && board[t.r][nc] == '1') {
						return false;
					}
				}
				//나무가 없다면 이동
				for (Train t : trains) {
					int nc = t.c+dc[3];
					board[t.r][t.c] = '0';
					board[t.r][nc] = 'B'; 
					t.c = nc;
				}
			}else if(c == 'R') {
				//오른쪽에 나무가 있는지 체크
				for (Train t : trains) {
					int nc = t.c+dc[1];
					if(nc < N && board[t.r][nc] == '1') {
						return false;
					}
				}
				//나무가 없다면 이동
				for (int i = 2; i >= 0; i++) {
					int nc = trains.get(i).c+dc[1];
					board[trains.get(i).r][trains.get(i).c] = '0';
					board[trains.get(i).r][nc] = 'B'; 
					trains.get(i).c = nc;
				}
			}else {
				//상,하에 나무가 있는지 체크
				for (Train t : trains) {
					for (int i = 0; i < 4; i+=2) {
						int nr = t.r+dr[i];
						if(nr >= 0 && nr < N && board[nr][t.c] == '1') {
							return false;
						}
					}
				}
				//나무가 없다면 돌려
				//보드 갱신 및 기차 값 수정
				board[trains.get(0).r][trains.get(0).c] = '0';
				trains.get(0).r += dr[0];
				trains.get(0).c += dc[1];
				board[trains.get(0).r][trains.get(0).c] = 'B';
				board[trains.get(2).r][trains.get(2).c] = '0';
				trains.get(2).r += dr[2];
				trains.get(2).c += dc[3];
				board[trains.get(2).r][trains.get(2).c] = 'B';
				//행 기준 정렬
				Collections.sort(trains, (t1, t2) -> Integer.compare(t1.r, t2.r));
				//나무 상태 갱신
				set = 1;
			}
		}
		return true;
	}

	static boolean checkTrain() {
		//서로 같은 행이면 가로 상태(return true)
		int r = trains.get(0).r;
		for (int i = 1; i < 3; i++) {
			//서로 같은 행이 아니면 세로 상태(return false)
			if(r != trains.get(i).r) {
				//열 값 기준으로 정렬
				Collections.sort(trains, (t1, t2) -> Integer.compare(t1.r, t2.r));
				return false;
			}
		}
		//행 값 기준으로 정렬
		Collections.sort(trains, (t1, t2) -> Integer.compare(t1.c, t2.c));
		return false;
	}

}
