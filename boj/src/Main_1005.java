import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1005 {
	static int T, N, K, W, result;
	static int[] time;
	static ArrayList<Integer>[] graph;
	static int[] count; //각 노드의 진입 차수;
	static boolean[] check;
	static Queue<Integer> queue; //집입차수 0인 노드들을 담아둘 큐

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			/* 입력 */
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			/* 초기화 */
			time = new int[N+1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				time[i] = Integer.parseInt(st.nextToken());
			}
			graph = new ArrayList[N+1];
			for (int i = 0; i <= N; i++) {
				graph[i] = new ArrayList<>();
			}
			count = new int[N+1];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				graph[s].add(e);
				count[e]++;
			}
			W = Integer.parseInt(br.readLine().trim());
			check = new boolean[N+1];
			queue = new ArrayDeque<>();
			result = 0;
			
			/* 로직 */
			
			findZero();
			loop:
			while(!queue.isEmpty()) {
				int maxT = 0;
				int size = queue.size();
//				System.out.println("size: " + size);
				while(size-- > 0) {
					int v = queue.poll();
					if(v == W) {
						result += time[v];
						break loop;
					}
					maxT = Math.max(maxT, time[v]);
					int n = graph[v].size();
					for (int i = 0; i < n; i++) {
						//집입차수 제거
						count[graph[v].get(i)]--;
					}
//					System.out.println("v: " + v + ", maxT: " + maxT + ", n: " + n);
				}
				result += maxT;
//				System.out.println("result: " + result);
				findZero(); 
			}
			
			sb.append(result).append("\n");
		}
		/* 출력 */
		System.out.print(sb);		
	}

	/**
	 * 진입차수가 0인 노드의 개수를 반환.
	 * */
	static void findZero() {
		for (int i = 1; i <= N; i++) {
			if(check[i]) continue;
			if(count[i] == 0) {
				check[i] = true;
				queue.offer(i);
			}
		}
	}

}
