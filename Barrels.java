import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


//5 6 7 8
//sum = 8 + 7 = 15

public class Barrels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			List<Long> wl = new ArrayList<Long>();
			for (int i = 0; i < n; i++) 
				wl.add(sc.nextLong());
			solve(wl, n, k);
		}
	}

	private static void solve(List<Long> wl, int n, int k) {
		// TODO Auto-generated method stub
		Collections.sort(wl);
		long sum = 0;
		for (int i = n - 1; k-- >= 0 && i >= 0; i--) 
			sum += wl.get(i);
		System.out.println(sum);
	}

}
