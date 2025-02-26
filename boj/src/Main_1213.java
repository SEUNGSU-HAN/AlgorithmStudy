import java.util.Arrays;
import java.util.Scanner;

public class Main_1213 {
	static String str;
	static char[] cl;
	static int[] counts;
	static String[] alphabet;

	public static void main(String[] args) {
		/* 입력 */
		Scanner sc = new Scanner(System.in);
		str = sc.nextLine();
		
		/* 초기화 */
		cl = str.toCharArray();
		counts = new int['Z'-'A'];
		for (int i = 0; i < cl.length; i++) {
			counts[cl[i]-'A']++;
		}
		alphabet = new String[26];
		for (int i = 0; i < 26; i++) {
			alphabet[i] = String.valueOf((char)(65+i));
		}
		
		/* 로직 */
		하는 중... 백트래킹으로 바꿔야 할듯?
		
		/* 출력 */
		System.out.print(isPalindrome());
	}

	private static String isPalindrome() {
		String result = "I'm Sorry Hansoo";
		int oddCount = 0; //홀수개 문자가 2개 이상이면 팰린 불가능
		int idx = 0; //문자를 끼워 넣을 index 번호
		String s = ""; //팰린드롬 문자열
		for (int i = 0; i < counts.length; i++) {
			if(oddCount > 1) { //홀수 2개 이상이면 아웃
				s = "";
				break;
			}
			if(counts[i]%2 == 1) { //홀수 카운팅
				oddCount++;
			}
			if(counts[i] != 0) {
				String tmp = "";
				for (int j = 0; j < counts[i]; j++) {
					tmp += alphabet[i];
				}
				
			}
		}
		
		return result = s.equals("") ? result : s;
	}

}
