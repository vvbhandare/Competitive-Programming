import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SumOfProductOfPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long a[] = new long[n];
		for (int i = 0; i < n; i++) a[i] = sc.nextLong();
		solve(a, n);
	}

	private static void solve(long[] a, int n) {
		// TODO Auto-generated method stub
		long ans = 0, sum = 0, mod = 1_000_000_007;
		for (int i = 0; i < n; i++) {
			ans = (ans + a[i] * sum) % mod;
			sum = (sum + a[i]) % mod;
		}
		System.out.println(ans);
	}

}
