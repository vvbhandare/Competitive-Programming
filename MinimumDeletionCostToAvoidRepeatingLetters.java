class MinimumDeletionCostToAvoidRepeatingLetters {
    public int minCost(String s, int[] cost) {
        int n = s.length(), ans = 0;
        for (int i = 0; i < n; i++) {
            char fc = s.charAt(i);
            int j = i + 1;
            while (j < n) {
                char nc = s.charAt(j);
                if (fc != nc) {
                    i = j + 1 == n ? j : j - 1;
                    break;
                }
                if (cost[i] <= cost[j]) {
                    ans += cost[i];
                    cost[i] = cost[j];
                } else {
                    ans += cost[j];
                    cost[j] = cost[i];
                }
                // System.out.println(ans + " " + j);
                // ans += Math.min(cost[i], cost[j]);
                j++;
            }
            if (j == n) break;
        }
        return ans;
    }
}


// aabc -> abc

// aaabc -> aabc -> abc

// "bbbaaa" -> bbaaa(4) -> baaa(3) -> baa(8) -> ba(8)
// [4,9,3,8,8,9]


