package com.boj.problem.silver;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

//N과 M()
//조합 (중복 x)
public class Main_15663 {
	static int N, M;
	static Set<Integer> ts;
	static int[] p;
	static ArrayDeque<Integer>[] nums;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception{
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		/* 초기화 */
		p = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		visited = new boolean[N];
		ts = new TreeSet<>((o1, o2) -> o1 - o2);
		nums = new ArrayDeque[M];
		for (int i = 0; i < M; i++) {
			nums[i] = new ArrayDeque<>();
		}
		
		/* 로직 */
		Arrays.sort(p);
		StringBuilder sb = new StringBuilder();
		combi(0, sb);
		아직 하는 중..
		
		/* 출력 */
		System.out.print(sb);
	}

	private static void combi(int cnt, StringBuilder sb) {
		if(cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(nums[i].peekFirst()).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < p.length; i++) {
			if(visited[i]) continue;
			if(!nums[cnt].contains(p[i])) {
				nums[cnt].addLast(p[i]);
				visited[i] = true;
			}
			combi(cnt+1, sb);
			nums[cnt].poll();
			visited[i] = false;
		}
	}

}
