import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BalancedTernaryString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Character, Integer> map = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int d = n / 3;
		String s = sc.next();
		map.put('0', 0);map.put('1', 0);map.put('2', 0);
		int[] a = new int[3];
		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		StringBuilder sb = new StringBuilder();
		char minc = map.get('0') < d ? '0' : map.get('1') < d ? '1' : '2';
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (minc < c && map.get(c) > d) {
				map.put(c, map.get(c) - 1);
				map.put(minc, map.getOrDefault(minc, 0) + 1);
				sb.append(minc);
				a[minc - '0']++;
			} else if (a[c - '0'] < d) {
				if (map.get(c) - 1 >= d) {
					map.put(c, map.get(c) - 1);	
				}
				sb.append(c);
				a[c - '0']++;
			} else {
				if (map.get(c) - 1 >= d) {
					map.put(c, map.get(c) - 1);
				}
				map.put(minc, map.get(minc) + 1);
				sb.append(minc);
				a[minc - '0']++;	
			}
			minc = map.get('0') < d ? '0' : map.get('1') < d ? '1' : '2';
		}
		System.out.println(sb.toString());
	}

}
