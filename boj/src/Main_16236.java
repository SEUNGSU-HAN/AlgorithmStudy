import java.io.*;
import java.util.*;

public class Main_16236 {
	static int N;
	static int eat, move; //아기 상어가 먹은 물고기 수, 이동 시간
	static int[][] board;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static class Fish implements Comparable<Fish>{
		int r, c, size;
		int distance;
		
		Fish(int r, int c, int size) {
			this.r = r;
			this.c = c;
			this.size = size;
		}
		
		@Override
		public int compareTo(Fish f) {
			return Integer.compare(this.size, f.size);
		}

		@Override
		public String toString() {
			return "Fish [r=" + r + ", c=" + c + ", size=" + size + ", distance=" + distance + "]";
		}
		
	}
	static class FishComparator implements Comparator<Fish> {

		@Override
		public int compare(Fish f1, Fish f2) {
			if(f1.distance == f2.distance) {
				if(f1.r == f2.r) {
					return Integer.compare(f1.c, f2.c);
				}else return Integer.compare(f1.r, f2.r);
			}
			return Integer.compare(f1.distance, f2.distance);
		}
		
	}
	
	static Fish shark;
	static PriorityQueue<Fish> feeds;
	static PriorityQueue<Fish> fd;
	static boolean cantEat;

	public static void main(String[] args) throws Exception{
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		/* 초기화 */
		board = new int[N][N];
		feeds = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 9) shark = new Fish(i, j, 2);
				//우선은 사이즈 순으로 정렬 삽입
				else if(board[i][j] > 0) feeds.offer(new Fish(i, j, board[i][j]));
			}
		}
		//실시간 먹을 수 있는 먹이들 (Comparator를 구현해 거리, r값, c값으로 우선순위결정)
		fd = new PriorityQueue<>(1, new FishComparator());
		
		System.out.println("shark: " + shark);
				
		/* 로직 */
		//먹이를 정렬해놓고 하나씩 빼먹으며 위치 파악
		while(true) {
			//우선순위 큐를 배열로 바꾸면 우선순위가 보장이 안됨;;
			//그래서 리스트에 못먹은 애들 담아뒀다가 다시 옮길 예정
			LinkedList<Fish> fl = new LinkedList<>();
			
			//상어 위치에 따라 현재 먹을 수 있는 먹이들 거리 없뎃
			int n = fd.size();
			for (int i = 0; i < n; i++) {
				Fish f = fd.poll();
				f.distance = getDistance(f, shark);
				System.out.println("a(r,c): (" + f.r + ", " + f.c + ") / dis: " + f.distance);
				fl.add(f);
			}		
			
			//1. 현재 상어 크기 기준에서 먹을 수 있는 먹이 집어넣기
			//(단, 삽입 시 현재 상어와의 거리 계산 후 삽입)
			while(feeds.peek() != null && feeds.peek().size < shark.size) {
				feeds.peek().distance = getDistance(feeds.peek(), shark);
				System.out.println("b(r,c): (" + feeds.peek().r + ", " + feeds.peek().c + ") / dis: " + feeds.peek().distance);
				fl.add(feeds.poll());
			}
			
			
			//먹을 수 있는 먹이가 없다면 엄마 호출(end)
			if(fl.size() == 0) break;
			
			//2. 우선순위가 가장 높은 먹이에게로 이동해 먹기!
			//우선 순위 정렬
			for (Fish f : fl) {
				if(f != null) fd.add(f);
			}
			
			fl = new LinkedList<>();
			//정렬 후 다시 이동(탐색 용)
			while(!fd.isEmpty()) {
				fl.add(fd.poll());
			}
			for (int i = 0; i < fl.size(); i++) {
				System.out.println(fl.get(i));
				fd.offer(fl.get(i));
			}
			System.out.println("shark: " + shark.r + ", " + shark.c);
			fl = new LinkedList<>();
			
			
			boolean isEat = false; //먹었니~?
			while(!fd.isEmpty()) {
				Fish f = fd.poll();
				System.out.println("f: " + f);
				if(bfs(new int[] {shark.r, shark.c, 0}, getVisited(), f)) {
					fl.remove(f);
					isEat = true;
					print();
					break;
				}
				//못 먹은 애들 담아뒀다 다시 먹이 판별하기
				fl.add(f);
			}
			
			//못먹은 애들 다시 먹이 후보에 넣기
			for (Fish f : fl) {
				fd.add(f);
			}
			System.out.println("isEat: " + isEat + ", fd size: " + fd.size() + ", feeds size: " + feeds.size());
			fl = null;
			
			//가까운 먹이 다 탐색 했는데 먹을 수 없을 경우
			if(!isEat) break;
			
		}
		
		/* 출력 */
		System.out.print(move);
		
	}
	static boolean bfs(int[] start, boolean[][] visited, Fish f) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(start);
		visited[start[0]][start[1]] = true;
		boolean isEat = false;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			if(cur[0] == f.r && cur[1] == f.c) {
				isEat = true;
				//상어 움직임 증가
				move += cur[2];
				System.out.println("cur[2]: " + cur[2] + ", move: " + move);
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nr = cur[0]+dr[i];
				int nc = cur[1]+dc[i];
				if(check(nr, nc) && !visited[nr][nc]) {
					q.offer(new int[] {nr, nc, cur[2]+1});
					visited[nr][nc] = true;
				}
			}
		}
		
		if(isEat) {
			//보드판 갱신
			board[start[0]][start[1]] = 0;
			board[f.r][f.c]= 0; 
			//상어 위치 이동
			shark.r = f.r;
			shark.c = f.c;
			//상어가 먹은 먹이 수 증가
			eat++;
			if(eat == shark.size) {
				//먹은 수가 같으면 상어 크기 진화!
				shark.size++;
				eat = 0;
			}
		}
		
		System.out.println("eat: " + eat + ", shark_size: " + shark.size);
		
		return isEat;
	}
	
	static void print() {
		System.out.println("==============");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	static boolean[][] getVisited(){
		boolean[][] visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(board[i][j] > shark.size) visited[i][j] = true;
			}
		}
		return visited;
	}

	static boolean check(int nr, int nc) {
		return (0 <= nr && nr < N) && (0 <= nc && nc < N);
	}

	//맨하탄 거리 사용
	static int getDistance(Fish f1, Fish f2) {
		int dy = Math.abs(f2.r - f1.r);
		int dx = Math.abs(f2.c - f1.c);
		return dy+dx;
	}

}
