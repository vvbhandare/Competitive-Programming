import java.util.Scanner;

public class YetAnotherTwoIntegersProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			long a = sc.nextLong();
			long b = sc.nextLong();
			solve(a, b);
		}
	}

	private static void solve(long a, long b) {
		// TODO Auto-generated method stub
		if (a == b) System.out.println(0);
		else if (a < b) solve(b, a);
		else {
			long d = a - b;
			if (d % 10 == 0) {
				System.out.println(d / 10);
			} else {
				long ans = (d / 10) + ((d % 10) <= 10 ? 1 : (d % 10));
				System.out.println(ans);	
			}
		}
	}

}
