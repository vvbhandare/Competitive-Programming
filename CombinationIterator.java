class CombinationIterator {
    
    PriorityQueue<String> pq = new PriorityQueue<>();
    
    public CombinationIterator(String s, int cl) {
        char[] arr = s.toCharArray();
        int n = s.length();
        for (int i = 0; i < (1 << n); i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < n; j++) {
				//bitmasking condition/logic
				if ((i & (1 << j)) > 0) {
					sb.append(arr[j]);
				}
			}
			if (sb.toString().length() == cl) pq.offer(sb.toString());
		}
    }
    
    public String next() {
        return pq.poll();
    }
    
    public boolean hasNext() {
        return !pq.isEmpty();
    }
}