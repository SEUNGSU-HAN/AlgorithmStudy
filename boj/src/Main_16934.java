import java.io.*;
import java.util.*;

public class Main_16934 {
	static int N;
	static class TrieNode {
		Map<Character, TrieNode> children;
		int isEndOfWord;
		
		public TrieNode() {
			children = new TreeMap<>();
			isEndOfWord = 0;
		}
	}
	static class Trie {
		TrieNode root;
		
		public Trie() {
			root = new TrieNode();
		}
		
		public void insert(String word) {
			TrieNode cur = root;
			
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				
				if(cur.children.get(c) == null)
					cur.children.put(c, new TrieNode());
				
				cur = cur.children.get(c);
			}
			
			cur.isEndOfWord++;
			System.out.println("word: " + word + ", isEndOfWord: " + cur.isEndOfWord);
		}
		
		public int search(String word) {
			TrieNode cur = root;
			
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				
				if(cur.children.get(c) == null) return i+1;
				
				cur = cur.children.get(c);
			}
			
			return word.length();
		}
		
		public String print() {
			StringBuilder sb = new StringBuilder();
			printHelper(root, sb);
			return sb.toString();
		}

		void printHelper(TrieNode cur, StringBuilder sb) {
			for (TrieNode next : cur.children.values()) {
				TrieNode next = cur.children[i];
				if(next == null) continue;
				
				String s = String.valueOf((char)('a'+i));
				System.out.println("s: " + s + ", isEnd: " + next.isEndOfWord);
				sb.append(s);
				if(next.isEndOfWord > 0) {
					if(next.isEndOfWord > 1)
						sb.append(next.isEndOfWord);
					sb.append("\n");
				}
				
				printHelper(next, sb);
			}
		}
	}
	static Trie nick, alias;
	
	public static void main(String[] args) throws Exception{
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		
		/* 초기화 */
		nick = new Trie();
		alias = new Trie();
		
		/* 로직 */
		for (int i = 0; i < N; i++) {
			StringBuilder sb = new StringBuilder();
			String w = br.readLine().trim();
			System.out.println("w: " + w);
			sb.append(w);
			int idx = nick.search(w);
			nick.insert(w);
			alias.insert(sb.substring(0, idx));
			
		}
		
		/* 출력 */
		System.out.print(alias.print());
	}

}
