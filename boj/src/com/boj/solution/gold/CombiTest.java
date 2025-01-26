package com.boj.solution.gold;

import java.util.Arrays;

public class CombiTest {
	static int[] p = {1, 2, 3, 4, 5};
	static int N, R;
	static int count;
	static int[] nums;
	static boolean[] visited;

	public static void main(String[] args) {
		N = p.length;
		R = 3;
		count = 0;
		nums = new int[R];
		visited = new boolean[N];
		combi(0, 0, 0, 1);
		System.out.println(count);
	}

	private static void combi(int cnt, int start, int tot, int mul) {
		if(cnt == R) {
			count++;
			System.out.println(tot);
			System.out.println(mul);
			System.out.println(Arrays.toString(nums));
			for (int i = 0; i < N; i++) {
				if(visited[i]) System.out.print(p[i]+ " ");
			}
			System.out.println();
			System.out.println("-------------------");
			return;
		}
		for (int i = 0; i < N; i++) {
//			if(visited[i]) continue;
			visited[i] = true;
			nums[cnt] = p[i];
			combi(cnt+1, i+1, tot+p[i], mul*p[i]);
			nums[cnt] = 0;
			visited[cnt] = false;
		}
	}

}
