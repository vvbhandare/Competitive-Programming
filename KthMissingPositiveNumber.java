class KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int j = 0;
        for(int i = 1; k > 0; i++) {
            if (set.contains(i)) continue;
            else {
                j = i;
                k--;
            }
        }
        return j;
    }
}