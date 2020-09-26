import java.util.Scanner;

public class Grid1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int w = sc.nextInt();
		char[][] G = new char[h][w];
		for (int i = 0; i < h; i++) {
			String s  = sc.next();
			for (int j = 0; j < w; j++) 
				G[i][j] = s.charAt(j);
		}
		dp(G, h, w);
	}

	private static void dp(char[][] G, int h, int w) {
		// TODO Auto-generated method stub
		int[][] dp = new int[h][w];
		int MOD = (int) (1e9 + 7);
		dp[0][0] = 1;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (G[i][j] == '#') {
					dp[i][j] = 0;
					continue;
				}
				if (i > 0) 
					dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD;
				if (j > 0) 
					dp[i][j] = (dp[i][j] + dp[i][j - 1]) % MOD;
			}
		}
		System.out.println(dp[h - 1][w - 1]);
	}

}
