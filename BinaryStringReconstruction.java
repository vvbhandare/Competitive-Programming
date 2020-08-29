import java.util.Arrays;
import java.util.Scanner;

public class BinaryStringReconstruction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			String s = sc.next();
			int x = sc.nextInt();
			solve(s, x);
		}
	}

	private static void solve(String S, int x) {
		// TODO Auto-generated method stub
		char s[] = S.toCharArray();
		int n = S.length();
		char ans[] = new char[n];
		Arrays.fill(ans, '1');
		for (int i = 0; i < n; i++) {
			if (s[i] == '0') {
				if (isInBounds(i - x, n)) ans[i - x] = '0';
				if (isInBounds(i + x, n)) ans[i + x] = '0';
			}
		}
		boolean res = true;
		for (int i = 0; i < n; i++) { 
			if (s[i] == '1') 
				res &= ((isInBounds(i - x, n) && ans[i - x] == '1') 
					|| (isInBounds(i + x, n) && ans[i + x] == '1'));
		}
		if (res) System.out.println(ans);
		else System.out.println(-1);
	}

	private static boolean isInBounds(int x, int n) {
		return x >= 0 && x < n;
	}
}
