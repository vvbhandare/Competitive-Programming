import java.util.Scanner;

public class Step {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] hts = new long[n];
		for (int i = 0; i < n; i++) hts[i] = sc.nextLong();
		solve(hts, n);
	}

	private static void solve(long[] hts, int n) {
		// TODO Auto-generated method stub
		long rht = 0, lm = hts[0];
		for (int i = 1; i < n; i++) {
			lm = Math.max(lm, hts[i]);
			if (hts[i] < lm) {
				rht += lm - hts[i];
			}
		}
		System.out.println(rht);
	}

}
