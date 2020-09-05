import java.util.Scanner;

public class MinimumProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			long a = sc.nextLong();
			long b = sc.nextLong();
			long x = sc.nextLong();
			long y = sc.nextLong();
			long n = sc.nextLong();
			long A = new MinimumProduct().solve(a, b, x, y, n, 1);
			long B = new MinimumProduct().solve(a, b, x, y, n, 2);
			System.out.println(Math.min(A, B));
		}
	}

	// 10 10 	8 5 	3
	private long solve(long a, long b, long x, long y, long n, int type) {
		// TODO Auto-generated method stub
//		System.out.println(a + " " + b);
		long mra = a - x;
		long mrb = b - y;
		
		long A = 0, B = 0;
		
		if (type == 1) {
			if (mra >= n) {
				A = a - n;
				B = b;
			} else {
				long d = n - mra;
				A = a - mra;
				B = d <= mrb ? b - d : b - mrb;
			}
		} else if (type == 2) {
			if (mrb >= n) {
				B = b - n;
				A = a;
			} else {
				long d = n - mrb;
				B = b - mrb;
				A = d <= mra ? a - d : a - mra;
			}
		}
		return A * B;
	}

}
