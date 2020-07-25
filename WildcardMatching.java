class WildcardMatching {
    Map<String, Boolean> map = new HashMap<>();
    public boolean isMatch(String s, String p) {
        return dfs(s, p, 0, 0);
    }
    
    private boolean dfs(String s, String p, int i, int j) {
        if (i == s.length() && j == p.length()) return true;
        if (j == p.length()) return false;
        
        if (map.containsKey(i + "_" + j)) return map.get(i + "_" + j);
        
        boolean b = false;
        if (i == s.length()) 
            b = p.charAt(j) == '*' && dfs(s, p, i, j + 1);
        else if (p.charAt(j) == '*') 
            b = dfs(s, p, i + 1, j) || dfs(s, p, i, j + 1);
        else if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)) 
            b = dfs(s, p, i + 1, j + 1);
        else 
            b = false;
        map.put(i + "_" + j, b);
        return b;
    }
}