import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TopBatsman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = 11;
			int[] a = new int[n];
			for (int i = 0; i < n; i++) a[i] = sc.nextInt();
			int k = sc.nextInt();
			performBitmasking(a, n, k);
		}
	}

	private static void performBitmasking(int[] a, int n, int k) {
		// TODO Auto-generated method stub
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int bl = (int) Math.pow(2, n);
		for (int mask = 0; mask < bl; mask++) {
			if (Integer.bitCount(mask) == k) {//n=10 1010 =2
				int sum = 0;
				for (int i = 0; i < n; i++) {
					if ((mask & (1 << i)) > 0) {//to check whether the bit set
						sum += a[i];
					}
				}
				map.put(sum, map.getOrDefault(sum, 0) + 1);
			}
		}
		System.out.println(map.entrySet().stream()
				.max(Map.Entry.comparingByKey()).get().getValue());
	}

}

//{1,2,3}
//n=3, bl=8

//empty
//000
//001
//010
//100
//011
//110
//111

