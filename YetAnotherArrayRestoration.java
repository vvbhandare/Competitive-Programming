import java.util.Scanner;

public class YetAnotherArrayRestoration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			long x = sc.nextLong();
			long y = sc.nextLong();
			solve(n, x, y);
			System.out.println();
		}
	}

	private static void solve(int n, long x, long y) {
		// TODO Auto-generated method stub
		long d = y - x, point = 0;
		for (int i  = 1; i <= d; i++) {
			if (d % i != 0) continue;
			if ((d / i) + 1 > n) continue;
			point = i;
			break;
		}
		long temp = y;
		int j = 0;
		while (temp > 0) {
			System.out.print(temp + " ");
			temp -= point;
			j++;
			if (j >= n) break;
		}
		while (j < n) {
			y += point;
			System.out.print(y + " ");
			j++;
		}
	}

}
