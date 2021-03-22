import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MaximumWidth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		String s = sc.next();
		String t = sc.next();

		if (n == m) System.out.println(1);
		else System.out.println(solve(n, m, s.toCharArray(), t.toCharArray()));
	}

	private static int solve(int n, int m, char[] s, char[] t) {
		// TODO Auto-generated method stub
		int[] S = new int[m];
		for (int i = 0, j = 0; i < n; i++) {
			if (s[i] == t[j]) S[j++] = i;
			if (j >= m) break;
		}
		int[] E = new int[m];
		for (int i = n - 1, j = m - 1; i >= 0; i--) {
			if (s[i] == t[j]) E[j--] = i;
			if (j == 0) break;
		}
		int res = 0;
		for (int i = 1; i < t.length; i++) res = Math.max(res, E[i] - S[i - 1]);
		return res;
	}

}

//11 3
//abcamnbcjkc
//abc
//[0, 1, 2]
//[0, 6, 10]
//9
