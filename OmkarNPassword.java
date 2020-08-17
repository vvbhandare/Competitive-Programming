import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class OmkarNPassword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			List<Long> l = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				l.add(sc.nextLong());
			}
			solve(l, n);
		}
	}

	private static void solve(List<Long> l, int n) {
		// TODO Auto-generated method stub
		PriorityQueue<Long> q = new PriorityQueue<Long>(
				(a, b) -> {return b > a ? 1 : -1;});
		q.addAll(l);
		long os = -1, ns = 0;
		while (!q.isEmpty() && q.size() > 1 && os != ns) {
			os = q.size();
			long a = q.poll();
			boolean f = false;
			List<Long> t = new ArrayList<>();
			while (!q.isEmpty()) {
				long b = q.poll();
				if (a == b) t.add(b);
				else if (a != b) {
					f = true;
					q.offer(a + b);
					break;
				}
			}
			if (t.size() > 0) {
				q.addAll(t);
				if (!f) q.offer(a);
			}
			ns = q.size();
		}
		System.out.println(q.size());
	}

}
