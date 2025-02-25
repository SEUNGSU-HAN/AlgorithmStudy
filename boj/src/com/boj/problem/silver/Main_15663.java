package com.boj.problem.silver;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//N과 M()
//조합 (중복 x)
public class Main_15663 {
	static int N, M;
	static int[] p, nums;
	static ArrayList<Integer>[] result;
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
		int max = 0;
		for (int i = 0; i < N; i++) {
			p[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, p[i]);
		}
		visited = new boolean[N];
		nums = new int[M];
		result = new ArrayList[max+1];
		for (int i = 0; i <= max; i++) {
			result[i] = new ArrayList<>();
		}
		
		/* 로직 */
		Arrays.sort(p);
		perm(0);
		하는중...
		
		/* 출력 */
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= max; i++) {
			if(result[i].size() != 0) {
				for (int j = 0; j < result[i].size(); j++) {
					sb.append(i).append(" ").append(result[i].get(j)).append("\n");
				}
			}
		}
		System.out.print(sb);
	}

	private static void perm(int cnt) {
		if(cnt == M) {
			for (int i = 1; i < M; i++) {
				if(!result[nums[0]].contains(nums[i])) result[nums[0]].add(nums[i]);				
			}
			return;
		}
		for (int i = 0; i < p.length; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			nums[cnt] = p[i];
			perm(cnt+1);
			nums[cnt] = 0;
			visited[i] = false;
		}
	}

}
