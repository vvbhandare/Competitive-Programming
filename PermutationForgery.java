import java.util.Arrays;
import java.util.Scanner;

public class PermutationForgery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int p[] = new int[n];
			int sum = 0;
			for (int i = 0; i < n; i++) {
				p[i] = sc.nextInt();
				sum += p[i];
			}
			solve(p, n);
			System.out.println();
		}
	}

	private static void solve(int[] p, int n) {
		// TODO Auto-generated method stub
		for (int i = n - 1; i >= 0; i--) 
			System.out.print(p[i] + " ");
	}

}
