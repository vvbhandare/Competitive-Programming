class ReversePairs {
    public int reversePairs(int[] nums) {
        return divideNConquer(nums, 0, nums.length - 1);
    }
    
    private int divideNConquer(int[] a, int l, int r) {
		// TODO Auto-generated method stub
		int count = 0;
		if (l < r) {
			int mid = l + (r - l) / 2;
			count += divideNConquer(a, l, mid);
			count += divideNConquer(a, mid + 1, r);
			count += merge(a, l, mid, r);
		}
		return count;
	}
    
    private int merge(int[] arr, int l, int m, int r) {
		// TODO Auto-generated method stub
		int n1 = m - l + 1, n2 = r - m; 
	  
	    int L[] = new int[n1];
	    for(int i = 0; i < n1; i++) L[i] = arr[l + i]; 
	    
	    int R[] = new int[n2];
	    for(int j = 0; j < n2; j++) R[j] = arr[m + 1 + j]; 
	  
	    int i = 0, j = 0, k = l, count = 0;
	      
	    while (i < n1 && j < n2) { 
	        if ((long) L[i] > (2 * (long) R[j])) {
                count += L.length - i;
                j++;
            } else i++;
	    } 
        
        i = 0; j = 0; k = l;
        
        while (i < n1 && j < n2) { 
	        if (L[i] <= R[j]) arr[k++] = L[i++];
	        else arr[k++] = R[j++];
	    } 
	  
	    while (i < n1) arr[k++] = L[i++];
	    while (j < n2) arr[k++] = R[j++];
	    
	    return count;
	}
}

// https://en.wikipedia.org/wiki/File:Merge_sort_algorithm_diagram.svg

// [2,4,3,5,1]

// 2=0
// 4=0
// 1*2=4,5    

// [1,3,2,3,1]
// 1 2 3 4 | 1 3

// [2,4,3,5,1]
// 2 3 4 | 1 5

// [2147483647,2147483647,2147483647,2147483647,2147483647,2147483647]
