import java.util.Scanner;

public class Takoyaki {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int X = sc.nextInt();
		int T = sc.nextInt();
		solve(N, X, T);
	}

	private static void solve(int n, int x, int t) {
		// TODO Auto-generated method stub
		if (x == 1 || n == 1) System.out.println(n * t);
		else {
			int r = (n  + x - 1) / x;
			System.out.println(r * t);
		}
	}

}
