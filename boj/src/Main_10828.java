import java.io.*;
import java.util.*;

public class Main_10828 {
	static int N;
	static ArrayList<Integer> stack;

	public static void main(String[] args) throws Exception{
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		/* 초기화 */
		stack = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		
		/* 로직 */
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			String command = input[0];
			int num = 0;
			if(input.length > 1) {
				num = Integer.parseInt(input[1]);
			}
			switch (command) {
			case "push" -> stack.add(num);
			case "pop" -> sb.append(stack.isEmpty() ? -1 : stack.removeLast());
			case "size" -> sb.append(stack.size());
			case "empty" -> sb.append(stack.isEmpty() ? 1 : 0);
			case "top" -> sb.append(stack.isEmpty() ? -1 : stack.getLast());
			}
			sb.append("\n");
		}
		
		/* 출력 */
		System.out.print(sb);
	}

}
