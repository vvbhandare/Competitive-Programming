class SpecialArrayWithXElementsGreaterThanOrEqualX {
    public int specialArray(int[] nums) {
        int n = nums.length;
        for (int i = 0; i <= n; i++) {
            int c = 0;
            for (int j : nums) if (j >= i) c++;
            if (i == c) return i;
        }
        return -1;
    }
}

// [0, 0] n = 2

// i = 0 c = 2
    
// i = 1 c = 2    
    
// i = 2 c = 2    
    
    