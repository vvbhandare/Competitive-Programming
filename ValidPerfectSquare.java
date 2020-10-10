class ValidPerfectSquare {
    public boolean isPerfectSquare(int n) {
        //Using Newton-Raphson Method
        double x = n, root = 0;
        double EPS = 1e-15;//0.00000000....1
		while (true) {
			root = (x + (n / x)) / 2;
			if (Math.abs(root - x) < EPS) break;
			x = root;
		}
		return root % 1 == 0;
    }
}

// x2+n / 2