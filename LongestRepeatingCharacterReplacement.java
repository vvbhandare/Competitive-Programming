class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int[] alphabets = new int[26];
        int max = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int o = alphabets[c - 'A'];
            int j = i + 1;
            int n = 1;
            int tk = k;
            while(j < s.length()) {
                if (c == s.charAt(j)) n++;
                else {
                    if (tk > 0) {
                        tk--;
                        n++;
                    } else break;
                }
                j++;
            }
            int b = i - 1;
            while(b >= 0) {
                if (c == s.charAt(b)) n++;
                else {
                    if (tk > 0) {
                        tk--;
                        n++;
                    } else break;
                }
                b--;
            }
            if (n > o) {
                alphabets[c - 'A'] = n;
            } else {
                alphabets[c - 'A'] = o;
            }
            max = Math.max(max, alphabets[c - 'A']);
        }
        return max;
    }
}