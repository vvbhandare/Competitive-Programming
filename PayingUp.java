import java.util.Arrays;
import java.util.Scanner;

public class PayingUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int notes[] = new int[n];
			for (int i = 0; i < n; i++) notes[i] = sc.nextInt();
			Arrays.sort(notes);
			if(performBitmask(notes, n, m)) System.out.println("Yes");
			else System.out.println("No");
		}
	}

	private static boolean performBitmask(int[] notes, int n, int m) {
		// TODO Auto-generated method stub
		int pow = (int) Math.pow(2, n);
		for (int mask = 0; mask < pow; mask++) {
			int sum = 0;
			for (int i = 0; i < n; i++) {
				if (sum + notes[i] > m) break;
				//to check whether the bit set
				else if ((mask & (1 << i)) > 0) sum += notes[i];
			}
			if (sum == m) return true;
		}
		return false;
	}

}
