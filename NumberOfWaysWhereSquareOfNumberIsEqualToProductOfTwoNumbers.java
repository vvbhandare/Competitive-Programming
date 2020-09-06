class NumberOfWaysWhereSquareOfNumberIsEqualToProductOfTwoNumbers {
    public int numTriplets(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int ans = 0;
        int n1 = nums1.length, n2 = nums2.length;
        Map<Long, Integer> S1 = new HashMap<>();
        Map<Long, Integer> S2 = new HashMap<>();
        
        for (int i = 0; i < n1; i++) {
            long s1 = ((long)nums1[i] * (long)nums1[i]);
            S1.put(s1, S1.getOrDefault(s1, 0) + 1);
        }
        // System.out.println("S1 = " + S1);
        
        for (int i = 0; i < n2; i++) {
            long s2 = ((long)nums2[i] * (long)nums2[i]);
            S2.put(s2, S2.getOrDefault(s2, 0) + 1);
        }
        // System.out.println("S2 = " + S2);
        
        for (int j = 0; j < n2; j++) {
            for (int k = j + 1; k < n2; k++) {
                long mul = ((long)nums2[j] * (long)nums2[k]);
                // System.out.println(nums2[j] + " " + nums2[k] + " = " + mul);
                if (S1.containsKey(mul)) {
                    ans += S1.get(mul);
                }
            }
        }
        
        for (int j = 0; j < n1; j++) {
            for (int k = j + 1; k < n1; k++) {
                long mul = ((long)nums1[j] * (long)nums1[k]);
                // System.out.println(nums1[j] + " * " + nums1[k] + " = " + mul);
                if (S2.containsKey(mul)) {
                    ans += S2.get(mul);
                }
            }
        }
         
        return ans;
    }
}