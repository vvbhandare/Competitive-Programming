class MakeTheStringGreat {
    public String makeGood(String s) {
        if (s.length() == 0) return "";
        if (s.length() == 1) return s;
        String o = s;
        StringBuilder sb = new StringBuilder(s);
        for(int i = 1; i < sb.length(); i++) {
            if (Character.toLowerCase(sb.charAt(i)) == Character.toLowerCase(sb.charAt(i - 1))) {
                if ((Character.isLowerCase(sb.charAt(i)) && Character.isUpperCase(sb.charAt(i - 1))) 
                || Character.isUpperCase(sb.charAt(i)) && Character.isLowerCase(sb.charAt(i - 1))) {
                    if (sb.charAt(i) != sb.charAt(i - 1)) {
                        return makeGood(sb.substring(0, i - 1) + sb.substring(i + 1));
                    }   
                }
            }
        }
        if (o.equals(sb.toString())) return sb.toString();
        else return "";
    }
}