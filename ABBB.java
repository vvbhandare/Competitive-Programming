import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class ABBB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			String s = sc.next();
			long s1 = new ABBB().solve(s);
			System.out.println(s1);
		}
	}

	private long solve(String s) {
		// TODO Auto-generated method stub
		Stack<Character> st = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == 'B') {
				if (!st.isEmpty()) {
					st.pop();
				} else st.push(c);
			} else st.push(c);
		}
		return st.size();
	}

}
