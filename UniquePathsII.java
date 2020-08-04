class UniquePathsII {
    int[][] memo;
    public int uniquePathsWithObstacles(int[][] G) {
        int m = G.length;
        int n = G[0].length;
        memo = new int[m][n];
        return dfs(G, 0, 0, m, n);
    }
    
    private int dfs(int[][] G, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n) return 0;
        if (i == m - 1 && j == n - 1) {
            // System.out.println(i + " " + j);
            if (G[i][j] == 1) return 0;
            return 1;
        }
        if (G[i][j] == 1) return 0;
        if (memo[i][j] != 0) return memo[i][j];
        memo[i][j] = dfs(G, i, j + 1, m, n) 
            + dfs(G, i + 1, j, m, n);
        return memo[i][j];
    }
}