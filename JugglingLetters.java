import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class JugglingLetters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			List<String> l = new ArrayList<String>();
			int sum = 0;
			for (int i = 0; i < n; i++) {
				String s = sc.next();
				l.add(s);
				sum += s.length();
			}
			if (sum > 1000) System.out.println("NO");
			else solve(l, n);
		}
	}

	private static void solve(List<String> l, int n) {
		// TODO Auto-generated method stub
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (String s : l) {
			for (char c : s.toCharArray()) {
				map.put(c, map.getOrDefault(c, 0) + 1);
			}
		}
		for (char c : map.keySet()) {
			if (map.get(c) % n != 0) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}

}
