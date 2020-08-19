class MinimumOperationsToMakeArrayEqual {
    public int minOperations(int n) {
        int sum = 0;
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = (2 * i) + 1;
            sum += arr[i];
        }
        int avg = sum / n;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int key = Math.abs(arr[i] - avg);
            map.put(key, key);
        }
        int cnt = 0;
        for(int p : map.values()) cnt += p;
        return cnt;
    }
}