import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SubstringRemovalGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			String s = sc.next();
			extract1s(s, s.length());
		}
	}

	private static void extract1s(String s, int n) {
		// TODO Auto-generated method stub
		List<Integer> l = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '1') {
				int a = i;
				int j = i + 1;
				for (; j < n; j++) {
					if (s.charAt(j) == '0') {
						break;
					}
				}
				if (j - a > 0) {
					l.add(j - a);
					i = j;
				}
		}
	}
	solve(l);
}

private static void solve(List<Integer> l) {
	// TODO Auto-generated method stub
	Collections.sort(l, (a, b) -> {return b - a;});
	int n = l.size(), alice = 0;
	for (int i = 0; i < n; i++) 
		if (i % 2 == 0) alice += l.get(i);
	System.out.println(alice);
}

}
