class NumberOfWaysToWearDifferentHatsToEachOther {
    
    public int MOD = 1000000007;
    
    public int numberWays(List<List<Integer>> hats) {
        int n = hats.size();
        int a[][] = new int[n + 1][41];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < hats.get(i).size(); j++) {
                    int id = hats.get(i).get(j);
                    a[i][id] = 1;
                }
            }
            int dp[][] = new int[1025][41];//1<<n
            for (int[] row : dp) Arrays.fill(row, -1);
        return countWays(a, n, 0, 0, dp);
    }
    
    //bitmask(i, mask)
    private int countWays(int[][] a, int n, int mask, int i, int[][] dp) {
		// TODO Auto-generated method stub
		if (mask == (1 << n) - 1) return 1;
        if (i > 40) return 0;
        if (dp[mask][i] != -1) return dp[mask][i];
        int ans = 0;
        ans = countWays(a, n, mask, i + 1, dp);
        for(int j = 0; j < n; j++) {
            if((a[j][i] == 1) && (mask & (1 << j)) == 0) {
                ans = (ans + countWays(a, n, (mask | (1 << j)), i + 1, dp)) % MOD;
            }
        }
        return dp[mask][i] = ans;
	}
}

// 00|10=>10(mask)

// n=2
//     1<<2=100=4-1=3=>11


// 1<<0=1
// 1<<10=10000000000 = 1024 

// 0000 0   0    0      0       0       0    0
// 1248 16  32   64    128     256     512  1024

// mask = setofpeoplewearinghats {1,1,1,......1}

// persons      hats
// 1           1,2
// 2           2,3,4
// 3           2
// .           
// .
// .
// .
// 10          39,40