class MinimumFallingPathSum {
    int[][] dp;
    public int minFallingPathSum(int[][] A) {
        int ans = Integer.MAX_VALUE;
        dp = new int[A.length][A.length];
        
        for(int i = 0; i < A.length; i++) {
            ans = Math.min(ans, dfs(A, 0, i));
        }
        return ans;
    }
    
    private int dfs(int[][] A, int r, int c) {
        if (r == A.length - 1) return A[r][c];
        
        if (dp[r][c] != 0) return dp[r][c];
        
        int res = Integer.MAX_VALUE;
        
        int cal = A[r][c];
        if (c - 1 >= 0) 
            res = Math.min(res, cal + dfs(A, r + 1, c - 1));
        res = Math.min(res, cal + dfs(A, r + 1, c));
        if (c + 1 < A.length) 
            res = Math.min(res, cal + dfs(A, r + 1, c + 1));
        
        return dp[r][c] = res;
    }
}