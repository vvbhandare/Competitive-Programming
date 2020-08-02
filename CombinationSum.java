class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        Arrays.sort(candidates);
        List<List<Integer>> l = new LinkedList<>();
        dfs(candidates, n, target, 0, new ArrayList<>(), l);
        return l;
    }
    
    private void dfs(int[] candidates, int n, int left, int i, 
                     List<Integer> cur, List<List<Integer>> l) {
        if (left == 0) {
            l.add(cur);
            return;
        }
        for(int j = i; j < n; j++) {
            int t = left - candidates[j];
            if (t >= 0) {
                List<Integer> sl = new ArrayList<>(cur);
                sl.add(candidates[j]);
                dfs(candidates, n, t, j, sl, l);
            } 
        }
    }
}