class WidestVerticalAreaBetweenTwoPointsContainingNoPoints {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        int diff = 0, p1 = 0, p2 = 0;
        for (final int[] arr : points) {
            // System.out.println(Arrays.toString(arr));
            if (p1 != 0 || p2 != 0) {
                int x = arr[0] - p1;
                // int y = arr[1] - p2;
                p1 = arr[0];
                p2 = arr[1];
                diff = Math.max(diff, x);
            } else {
                p1 = arr[0];
                p2 = arr[1];
            }
        }
        return diff;
    }
}