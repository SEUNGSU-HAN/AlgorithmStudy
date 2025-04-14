import java.io.*;
import java.util.*;

public class Main_7432 {
	static int N;
	static class TrieNode {
		Map<String, TrieNode> childern;
		boolean isEndOfPath;
		
		public TrieNode() {
			childern = new HashMap<>();
			isEndOfPath = false;
		}
	}
	
	static class Trie {
		TrieNode root;
		
		public Trie() {
			root = new TrieNode();
		}
		
		public void insert(String path) {
			TrieNode cur = root;
			
			for (int i = 0; i < path.length(); i++) {
				String c = String.valueOf(path.charAt(i));
				
				if(!cur.childern.containsKey(c)) {
					cur.childern.put(c, new TrieNode());
				}
				
				cur = cur.childern.get(c);
			}
			
			cur.isEndOfPath = true;
		}
		
		public boolean search(String path) {
			TrieNode cur = root;
			
			for (int i = 0; i < path.length(); i++) {
				String c = String.valueOf(path.charAt(i));
				
				if(!cur.childern.containsKey(c)) return false;
				
				cur = cur.childern.get(c);
			}
			
			return cur.isEndOfPath;
		}
	}
	static Trie trie;

	public static void main(String[] args) throws Exception{
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		
		/* 초기화 */
		trie = new Trie();
		
		/* 로직 */
		for (int i = 0; i < N; i++) {
			String path = br.readLine().trim();
			if(!trie.search(path)) trie.insert(path);
		}
		
		
		/* 출력 */
		
		
	}
	

}
