class ArithmeticSubarrays {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int m = l.length;
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> ll = new ArrayList<>();
            for (int j = l[i]; j <= r[i]; j++) {
                ll.add(nums[j]);
            }
            Collections.sort(ll);
            int d = 0;
            for (int j = 1; j < ll.size(); j++) {
                if (j == 1) {
                    d = ll.get(j) - ll.get(j - 1);
                } else if (d != (ll.get(j) - ll.get(j - 1))) {
                    res.add(false);
                    break;
                }
                if (j + 1 == ll.size()) 
                    res.add(true);
            }
        }
        return res;
    }
    
}