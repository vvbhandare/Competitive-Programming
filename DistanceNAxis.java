import java.util.Scanner;

public class DistanceNAxis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			long n = sc.nextLong();
			long k = sc.nextLong();
			solve(n, k);
		}
	}

//	Formula = B = (D + A) / 2 => % # of (+/-)1 of A
	private static void solve(long A, long D) {
		// TODO Auto-generated method stub
		if (A == 0) System.out.println(D);
		else if (A - D == 0) System.out.println(0);
		else if (A - D < 0) System.out.println(D - A);
		else if (A - D > 0) System.out.println((D + A) % 2);
	}

}
