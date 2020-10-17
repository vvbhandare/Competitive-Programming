import java.util.Scanner;

public class BoxIsPull {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			long x1 = sc.nextLong();
			long y1 = sc.nextLong();
			long x2 = sc.nextLong();
			long y2 = sc.nextLong();
			solve(x1, y1, x2, y2);
		}
	}

	private static void solve(long x1, long y1, long x2, long y2) {
		// TODO Auto-generated method stub
		long x = Math.abs(x1 - x2);
		long y = Math.abs(y1 - y2);
		long r = x + y;
		if (x == 0 || y == 0) 
			System.out.println(r);
		else 
			System.out.println(r + 2);
	}

}
