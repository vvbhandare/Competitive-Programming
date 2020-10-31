import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ChefMonocarp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int q = sc.nextInt();
		while (q-- > 0) {
			int n = sc.nextInt();
			int[] t = new int[n];
			for (int i = 0; i < n; i++) {
				t[i] = sc.nextInt();
			}
			Arrays.sort(t);
			memo =  new HashMap<>();
			int ans = solve(t, 0, 1);
			System.out.println(ans);
		}
	}
	
	static  Map<String, Integer> memo;
	
	private static int solve(int[] t, int i, int ct) {
		// TODO Auto-generated method stub
		String key = i + "_" + ct;
		
		if (i == t.length && ct != 2 * t.length + 1) return 0;
 
		if (ct == 2 * t.length + 1) return (int) 1e9;

		if (memo.containsKey(key)) return memo.get(key);
		
		int use = Math.abs(ct - t[i]) + solve(t, i + 1, ct + 1);
		int ignore = solve(t, i, ct + 1);
		
		memo.put(key, Math.min(use, ignore));
		
		return Math.min(use, ignore);
	}

}
