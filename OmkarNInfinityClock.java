import java.util.Arrays;
import java.util.Scanner;

public class OmkarNInfinityClock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			long k = sc.nextLong();
			long[] arr = new long[n];
			long d = Long.MIN_VALUE, m = Long.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextLong();
				d = Math.max(d, arr[i]);
				m = Math.min(m, arr[i]);
			}
			solve(arr, n, k, d, m);
		}
	}

	private static void solve(long[] arr, int n, long k, long d, long m) {
		// TODO Auto-generated method stub
		int loop = k % 2 != 0 ? 1 : 2;
		for (int j = 0; j < loop; j++) {
			long max = Long.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				arr[i] = d - arr[i];
				if (arr[i] > max) max = arr[i];
				if (j + 1 == loop) 
					System.out.print(arr[i] + " ");
			}
			d = max;
			System.out.println();
		}
//		System.out.println(Arrays.toString(arr).replace(",", "").replace("[", "").replace("]", "").trim());
	}

}

