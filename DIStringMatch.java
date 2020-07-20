class DIStringMatch {
    public int[] diStringMatch(String S) {
        int[] res = new int[S.length() + 1];
        int I = 0, D = S.length();
        int j = 0;
        for(char c : S.toCharArray()) {
            if (c == 'I') {
                res[j++] = I;
                I++;
            } else {
                res[j++] = D;
                D--;
            }
        }
        res[j] = I;
        return res;
    }
}