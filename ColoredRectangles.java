import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ColoredRectangles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int G = sc.nextInt();
		int B = sc.nextInt();
		int[] r = new int[R];
		for (int i = 0; i < R; i++) r[i] = sc.nextInt();
		int[] g = new int[G];
		for (int i = 0; i < G; i++) g[i] = sc.nextInt();
		int[] b = new int[B];
		for (int i = 0; i < B; i++) b[i] = sc.nextInt();
		solve(r, g, b, R, G, B);
	}

	static int[][][] dp = new int[201][201][201];
	private static void solve(int[] r, int[] g, int[] b, int R, int G, int B) {
		// TODO Auto-generated method stub
		Arrays.sort(r);
		Arrays.sort(g);
		Arrays.sort(b);
		for (int i = R; i >= 0; i--) {
			for (int j = G; j >= 0; j--) {
				for (int k = B; k >= 0; k--) {
					if (i > 0 && j > 0)
						dp[i - 1][j - 1][k] = Math.max(dp[i - 1][j - 1][k], dp[i][j][k] + r[i - 1] * g[j - 1]);
					if (i > 0 && k > 0)
						dp[i - 1][j][k - 1] = Math.max(dp[i - 1][j][k - 1], dp[i][j][k] + r[i - 1] * b[k - 1]);
					if (j > 0 && k > 0)
						dp[i][j - 1][k - 1] = Math.max(dp[i][j - 1][k - 1], dp[i][j][k] + g[j - 1] * b[k - 1]);
				}
			}
		}
		int ans = 0;
		for (int i = 0; i <= R; i++)
			for (int j = 0; j <= G; j++)
				for (int k = 0; k <= B; k++)
					ans = Math.max(ans, dp[i][j][k]);
		System.out.println(ans);
	}

}
