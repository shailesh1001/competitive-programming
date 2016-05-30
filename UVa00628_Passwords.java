package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 569 (628 - Passwords) */
/* SUBMISSION: 09036776 */
/* SUBMISSION TIME: 2011-07-10 18:07:20 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00628_Passwords {
	
	static List<String> dict;
	
	static void solve(String rule, String pass) {
		if (rule.isEmpty()) {
			System.out.println(pass);
			return;
		}
		
		char c = rule.charAt(0);
		String newrule = rule.substring(1, rule.length());
		if (c == '0') {
			for (char d = '0'; d <= '9'; ++d)
				solve(newrule, pass + d);
		} else {
			for (String word : dict)
				solve(newrule, pass + word);
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (in.hasNext()) {
			int n = in.nextInt();
			dict = new ArrayList<String>();
			
			for (int i = 0; i < n; ++i)
				dict.add(in.next());
			System.out.println("--");
			
			int m = in.nextInt();
			for (int i = 0; i < m; ++i) {
				String rule = in.next();
				
				solve(rule, "");
			}
		}
	}
}