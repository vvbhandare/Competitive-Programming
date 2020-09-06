class ReplaceAllQsToAvoidConsecutiveRepeatingChars {
    public String modifyString(String s) {
        char[] alphabets = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            char c = sb.charAt(i);
            if (c == '?') {
                if (i > 0 && i + 1 < s.length()) {
                    for (int j = 0; j < 26; j++) {
                        if (sb.charAt(i - 1) != alphabets[j] && sb.charAt(i + 1) != alphabets[j]) {
                            sb.setCharAt(i, alphabets[j]);
                            break;
                        }
                    }
                } else if (i == 0) {
                    for (int j = 0; j < 26; j++) {
                        if (i + 1 >= s.length()) {
                            sb.setCharAt(i, alphabets[j]);
                            break;
                        } else if (i + 1 < s.length() && sb.charAt(i + 1) != alphabets[j]) {
                            sb.setCharAt(i, alphabets[j]);
                            break;
                        }
                    }
                } else if (i + 1 == s.length()) {
                    for (int j = 0; j < 26; j++) {
                        if (sb.charAt(i - 1) != alphabets[j]) {
                            sb.setCharAt(i, alphabets[j]);
                            break;
                        }
                    }
                }
            } else sb.append(c);
        }
        return sb.toString().substring(0, s.length());
    }
}