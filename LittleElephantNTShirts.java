import java.util.Arrays;
import java.util.Scanner;

public class LittleElephantNTShirts {

	private static final int MOD = (int) (1e9 + 7);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int pt[][] = new int[n + 1][101];
            for(int i = 0; i < n; i++) {
            	String S = sc.next();
            	S += sc.nextLine();
                String arr[] = S.split(" ");
                for(int j = 0; j < arr.length; j++) {
                    int id = Integer.parseInt(arr[j]);
                    pt[i][id] = 1;
                }
            }
            long dp[][] = new long[1025][101];
            for (long[] row : dp) Arrays.fill(row, -1);
            
            System.out.println(countWays(pt, n, 0, 0, dp) % MOD);
        }
	}

	private static long countWays(int[][] pt, int n, int mask, int i, long[][] dp) {
		// TODO Auto-generated method stub
		if (mask == (1 << n) - 1) return 1;
        if (i > 100) return 0;
        if (dp[mask][i] != -1) return dp[mask][i];
        long ans = 0;
        ans = countWays(pt, n, mask, i + 1, dp);
        for(int j = 0; j < n; j++) { 
            if((pt[j][i] == 1) && (mask & (1 << j)) == 0) {
                ans = (ans + countWays(pt, n, (mask | (1 << j)), i + 1, dp)) % MOD;
            }
        }
        return dp[mask][i] = ans;
	}

}
