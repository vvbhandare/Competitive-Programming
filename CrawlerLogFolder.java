class CrawlerLogFolder {
    public int minOperations(String[] logs) {
        Stack<String> st = new Stack<>();
        for (String log : logs) {
            if (log.equals("./")) {
                continue;
            }
            else if (log.equals("../")) {
                if (!st.isEmpty()) {st.pop();}
            }
            else {
                st.push(log);
            }
            // System.out.println(st);
        }
        return st.size();
    }
}