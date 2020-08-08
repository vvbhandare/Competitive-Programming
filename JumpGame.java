class JumpGame {
    int memo[];
    public boolean canJump(int[] nums) {
        int n = nums.length;
        memo = new int[n];
        Arrays.fill(memo, -1);
        return dfs(nums, n, 0);
    }
    
    private boolean dfs(int[] nums, int n, int i) {
        if (i >= n - 1) return true;
        int v = nums[i];
        if (v == 0) return false;
        if (memo[i] != -1) return memo[i] == 0 ? false : true;
        boolean b = false;
        for(int j = 1; j <= v; j++) {
            b = b || dfs(nums, n, j + i);
            memo[i] = b ? 1 : 0;
            if (b) break;
        }
        return b;
    }
}