class ThousandSeparator {
    public String thousandSeparator(int n) {
        String s = String.valueOf(n);
        int l = s.length();
        if (l < 3) return s;
        StringBuilder sb = new StringBuilder();
        int j = 0;
        for(int i = l - 1; i >= 0; i--) {
            if (j == 3) {
                sb.append(".");
                j = 0;
            }
            sb.append(s.charAt(i));
            j++;
        }
        System.out.println(sb);
        return sb.reverse().toString();
    }
}