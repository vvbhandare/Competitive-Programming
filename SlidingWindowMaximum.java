class SlidingWindowMaximum {
    
    int[][] sparse;
    
    //matrix of size = nums.length x log(nums.length)
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n = nums.length;
        int c = log(n) + 1;
        sparse = precompute(nums, n, c, k);

        int[] ans = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) 
            ans[i] = query(i, i + k - 1);
        
        return ans;
        
    }
    
    //j=2 2^2=4
    //2^1+2^1=2+2=4
    
    public int[][] precompute(int[] nums, int n, int c, int k) {
        int sparse[][] = new int[n][c];
        
        for (int i = 0; i < n; i++) 
            sparse[i][0] = nums[i];
        
        // (1 << j) = Math.pow(2, j)
        // j = 2 -> 2^2 = 4 -> 2^1 + 2^1 = 2 + 2 = 4
        for (int j = 1; (1 << j) <= n; j++) {
            for (int i = 0; i + (1 << j) - 1 < n; i++) {
                sparse[i][j] = Math.max(sparse[i][j - 1], 
                                sparse[i + (1 << (j - 1))][j - 1]);
            }
        }
        return sparse;
    }
    
    public int query(int low, int high) {
        int l = high - low + 1;
        int k = log(l);
        return Math.max(sparse[low][k], 
                       sparse[low + l - (1 << k)][k]);
    }
    
    public int log(int n){
        return (int) (Math.log(n) / Math.log(2));
    }
}