class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String S) {
        StringBuilder sb = new StringBuilder(S);
        String R = sb.reverse().toString();
        int m = S.length();
        int dp[][] = new int[m + 1][m + 1];
        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) 
                    dp[i][j] = 0;
                else if (S.charAt(i - 1) == R.charAt(j - 1)) 
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else 
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][m];
    }
}