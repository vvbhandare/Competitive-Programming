import java.util.Scanner;

public class DontBeLate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int D = sc.nextInt();
		int T = sc.nextInt();
		int S = sc.nextInt();
		solve(D, T, S);
	}

	private static void solve(int d, int t, int s) {
		// TODO Auto-generated method stub
		//formula : d = vt
		if (s == 0) {
			if (d == 0) System.out.println("Yes");
			else System.out.println("No");
			return;
		}
		int res = s * t;
		if (res >= d) System.out.println("Yes");
		else System.out.println("No");
	}

}
