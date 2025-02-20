import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main_9375 {
	static int T, N;
	static Map<String, ArrayList<String>> clothes;
	static int csize;
	static int[] cnums; //각 부위별 옷 개수
	static int result;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		
		for (int t = 0; t < T; t++) {
			/* 입력 */
			N = Integer.parseInt(br.readLine().trim());
			
			/* 초기화 */
			result = 0;
			clothes = new HashMap<>();
			for (int i = 0; i < N; i++) {
				String[] cl = br.readLine().split(" ");
				if(!clothes.containsKey(cl[1]))	clothes.put(cl[1], new ArrayList<>());
				clothes.get(cl[1]).add(cl[0]);
//				result++;
			}
			csize = clothes.size();
			cnums = new int[csize];
			int idx = 0;
			for (String s : clothes.keySet()) {
				cnums[idx++] = clothes.get(s).size();
			}
			
			/* 로직 */
//			if(csize > 1) {
//				for (int i = 2; i <= csize; i++) {
//					combi(0, 0, i, new boolean[csize], new int[i], 1);					
//				}
//			}
			for (int i = 0; i < csize; i++) {
				
			}
			
			sb.append(result).append("\n");
		}
		
		/* 출력 */
		System.out.print(sb);
	}

	private static void combi(int cnt, int start, int R, boolean[] visited, int[] choice, int tot) {
		if(cnt == R) {
			result+=tot;
			return;
		}
		for (int i = start; i < csize; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			choice[cnt] = cnums[i];
			combi(cnt+1, i+1, R, visited, choice, tot*cnums[i]);
			choice[cnt] = 0;
			visited[i] = false;
			
		}
	}

}
