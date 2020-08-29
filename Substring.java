import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Substring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		String T = sc.next();
		solve(S, T);
	}

	private static void solve(String s, String t) {
		// TODO Auto-generated method stub
		int n = t.length(), l = s.length();
		List<String> subs = new ArrayList<String>();
		for (int i = 0; i <= l - n; i++) {
			subs.add(s.substring(i, i + n));
		}
//		System.out.println(subs.toString());
		int gm = Integer.MAX_VALUE;
		for (String ss : subs) {
			int lm = 0;
			for (int i = 0; i < ss.length(); i++) {
				if (ss.equals(t)) {
					System.out.println(0);
					return;
				} else if (ss.charAt(i) != t.charAt(i)) {
					lm++;
				}
			}
			gm = Math.min(gm, lm);
		}
		System.out.println(gm);
	}

}
