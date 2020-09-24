class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
        if (n1 + n2 != n3) return false;
        if (n1 == 0 && n2 == 0 && n3 == 0) return true;
        int i = 0, j = 0, k = 0;
        boolean b1 = false, b2 = false;
        if (i < n1 && k < n3 && s1.charAt(i) == s3.charAt(k)) 
            b1 = traverse(i + 1, j, k + 1, "" + s1.charAt(i), s1, s2, s3);
        if (j < n2 && k < n3 && s2.charAt(j) == s3.charAt(k)) 
            b2 = traverse(i, j + 1, k + 1, "" + s2.charAt(j), s1, s2, s3);
        return b1 || b2;
    }
    
	private Map<String, Boolean> memo = new HashMap<>();
	
    private boolean traverse(int i, int j, int k, String cs, String s1, String s2, String s3) {
//    	System.out.println(cs);
        String key = i + "_" + j + "_" + k;
        if (cs.equals(s3)) return true;
        if (i >= s1.length() && j >= s2.length()) return false;
        if (memo.containsKey(key)) return memo.get(key);
        boolean b1 = false, b2 = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) 
            b1 = traverse(i + 1, j, k + 1, cs + s1.charAt(i), s1, s2, s3);
        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) 
            b2 = traverse(i, j + 1, k + 1, cs + s2.charAt(j), s1, s2, s3);
        memo.put(key,  b1 || b2);
        return b1 || b2;
    }
}

// "aa b c c"
// "dbb c a"
// "aadbbcbcac"
    
// "aa b cc"
// "dbb ca"
// "aadbbbaccc"
    
// ""
// ""
// ""
    
// "a"
// ""
// "a"
    
// ""
// "b"
// "b"
    
// "cbcccbabbccbbcccbbbcabbbabcababbbbbbaccaccbabbaacbaabbbc"
// "abcbbcaababccacbaaaccbabaabbaaabcbababbcccbbabbbcbbb"
// "abcbcccbacbbbbccbcbcacacbbbbacabbbabbcacbcaabcbaaacbcbbbabbbaacacbbaaaabccbcbaabbbaaabbcccbcbabababbbcbbbcbb"