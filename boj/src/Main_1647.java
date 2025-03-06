import java.io.*;
import java.util.*;

public class Main_1647 {
	static int N, M;
	static class Edge implements Comparable<Edge> {
		int s, e, w;

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
	}
	static int[][] map;

	public static void main(String[] args) throws Exception{
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
				
		/* 초기화 */
		map = new int[N+1][N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			map[s][e] = w;
			map[e][s] = w;
		}
		
		/* 로직 */
		푸는 중...
		
		/* 출력 */
		
	}

}
