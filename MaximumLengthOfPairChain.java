class MaximumLengthOfPairChain {
    public int findLongestChain(int[][] pairs) {
        int cur = Integer.MIN_VALUE, res = 0;
        Arrays.sort(pairs, (a, b) -> {
            return a[1] - b[1];
        });
        for(int[] pair : pairs) {
            if (cur < pair[0]) {
                cur = pair[1];
                res++;
            }
        }
        return res;
    }
}