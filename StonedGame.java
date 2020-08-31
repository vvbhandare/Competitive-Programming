import java.util.Arrays;
import java.util.Scanner;

public class StonedGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int[] p = new int[n];
			for (int i = 0; i < n; i++) p[i] = sc.nextInt();
			Arrays.sort(p);
			solve(p, n);
		}
	}

	private static void solve(int[] p, int n) {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int i = 0; i < n - 1; i++) sum += p[i];
		if (p[n - 1] > sum) {
			System.out.println("T");
			return;
		}
		sum += p[n - 1];
		if (sum % 2 == 0) System.out.println("HL");
		else System.out.println("T");
	}

}
