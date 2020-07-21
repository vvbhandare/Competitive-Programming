class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int n = s.length();
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') st.push(i);
            else {
                if (st.isEmpty()) st.push(i);
                else {
                    if (s.charAt(st.peek()) == '(') st.pop();
                    else st.push(i);
                }
            }
        }
        if (st.isEmpty()) return n;
        int longest = 0, a = n;
        while (!st.isEmpty()) {
            int b = st.pop();
            longest = Math.max(longest, a - b - 1);
            a = b;
        }
        longest = Math.max(longest, a);
        return longest;
    }
}