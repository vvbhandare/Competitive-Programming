class FindKthBitInNthBinaryString {
    public char findKthBit(int n, int k) {
        StringBuilder s = new StringBuilder();
        s.append('0');
        for(int i = 1; i <= n; i++) {
            if (k <= s.length()) return s.charAt(k - 1);
            s.append('1');
            for(int j = s.length() - 2; j >= 0; j--) {
                s.append(s.charAt(j) == '0' ? '1' : '0');
            }
        }
        return s.charAt(k - 1);
    }
}