class MinimumNumberOfDaysToEatNOranges {
    public int minDays(int n) {
        return dfs(n);
    }
    
    Map<Integer, Integer> memo = new HashMap<>();
    
    private int dfs(int n) { 
        if (n <= 1) return n;
        
        if (!memo.containsKey(n)) {
            memo.put(n, 1 + Math.min(n%3 + dfs(n/3), n%2 + dfs(n/2)));
        }
        
        return memo.get(n);
    }
}