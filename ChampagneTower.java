class ChampagneTower {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] M = new double[101][101];
        M[0][0] = poured;
        for(int r = 0; r <= query_row; r++) {
            for(int c = 0; c <= r; c++) {
                double of = (M[r][c] - 1.0) / 2.0;
                if (of > 0) {
                    M[r + 1][c] += of;
                    M[r + 1][c + 1] += of;
                }
            }
        }
        return Math.min(1, M[query_row][query_glass]);
    }
}