import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class EpicTransformation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			Map<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < n; i++) {
				int k = sc.nextInt();
				map.put(k, map.getOrDefault(k, 0) + 1);
			}

			PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
			pq.addAll(map.values());
			while (pq.size() >= 2) {
				int a = pq.poll();
				int b = pq.poll();
				a--;
				b--;
				n -= 2;
				if (a > 0) pq.add(a);
				if (b > 0) pq.add(b);
			}
			System.out.println(n);
		}
		sc.close();
	}

}
