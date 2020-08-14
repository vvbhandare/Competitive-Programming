import java.util.Scanner;

public class BoboniuLikesToColorBalls {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int r = sc.nextInt();
			int g = sc.nextInt();
			int b = sc.nextInt();
			int w = sc.nextInt();
			if(solve(r, g, b, w))
				System.out.println("YES");
			else 
				System.out.println("NO");
		}
	}

	private static boolean solve(int r, int g, int b, int w) {
		// TODO Auto-generated method stub
		if (r == 0 && g == 0 && b == 0) {
			return true;
		} else if ((r % 2 != 0 && g % 2 != 0 && b % 2 != 0) ||
				(r % 2 == 0 && g % 2 == 0 && b % 2 == 0)) {
			return true;
		} else if ((r == 0 && (g % 2 == 0 && b % 2 == 0)) ||
				(g == 0 && (r % 2 == 0 && b % 2 == 0)) || 
				(b == 0 && (g % 2 == 0 && r % 2 == 0))) {
			return true;
		}  else if ((r == 0 && (g % 2 != 0 && b % 2 != 0)) ||
				(g == 0 && (r % 2 != 0 && b % 2 != 0)) || 
				(b == 0 && (g % 2 != 0 && r % 2 != 0))) {
			return false;
		} else {
			int e = 0, o = 0;
			if (r % 2 == 0) e++; else o++;
			if (g % 2 == 0) e++; else o++;
			if (b % 2 == 0) e++; else o++;
			if (w % 2 == 0) e++; else o++;
			if (e == o) return false;
			else if (e > o) {
				if (e % (o * 3) == 0) return true;
			} else {
				if (o % (e * 3) == 0) return true;
			}
		}
		return false;
	}

}
 