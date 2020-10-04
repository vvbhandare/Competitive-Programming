class AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod {
    public List<String> alertNames(String[] kn, String[] kt) {
        int[] times = new int[kt.length];
        for (int i = 0; i < kt.length; i++) {
            String s = kt[i].replace(":", "");
            times[i] = Integer.valueOf(s);
        }
        Set<String> res = new TreeSet<>();
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < kn.length; i++) {
            if (map.containsKey(kn[i])) {
                List<Integer> l = map.get(kn[i]);
                l.add(times[i]);
                map.put(kn[i], l);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(times[i]);
                map.put(kn[i], l);
            }
        }
        for (String s : map.keySet()) {
            int d = 0, c = 0;
            for (int i = 0; i < map.get(s).size(); i++) {
                List<Integer> tt = map.get(s);
                Collections.sort(tt);
                int f = tt.get(i), last = 0, j = i + 2;
                if (j < tt.size()) {
                    last = tt.get(j);
                    // System.out.println(f + " " + last);
                    if (f < last && Math.abs(last - f) <= 100) res.add(s);
                    f = map.get(s).get(i + 1);
                }
            }
        }
        List<String> mainList = new ArrayList<String>();
        mainList.addAll(res);
        // Collections.sort(mainList);
        return mainList;
    }
}