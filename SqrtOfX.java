class SqrtOfX {
    public int mySqrt(int n) {
        if (n == 0) return 0;
        double EPS = 1e-15;
        double x = n, root = 0;
		while (true) {
			root = (x + (n / x)) / 2;
			if (Math.abs(root - x) < EPS) break;
			x = root;
		}
		return (int) root;
    }
}