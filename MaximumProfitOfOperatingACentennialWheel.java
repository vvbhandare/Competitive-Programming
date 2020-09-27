class MaximumProfitOfOperatingACentennialWheel {
    public int minOperationsMaxProfit(int[] c, int bc, int rc) {
        int ans = 0, n  = c.length, cap = 0, ob = 0, i, max = 0, res = -1;
        for (i = 0; i < n; i++) {
            c[i] += cap;
            if (c[i] <= 4) {
                ob += c[i];
                ans = ((ob * bc) - ((i + 1) * rc));
            } else {
                // System.out.println(c[i] + " " + cap);
                cap = c[i] - 4;
                ob += 4;
                ans = ((ob * bc) - ((i + 1) * rc));
            }
            // System.out.println(ob + " " + bc + " " + (i + 1) + " " + rc + " " + ans);
            if (max < ans) {
                max = ans;
                res = i + 1;
            }
        }
        while (cap > 0) {
            if (cap >= 4) {
                cap -= 4;
                ob += 4;
            } else {
                ob += cap;
                cap = 0;
            }
            i++;
            ans = ((ob * bc) - (i * rc));
            // System.out.println(ob + " " + bc + " " + i + " " + rc + " " + ans);
            if (max < ans) {
                max = ans;
                res = i;
            }
        }
        // System.out.println(ans);
        return res;
    }
}