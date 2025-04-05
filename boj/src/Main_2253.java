import java.io.*;
import java.util.*;

public class Main_2253 {
	static final int INF = Integer.MAX_VALUE;
	static int N, M;
	static int[] d = {-1, 0, 1};
	static class Pos implements Comparable<Pos> {
		int pos, x, count;

		public Pos(int pos, int x, int count) {
			this.pos = pos;
			this.x = x;
			this.count = count;
		}

		@Override
		public int compareTo(Pos o) {
			return this.count == o.count ? -Integer.compare(this.pos, o.pos) : Integer.compare(this.count, o.count);
		}
	}
	static int[] jump;
	
	public static void main(String[] args) throws Exception{
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		/* 초기화 */
		jump = new int[N+1];
		Arrays.fill(jump, INF);
		for (int i = 0; i < M; i++) {
			int n = Integer.parseInt(br.readLine().trim());
			jump[n] = -1;
		}
		jump[0] = jump[1] = 0;		
		
		/* 로직 */
		PriorityQueue<Pos> q = new PriorityQueue<>();
		q.offer(new Pos(1, 0, 0));
		while(!q.isEmpty()) {
			Pos cur = q.poll();
			for (int i = (cur.x == 0 ? 2 : (cur.x == 1 ? 1 : 0)); i < 3; i++) {
				int nx = cur.x+d[i];
				int npos = cur.pos+nx;
				if(npos > N || jump[npos] == -1) continue;
				if(npos == N) {
					System.out.print(cur.count+1);
					return;
				}
				q.offer(new Pos(npos, nx, cur.count+1));
			}
		}
		
		
		/* 출력 */
		System.out.print(-1);
	}

}
